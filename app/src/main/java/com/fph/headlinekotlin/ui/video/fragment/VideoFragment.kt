package com.fph.headlinekotlin.ui.video.fragment

import `in`.srain.cube.views.ptr.PtrDefaultHandler
import `in`.srain.cube.views.ptr.PtrFrameLayout
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.base.LazyFragment
import com.fph.headlinekotlin.ui.video.adapter.VideoAdapter
import com.fph.headlinekotlin.ui.video.bean.VideoListBean
import com.fph.headlinekotlin.ui.video.contract.VideoContract
import com.fph.headlinekotlin.ui.video.presenter.VideoPresenter
import kotlinx.android.synthetic.main.fragment_video.*
import java.util.*

/**
 * Created by fengpeihao on 2018/4/4.
 */
class VideoFragment : LazyFragment(), VideoContract.View {

    private var mVideoListBean: VideoListBean? = null
    private var mList = ArrayList<VideoListBean.DataBean>()
    private var mAdapter = VideoAdapter()
    private val mLayoutManager = LinearLayoutManager(context)
    private var isLoading = false
    private var isLoadAll = false
    private var type = "toutiao"
    /**
     * 客户端请求的数据处于当前类别信息流的第几页
     * （注：首次请求即第一个页面该参数传1,上拉加载下一页数据时传2，以此类推传3,4......；
     * 首次下拉请求叠加数据时该参数传-1，继续下拉请求叠加数据时传-2，以此类推传-3......）
     */
    private val pgnum = 1
    private var refreshPgnum = -1
    private var loadMorePgnum = 1
    /**
     * 目前最新的一条新闻的位置，上拉加载传正数、下拉叠加传负数
     */
    private val idx = 0;
    private var refreshIdx = 0
    private var loadMoreIdx = 0

    private val mPresenter = VideoPresenter(this)

    override fun getLayoutId(): Int {
        return R.layout.fragment_video
    }

    override fun init(savedInstanceState: Bundle?) {

        if (savedInstanceState != null) {
            refreshPgnum = savedInstanceState.getInt("refreshPgnum", refreshPgnum)
            loadMorePgnum = savedInstanceState.getInt("loadMorePgnum", loadMorePgnum)
            refreshIdx = savedInstanceState.getInt("refreshIdx", refreshIdx)
            loadMoreIdx = savedInstanceState.getInt("loadMoreIdx", loadMoreIdx)
            isFirstShow = savedInstanceState.getBoolean("isFirstShow", isFirstShow)
            mList = savedInstanceState.getSerializable("mList") as ArrayList<VideoListBean.DataBean>
        }
        type = arguments?.getString("type", "toutiao") ?: "toutiao"
        recycler_view.layoutManager = mLayoutManager
        mAdapter.setList(mList, VideoAdapter.INIT)
        recycler_view.adapter = mAdapter

        ptr_frame.setPtrHandler(object : PtrDefaultHandler() {
            override fun onRefreshBegin(frame: PtrFrameLayout) {
                mPresenter.getVideoList(mVideoListBean?.endkey, mVideoListBean?.newkey, "", refreshPgnum, refreshIdx, type, "wifi", VideoAdapter.REFRESH)
                refreshPgnum--
            }
        })

        recycler_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                //获取最后一个完全显示的ItemPosition
                val lastVisibleItem = mLayoutManager.findLastCompletelyVisibleItemPosition()
                val totalItemCount = mLayoutManager.itemCount
                if (totalItemCount > 0 && newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem == totalItemCount - 1 && !isLoading && !isLoadAll) {
                    isLoading = true
                    loadMorePgnum++
                    mPresenter.getVideoList(mVideoListBean?.endkey, mVideoListBean?.newkey, "", loadMorePgnum, loadMoreIdx, type, "上海", VideoAdapter.LOAD_MORE)
                }
            }
        })
    }

    override fun lazyInit() {
        mPresenter.getVideoList(mVideoListBean?.endkey, mVideoListBean?.newkey, "", pgnum, idx, type, "上海", VideoAdapter.NORMAL)
    }

    override fun getVideoList(videoListBean: VideoListBean, loadType: Int) {
        this.mVideoListBean = videoListBean
        if (loadType == VideoAdapter.REFRESH) {
            refreshIdx -= videoListBean.data?.size ?: 0
            mList.addAll(0, videoListBean.data!!)
            ptr_frame.refreshComplete()
        } else if (loadType == VideoAdapter.LOAD_MORE) {
            if (videoListBean.data?.size ?: 0 == 0) {
                isLoadAll = true
            }
            loadMoreIdx += videoListBean.data?.size ?: 0
            mList.addAll(videoListBean.data!!)
            isLoading = false
        } else {
            mList.addAll(videoListBean.data!!)
        }
        mAdapter.setList(videoListBean.data!!, loadType)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("refreshPgnum", refreshPgnum)
        outState.putInt("loadMorePgnum", loadMorePgnum)
        outState.putInt("refreshIdx", refreshIdx)
        outState.putInt("loadMoreIdx", loadMoreIdx)
        outState.putBoolean("isFirstShow", isFirstShow)
        outState.putSerializable("mList", mList)
    }
}

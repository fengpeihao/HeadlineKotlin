package com.fph.headlinekotlin.ui.video.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.base.BaseViewHolder
import com.fph.headlinekotlin.ui.news.adapter.NewsAdapter
import com.fph.headlinekotlin.ui.video.bean.VideoListBean
import com.fph.headlinekotlin.utils.TimeUtils

/**
 * Created by fengpeihao on 2018/4/9.
 */
class VideoAdapter : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    private var type = NewsAdapter.NORMAL
    private val NO_DATA = -1
    private var mContext: Context? = null
    private var mList = ArrayList<VideoListBean.DataBean>()

    companion object {
        const val INIT = -2
        const val NORMAL = 0
        const val LOAD_MORE = 1
        const val REFRESH = -1
    }

    fun setList(list: List<VideoListBean.DataBean>, loadType: Int) {
        type = loadType
        if (loadType == REFRESH) {
            mList.addAll(0, list)
        } else if (loadType == LOAD_MORE) {
            mList.addAll(list)
        } else {
            mList.addAll(list)
        }
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        if (mList.size == 0) {
            return NO_DATA
        }
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (getItemViewType(position) == NO_DATA) return
        val dataBean = mList.get(position)
        holder.setText(R.id.tv_video_title, dataBean.topic ?: "")
        Glide.with(mContext).load(dataBean.lbimg?.get(0)?.src).into(holder.getView<ImageView>(R.id.img_video_thumb))
        holder.setText(R.id.tv_video_time, TimeUtils.getVideoTime(dataBean.videoalltime))
        holder.setText(R.id.tv_video_source, dataBean.source ?: "")
        if (dataBean.comment_count?.toInt() ?: 0 == 0) {
            holder.setText(R.id.tv_comment_number, "")
        } else {
            holder.setText(R.id.tv_comment_number, dataBean.comment_count!!)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        if (viewType == NO_DATA) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_no_data, parent, false)
            return ViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
            return ViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        if (mList.size == 0) {
            if (type == INIT) return 0
            return 1
        }
        return mList.size
    }

    class ViewHolder(itemView: View) : BaseViewHolder(itemView)
}
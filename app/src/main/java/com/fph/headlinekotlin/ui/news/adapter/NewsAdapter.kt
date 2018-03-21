package com.fph.headlinekotlin.ui.news.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.feilu.kotlindemo.api.Constant
import com.fph.headlinekotlin.R
import com.fph.headlinekotlin.ui.main.activity.WebViewActivity
import com.fph.headlinekotlin.ui.news.bean.NewsListBean
import com.fph.headlinekotlin.utils.TimeUtils


/**
 * Created by fengpeihao on 2018/1/12.
 */
class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val NONE = 0;
    private val ONE = 1
    private val THREE = 3
    val NORMAL = 0;
    val LOAD_MORE = 1;
    val REFRESH = -1;
    private var mContext: Context? = null
    private var mList = ArrayList<NewsListBean.DataBean>()

    fun setList(list: List<NewsListBean.DataBean>, loadType: Int) {
        if (loadType == REFRESH) {
            mList.addAll(0, list)
        } else if (loadType == LOAD_MORE) {
            mList.addAll(list)
        } else {
            mList.addAll(list)
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList.get(position)
        holder.setText(R.id.tv_title, item.topic ?: "")
        holder.setText(R.id.tv_time, TimeUtils.getNewsTime(item.date ?: ""))
        holder.setText(R.id.tv_comment, item.source ?: "")
        when (holder.itemViewType) {
            NONE -> {

            }
            ONE -> {
                Glide.with(mContext).load(item.miniimg!![0].src).into(holder.getView<ImageView>(R.id.img_pic))
            }
            THREE -> {
                Glide.with(mContext).load(item.miniimg!![0].src).into(holder.getView<ImageView>(R.id.img_one))
                Glide.with(mContext).load(item.miniimg!![1].src).into(holder.getView<ImageView>(R.id.img_two))
                Glide.with(mContext).load(item.miniimg!![2].src).into(holder.getView<ImageView>(R.id.img_three))
            }
        }
        holder.itemView.setTag(position)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val tag = view.getTag() as Int
                val intent = Intent(mContext,WebViewActivity::class.java)
                val bundle = Bundle()
                bundle.putString(Constant.webUrl,mList.get(tag).shareurl)
                intent.putExtras(bundle)
                mContext?.startActivity(intent)
            }
        })
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        if (viewType == ONE) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_list_one_img,parent,false)
            return ViewHolder(view)
        } else if (viewType == THREE) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_list_three_img,parent,false);
            return ViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_list_none_img,parent,false);
            return ViewHolder(view)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val miniimg = mList.get(position).miniimg
        if (miniimg?.size ?: 0 >= 3) {
            return THREE
        }
        if (miniimg?.size ?: 0 == 1) {
            return ONE
        }
        return NONE
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var views = SparseArray<View>()
        fun <T : View> getView(@IdRes viewId: Int): T {
            var view = views.get(viewId)
            if (view == null) {
                view = itemView.findViewById<T>(viewId)
                views.put(viewId, view)
            }
            return view as T
        }

        fun setText(@IdRes viewId: Int, value: CharSequence) {
            val view = getView<TextView>(viewId)
            view.setText(value)
        }
    }
}
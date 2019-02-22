package com.fph.headlinekotlin.ui.main.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.fph.headlinekotlin.R
import kotlinx.android.synthetic.main.layout_bottom.view.*

/**
 * Created by fengpeihao on 2018/1/11.
 */
class BottomTabView : LinearLayout, View.OnClickListener {
    companion object {
        val NEWS: Int = 0;
        val VIDEO: Int = 1;
        val TASK: Int = 2;
        val MINE: Int = 3;
    }

    private var checkIndex: Int = NEWS
    var mListener: OnTabCheckedListener? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        init()
    }

    private fun init() {
        LayoutInflater.from(context).inflate(R.layout.layout_bottom, this)
        layout_news.setOnClickListener(this)
        layout_video.setOnClickListener(this)
        layout_task.setOnClickListener(this)
        layout_mine.setOnClickListener(this)
        checkTab(checkIndex)
    }

    fun setDefaultChcekIndex(defaultCheckIndex: Int) {
        checkIndex = defaultCheckIndex
        checkTab(checkIndex)
    }

    private fun checkTab(index: Int) {
        when (index) {
            NEWS -> {
                checkNews(true)
                checkVideo(false)
                checkTask(false)
                checkMine(false)
            }
            VIDEO -> {
                checkNews(false)
                checkVideo(true)
                checkTask(false)
                checkMine(false)
            }
            TASK -> {
                checkNews(false)
                checkVideo(false)
                checkTask(true)
                checkMine(false)
            }
            MINE -> {
                checkNews(false)
                checkVideo(false)
                checkTask(false)
                checkMine(true)
            }
        }
        mListener?.onTanCheckedChange(index)
    }

    private fun checkNews(checked: Boolean) {
        if (checked) {
            img_news.setImageResource(R.mipmap.news_press)
            tv_news.setTextColor(context.resources.getColor(R.color.text_color_normal))
        } else {
            img_news.setImageResource(R.mipmap.news)
            tv_news.setTextColor(context.resources.getColor(R.color.text_color_light))
        }
    }

    private fun checkVideo(checked: Boolean) {
        if (checked) {
            img_video.setImageResource(R.mipmap.video_selected)
            tv_video.setTextColor(context.resources.getColor(R.color.text_color_normal))
        } else {
            img_video.setImageResource(R.mipmap.video_normal)
            tv_video.setTextColor(context.resources.getColor(R.color.text_color_light))
        }
    }

    private fun checkTask(checked: Boolean) {
        if (checked) {
            img_task.setImageResource(R.mipmap.task_icon_selected)
            tv_task.setTextColor(context.resources.getColor(R.color.text_color_normal))
        } else {
            img_task.setImageResource(R.mipmap.task_icon_normal)
            tv_task.setTextColor(context.resources.getColor(R.color.text_color_light))
        }
    }

    private fun checkMine(checked: Boolean) {
        if (checked) {
            img_mine.setImageResource(R.mipmap.mine_press)
            tv_mine.setTextColor(context.resources.getColor(R.color.text_color_normal))
        } else {
            img_mine.setImageResource(R.mipmap.mine)
            tv_mine.setTextColor(context.resources.getColor(R.color.text_color_light))
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.layout_news -> {
                checkTab(NEWS)
            }
            R.id.layout_video -> {
                checkTab(VIDEO)
            }
            R.id.layout_task -> {
                checkTab(TASK)
            }
            R.id.layout_mine -> {
                checkTab(MINE)
            }
        }
    }

    interface OnTabCheckedListener {
        fun onTanCheckedChange(index: Int)
    }
}
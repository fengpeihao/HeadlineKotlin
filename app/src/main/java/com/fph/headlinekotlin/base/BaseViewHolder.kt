package com.fph.headlinekotlin.base

import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.widget.TextView

/**
 * Created by fengpeihao on 2018/12/18.
 */
open class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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
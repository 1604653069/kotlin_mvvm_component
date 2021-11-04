package com.hong.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class BaseAdapter<E, VH : RecyclerView.ViewHolder?>(private var mContext: Context) :
    RecyclerView.Adapter<VH>() {
     var mList: MutableList<E> = ArrayList()
     var mItemClickListener: OnItemClickListener<E>? = null
     var mOnItemLongClickListener: OnItemLongClickListener<E>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutid = onBindLayout()
        val view = LayoutInflater.from(mContext).inflate(layoutid, parent, false)
        return onCreateHolder(view)
    }

    protected abstract fun onBindLayout(): Int
    protected abstract fun onCreateHolder(view: View?): VH
    protected abstract fun onBindData(holder: VH, e: E, position: Int)
    override fun onBindViewHolder(holder: VH, position: Int) {
        val e = mList[position]
        if (mItemClickListener != null) {
            holder!!.itemView.setOnClickListener { mItemClickListener!!.onItemClick(e, position) }
        }
        if (mOnItemLongClickListener != null) {
            holder!!.itemView.setOnLongClickListener {
                mOnItemLongClickListener!!.onItemLongClick(e,
                    position
                )
            }
        }
        onBindData(holder, e, position)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun addAll(list: List<E>?) {
        if (list != null && list.isNotEmpty()) {
            mList.addAll(list)
            notifyDataSetChanged()
        }
    }

    fun refresh(list: List<E>?) {
        mList.clear()
        if (list != null && list.isNotEmpty()) {
            mList.addAll(list)
        }
        notifyDataSetChanged()
    }

    fun remove(position: Int) {
        mList.removeAt(position)
        notifyDataSetChanged()
    }

    fun remove(e: E) {
        mList.remove(e)
        notifyDataSetChanged()
    }

    fun add(e: E) {
        mList.add(e)
        notifyDataSetChanged()
    }

    fun addLast(e: E) {
        add(e)
    }

    fun addFirst(e: E) {
        mList.add(0, e)
        notifyDataSetChanged()
    }

    fun clear() {
        mList.clear()
        notifyDataSetChanged()
    }

    val dataList: List<E>
        get() = mList

    fun setItemClickListener(itemClickListener: OnItemClickListener<E>?) {
        mItemClickListener = itemClickListener
    }

    fun setOnItemLongClickListener(onItemLongClickListener: OnItemLongClickListener<E>?) {
        mOnItemLongClickListener = onItemLongClickListener
    }

    interface OnItemClickListener<E> {
        fun onItemClick(e: E, position: Int)
    }

    interface OnItemLongClickListener<E> {
        fun onItemLongClick(e: E, position: Int): Boolean
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    val listData: List<E>
        get() = mList

}

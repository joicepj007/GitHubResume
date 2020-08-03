package com.android.githubresumebuilder.resume.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.githubresumebuilder.R
import com.android.githubresumebuilder.resume.presentation.model.PostVM
import kotlinx.android.synthetic.main.view_list_item.view.*


class RVPostAdapter : RecyclerView.Adapter<RVPostAdapter.ViewHolder>() {

    private val mList: MutableList<PostVM> = mutableListOf()

    fun add(lstPostVM: PostVM) {
        mList.add(lstPostVM)
        notifyItemInserted(this.itemCount)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.view_list_item, parent, false)
    )

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(postVM: PostVM) {
            mList.size
            itemView.item_name.text = postVM.name
            itemView.item_description.text = postVM.description
            itemView.item_html.text = postVM.html_url
        }
    }
}
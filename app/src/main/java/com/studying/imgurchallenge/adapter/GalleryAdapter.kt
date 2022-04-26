package com.studying.imgurchallenge.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.studying.imgurchallenge.R
import com.studying.imgurchallenge.extensions.inflate
import com.studying.imgurchallenge.model.Data
import com.studying.imgurchallenge.model.DataResponse

class GalleryAdapter(
    private val context: Context,

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var galleryList: List<Data> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerView.ViewHolder{
        val view = parent.inflate(R.layout.gallery_list)
        return GalleryViewHolder(view)
    }

    fun populateAdapter(itemsList: List<Data>){
        galleryList = itemsList
        notifyItemRangeInserted(0, itemsList.size)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder = holder as GalleryViewHolder
        val entity = galleryList[position]
        bindItemViewHolder(itemViewHolder, entity, position)
    }

    override fun getItemCount(): Int {
        return galleryList.size
    }

    private fun bindItemViewHolder(viewHolder: GalleryViewHolder, item: Data, position: Int){

        viewHolder.galleryList.setImageResource(R.drawable.ic_launcher_background)

    }


}
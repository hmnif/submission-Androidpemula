package com.example.submissionandroidpemula.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.submissionandroidpemula.R
import com.example.submissionandroidpemula.detail_bola
import com.example.submissionandroidpemula.model.Bola

class ListBolaAdapter(private val listBola: ArrayList<Bola>) : RecyclerView.Adapter<ListBolaAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card_bola, viewGroup,false )
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBola.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, rank, photo, overview, identity) = listBola[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvRank.text = rank

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, detail_bola::class.java)
            moveDetail.putExtra(detail_bola.EXTRA_RANK, rank)
            moveDetail.putExtra(detail_bola.EXTRA_NAME, name)
            moveDetail.putExtra(detail_bola.EXTRA_PHOTO, photo)
            moveDetail.putExtra(detail_bola.EXTRA_IDENTITY, identity)
            moveDetail.putExtra(detail_bola.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvRank: TextView = itemView.findViewById(R.id.tv_item_rank)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}
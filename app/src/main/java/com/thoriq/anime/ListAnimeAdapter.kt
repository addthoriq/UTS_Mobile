package com.thoriq.anime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListAnimeAdapter(private val listAnime: ArrayList<ValAnime>): RecyclerView.Adapter<ListAnimeAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var gbrAnime: ImageView = itemView.findViewById(R.id.img_item_anime)
        var tvJudul: TextView = itemView.findViewById(R.id.tv_item_judul)
        var tvDesc: TextView = itemView.findViewById(R.id.tv_item_desc)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ValAnime)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder{
        val v: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_anime, viewGroup, false)
        return ListViewHolder(v)
    }
    override fun getItemCount(): Int {
        return listAnime.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val anim = listAnime[position]
        Glide.with(holder.itemView.context)
            .load(anim.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.gbrAnime)

        holder.tvJudul.text = anim.judul
        holder.tvDesc.text = anim.desc

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listAnime[holder.absoluteAdapterPosition])
        }
    }


}
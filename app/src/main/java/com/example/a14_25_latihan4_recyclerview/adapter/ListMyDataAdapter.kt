package com.example.a14_25_latihan4_recyclerview.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.a14_25_latihan4_recyclerview.DetalActivity
import com.example.a14_25_latihan4_recyclerview.MyData
import com.example.a14_25_latihan4_recyclerview.databinding.ItemListBinding

class ListMyDataAdapter(private val listMyData: ArrayList<MyData>) :
    RecyclerView.Adapter<ListMyDataAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listMyData[position])
    }
    override fun getItemCount(): Int = listMyData.size
    inner class ListViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(myData: MyData) {
            with(binding) {
                tvItemName.text = myData.name
                tvItemDescription.text = myData.description
                Glide.with(itemView.context)
                    .load(myData.photo)
                    .apply(RequestOptions().override(55, 55))
                    .into(imgItemPhoto)
            }
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetalActivity::class.java)
                intent.putExtra(DetalActivity.EXTRA_NAME, myData.name)
                intent.putExtra(DetalActivity.EXTRA_DESCRIPTION, myData.description)
                intent.putExtra(DetalActivity.EXTRA_PHOTO, myData.photo)
                itemView.context.startActivity(intent)
            }
        }
    }
}
package com.mabbar.market.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mabbar.market.ApiInterface
import com.mabbar.market.DataItem
import com.mabbar.market.R

class NewsAdapter (var item:List<DataItem?>?):RecyclerView.Adapter<NewsAdapter.viewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.viewholder {
val view=LayoutInflater.from(parent.context).inflate(R.layout.item_new,parent,false)
        return viewholder(view)
    }


    override fun onBindViewHolder(holder: NewsAdapter.viewholder, position: Int) {
       // val data=item.get(position)
        val items= item?.get(position)
        Glide.with(holder.itemView)
            .load(items?.image)
            .into(holder.image)
        holder.name.setText(items?.name)
        holder.price.text = "${ item?.get(position)?.price.toString() }$"
        holder.restaurantId.text = "${ item?.get(position)?.restaurantId.toString() }$"
        holder.id.text = "${ item?.get(position)?.id.toString() }$"
//        items?.quantity?.let { holder.quantity.setText(it) }
//        items?.restaurantId?.let { holder.restaurantId.setText(it) }
//        items?.id?.let { holder.id.setText(it) }





    }

    override fun getItemCount(): Int {
        return item?.size?:0
    }
    fun changeData(data:List<DataItem?>?){
        item=data;
        notifyDataSetChanged()
    }


    class viewholder(itemview:View):RecyclerView.ViewHolder(itemview){
        val name:TextView=itemview.findViewById(R.id.name)
        val price:TextView=itemview.findViewById(R.id.price)
        val image:ImageView=itemview.findViewById(R.id.image)
        val quantity:TextView=itemview.findViewById(R.id.quantity)
        val restaurantId:TextView=itemview.findViewById(R.id.restaurantId)
        val id:TextView=itemview.findViewById(R.id.id)


    }
}
package com.latihan.latihander.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.latihan.latihander.PercobaanActivity
import com.latihan.latihander.R
import com.latihan.latihander.databinding.ActivityPercobaanBinding
import com.latihan.latihander.databinding.ItemCharacterBinding
import com.latihan.latihander.model.ResultsItem

class RickAdapter(val dataRick: List<ResultsItem>)
    : RecyclerView.Adapter<RickAdapter.MyViewHolder>() {

    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var binding : ItemCharacterBinding = ItemCharacterBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false))
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var user = dataRick [position]
         holder.binding.itemNameRick.text = user.name
         holder.binding.itemStatusRick.text = user.status
         holder.binding.itemSpeciesRick.text = user.species

        Glide.with(holder.binding.itemImageRick).load(user.image).into(holder.binding.itemImageRick)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PercobaanActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        if(dataRick != null){
            return dataRick.size
        }
        return 0
    }
}



/*class RickAdapter (val dataRick: List<ResultsItem>):
    RecyclerView.Adapter<RickAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imgRick = view.findViewById<ImageView>(R.id.item_image_Rick)
        val nameRick = view.findViewById<TextView>(R.id.item_name_rick)
        val satatusRick = view.findViewById<TextView>(R.id.item_status_rick)
        val speciesRick = view.findViewById<TextView>(R.id.item_species_rick)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(dataRick != null){
            return dataRick.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameRick.text = dataRick.get(position).name
        holder.satatusRick.text = dataRick.get(position).status
        holder.speciesRick.text = dataRick.get(position).species

        Glide.with(holder.imgRick)
            .load(dataRick.get(position).image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgRick)


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PercobaanActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }

}*/
package com.example.matchpeoples

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MatchAdapter(private  val profileList : List<UserModel>, private val context : Context):
    RecyclerView.Adapter<MatchAdapter.ViewHolder>(){


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val userNameAge : TextView = itemView.findViewById(R.id.user_name_age)
        val userImage: ImageView = itemView.findViewById(R.id.user_image)
        val userOccupation : TextView = itemView.findViewById(R.id.user_occupation)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val profile = profileList[position]
        holder.userNameAge.text=profile.name
        holder.userOccupation.text=profile.occupation



        Glide.with(context)
            .load(profile.ImageUrl)
            .override(150, 150) // Replace 150 with the desired width and height in pixels
            .centerCrop() // or .fitCenter() depending on how you want to scale the image
            .into(holder.userImage)


    }

}
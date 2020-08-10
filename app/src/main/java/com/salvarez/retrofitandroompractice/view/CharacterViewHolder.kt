package com.salvarez.retrofitandroompractice.view

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.salvarez.retrofitandroompractice.R
import com.salvarez.retrofitandroompractice.model.dto.CharacterDto

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var ivCharacter: ImageView = itemView.findViewById(R.id.ivCharacter)
    private var tvNameCharacter: TextView = itemView.findViewById(R.id.tvNameCharacter)
    private var ratingBarCharacter: RatingBar = itemView.findViewById(R.id.ratingBarCharacter)

    fun drawData(characterDto: CharacterDto){
        Glide.with(itemView.context).load(buildUrl(characterDto)).centerCrop().placeholder(android.R.drawable.ic_menu_report_image).into(ivCharacter)
        tvNameCharacter.text = characterDto.name
    }

    private fun buildUrl(characterDto: CharacterDto): String{
        val baseUrl = characterDto.image.path
        val extension = characterDto.image.extension
        return "$baseUrl.$extension"
    }
}
package com.salvarez.retrofitandroompractice.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.salvarez.retrofitandroompractice.R
import com.salvarez.retrofitandroompractice.model.dto.CharacterDto

class CharacterAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    private var dataCharacterList: MutableList<CharacterDto> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataCharacterList.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val characterDto: CharacterDto = dataCharacterList[position]
        holder.drawData(characterDto)
    }

    fun addCharacter(characterDto: CharacterDto){
        dataCharacterList.add(0, characterDto)
        notifyItemInserted(0)
    }

    fun addCharacters(characterList: MutableList<CharacterDto>){
        characterList.forEach {
            addCharacter(it)
        }
    }

}
package com.salvarez.retrofitandroompractice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.salvarez.retrofitandroompractice.R
import com.salvarez.retrofitandroompractice.viewmodel.CharacterViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var characterViewModel: CharacterViewModel
    private var characterAdapter: CharacterAdapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        characterViewModel = ViewModelProviders.of(this).get(CharacterViewModel::class.java)
        setupRecyclerView()

        characterViewModel.getAllCharacters()

        characterViewModel.characterList.observe(this, Observer {
            characterAdapter.addCharacters(it)
            rvCharacters.adapter = characterAdapter
        })
    }

    private fun setupRecyclerView(){
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvCharacters.layoutManager = layoutManager
    }
}

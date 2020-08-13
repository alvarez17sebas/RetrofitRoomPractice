package com.salvarez.retrofitandroompractice.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.salvarez.retrofitandroompractice.R
import com.salvarez.retrofitandroompractice.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val characterViewModel: CharacterViewModel by viewModels()
    private var characterAdapter: CharacterAdapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
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

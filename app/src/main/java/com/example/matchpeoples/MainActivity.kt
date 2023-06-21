package com.example.matchpeoples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var matchAdapter: MatchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        val profileList = listOf(
            UserModel("Emily", 25, "Painter", R.drawable.carsouel1),
            UserModel("John", 30, "Doctor", R.drawable.carousel2),
            UserModel("Priya", 28, "Actor",R.drawable.carousel3),
            // Add more Person objects as needed
        )
        matchAdapter = MatchAdapter(profileList, this)
        recyclerView.adapter = matchAdapter
    }


    private fun init(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
    }
}
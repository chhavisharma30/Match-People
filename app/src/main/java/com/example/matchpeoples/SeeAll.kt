package com.example.matchpeoples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_see_all.*

class SeeAll : AppCompatActivity() {

    private lateinit var matchAdapter: MatchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_all)

        init(recyclerView)
        init(recyclerView2)
        val profileList = listOf(
            UserModel("Emily 25", 25, "Painter", R.drawable.carsouel1),
            UserModel("John 30", 30, "Doctor", R.drawable.carousel2),
            UserModel("Priya 28", 28, "Actor",R.drawable.carousel3),
            // Add more Person objects as needed
        )
        matchAdapter = MatchAdapter(profileList, this)
        recyclerView3.adapter = matchAdapter

    }

    private fun init(recyclerView: RecyclerView){
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
    }
}
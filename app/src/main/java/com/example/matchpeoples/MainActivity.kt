package com.example.matchpeoples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var matchAdapter: MatchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hiding title bar
        window.requestFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        //hiding action bar
        supportActionBar?.hide()
        //making status bar transparent
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR


        init(recyclerView)
        init(recyclerView2)
        val profileList = listOf(
            UserModel("Emily 25", 25, "Painter", R.drawable.carsouel1),
            UserModel("John 30", 30, "Doctor", R.drawable.carousel2),
            UserModel("Priya 28", 28, "Actor",R.drawable.carousel3),
            // Add more Person objects as needed
        )
        matchAdapter = MatchAdapter(profileList, this)
        recyclerView.adapter = matchAdapter
        recyclerView2.adapter=matchAdapter

        Button.setOnClickListener {
            // Start the new activity
            //val intent = Intent(this@MainActivity, SeeAll::class.java)
            val intent = Intent(this@MainActivity,Matched::class.java)
            startActivity(intent)
        }
    }


    private fun init(recyclerView: RecyclerView){
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
    }
}
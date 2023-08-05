package com.example.matchpeoples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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


        FirebaseApp.initializeApp(this)

        fetchAndDisplayData()



        Button.setOnClickListener {
            // Start the new activity
            //val intent = Intent(this@MainActivity, SeeAll::class.java)
            val intent = Intent(this@MainActivity,Matched::class.java)
            startActivity(intent)
        }
    }


    private fun fetchAndDisplayData() {
        val firestore = FirebaseFirestore.getInstance()
        val userCollection = firestore.collection("Users")

        userCollection.get().addOnSuccessListener { querySnapshot ->
            val userList = ArrayList<UserModel>()

            for (document in querySnapshot) {
                val name = document.getString("name") ?: ""
                val age = document.getLong("hone")?.toInt() ?: 0
                val occupation = document.getString("Location") ?: ""
                val imageUrl = document.getString("ImageUrl") ?: ""

                val user = UserModel(name, age, occupation, imageUrl)
                userList.add(user)
            }


            initRecyclerView(userList)
        }.addOnFailureListener { exception ->

        }
    }

    private fun initRecyclerView(userList: List<UserModel>) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView2.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        matchAdapter = MatchAdapter(userList, this)
        recyclerView.adapter = matchAdapter
        recyclerView2.adapter = matchAdapter
    }
}












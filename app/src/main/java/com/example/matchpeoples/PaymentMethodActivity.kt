package com.example.matchpeoples

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PaymentMethodActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val imageIds = arrayOf(R.drawable.cardpic, R.drawable.cardpic, R.drawable.cardpic)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.requestFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_payment_method)
        //hiding action bar
        supportActionBar?.hide()
        //making status bar transparent
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR


        recyclerView = findViewById(R.id.recylerview_card)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        val adapter = ImageAdapter(imageIds)
        recyclerView.adapter = adapter

        // Show imageView2 initially (center item)
        recyclerView.scrollToPosition(1)
    }
}







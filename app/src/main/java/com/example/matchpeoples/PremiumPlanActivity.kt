package com.example.matchpeoples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window

class PremiumPlanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //hiding title bar
        window.requestFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_premium_plan)
        //hiding action bar
        supportActionBar?.hide()
        //making status bar transparent
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}
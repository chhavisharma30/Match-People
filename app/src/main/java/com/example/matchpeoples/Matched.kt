package com.example.matchpeoples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_matched.*
import kotlin.random.Random

class Matched : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hiding title bar
        window.requestFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_matched)
        //hiding action bar
        supportActionBar?.hide()
        //making status bar transparent
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        //hearts
        val displayMetrics = resources.displayMetrics
        val screenWidth = displayMetrics.widthPixels
        val screenHeight = displayMetrics.heightPixels
        val heartWidth = screenWidth / 10 // Adjust the size as per your preference
        val heartHeight = heartWidth // Adjust the size as per your preference

        val layoutParams = heartImageView.layoutParams
        layoutParams.width = heartWidth
        layoutParams.height = heartHeight
        heartImageView.layoutParams = layoutParams

        val numberOfHearts = 20
        val random = java.util.Random()

        for (i in 0 until numberOfHearts) {
            val heart = ImageView(this)
            heart.setImageResource(R.drawable.ic_baseline_favorite_24)

            val heartWidth = random.nextInt(100) + 50 // Adjust the range of sizes as per your preference
            val heartHeight = heartWidth
            val rotation = random.nextInt(61) - 30 // Random rotation between -30 and 30 degrees

            val x = random.nextInt(screenWidth)
            val y = random.nextInt(screenHeight/2)

            val params = FrameLayout.LayoutParams(heartWidth, heartHeight)
            params.leftMargin = x
            params.topMargin = y

            heart.layoutParams = params
            heart.visibility = View.VISIBLE

            heart.rotation = rotation.toFloat()

            (heartImageView.parent as FrameLayout).addView(heart)
        }

        //progress bar
        val progress = 50
        progressBar2.progress = progress

    }
}
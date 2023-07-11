package com.example.matchpeoples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_matched.*
import kotlin.random.Random

class Matched : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matched)

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

            val x = random.nextInt(screenWidth)
            val y = random.nextInt(screenHeight/2)

            val params = FrameLayout.LayoutParams(heartWidth, heartHeight)
            params.leftMargin = x
            params.topMargin = y

            heart.layoutParams = params
            heart.visibility = View.VISIBLE

            (heartImageView.parent as FrameLayout).addView(heart)
        }


    }
}
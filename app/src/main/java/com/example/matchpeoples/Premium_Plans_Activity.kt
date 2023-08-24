package com.example.matchpeoples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class Premium_Plans_Activity : AppCompatActivity(), PaymentResultListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_premium_plans)
        //hiding action bar
        supportActionBar?.hide()
        //making status bar transparent
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        var price = 0

        val platinumPrice1 = findViewById<View>(R.id.Platinum_Price1)
        val platinumPrice2 = findViewById<View>(R.id.Platinum_Price2)
        val platinumPrice3 = findViewById<View>(R.id.Platinum_Price3)
        val Gold_Price1 = findViewById<View>(R.id.Gold_Price1)
        val Gold_Price2 = findViewById<View>(R.id.Gold_price2)
        val Gold_Price3 = findViewById<View>(R.id.Gold_price3)

        val continue_premimumplan = findViewById<View>(R.id.continue_premimumplan)

        platinumPrice1.setOnClickListener {
            price = 100
            platinumPrice2.setBackgroundResource(0)
            platinumPrice3.setBackgroundResource(0)
            Gold_Price1.setBackgroundResource(0)
            Gold_Price2.setBackgroundResource(0)
            Gold_Price3.setBackgroundResource(0)
            platinumPrice1.setBackgroundResource(R.drawable.pink_curve_background)
        }

        platinumPrice2.setOnClickListener {
            price = 200
            platinumPrice1.setBackgroundResource(0)
            platinumPrice3.setBackgroundResource(0)
            Gold_Price1.setBackgroundResource(0)
            Gold_Price2.setBackgroundResource(0)
            Gold_Price3.setBackgroundResource(0)

            platinumPrice2.setBackgroundResource(R.drawable.pink_curve_background)

        }

        platinumPrice3.setOnClickListener {
            price = 300
            platinumPrice1.setBackgroundResource(0)
            platinumPrice2.setBackgroundResource(0)
            Gold_Price1.setBackgroundResource(0)
            Gold_Price2.setBackgroundResource(0)
            Gold_Price3.setBackgroundResource(0)
            platinumPrice3.setBackgroundResource(R.drawable.pink_curve_background)
        }

        Gold_Price1.setOnClickListener{
            price = 400
            platinumPrice1.setBackgroundResource(0)
            platinumPrice2.setBackgroundResource(0)
            platinumPrice3.setBackgroundResource(0)
            Gold_Price2.setBackgroundResource(0)
            Gold_Price3.setBackgroundResource(0)
            Gold_Price1.setBackgroundResource(R.drawable.pink_curve_background)

        }

        Gold_Price2.setOnClickListener{
            price = 500
            platinumPrice1.setBackgroundResource(0)
            platinumPrice2.setBackgroundResource(0)
            platinumPrice3.setBackgroundResource(0)
            Gold_Price1.setBackgroundResource(0)
            Gold_Price3.setBackgroundResource(0)
            Gold_Price2.setBackgroundResource(R.drawable.pink_curve_background)


        }

        Gold_Price3.setOnClickListener{
            price = 600
            platinumPrice1.setBackgroundResource(0)
            platinumPrice2.setBackgroundResource(0)
            platinumPrice3.setBackgroundResource(0)
            Gold_Price1.setBackgroundResource(0)
            Gold_Price2.setBackgroundResource(0)
            Gold_Price3.setBackgroundResource(R.drawable.pink_curve_background)


        }

        continue_premimumplan.setOnClickListener{
            if (price==0){
                Toast.makeText(this@Premium_Plans_Activity, "Please select any plan", Toast.LENGTH_SHORT).show()
            }else{
                openRazorpayGateway(price)

            }
        }
        Checkout.preload(this@Premium_Plans_Activity)

    }

    private fun openRazorpayGateway(amount: Int) {
        val checkout = Checkout()
        checkout.setKeyID("") // Add Razor Pay Api
        try {
            val options = JSONObject()
            options.put("name", "Edfling")
            options.put("description", "This is demo description of our company")
            options.put("theme.color", "#3399cc")
            options.put("currency", "INR")
            options.put("amount", amount * 100)


            val retryObj = JSONObject()
            retryObj.put("enabled", true)
            retryObj.put("max_count", 4)
            options.put("retry", retryObj)
            checkout.open(this@Premium_Plans_Activity, options)

        } catch (e: Exception) {

            Toast.makeText(this@Premium_Plans_Activity, "Error in Payment : " + e.message, Toast.LENGTH_LONG)
                .show()
                 e.printStackTrace()
        }
    }



    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this@Premium_Plans_Activity, "Payment is successfull", Toast.LENGTH_SHORT).show()
    }
    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this@Premium_Plans_Activity, "Payment is failed", Toast.LENGTH_SHORT).show()
    }
}


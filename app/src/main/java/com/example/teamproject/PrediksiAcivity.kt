package com.example.teamproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class PrediksiAcivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prediksi_acivity)

        val splashTime: Long = 3000

        Handler().postDelayed({
            val intent = Intent(this, OutputActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTime)
    }
}
package com.example.teamproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class InputActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val btnMoveActivity: Button = findViewById(R.id.button_prediksi)
        btnMoveActivity.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button_prediksi -> {
                val moveIntent = Intent(this@InputActivity, PrediksiAcivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
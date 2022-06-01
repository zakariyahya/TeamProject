package com.example.teamproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LetsgoActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letsgo_screen)

        val btnMoveActivity: Button = findViewById(R.id.button_lets_go)
        btnMoveActivity.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_lets_go -> {
                val moveIntent = Intent(this@LetsgoActivity, InputActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
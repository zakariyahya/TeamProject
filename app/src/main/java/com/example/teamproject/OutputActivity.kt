package com.example.teamproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class OutputActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)
        val btnMoveActivity: Button = findViewById(R.id.button_back_home)
        btnMoveActivity.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button_back_home -> {
                val moveIntent = Intent(this@OutputActivity, LetsgoActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
package com.example.teamproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader

class OutputActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        val minput = InputStreamReader(assets.open("dki4.csv"))
        val reader = BufferedReader(minput)

        var line : String?
        var displayData : String = ""
        val randoms = (0..450).random().toString()
        while (reader.readLine().also { line = it } != null){
            val row : List<String> = line!!.split(",")
            if (row[0] == randoms) {
                displayData = displayData + "Polusi pada \t"+row[1] +"\t di Bundaran HI" +"\t sebesar"+
                        "\n pm10 = \t"+ row[2] + ",\t pm25 = " + row[3]+ ",\t so2 = " + row[4]+ ",\t co = " + row[5]+
                        ",\t o3 = " + row[6]+ ",\t no2 = " + row[7]+ ", dan Gas Rumah Kaca co2 = " + row[8] +".\n"+
                        "hasil ISPU ialah Tidak Baik, kami menganjurkan untuk menjaga kesehatan dan menanam pohon jenis ______ sebanyak 3 buah"

            }
        }

        var txtData = findViewById(R.id.textView7) as TextView
        txtData.text = displayData

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
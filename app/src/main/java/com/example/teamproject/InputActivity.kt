package com.example.teamproject

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class InputActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var option: Spinner
    private lateinit var tvDatePicker: TextView
    private lateinit var btnDatePicker: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        option = findViewById(R.id.sp_option) as Spinner
//        result = findViewById(R.id.inputDaerah) as TextView
        val locations = arrayOf("Bundaran HI","Kelapa Gading","Jagakarsa","Lubang Buaya","Kebon Jeruk")

        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,locations)

        tvDatePicker = findViewById(R.id.inputTanggal)
        btnDatePicker = findViewById(R.id.buttonDate)

        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
            myCalendar.set(Calendar.YEAR,i)
            myCalendar.set(Calendar.MONTH,i2)
            myCalendar.set(Calendar.DAY_OF_MONTH,i3)
            updateLable(myCalendar)
        }

        btnDatePicker.setOnClickListener{
            DatePickerDialog(this,datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
//        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//                result.text = "Please select an Option"
//            }
//
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                result.text = locations.get(p2)
//            }
//        }


        init()

        val btnMoveActivity: Button = findViewById(R.id.button_prediksi)
        btnMoveActivity.setOnClickListener{
            if(tvDatePicker.text.toString().isEmpty()){
                Toast.makeText(this,"Date input must not be empty",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, PrediksiAcivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun updateLable(myCalendar: Calendar) {
        val myFormat="dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat,Locale.UK)
        tvDatePicker.setText(sdf.format(myCalendar.time))
    }

    private fun init(){
//        result = findViewById(R.id.inputDaerah)
        tvDatePicker = findViewById(R.id.inputTanggal)

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
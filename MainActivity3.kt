package com.example.myweatherapplication
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedViewActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)



        intent.getDoubleExtra("temperature", 0.0)
        intent.getDoubleExtra("max_temperature", 0.0)
        intent.getDoubleExtra("min_temperature", 0.0)
        intent.getStringExtra("weather_description")


        findViewById<TextView>(R.id.date)
        findViewById<TextView>(R.id.temperature)
        findViewById<TextView>(R.id.max_temp)
        findViewById<TextView>(R.id.min_tempp)
        findViewById<TextView>(R.id.weather_conditions)

    }
}
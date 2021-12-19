package com.nishajain.readfromassets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = readFromAsset()
        val textView = findViewById<TextView>(R.id.textView)
        textView.setText(data)
    }
    private fun readFromAsset(): String {
        val file_name = "data.json"
        val bufferReader = application.assets.open(file_name).bufferedReader()
        val data = bufferReader.use {
            it.readText()
        }
        Log.d("Read", data)

        return data;
    }
}
package com.sampson.kotlinintegrationtests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var textFormatter: TextFormatter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNumber = findViewById<EditText>(R.id.edtInsertNumber)
        val btnAction = findViewById<Button>(R.id.btnAction)

        textFormatter = TextFormatter(FactorialGenerator(),applicationContext)

        btnAction.setOnClickListener {
            edtNumber.setText(textFormatter.getFactorialResult(edtNumber.text.toString().toInt()))
        }
    }
}
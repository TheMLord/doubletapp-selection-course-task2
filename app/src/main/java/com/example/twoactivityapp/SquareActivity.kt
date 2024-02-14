package com.example.twoactivityapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SquareActivity : AppCompatActivity() {
    private val logSquareActivityName = "SquareActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(logSquareActivityName, "onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        val intent = intent
        val bundle: Bundle? = intent.extras
        val textView = findViewById<TextView>(R.id.square_number_tv)
        val n: Int = bundle?.getString(MainActivity.KEY_BUNDLE_NUMBER)?.toInt() ?: 0
        Log.d(logSquareActivityName, "получение через bundle number=$n")

        textView.text = (n * n).toString()
        Log.d(logSquareActivityName, "передача textView значения number^2=${n * n}")
    }

    fun onClickButtonGoToMain(view: View) {
        Log.d(logSquareActivityName, "закрытие SquareActivity")
        finish()
    }
}
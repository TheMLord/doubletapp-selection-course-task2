package com.example.twoactivityapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity

private var number = -1


class MainActivity : ComponentActivity() {

    private val logMainName = "MainActivity"

    companion object {
        const val KEY_BUNDLE_NUMBER = "number"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(logMainName, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        number += 1
        Log.d(logMainName, "onStart")
        Log.d(logMainName, "изменение значения числа, текущее $number")
    }

    override fun onResume() {
        super.onResume()
        val numberView = findViewById<TextView>(R.id.main_text_view)
        numberView.text = number.toString()
        Log.d(logMainName, "onResume")
        Log.d(logMainName, "отрисовка числа на экране")

    }

    override fun onPause() {
        super.onPause()
        Log.d(logMainName, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(logMainName, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(logMainName, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(logMainName, "onDestroy")
    }

    fun onClickButton(view: View) {
        Log.d(logMainName, "переход на SquareActivity")
        val intent = Intent(this, SquareActivity::class.java).apply {
            val bundle = Bundle().apply { putString(KEY_BUNDLE_NUMBER, number.toString()) }
            putExtras(bundle)
        }
        startActivity(intent)
    }
}
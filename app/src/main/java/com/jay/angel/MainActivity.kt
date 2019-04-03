package com.jay.angel

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        button_graph_3.setOnClickListener {
            startActivity(Intent(this@MainActivity, Graph3Activity::class.java))
        }

        button_graph_5.setOnClickListener {
            startActivity(Intent(this@MainActivity, Graph5Activity::class.java))
        }
    }
}

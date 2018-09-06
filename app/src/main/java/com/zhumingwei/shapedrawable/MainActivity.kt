package com.zhumingwei.shapedrawable

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv1.setShape(20f,Color.RED)
        tv2.setShape(30f,Color.RED,10f)
        tv2.setTextColor(Color.BLACK)
    }
}

package com.app.time2speak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_activity04.*

class activity04 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity04)

progressBar.progress=0

        btn_play.setOnClickListener{


                progressBar.progress=(progressBar.progress +99 ) % 100




        }
    }
}

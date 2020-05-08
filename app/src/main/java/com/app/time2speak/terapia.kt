package com.app.time2speak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_terapia.*

class terapia : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terapia)


        img_voice.setOnClickListener{
         //   val intent: Intent = Intent(this,practica_palabra::class.java)
            overridePendingTransition( R.anim.slide_in_right,R.anim.slide_out_left)
            startActivity(intent)
        }
    }
}

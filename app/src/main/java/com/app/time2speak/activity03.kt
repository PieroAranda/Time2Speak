package com.app.time2speak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_activity03.*

class activity03 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity03)


        img_voice.setOnClickListener{
            val intent: Intent = Intent(this,activity04::class.java)
            overridePendingTransition( R.anim.slide_in_right,R.anim.slide_out_left)
            startActivity(intent)
        }
    }
}

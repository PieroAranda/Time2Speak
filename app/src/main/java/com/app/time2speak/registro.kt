package com.app.time2speak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registro.*

class registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        btnRegistro2.setOnClickListener{
            val intent = Intent(this,inicioSesion::class.java)
            overridePendingTransition( R.anim.slide_in_left,R.anim.slide_out_right)
            startActivity(intent)
        }
    }
}

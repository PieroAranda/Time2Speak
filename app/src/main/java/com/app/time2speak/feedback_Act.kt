package com.app.time2speak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_feedback_.*

class feedback_Act : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback_)

        btn_aceptar.setOnClickListener {
            val intent =Intent(this,lista_letras::class.java)
            startActivity(intent)
        }
    }

}

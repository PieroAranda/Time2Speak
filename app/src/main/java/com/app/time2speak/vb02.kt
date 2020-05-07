package com.app.time2speak

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_vb02.*

class vb02 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vb02)


        img_enano.setOnClickListener (){
            val intent: Intent = Intent(this,activity03::class.java)
            overridePendingTransition( R.anim.slide_in_right,R.anim.slide_out_left)
            startActivity(intent)
        }

        img_erizo.setOnClickListener (){

            val toast= Toast.makeText(applicationContext, "Completado", Toast.LENGTH_LONG)
            toast.show()
        }

        img_estrella.setOnClickListener (){

            val toast= Toast.makeText(applicationContext, "Completado", Toast.LENGTH_LONG)
            toast.show()
        }

    }
}

package com.app.time2speak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_vb01.*

class vb01 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vb01)

        img_a.setOnClickListener{

            val intent: Intent = Intent(this,vb02::class.java)
            overridePendingTransition( R.anim.slide_in_right,R.anim.slide_out_left)
            startActivity(intent)
        }

        img_b.setOnClickListener (){
            val toast= Toast.makeText(applicationContext, "Completado", Toast.LENGTH_SHORT)
            toast.show()
        }
        img_c.setOnClickListener (){
            val toast= Toast.makeText(applicationContext, "Completado", Toast.LENGTH_SHORT)
            toast.show()
        }
        img_d.setOnClickListener (){
            val toast= Toast.makeText(applicationContext, "Completado", Toast.LENGTH_SHORT)
            toast.show()
        }
        img_e.setOnClickListener (){
            val toast= Toast.makeText(applicationContext, "Completado", Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}

package com.app.time2speak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent: Intent = Intent(this,lista_letras::class.java)
        overridePendingTransition( R.anim.slide_in_right,R.anim.slide_out_left)



        btn_terapia.setOnClickListener{


            val alerta = alert(""){
                title("¿Permitir a Time2speak acceder a tu microfono?")
                positiveButton ("Permitir") { startActivity(intent) }
                negativeButton ("Denegar"){ toast("Se denego el acceso al microfono")}
            }

            alerta.show()
        }



    }
}

package com.app.time2speak

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_inicio_sesion.*
import org.jetbrains.anko.email
import java.util.regex.Pattern

class inicioSesion : AppCompatActivity() {
    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)
        btnIniciarSesion.setOnClickListener{
            if(validateEmail() and validateContraseña()){
            val intent = Intent(this,MainActivity::class.java)
            overridePendingTransition( R.anim.slide_in_right,R.anim.slide_out_left)
            startActivity(intent)}
        }
        btnRegistrarse.setOnClickListener{
            val intent = Intent(this,registro::class.java)
            overridePendingTransition( R.anim.slide_in_left,R.anim.slide_out_right)
            startActivity(intent)
        }
    }

   // override fun onClick(v: View?){
   //     when(v?.id){
   //         R.id.btnIniciarSesion->{
   //             if(validate()){
   //
   //             }
   //         }
   //     }
   // }

    private fun validateEmail(): Boolean {
        if (txtEmail.text.toString().isEmpty()){
            txtEmail.error = "Ingrese Correo Electronico"
           return false
        }else if( !EMAIL_ADDRESS_PATTERN.matcher(txtEmail.text.toString().trim()).matches()){
            txtEmail.error = "Ingrese un correo valido"
            return false
        }else return true
    }


    private fun validateContraseña() :Boolean{
        if(txtEmail.text.toString().isEmpty()){
            txtContra.error = "Ingrese su Contraseña"
            return false
        }
        return true
    }

}

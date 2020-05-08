package com.app.time2speak

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
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

        img_mic.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(this)
            val alertDialogBuilder2 = AlertDialog.Builder(this)

            alertDialogBuilder.setMessage("Esta usted conforme con la grabacion?").setCancelable(false)
                .setPositiveButton("Si",DialogInterface.OnClickListener(){_,_->
                    alertDialogBuilder2.setMessage("Su audio ha sido enviado").setCancelable(false)
                        .setPositiveButton("Aceptar",DialogInterface.OnClickListener(){_,_->
                            val intent: Intent=Intent(this,feedback_Act::class.java)
                            startActivity(intent)
                        }).create().show()
                }).setNegativeButton("no",DialogInterface.OnClickListener(){dialog,_->
                    dialog.cancel()
                }).create().show()
        }
    }
}

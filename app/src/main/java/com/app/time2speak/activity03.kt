package com.app.time2speak

import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaRecorder
import android.os.Bundle
import android.os.Environment
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_activity03.*
import java.io.IOException

class activity03 : AppCompatActivity() {

    private var output: String? = null
    private var mediaRecorder: MediaRecorder? = null
    private var state: Boolean = false
    private var recordingStopped: Boolean = false
    private var mp:MediaPlayer?=null
    private var cont: Int=0
    val TV=findViewById<TextView>(R.id.txt_cont)
    val num=TV.text.toString()
    val con=num.toInt()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity03)

        //output = Environment.getExternalStorageDirectory().absolutePath + "/recording.mp3"
        //output= "R.raw.recording.mp3"
        output = Environment.getExternalStorageDirectory().absolutePath + "/recording.mp3"
        mediaRecorder = MediaRecorder()

        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        mediaRecorder?.setOutputFile(output)


        img_voice.setOnClickListener {
            val intent: Intent = Intent(this, activity04::class.java)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            startActivity(intent)
        }

        img_mic.setOnClickListener {

                mediaRecorder?.prepare()
                mediaRecorder?.start()
                state = true
                Toast.makeText(this, "Recording started!", Toast.LENGTH_SHORT).show()

        }

        btn_pause.setOnClickListener {
            if (state) {
                mediaRecorder?.stop()
                mediaRecorder?.release()
                state = false
                Toast.makeText(this, "Recording stopped", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "You are not recording right now!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun Confirmacion_audio(){
        val alertDialogBuilder = AlertDialog.Builder(this)
        val alertDialogBuilder2 = AlertDialog.Builder(this)

        alertDialogBuilder.setMessage("Esta usted conforme con la grabacion?").setCancelable(false)
            .setPositiveButton("Si",DialogInterface.OnClickListener(){_,_->
                alertDialogBuilder2.setMessage("Su audio ha sido enviado").setCancelable(false)
                    .setPositiveButton("Aceptar",DialogInterface.OnClickListener(){dialog,_->
                        if(cont<=10) {
                            dialog.cancel()
                            val txt1=findViewById<TextView>(R.id.txt_cont)
                        }else {
                            val intent: Intent = Intent(this, feedback_Act::class.java)
                            startActivity(intent)
                        }
                    }).create().show()
            }).setNegativeButton("no",DialogInterface.OnClickListener(){dialog,_->
                dialog.cancel()
            }).create().show()
    }


    private fun Reproducir_audio(){
        //mp= MediaPlayer.create(this,"Environment.getExternalStorageDirectory().absolutePath + "/recording.mp3)
    }
}

package com.app.time2speak

import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.speech.tts.TextToSpeech
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_terapia.*
import org.w3c.dom.Text
import java.util.*

class terapia : AppCompatActivity() {

    lateinit var mTTS:TextToSpeech

    private var output: String? = null
    private var mediaRecorder: MediaRecorder? = null
    private var state: Boolean = false
    private var recordingStopped: Boolean = false
    private var mp: MediaPlayer?=null
    private var cont: Int=0
    val TV=findViewById<TextView>(R.id.txt_cont)
    val num=TV.text.toString()
    val con=num.toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terapia)


        output = Environment.getExternalStorageDirectory().absolutePath + "/recording.mp3"
        mediaRecorder = MediaRecorder()

        mediaRecorder?.setAudioSource(MediaRecorder.AudioSource.MIC)
        mediaRecorder?.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
        mediaRecorder?.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
        mediaRecorder?.setOutputFile(output)

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




        speaker.setOnClickListener{

            val toSpeak = txtPalabraImagen.text.toString()
            mTTS.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null)
        }

        mTTS = TextToSpeech(applicationContext,TextToSpeech.OnInitListener { status->
            if (status != TextToSpeech.ERROR){
                mTTS.language = Locale.getDefault()
            }


        })


    }
    private fun Confirmacion_audio(){
        val alertDialogBuilder = AlertDialog.Builder(this)
        val alertDialogBuilder2 = AlertDialog.Builder(this)

        alertDialogBuilder.setMessage("Esta usted conforme con la grabacion?").setCancelable(false)
            .setPositiveButton("Si", DialogInterface.OnClickListener(){ _, _->
                alertDialogBuilder2.setMessage("Su audio ha sido enviado").setCancelable(false)
                    .setPositiveButton("Aceptar", DialogInterface.OnClickListener(){ dialog, _->
                        if(cont<=10) {
                            dialog.cancel()
                            val txt1=findViewById<TextView>(R.id.txt_cont)
                        }else {
                            val intent: Intent = Intent(this, feedback_Act::class.java)
                            startActivity(intent)
                        }
                    }).create().show()
            }).setNegativeButton("no", DialogInterface.OnClickListener(){ dialog, _->
                dialog.cancel()
            }).create().show()
    }
}

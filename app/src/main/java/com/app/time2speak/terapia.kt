package com.app.time2speak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_terapia.*
import org.w3c.dom.Text
import java.util.*

class terapia : AppCompatActivity() {

    lateinit var mTTS:TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terapia)

        mTTS = TextToSpeech(applicationContext,TextToSpeech.OnInitListener { status->
            if (status != TextToSpeech.ERROR){
                mTTS.language = Locale.getDefault()
            }

        })

        speaker.setOnClickListener{

            val toSpeak = txtPalabraImagen.text.toString()
            mTTS.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null)
        }



    }
}

package com.silviaodwyer.leetspeaktranslator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    var openTranslatorButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        openTranslatorButton = findViewById(R.id.openTranslatorButton)

        openTranslatorButton?.setOnClickListener {
            var intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

package com.silviaodwyer.leetspeaktranslator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/**
 * Created by silvi on 08/02/2018.
 */
class TranslatorActivity : AppCompatActivity() {
    private var outputMessage: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translator)
        var translateButton = findViewById<Button>(R.id.translateButton)
        outputMessage = findViewById<TextView>(R.id.outputMessage)
        outputMessage?.text = ""
        outputMessage?.movementMethod = ScrollingMovementMethod()

        translateButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {}
            // Contents in the editText are saved in a variable
            var messageToBeTranslated = findViewById<EditText>(R.id.userInput)
            var appendMessage = ("Your entered message is as follows: $messageToBeTranslated")
        }


        )
    }
}
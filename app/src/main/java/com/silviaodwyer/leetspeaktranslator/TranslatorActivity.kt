package com.silviaodwyer.leetspeaktranslator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/**
 * Created by silvi on 08/02/2018.
 */

private val TAG = "MainActivity"
class TranslatorActivity : AppCompatActivity() {
    private var outputMessage: TextView? = null
    var userInput = findViewById<EditText>(R.id.userInput)

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "OnCreate: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translator)
        var translateButton = findViewById<Button>(R.id.translateButton)
        outputMessage = findViewById<TextView>(R.id.outputMessage)
        outputMessage?.text = ""
        outputMessage?.movementMethod = ScrollingMovementMethod()

        translateButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                // Contents in the editText are saved in a variable
                Log.d(TAG, "OnClick: called")
                val messageToBeTranslated = userInput?.text
                var appendMessage = ("Your entered message is as follows: $messageToBeTranslated")
            }
        })
    }

    override fun onStart() { // To get access to these auto-generated methods, just press CTRL + O and start typing!
        Log.d(TAG, "OnStart: called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.d(TAG, "OnRestoreInstanceState: called")
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onRestart() {
        Log.d(TAG, "OnRestart: called")
        super.onRestart()
    }

    override fun onResume() {
        Log.d(TAG, "OnResume: called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "OnPause: called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.d(TAG, "OnSaveInstanceState called")
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        Log.d(TAG, "OnStop: called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "OnDestroy: called")
        super.onDestroy()
    }
}
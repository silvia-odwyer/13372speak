package com.silviaodwyer.leetspeaktranslator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.silviaodwyer.leetspeaktranslator.R.id.textView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var translatorButton: Button? = null
    private var aboutButton: Button? = null
    private var outputMessage: TextView? = null
    private var numTimesClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        translatorButton = findViewById<Button>(R.id.button)      // Click CTRL and hover over editText to see it in XML
        outputMessage = findViewById<TextView>(R.id.textView5)

        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()

        button?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                numTimesClicked += 1
                textView?.append("Opening translator . . . :)")


            }
        })
    }
}


package com.silviaodwyer.leetspeaktranslator

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.silviaodwyer.leetspeaktranslator.R
import android.content.Context.INPUT_METHOD_SERVICE
import android.text.Editable
import android.view.inputmethod.InputMethodManager
import android.content.ClipData
import android.content.ClipboardManager

/**
 * Created by Silvia O'Dwyer on 08/02/2018.
 * Still a work-in-progress.
 * The functions used here may form the basis for another, more advanced app,
 * an app where strings can be converted to a variety of alphabets, etc.,
 * All comments welcome :)
 */

private val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private var outputMessage: TextView? = null
    private var translateButton: Button? = null
    private var userInput: EditText? = null
    private var advTranslateButton: Button? = null

    var messageToBeTranslated: String = ""
    val alphabetArray: Array<Any> = arrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '.', ',', "'", '1', '2', '3', '4', '5', '6', '7', '8', '9', '0')

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userInput = findViewById(R.id.userInput)
        outputMessage = findViewById(R.id.outputMessage)
        translateButton = findViewById(R.id.translateButton)
        advTranslateButton = findViewById(R.id.advTranslateButton)

        fun advConvertToLeetSpeak(messageToBeTranslated: String, alphabetArray: Array<Any>): String {

            var messageToBeTranslated: String = messageToBeTranslated.toLowerCase()
            var outputMessage: String = ""
            val leetArray: Array<Any> = arrayOf("4", "8", "(", "|)", '3', "|=", "9", "|-|", "!", "_|", 'X', "1", "|\\//|", "|V", "0", "|*", "(_,)", "2", "5", "7", "(_)", "\\//", "\\//\\//", "><", "7", "2", ' ', '.', ',', "'", "''", '1', '2', '3', '4', '5', '6', '7', '8', '9', '0')
            var listOfMessage = messageToBeTranslated.toList()

            for (letter in listOfMessage) {
                var index_number = alphabetArray.indexOf(letter)
                var leetElement = leetArray[index_number]
                outputMessage += leetElement
            }

            outputMessage = outputMessage.toString()
            return outputMessage
        }

        fun specialWordConvert(word : String, leetWordList : List<String>, englishWordList : List<String>) : String {
            var translatedWord = ""
            for (word1 in englishWordList) {
                if (word1 == word){
                    var wordIndex: Int = englishWordList.indexOf(word1)
                    var leetWord: String = leetWordList[wordIndex]
                    translatedWord += leetWord
                    //println("$translatedWord")
                }
            }
            return translatedWord
        }

        fun convertToLeetSpeak(messageToBeTranslated: String, alphabetArray: Array<Any>): String {

            var outputMessage: String = ""
            var fullWord: String = ""
            val leetArray: Array<Any> = arrayOf('4', 'b', 'c', 'd', '3', 'f', 'g', 'h', '1', 'j', 'k', 'l', 'm', 'n', '0', 'p', 'q', 'r', '5', '7', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '.', ',', "'", "''", '1', '2', '3', '4', '5', '6', '7', '8', '9', '0')

            val leetWordList: List<String> = listOf("1337", "1337", "h4xor", "pwn", "j00", "kewl", "roxx0rs", "w00t", "w00t", "d00d")
            val englishWordList: List<String> = listOf("leet", "elite", "hacker", "own", "you", "cool", "rocks", "woo", "yay", "dude")

            var leetSentenceb4Conversion: String = ""
            var splitString = messageToBeTranslated.split(" ")

            //println(splitString)
            for (word in splitString) {
                //println("WORD: $word")
                fullWord = ""

                if (word in englishWordList){
                    //println("$word is in the English Word List.")
                    var leetWord = specialWordConvert(word, leetWordList, englishWordList)
                    leetSentenceb4Conversion += ("$leetWord ")

                }

                else{
                    //println("$word is not in the English Word List")
                    var listOfWord = word.toList()
                    //println("List of the non-Leet word is: $listOfWord")
                    fullWord = ""

                    for (letter in listOfWord) {
                        var index_number = alphabetArray.indexOf(letter)
                        var leetElement = leetArray[index_number]
                        fullWord += leetElement
                    }
                    //println("FULL WORD: $fullWord")
                    //fullWord = fullWord.toString()
                    leetSentenceb4Conversion += ("$fullWord ")

                }
            }

            leetSentenceb4Conversion = leetSentenceb4Conversion.toString()
            println(leetSentenceb4Conversion)
            Log.d(TAG, "THE FINAL TRANSLATED MESSAGE IS: $leetSentenceb4Conversion")

            return leetSentenceb4Conversion

        }

        fun copyToClipboard(leetTranslation: String){
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("leetMessage", "$leetTranslation")
            clipboard!!.setPrimaryClip(clip)
        }

        translateButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                // Contents in the editText are saved in a variable
                //Log.d(TAG, "OnClick: called")
                val messageToBeTranslated = userInput?.text
                //outputMessage?.movementMethod = ScrollingMovementMethod()
                outputMessage?.text = ""

                var stringOfMessage: String = messageToBeTranslated.toString()
                stringOfMessage = stringOfMessage.toLowerCase()

                var leetTranslation: String = convertToLeetSpeak(stringOfMessage, alphabetArray)

                var clipboardMessage = copyToClipboard(leetTranslation)
                outputMessage?.setText("$leetTranslation")


                // Check if no view has focus:
                val view: View = getCurrentFocus()
                if (view != null) {
                    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(view!!.getWindowToken(), 0)
                }
            }
        })

        advTranslateButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val messageToBeTranslated = userInput?.text
                outputMessage?.movementMethod = ScrollingMovementMethod()
                outputMessage?.text = ""

                var stringOfMessage: String = messageToBeTranslated.toString()
                stringOfMessage = stringOfMessage.toLowerCase()

                var leetTranslation: String = advConvertToLeetSpeak(stringOfMessage, alphabetArray)

                outputMessage?.setText("$leetTranslation")

                var clipboardMessage = copyToClipboard(leetTranslation)

                val view: View = getCurrentFocus()
                if (view != null) {
                    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputMethodManager.hideSoftInputFromWindow(view!!.getWindowToken(), 0)
                }
            }

        })

        userInput?.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                userInput?.setText("")
            }
        })

    }

    // Methods used for debugging purposes and outputing to the console
    override fun onStart() { // Tip for anyone reading this code (HI!): To get access to these auto-generated methods, just press CTRL + O and select your method.
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

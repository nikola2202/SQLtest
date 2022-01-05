package com.nikola.mysqltest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import com.nikola.TextDAO
import com.nikola.TextDatabase
import com.nikola.entities.AddText
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var textInput: TextView
    lateinit var et_text: EditText
    lateinit var dao: TextDatabase
    lateinit var delete: Button
    lateinit var continueBtn: Button
    var tempText: AddText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        continueBtn = findViewById(R.id.btnContinue)
        continueBtn.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
            finish()
        }

        textInput = findViewById(R.id.textInput)
        et_text = findViewById(R.id.enterText)

        dao = TextDatabase.getInstance(this)


        textInput.text =  dao.textDAO().getAllText().text
        if(tempText != null) {
            if (!tempText?.text?.isEmpty()!!)
            {
                textInput.text = tempText!!.text
            }
        }

    }

    fun EnterBtn(view: View) {

        if (et_text.text.toString().isEmpty()) {
            Toast.makeText(this, "Cannot be empty.", Toast.LENGTH_SHORT).show()
        } else {
            textInput.text = et_text.text

            if (textInput.text != "")
            {
                dao.textDAO().insertText(AddText(1, et_text.text.toString()))
            }else
            {
                dao.textDAO().updateText(AddText(1, et_text.text.toString()))
            }
        }

    }

    fun DeleteBtn(view: android.view.View) {

        textInput.text = ""

    }

}
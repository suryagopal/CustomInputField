package com.example.edittextviewz.customtextInput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.edittextviewz.R
import kotlinx.android.synthetic.main.activity_sample.*

class Sample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        errorInputText.error = "Error banner"
        focusInputLabel.requestFocus()
        passwordCustomLabel.setPassword()
    }
}
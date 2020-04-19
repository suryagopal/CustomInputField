package com.example.edittextviewz.inputview

import android.R.attr.password
import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import com.example.edittextviewz.R
import kotlinx.android.synthetic.main.activity_input_field.*
import kotlinx.android.synthetic.main.custom_text_input_layout.view.*


class InputFieldActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_field)

        focusInput.input_text.setText("Focused Text")
        focusInput.requestFocus()

        errorInput.input_text.setText("Hello Error")
        errorInput.setError("Error banner text")

        disableInput.toggleEnable()

        passwordInput.setPasswordType()


    }
}

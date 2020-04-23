package com.example.edittextviewz.customtextInput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import com.example.edittextviewz.R
import kotlinx.android.synthetic.main.activity_sample.*

class Sample : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        errorInputText.error = "Error banner"
        focusInputLabel.requestFocus()
        passwordCustomLabel.setPassword()

        validCustomLabel.editText?.apply {
            onTextChanged {
                val len = it?.length ?: 0
                when {
                    len in 1..3 -> validCustomLabel.isError = true
                    len > 6 -> validCustomLabel.isSuccess = true
                    else -> {
                        validCustomLabel.isError = false
                        validCustomLabel.isSuccess = false
                    }
                }
            }
        }
    }

    fun TextView.onTextChanged(onTextChanged: (s: CharSequence?) -> Unit) : TextWatcher {
        return textWatcher(onTextChanged).also { addTextChangedListener(it) }
    }

    fun textWatcher(onTextChanged: (s: CharSequence?) -> Unit): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                onTextChanged(s)
            }
        }
    }
}
package com.example.edittextviewz.customtextInput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import com.example.edittextviewz.R
import kotlinx.android.synthetic.main.activity_sample.*
import kotlinx.android.synthetic.main.input_usecases.*
import java.util.*

class SampleCustomAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_usecases)

        case3.setPassword()

       /* case11.let { edittext ->
            val isInError = { t: CharSequence? -> (t?.length ?: 0) in (1..5) }
            edittext.onTextChanged { edittext.isError = isInError(it) }
            edittext.isError = isInError(edittext.text)
        }*/

        case11.let { editText ->
            val isInError = { t: CharSequence? -> (t?.length ?: 0) in (1..5) }
            case11.editText?.onTextChanged { editText.isError = isInError(it) }
            editText.isError = isInError(case11.editText?.text)
        }

        case12.let { editText ->
            val isInError = { t: CharSequence? -> t?.all { Character.isDigit(it) } ?: false }
            case12.editText?.onTextChanged { editText.isError = isInError(it) }
            editText.isError = isInError(case12.editText?.text)
        }


       /* case13.apply {
            setCompoundDrawableBehaviourRelative(2, CompoundDrawableBehaviour.Button("a11y") { i, v ->
                var txt = this.text?.toString() ?: ""
                if (txt.isNotEmpty()) {
                    txt = if (Character.isUpperCase(txt[0])) {
                        txt.toLowerCase(Locale.UK)
                    } else {
                        txt.toUpperCase(Locale.UK)
                    }
                    setText(txt)
                }
            })
        }*/

        case14.editText?.apply {
            onTextChanged {
                val len = it?.length ?: 0
                when {
                    len in 1..3 -> case14.isError = true
                    len > 6 -> case14.isSuccess = true
                    else -> {
                        case14.isError = false
                        case14.isSuccess = false
                    }
                }
            }
        }



    }

    private fun TextView.onTextChanged(onTextChanged: (s: CharSequence?) -> Unit) : TextWatcher {
        return textWatcher(onTextChanged).also { addTextChangedListener(it) }
    }

    private fun textWatcher(onTextChanged: (s: CharSequence?) -> Unit): TextWatcher {
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                onTextChanged(s)
            }
        }
    }
}


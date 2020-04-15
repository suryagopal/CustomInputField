package com.example.edittextviewz

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.custom_text_input_layout.view.*


class SortCodeInputField @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.sort_code_layout, this, true)

        orientation = VERTICAL

        obtainStyleAttributes(context, attrs)

        setListener()
    }

    private fun setListener() {
        var previousLength = 0
        input_text.onChange {
            if (previousLength < it.length) {
                when (it.length) {
                    2 -> input_text.append("-")
                    5 -> input_text.append("-")
                }
            } else {
                when (it.length) {
                    3 -> {
                        input_text.setText(input_text.text.toString().substring(0,2))
                    }
                    6 -> {
                        input_text.setText(input_text.text.toString().substring(0,5))
                    }
                }
            }

            input_text.setSelection(input_text.text.toString().length)
            previousLength = it.length
        }

    }

    private fun obtainStyleAttributes(context: Context, attrs: AttributeSet?) {
        context.theme.obtainStyledAttributes(attrs, R.styleable.SortCodeInputField, 0, 0).apply {
            val hintText = getString(R.styleable.SortCodeInputField_SortCodeHint)
            input_text.hint = hintText

        }.recycle()
    }

    fun setError(error: String) {
        input_layout.error = error
    }

    fun clearError() {
        input_layout.isErrorEnabled = false
    }
}

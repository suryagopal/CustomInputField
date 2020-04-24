package com.example.edittextviewz.customtextInput

import android.content.Context
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import com.example.edittextviewz.R
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.custom_text_input_layout.view.*

class CustomTextInput @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.textInputLayoutStyle
) : TextInputLayout(context, attrs, defStyleAttr) {

    private var isPasswordShown: Boolean = false

    private val inputLayout: TextInputLayout = this

    fun setPassword() {
        inputLayout.suffixText = "Show"

        inputLayout.suffixTextView.setOnClickListener {

            when (isPasswordShown) {
                true -> {
                    inputLayout.suffixText = "Hide"
                    isPasswordShown = false

                    inputLayout.editText!!.transformationMethod =
                        HideReturnsTransformationMethod.getInstance()

                }
                false -> {
                    inputLayout.suffixText = "Show"
                    isPasswordShown = true

                    inputLayout.editText!!.transformationMethod =
                        PasswordTransformationMethod.getInstance()
                }
            }
        }
    }

    fun setError(error: String) {
        inputLayout.error = error
    }

    open var isError: Boolean = false
        set(value) {
            if (value != field) {
                field = value
                if (isError) {
                    isSuccess = false
                }
                refreshState()
            }
        }
    open var isSuccess: Boolean = false
        set(value) {
            if (value != field) {
                field = value
                if (isSuccess) {
                    isError = false
                }
                refreshState()
            }
        }

    private fun refreshState() {
        when {
            isSuccess -> {
                inputLayout.endIconMode = END_ICON_CUSTOM
                inputLayout.endIconDrawable = context.getDrawable(R.drawable.tick)
            }
            isError -> {
                inputLayout.error = "error"
            }
            else -> {
                inputLayout.isErrorEnabled = false
                inputLayout.endIconMode = END_ICON_CLEAR_TEXT
            }
        }
    }

}

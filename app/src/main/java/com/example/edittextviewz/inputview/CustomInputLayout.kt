package com.example.edittextviewz.inputview

import android.content.ClipDescription
import android.content.Context
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.edittextviewz.R
import com.google.android.material.textfield.TextInputLayout.END_ICON_NONE
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.custom_text_input_layout.view.*

class CustomInputLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.custom_input_layout, this, true)


        orientation = VERTICAL

        obtainStyleAttributes(context, attrs)
    }

    private fun obtainStyleAttributes(context: Context, attrs: AttributeSet?) {
        context.theme.obtainStyledAttributes(attrs, R.styleable.CustomTextInputLayout, 0, 0).apply {
            val hintText = getString(R.styleable.CustomTextInputLayout_hintText)
            val labelText = getString(R.styleable.CustomTextInputLayout_labelText)

            input_text.hint = hintText
            input_layout.prefixText = labelText

        }.recycle()
    }

    fun setError(error: String) {
        input_layout.error = error
    }

    fun clearError() {
        input_layout.isErrorEnabled = false
    }

    fun toggleEnable() {
        input_layout.isEnabled = !input_layout.isEnabled
    }

    fun setEndIconDescription(description: String) {
        input_layout.endIconContentDescription = description
    }

    fun setPasswordType() {
        var isPasswordShown = false
        input_layout.endIconMode = END_ICON_NONE
        input_layout.suffixText = "Show"
        input_text.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        input_layout.suffixTextView.setOnClickListener {

            when (isPasswordShown) {
                true -> {
                    input_layout.suffixText = "Hide"
                    input_layout.endIconContentDescription = "Hide"
                    isPasswordShown = false

                    input_text.transformationMethod = HideReturnsTransformationMethod.getInstance()

                }
                false -> {
                    input_layout.suffixText = "Show"
                    input_layout.endIconContentDescription = "Show"
                    isPasswordShown = true

                    input_text.transformationMethod = PasswordTransformationMethod.getInstance()
                }
            }
        }
    }
}

package com.example.edittextviewz

import android.content.Context
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.custom_text_input_layout.view.*

class PasswordInputLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var isPasswordShown:Boolean = false

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.passowd_input_layout, this, true)

        context.theme.obtainStyledAttributes(attrs, R.styleable.PasswordInputLayout, 0, 0).apply {
            val hintText = getString(R.styleable.PasswordInputLayout_passwordHint)
            input_text.hint = hintText
        }.recycle()


        orientation = VERTICAL

        input_layout.suffixText = "Show"

        input_layout.suffixTextView.setOnClickListener {

            when(isPasswordShown){
                true->{
                    input_layout.suffixText = "Hide"
                    isPasswordShown = false

                    input_text.transformationMethod = HideReturnsTransformationMethod.getInstance()

                }
                false->{
                    input_layout.suffixText = "Show"
                    isPasswordShown = true

                    input_text.transformationMethod = PasswordTransformationMethod.getInstance()
                }
            }
        }

    }

    fun setError(error:String){
        input_layout.error = error
    }

    fun clearError(){
        input_layout.isErrorEnabled = false
    }

}

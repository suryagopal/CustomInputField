package com.example.edittextviewz

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.custom_text_input_layout.view.*

class CustomTextInputLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.custom_text_input_layout, this, true)

        orientation = VERTICAL

        obtainStyleAttributes(context, attrs)
    }

    private fun obtainStyleAttributes(context: Context, attrs: AttributeSet?){
        context.theme.obtainStyledAttributes(attrs, R.styleable.CustomTextInputLayout, 0, 0).apply {
            val titleColor = getColor(R.styleable.CustomTextInputLayout_tileColor, resources.getColor(R.color.stromGrey, context.theme))
            val titleText = getString(R.styleable.CustomTextInputLayout_titleText)
            val hintText = getString(R.styleable.CustomTextInputLayout_hintText)
            val labelText = getString(R.styleable.CustomTextInputLayout_labelText)

            label.setTextColor(titleColor)
            label.text = titleText
            input_text.hint = hintText
            input_layout.prefixText = labelText
        }.recycle()
    }

    fun setError(error:String){
        input_layout.error = error
    }

    fun clearError(){
        input_layout.isErrorEnabled = false
    }

    fun toggleLabelVisibility(){
        label.isVisible = !label.isVisible
    }

    fun toggleEnable(){
        input_layout.isEnabled = !input_layout.isEnabled
    }
}

package com.example.edittextviewz

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.custom_text_input_layout.view.*
import kotlinx.android.synthetic.main.mi_input_layout.view.*

class MiInput @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.mi_input_layout, this, true)

        orientation = HORIZONTAL
        gravity = Gravity.CENTER_HORIZONTAL

        obtainStyleAttributes(context, attrs)
    }

    private fun obtainStyleAttributes(context: Context, attrs: AttributeSet?){
        context.theme.obtainStyledAttributes(attrs, R.styleable.MiInput, 0, 0).apply {
            val firstInput = getString(R.styleable.MiInput_firstInput)
            val secondInput = getString(R.styleable.MiInput_secondInput)
            val thirdInput = getString(R.styleable.MiInput_thirdInput)

            firstLabel.text = firstInput
            secondLabel.text = secondInput
            thirdLabel.text = thirdInput
        }.recycle()
    }

    fun setFirstInputLabel(firstInput:String){
        firstLabel.text = firstInput
    }

    fun setSecondInputLabel(secondInput:String){
        secondLabel.text = secondInput
    }

    fun setThirdInputLabel(thirdInput:String){
        thirdLabel.text = thirdInput
    }
}

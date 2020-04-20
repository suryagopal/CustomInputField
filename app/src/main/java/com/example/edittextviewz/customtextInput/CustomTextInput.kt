package com.example.edittextviewz.customtextInput

import android.content.Context
import android.util.AttributeSet
import com.example.edittextviewz.R
import com.google.android.material.textfield.TextInputLayout

class CustomTextInput @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.textInputLayoutStyle
) : TextInputLayout(context, attrs, defStyleAttr) {}

package com.example.edittextviewz

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.date_picker_layout.view.*

class CustomDatePicker @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val builder = MaterialDatePicker.Builder.datePicker()
    private val picker = builder.build()
    private lateinit var callback:DatePickerCallback
    private var selectedDateValue:Long = 0

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.date_picker_layout, this, true)

        orientation = HORIZONTAL
        background = resources.getDrawable(R.drawable.round_corner_bg, context.theme)
        gravity = Gravity.CENTER_VERTICAL

        setListener()
    }

    private fun setListener() {
        setOnClickListener{
            picker.show(callback.getFragmentManager(), picker.toString())
        }

        picker.addOnPositiveButtonClickListener {
            selectedDate.text = picker.headerText
            selectedDateValue = it
        }
    }

    fun setDatePickerCallback(callback:DatePickerCallback){
        this.callback = callback
    }

    fun getSelectedDate():Long{
        return selectedDateValue
    }

}

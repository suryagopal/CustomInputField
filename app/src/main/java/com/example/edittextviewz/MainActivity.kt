package com.example.edittextviewz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showError.setOnClickListener{
            customInputField.setError("Please enter a valid email!")
            passwordInputField.setError("Please enter a valid password!")

        }

        clearError.setOnClickListener{
            customInputField.clearError()
            passwordInputField.clearError()
        }

        showLabel.setOnClickListener{
            customInputField.toggleLabelVisibility()
        }

        toggleEnable.setOnClickListener{
            customInputField.toggleEnable()
        }

        tipsView.setTipsViewOnClickListener(listener = object : TipsViewClickListener {
            override fun onTipActionClick(tipModel:TipViewModel) {
                Toast.makeText(this@MainActivity, "${tipModel.tip} clicked!", Toast.LENGTH_LONG).show()
            }
        })

        date_picker.setDatePickerCallback(callback = object : DatePickerCallback{
            override fun getFragmentManager(): FragmentManager {
                return supportFragmentManager
            }
        })

        generateDummytips()

    }

    private fun generateDummytips() {
        var tipsList: ArrayList<TipViewModel> = arrayListOf()
        var tip1 = TipViewModel("\u2022 This is the first tip", TipType.TipMessage)
        var tip2 = TipViewModel("\u2022 This is the second tip", TipType.TipMessage)
        var tip3 = TipViewModel("Find out more", TipType.TipAction)

        tipsList.add(tip1)
        tipsList.add(tip2)
        tipsList.add(tip3)

        tipsView.addTips(tipsList)
    }

}

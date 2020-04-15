package com.example.edittextviewz

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.tips_view_layout.view.*

class TipsView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var tipsList: ArrayList<TipViewModel> = arrayListOf()
    lateinit var clickListener: TipsViewClickListener

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.tips_view_layout, this, true)
        orientation = VERTICAL

        setBackgroundColor(resources.getColor(R.color.grapeGreen, context.theme))

    }

    fun addTips(tips:ArrayList<TipViewModel>){
        this.tipsList = tips.clone() as ArrayList<TipViewModel>
        addTipsInContainer()
    }

    private fun addTipsInContainer() {
        tipsList.forEach {tipModel->
            when (tipModel.tipType) {
                TipType.TipMessage -> {
                    val view = getTipMessageItem()
                    (view as TextView).text = tipModel.tip

                    tipsContainer.addView(view)
                }
                TipType.TipAction -> {
                    val view = getTipActionItem()
                    (view as TextView).text = tipModel.tip
                    tipsContainer.addView(view)

                    view.setOnClickListener { clickListener.onTipActionClick(tipModel) }
                }
            }
        }
    }

    private fun getTipMessageItem(): View {
        val viewInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return viewInflater.inflate(R.layout.tip_message_item, null)
    }

    private fun getTipActionItem(): View {
        val viewInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return viewInflater.inflate(R.layout.tip_action_item, null)
    }

    fun setTipsViewOnClickListener(listener: TipsViewClickListener) {
        this.clickListener = listener
    }
}
package com.example.edittextviewz

enum class TipType{
    TipMessage,
    TipAction
}

data class TipViewModel(
    val tip:String,
    val tipType:TipType
)

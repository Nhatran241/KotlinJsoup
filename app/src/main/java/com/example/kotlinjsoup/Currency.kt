package com.example.kotlinjsoup

class Currency {
    var name: String? = ""
    var indiName: String = ""
    var indiValue: String = ""

    override fun toString(): String {
        return "$indiName : $indiValue"
    }

} 
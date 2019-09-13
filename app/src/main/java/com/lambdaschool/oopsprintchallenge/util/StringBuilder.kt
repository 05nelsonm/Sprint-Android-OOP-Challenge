package com.lambdaschool.oopsprintchallenge.util

fun stringBuilder(list: List<String>): String {
    var returnString = ""
    list.forEach{
        returnString += it + "\n"
    }
    return returnString
}
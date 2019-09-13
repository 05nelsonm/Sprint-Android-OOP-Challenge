package com.lambdaschool.oopsprintchallenge.model

import java.io.Serializable

abstract class AgeOfEmpiresApiObject(
    open var id: Int = 0,
    open val name: String? = null,
    open var category: String = ""
): Serializable {

    open fun info(): String {
        return "Name: $name"
    }

    open fun description(): String {
        return "Age of Empires II object"
    }
}
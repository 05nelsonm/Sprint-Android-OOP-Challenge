package com.lambdaschool.oopsprintchallenge.model

import java.io.Serializable

abstract class AgeOfEmpiresApiObject(
    open val id: Int = 0,
    open val name: String? = null,
    open val expansion: String? = null
): Serializable {

    open fun info(): String {
        return "Name: $name"
    }

    open fun description(): String {
        return "Age of Empires II object"
    }
}
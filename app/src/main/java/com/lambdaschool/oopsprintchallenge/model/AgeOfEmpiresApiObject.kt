package com.lambdaschool.oopsprintchallenge.model

import android.graphics.drawable.Drawable
import java.io.Serializable

abstract class AgeOfEmpiresApiObject(
    open var id: Int = 0,
    open var name: String? = null,
    open var expansion: String = "",
    open var drawableName: Drawable?,
    open var isFavorite: Boolean
): Serializable {

    open fun info(): String {
        return "Name: $name"
    }

    open fun description(): String {
        return "Age of Empires II object"
    }
}
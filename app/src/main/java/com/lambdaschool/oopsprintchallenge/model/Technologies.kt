package com.lambdaschool.oopsprintchallenge.model

import android.graphics.drawable.Drawable
import com.lambdaschool.oopsprintchallenge.util.stringBuilder

data class Technologies(
    override var id: Int,
    override var name: String?,
    override var expansion: String,
    override var drawableName: Drawable?,
    override var isFavorite: Boolean,
    var description: String,
    var age: String,
    var develops_in: String,
    var build_time: Int,
    var applies_to: List<String>
): AgeOfEmpiresApiObject(id, name, expansion, drawableName, isFavorite) {

    override fun description(): String {

        val appliesTo = stringBuilder(applies_to)
        var yesNo = ""
        if (isFavorite) {
            yesNo = "Yes"
        } else {
            yesNo = "No"
        }

        return "Description: $description\n\nAge: $age\n\nDevelops In: " +
                "$develops_in\n\nBuild Time: $build_time\n\nApplies To: " +
                "$appliesTo\n\nIs it a Favorite?: $yesNo"
    }
}
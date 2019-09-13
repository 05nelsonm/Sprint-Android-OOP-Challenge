package com.lambdaschool.oopsprintchallenge.model

import com.lambdaschool.oopsprintchallenge.util.stringBuilder

class Technologies(
    var description: String,
    var age: String,
    var develops_in: String,
    var build_time: Int,
    var applies_to: List<String>,
    var isFavorite: Boolean
): AgeOfEmpiresApiObject() {

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
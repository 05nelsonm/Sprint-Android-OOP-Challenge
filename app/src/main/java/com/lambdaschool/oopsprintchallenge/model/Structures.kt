package com.lambdaschool.oopsprintchallenge.model

import com.lambdaschool.oopsprintchallenge.util.stringBuilder

class Structures(
    var age: String,
    var build_time: Int,
    var hit_points: Int,
    var line_of_sight: Int,
    var armor: String,
    var special: List<String>,
    var isFavorite: Boolean
): AgeOfEmpiresApiObject() {

    override fun description(): String {

        val specialString = stringBuilder(special)
        var yesNo = ""
        if (isFavorite) {
            yesNo = "Yes"
        } else {
            yesNo = "No"
        }

        return "Age: $age\n\nBuild Time: $build_time\n\nHit Points: " +
                "$hit_points\n\nLine of Sight: $line_of_sight\n\nArmor: " +
                "$armor\n\nSpecial: $specialString\n\nIs it a Favorite?: $yesNo"
    }
}
package com.lambdaschool.oopsprintchallenge.model

import com.lambdaschool.oopsprintchallenge.util.stringBuilder

class Units(
    var age: String,
    var created_in: String,
    var build_time: Int,
    var reload_time: Int,
    var movement_rate: Double,
    var line_of_sight: Int,
    var hit_points: Int,
    var attack: Int,
    var armor: String,
    var attack_bonus: List<String>,
    var isFavorite: Boolean
): AgeOfEmpiresApiObject() {

    override fun description(): String {

        val attackBonus = stringBuilder(attack_bonus)
        var yesNo = ""
        if (isFavorite) {
            yesNo = "Yes"
        } else {
            yesNo = "No"
        }

        return "Age: $age\n\nCreated In: $created_in\n\nBuild Time: " +
                "$build_time\n\nReload Time: $reload_time\n\nMovement Rate: " +
                "$movement_rate\n\nLine of Sight: $line_of_sight\n\n" +
                "Hit Points: $hit_points\n\nAttack: $attack\n\nArmor: $armor\n\n" +
                "Attack Bonus: $attackBonus\n\nIs it a Favorite?: $yesNo"
    }
}
package com.lambdaschool.oopsprintchallenge.model

import com.lambdaschool.oopsprintchallenge.util.stringBuilder

data class Civilization(
    var isFavorite: Boolean,
    var army_type: String,
    var unique_unit: List<String>,
    var unique_tech: List<String>,
    var team_bonus: String,
    var civilization_bonus: List<String>
): AgeOfEmpiresApiObject() {

    override fun description(): String {

        val uniqueUnit = stringBuilder(unique_unit)
        val uniqueTech = stringBuilder(unique_tech)
        val civilizationBonus = stringBuilder(civilization_bonus)
        var yesNo = ""
        if (isFavorite) {
            yesNo = "Yes"
        } else {
            yesNo = "No"
        }

      return "Army Type: $army_type\n\nUnique Unit: $uniqueUnit\n\nUnique Tech: " +
                "$uniqueTech\n\nTeam Bonus: $team_bonus\n\nCivilization Bonus: " +
                "$civilizationBonus\n\nIs it a Favorite?: $yesNo"
    }
}
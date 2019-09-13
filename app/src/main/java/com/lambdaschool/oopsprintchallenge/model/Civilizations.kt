package com.lambdaschool.oopsprintchallenge.model

class Civilizations(
    var id: Int,
    var name: String,
    var expansion: String,
    var army_type: String,
    var unique_unit: List<String>,
    var unique_tech: List<String>,
    var team_bonus: String,
    var civilization_bonus: List<String>
    )
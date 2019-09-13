package com.lambdaschool.oopsprintchallenge.model

class Units(
    var id: Int,
    var name: String,
    var description: String,
    var expansion: String,
    var age: String,
    var created_in: String,
    var build_time: Int,
    var reload_time: Int,
    var movement_rate: Double,
    var line_of_sight: Int,
    var hit_points: Int,
    var attack: Int,
    var armor: String,
    var attack_bonus: List<String>
)
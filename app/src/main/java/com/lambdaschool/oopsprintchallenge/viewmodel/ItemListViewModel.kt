package com.lambdaschool.oopsprintchallenge.viewmodel

import com.lambdaschool.oopsprintchallenge.model.AgeOfEmpiresApiObject

object ItemListViewModel {
    val ageOfEmpiresApiObjects = mutableListOf<AgeOfEmpiresApiObject>()
    val ageOfEmpiresApiObjectsHash = HashMap<Int, Int>()
}
package com.lambdaschool.oopsprintchallenge.viewmodel

import androidx.databinding.BaseObservable
import com.lambdaschool.oopsprintchallenge.model.AgeOfEmpiresApiObject

object ItemListViewModel {
    val ageOfEmpiresApiObjects = mutableListOf<AgeOfEmpiresApiObject>()
    val ageOfEmpiresApiObjectsHash = HashMap<Int, Int>()
}
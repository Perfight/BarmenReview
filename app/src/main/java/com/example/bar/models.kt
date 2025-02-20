package com.example.bar

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

class Notes : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
    var name: String = ""
    var description: String = ""
}

class Ingredient : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
    var name: String = ""
    var taste: String = ""
    var degree: String = ""
    var base: String = ""
    var mixwith: List<Ingredient>? = null
}

class Cocktail : RealmObject {
    @PrimaryKey
    var id: ObjectId = ObjectId()
    var name: String = ""
    var ingredients: List<Ingredient> = emptyList()
    var instructions: String = ""
    var taste: String = ""
    var base: String = ""
    var group: String = ""
    var color: String = ""
}
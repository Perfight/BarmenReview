package com.example.bar

import android.app.Application
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class Bar : Application() {
    companion object {
        lateinit var realm: Realm
    }

    override fun onCreate() {
        super.onCreate()
        SharedPreferences.initialize(this)
        realm = Realm.open(
            RealmConfiguration.create(
                schema = setOf(
                    Ingredient::class,
                    Cocktail::class,
                    Notes::class
                )
            )
        )
    }
}
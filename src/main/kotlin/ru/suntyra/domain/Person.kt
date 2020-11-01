package ru.suntyra.domain

open class Person(
    var name: String,
    var surname: String,
    var location: Place
) {
    fun go(place: Place) {
        location = place
    }
}

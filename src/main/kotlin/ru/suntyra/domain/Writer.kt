package ru.suntyra.domain

class Writer(
    name: String,
    surname: String,
    location: Place
) : Person(name, surname, location) {

    lateinit var book: Book

    fun writeBook() {
        book = Book(1, mutableListOf(Information(1.0, location)), this)
    }

    fun addSomeStringInBook() {
        val lastInformation = book.informations[book.pageNumber - 1]

        book.informations.add(
            Information(
                if (lastInformation.place != location) lastInformation.baseInterest * 1.5
                else lastInformation.baseInterest * 0.5,
                location
            )
        )
        book.pageNumber++
    }
}

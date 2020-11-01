package ru.suntyra.domain

class Redactor(name: String, surname: String, location: Place) : Person(name, surname, location) {
    fun checkBookInformationInterest(author: Writer): BookQuality {
        val quality = author.book.informations.map { it.baseInterest }.reduce(Double::plus) / author.book.pageNumber

        return when {
            quality > 0.9 -> BookQuality.HIGH_QUALITY
            quality > 0.6 -> BookQuality.MEDIUM_QUALITY
            else -> BookQuality.LOW_QUALITY
        }
    }

    fun checkCurrentInformationInterest(author: Writer, pageNumber: Int): BookQuality {
        val quality = author.book.informations[pageNumber].baseInterest

        return when {
            quality > 0.9 -> BookQuality.HIGH_QUALITY
            quality > 0.6 -> BookQuality.MEDIUM_QUALITY
            else -> BookQuality.LOW_QUALITY
        }
    }
}

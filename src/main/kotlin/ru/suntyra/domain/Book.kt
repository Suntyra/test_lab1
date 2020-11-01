package ru.suntyra.domain

class Book(
    var pageNumber: Int,
    var informations: MutableList<Information>,
    var author: Writer
) {
}

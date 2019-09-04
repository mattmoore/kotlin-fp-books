package io.mattmoore.fp.books

fun main() {
    val books = loadBooks("books.json")
    println(books.first())
}

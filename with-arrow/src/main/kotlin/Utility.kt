package io.mattmoore.fp.books

import java.io.File
import com.google.gson.Gson

fun loadBooks(path: String): List<Book> {
    val json = File(path).readText()
    return Gson().fromJson(json, Array<Book>::class.java).toList()
}

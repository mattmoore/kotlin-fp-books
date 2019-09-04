package io.mattmoore.fp.books

import kotlin.test.*

public class QueryTest {
    @Test
    fun `should find authors born in the specified range of years`() {
        val authors = listOf(
                Author(firstName = "Jane", lastName = "Doe", birthYear = 1987),
                Author(firstName = "John", lastName = "Doe", birthYear = 1887))
        val expectedAuthors = listOf(
                Author("Jane", "Doe", 1987))
        val result = Query().authorsFromYearRange(yearStart = 1900, yearEnd = 1999, authors = authors)
        assert(result == expectedAuthors)
    }

    @Test
    fun `should find authors born in the specified range of years from books`() {
        val books = listOf(
                Book(title = "Title 1",
                     author = Author(firstName = "Jane", lastName = "Doe", birthYear = 1987)),
                Book(title = "Title 2",
                     author = Author(firstName = "John", lastName = "Doe", birthYear = 1887)))
        val expectedAuthors = listOf(
                Author("Jane", "Doe", 1987))
        val result = Query().authorsFromYearRange(yearStart = 1900, yearEnd = 1999, books = books)
        assert(result == expectedAuthors)
    }

    @Test
    fun `should find top 15 authors by last name in ascending order from books`() {
        val authors = listOf(
                Author(firstName = "Jane", lastName = "Doe", birthYear = 1987),
                Author(firstName = "John", lastName = "Doe", birthYear = 1887),
                Author(firstName = "John", lastName = "Doe", birthYear = 1887))
        val expectedAuthors = listOf(
                Author(firstName = "Jane", lastName = "Doe", birthYear = 1987),
                Author(firstName = "John", lastName = "Doe", birthYear = 1887))
        val result = Query().topAuthorsByLastName(limit = 15, authors = authors)
        assert(result == expectedAuthors)
    }

    @Test
    fun `should find top 15 authors by last name in ascending order`() {
        val books = listOf(
                Book(title = "Title 1",
                     author = Author(firstName = "Jane", lastName = "Doe", birthYear = 1987)),
                Book(title = "Title 2",
                     author = Author(firstName = "John", lastName = "Doe", birthYear = 1887)),
                Book(title = "Title 3",
                    author = Author(firstName = "John", lastName = "Doe", birthYear = 1887)))
        val expectedAuthors = listOf(
                Author(firstName = "Jane", lastName = "Doe", birthYear = 1987),
                Author(firstName = "John", lastName = "Doe", birthYear = 1887))
        val result = Query().topAuthorsByLastName(limit = 15, books = books)
        assert(result == expectedAuthors)
    }
}

package io.mattmoore.fp.books

import kotlin.test.*

class UtilityTest {
    @Test
    fun `loadBooks should convert JSON books into a list of Book`() {
        val expected = listOf(
          Book(
            title = "Harry Potter and the Philosopher's Stone",
            author = Author(firstName = "J. K.", lastName = "Rowling", birthYear = 1965)
          ),
          Book(
            title = "Harry Potter and the Chamber of Secrets",
            author = Author(firstName = "J. K.", lastName = "Rowling", birthYear = 1965)
          )
        )
        val result = loadBooks("books.json").take(2)
        assertEquals(expected, result)
    }
}

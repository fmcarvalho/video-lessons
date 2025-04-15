package pt.isel

import kotlin.test.Test
import kotlin.test.assertEquals

class PersonDto(
    val name: String,
    @Match(name = "country") val from: String,
)

class StudentDto(
    val state: State,
    val name: String,
    @Match(name = "nr") val id: Int,
)

data class State(
    val name: String,
    val idiom: String,
)

class NaiveMapperTest {
    @Test
    fun `test mapping PersonDto to Person`() {
        val dto = PersonDto("Ze Manel", "Portugal")
        val person = dto.mapTo(Person::class) as Person
        assertEquals(dto.name, person.name)
        assertEquals(dto.from, person.country)
    }

    @Test
    fun `test mapping studentDto to Student`() {
        val dto = StudentDto(State("Portugal", "Portuguese"), "Maria Rosa", 87232)
        val student = dto.mapTo(Student::class) as Student
        assertEquals(dto.name, student.name)
        assertEquals(dto.id, student.nr)
        assertEquals(dto.state.name, student.country.name)
        assertEquals(dto.state.idiom, student.country.idiom)
    }
}

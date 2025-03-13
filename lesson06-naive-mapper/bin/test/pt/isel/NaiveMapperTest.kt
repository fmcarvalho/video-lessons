package pt.isel

import kotlin.test.Test
import kotlin.test.assertEquals

class PersonDto(
    val name: String,
    @Match(name = "country") val from: String
)

class NaiveMapperTest {
    @Test fun `test mapping PersonDto to Person`() {
        val dto = PersonDto("Ze Manel", "Portugal")
        val person = dto.mapTo(Person::class) as Person
        assertEquals(dto.name, person.name)
        assertEquals(dto.from, person.country)
    }
}

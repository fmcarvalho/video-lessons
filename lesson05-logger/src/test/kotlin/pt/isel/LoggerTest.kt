package pt.isel

import org.w3c.dom.css.Rect
import java.io.PrintStream
import kotlin.math.exp
import kotlin.test.Test
import kotlin.test.assertEquals

class LoggerTest {
    @Test fun `test logger with an instance of Person`() {
        val expected = """Person
            - country: Portugal
            - id: 76543
            - name: Ze Manel
        """.lines().iterator()
        val p = Person(76543, "Ze Manel", "Portugal")
        StringBuilder()
            .also { sb ->
                sb.log(p)
                sb.toString().lines().forEach { actual ->
                    assertEquals(expected.next().trim(), actual.trim())
                }
            }
    }
    @Test fun `test logger with an instance of Rectangle`() {
        val expected = """Rectangle
            - area: 35
            - height: 7
            - width: 5
        """.lines().iterator()
        val rect = Rectangle(5, 7)
        StringBuilder()
            .also { sb ->
                sb.log(rect)
                sb.toString().lines().forEach { actual ->
                    assertEquals(expected.next().trim(), actual.trim())
                }
            }
    }
    @Test fun `test logger with an instance of JavaRectangle`() {
        val expected = """JavaRectangle
            - area: 35
            - height: 7
            - width: 5
        """.lines().iterator()
        val rect = JavaRectangle(5, 7)
        System.out.log(rect)
    }
}

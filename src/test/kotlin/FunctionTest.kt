import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import ru.suntyra.Function
import kotlin.math.asin

class FunctionTest {
    private val function = Function()
    @Test
    fun testRightBorder(){
        assertEquals(asin(1.0), function.arcsin(1.0)!!, function.PRECISION, "Правая граница не верна.")
    }

    @Test
    fun testLeftBourder(){
        assertEquals(asin(-1.0), function.arcsin(-1.0)!!, function.PRECISION, "Левая граница не верна.")
    }

    @Test
    fun testYIntercept(){
        assertEquals(asin(0.0), function.arcsin(0.0)!!, function.PRECISION, "Пересечение с осью ордина не верно.")
    }

    @Test
    fun testLeftPartOfThePositiveSegment(){
        assertEquals(asin(0.33), function.arcsin(0.33)!!,  function.PRECISION,"Левая часть положительного отрезка не верна.")
    }

    @Test
    fun testRightPartOfThePositiveSegment() {
        assertEquals(asin(0.67), function.arcsin(0.67)!!, function.PRECISION, "Правая часть положительного отрезка не верна.")
    }

    @Test
    fun testLeftPartOfTheNegativeSegment() {
        assertEquals(asin(-0.67), function.arcsin(-0.67)!!, function.PRECISION, "Последняя часть положительного отрезка не верна.")
    }

    @Test
    fun testRightPartOfTheNegativeSegment() {
        assertEquals(asin(-0.33), function.arcsin(-0.33)!!, function.PRECISION, "Последняя часть положительного отрезка не верна.")
    }

    @Test
    fun testOutOfBoundsOnTheRight(){
        assertNull(function.arcsin(1.5), "Тест на выход за границы справа.")
    }

    @Test
    fun testOutOfBoundsOnTheLeft(){
        assertNull(function.arcsin(-1.5), "Тест на выход за границы слева.")
    }
}

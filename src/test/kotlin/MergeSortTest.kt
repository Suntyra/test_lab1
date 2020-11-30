import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.suntyra.MergeSort

class MergeSortTest {
    private val mergeSort = MergeSort()
    @Test
    fun sortedArray() {
        val array = intArrayOf(1, 2, 3, 4, 5)
        mergeSort.mergeSort(array, 0, array.size - 1)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), array, "Массив не отсортирован")
    }

    @Test
    fun randomArray() {
        val array = intArrayOf(10, 4, 0, 1, 6, 7, 8, 9, 15, 10)
        mergeSort.mergeSort(array, 0, array.size - 1)
        assertArrayEquals(intArrayOf(0, 1, 4, 6, 7, 8, 9, 10, 10, 15), array, "Массив не отсортирован")
    }

    @Test
    fun oneRepeatElement(){
        val array = intArrayOf(1, 1, 1, 1, 1, 1, 1)
        mergeSort.mergeSort(array, 0, array.size - 1)
        assertArrayEquals(intArrayOf(1, 1, 1, 1, 1, 1, 1), array, "Массив не содержит только повторяющийся элемент")
    }

    @Test
    fun emptyArray(){
        val array = intArrayOf()
        mergeSort.mergeSort(array,0,0)
        assertArrayEquals(intArrayOf(), array, "Массив не пустой")
    }

    @Test
    fun oneElementArray(){
        val array = intArrayOf(1)
        mergeSort.mergeSort(array,0,array.size - 1)
        assertArrayEquals(intArrayOf(1), array, "Массив содержит не один элемент")
    }

    @Test
    fun testArrayWithNegativeNumbers(){
        val array = intArrayOf(1, -5, 10, 5, -3, 0, 4, 3, -3)
        mergeSort.mergeSort(array,0,array.size - 1)
        assertArrayEquals(intArrayOf(-5, -3, -3, 0, 1, 3, 4, 5, 10), array, "Массив не отсортирован, сортировка не работает с отрицательными числами")
    }

    @Test
    fun testAnotherElementAtTheBeginning(){
        val array = intArrayOf(5, 1, 2, 3, 4)
        mergeSort.mergeSort(array,0,array.size - 1)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), array, "Массив не отсортирован")
    }

    @Test
    fun testAnotherElementAtTheEnd(){
        val array = intArrayOf(2, 3, 4, 5, 1)
        mergeSort.mergeSort(array,0,array.size - 1)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5), array, "Массив не отсортирован")
    }
}



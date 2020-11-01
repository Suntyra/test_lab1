package ru.suntyra


class MergeSort {
        fun mergeSort(array: IntArray, low: Int, high: Int) {
            if (high <= low) return
            val mid = (low + high) / 2
            mergeSort(array, low, mid)
            mergeSort(array, mid + 1, high)
            merge(array, low, mid, high)
        }

        fun merge(array: IntArray, low: Int, mid: Int, high: Int) {
            val leftArray = IntArray(mid - low + 1)
            val rightArray = IntArray(high - mid)

            for (i in leftArray.indices) leftArray[i] = array[low + i]
            for (i in rightArray.indices) rightArray[i] = array[mid + i + 1]

            var leftIndex = 0
            var rightIndex = 0

            for (i in low until high + 1) {
                if (leftIndex < leftArray.size && rightIndex < rightArray.size) {
                    if (leftArray[leftIndex] < rightArray[rightIndex]) {
                        array[i] = leftArray[leftIndex]
                        leftIndex++
                    } else {
                        array[i] = rightArray[rightIndex]
                        rightIndex++
                    }
                } else if (leftIndex < leftArray.size) {
                    array[i] = leftArray[leftIndex]
                    leftIndex++
                } else if (rightIndex < rightArray.size) {
                    array[i] = rightArray[rightIndex]
                    rightIndex++
                }
            }
        }
}

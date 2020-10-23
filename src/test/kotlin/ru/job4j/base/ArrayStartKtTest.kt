package ru.job4j.base

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * тестрование класса работы с массивами
 */
internal class ArrayStartKtTest : StringSpec({
    "[null, null, '1', '2'] = [0] = 1" {
        val array = arrayOfNulls<String>(5)
        array[3] = "1"
        array[4] = "2"
        defragment(array)
        array[0] shouldBe "1"
    }
})

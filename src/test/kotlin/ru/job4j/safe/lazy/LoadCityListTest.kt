package ru.job4j.safe.lazy

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

/**
 * тестирование ленивой загрузки
 */
class LoadCityListTest : StringSpec({
    "load Lazy get index 0 = City(region=Москва и Московская обл., city=Москва)" {
        with(LoadCityList()) {
            cityList
        }[0].city shouldBe "Москва"
    }
})
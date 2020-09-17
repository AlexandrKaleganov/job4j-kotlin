package ru.job4j.oop

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

internal class DriverTest : StringSpec({
    "Driver().hasLicense() = false" {
        Driver().hasLicense() shouldBe false
    }
    "Driver().hasLicense() = true" {
        val driver = Driver()
        driver.passExamOn('A')
        driver.hasLicense() shouldBe true
    }
    "Driver().canDrive('N') = true" {
        Driver().canDrive('N') shouldBe true
    }
    "Driver().canDrive('B') = false" {
        Driver().canDrive('B') shouldBe false
    }

})
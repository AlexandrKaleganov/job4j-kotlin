package ru.job4j.lambda


import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.time.LocalDate
import java.util.*

internal class CompanyTest : StringSpec({
    "mapCompanyToString" {
        val companies = listOf(Company("seagate", Address("Тайвань"), LocalDate.of(2020, 11, 14)),
                Company("hitachi", Address("Тайвань"), LocalDate.of(2020, 11, 14)))
        companies.map { it.name + " " + it.address.address + " " + it.created}.toString() shouldBe
                "[seagate Тайвань 2020-11-14, hitachi Тайвань 2020-11-14]"
    }
})
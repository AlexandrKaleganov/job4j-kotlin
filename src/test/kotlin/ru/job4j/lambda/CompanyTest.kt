package ru.job4j.lambda


import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import java.util.*

internal class CompanyTest : StringSpec({
    "mapCompanyToString" {
        val companies = listOf(Company("seagate", Address("Тайвань"), Date(2020, 11, 14)),
                Company("hitachi", Address("Тайвань"), Date(2020, 11, 14)))
        companies.map { it.name + " " + it.address.address + " " + it.created}.toString() shouldBe
                "[seagate Тайвань Tue Dec 14 00:00:00 NOVT 3920, hitachi Тайвань Tue Dec 14 00:00:00 NOVT 3920]"
    }
})
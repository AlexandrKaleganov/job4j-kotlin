package ru.job4j.lambda

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

internal class EmailServiceTest : StringSpec({
    "EmailService().emailTo(Message('user', 'user@mail.ru'))" {
        EmailService().emailTo(Message("user", "user@mail.ru")) shouldBe
                "Subject : user@mail.ruBody : Hello, user@mail.ru You win!"
    }
})
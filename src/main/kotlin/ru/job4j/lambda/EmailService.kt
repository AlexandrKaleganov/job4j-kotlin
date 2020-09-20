package ru.job4j.lambda

class EmailService {
    fun emailTo(message: Message): String {
        return with(java.lang.StringBuilder()){
            append("Subject : ").append(message.email)
            append("Body : ").append("Hello, ").append(message.email).append(" ")
            append("You win!")
        }.toString()
    }
}
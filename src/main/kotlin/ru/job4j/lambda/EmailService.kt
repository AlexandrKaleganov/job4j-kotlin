package ru.job4j.lambda

/**
 * пример работы функционального метода with
 * он принимает объект и возращает егоже,
 * если в конце есть метод, который что-то возвращает то функция вернёт
 * значение в данно примере
 */
class EmailService {
    fun emailTo(message: Message): String {
        return with(java.lang.StringBuilder()){
            append("Subject : ").append(message.email)
            append("Body : ").append("Hello, ").append(message.email).append(" ")
            append("You win!")
            toString()
        }
    }
}

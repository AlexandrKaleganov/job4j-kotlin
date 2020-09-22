package ru.job4j.safe.ifelse

class Address(var home: String, var street: String, var zip: String) {
    override fun toString(): String {
        return "Address(home='$home', street='$street', zip='$zip')"
    }
}
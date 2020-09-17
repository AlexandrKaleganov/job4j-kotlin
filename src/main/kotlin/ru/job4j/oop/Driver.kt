package ru.job4j.oop

class Driver {

    private val types = arrayOf('A', 'B', 'C')
    private var license = 'N'
    fun passExamOn(category: Char) {
        license = category
    }

    fun hasLicense(): Boolean {
        return types.contains(license)
    }

    fun canDrive(category: Char): Boolean {
        return this.license == category
    }
}
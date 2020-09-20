package ru.job4j.lambda

import kotlin.math.pow

    val inc = { x: Int -> x + 1 }
    val dec = { x: Int -> x.dec() }
    val square = { x: Int -> x.toDouble().pow(2).toInt() }

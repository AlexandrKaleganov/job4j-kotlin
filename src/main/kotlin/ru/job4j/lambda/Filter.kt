package ru.job4j.lambda

val predicate = {e: Account -> e.name == "Ivan" && e.balance > 0 }
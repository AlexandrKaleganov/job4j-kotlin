package ru.job4j.lambda

/**
 * фильтр для объекта <Account>
 */
val predicate = {e: Account -> e.name == "Ivan" && e.balance > 0 }

package ru.job4j.safe.lazy

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.jsoup.Jsoup

class LoadCityList {
     val cityList: List<City> by lazy { getList() }

    private fun getList (): List<City> {
        val doc = Jsoup.connect("https://gist.githubusercontent.com/gorborukov/0722a93c35dfba96337b/raw/435b297ac6d90d13a68935e1ec7a69a225969e58/russia").get()
        return jacksonObjectMapper().readValue(doc.body().text());
    }
}
fun main(args: Array<String>) {
    val loadCityList = LoadCityList()
    val  res = loadCityList.cityList
    res.forEach { e-> println(e) }
}
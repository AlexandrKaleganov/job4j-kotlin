package ru.job4j.dsl

import org.apache.commons.dbcp2.BasicDataSource

class Dbcp(
    private val driver: String?, private val dataUrl: String?, private val login: String?,
    private val pass: String?, private val min: Int, private val max: Int, private val mT: Int
) : BasicDataSource(
) {
  init{
      driverClassName = driver
      url = dataUrl
      username = login
      password = pass
//      maxTotal = mT
//      minIdle = min
//      maxIdle = max
//      autoCommitOnReturn = true
    }

    companion object Builder {
        private var driver: String? = null
        private var dataUrl: String? = null
        private var login: String? = null
        private var pass: String? = null
        private var maxTotal: Int = 40
        private var max: Int = 40
        private var min: Int = 4
        fun driver(dr: String) = apply { driver = dr }
        fun url(url: String) = apply { dataUrl = url }
        fun login(lg: String) = apply { login = lg }
        fun pass(ps: String) = apply { pass = ps }
        fun minIdle(mi: Int) = apply { min = mi }
        fun maxIdle(ma: Int) = apply { max = ma }
        fun maxSt(mt: Int) = apply { maxTotal = mt }
        fun builder() = Dbcp(driver, dataUrl, login, pass, min, max, maxTotal)
    }

}
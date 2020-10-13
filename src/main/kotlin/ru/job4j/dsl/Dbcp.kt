package ru.job4j.dsl

import org.apache.commons.dbcp2.BasicDataSource

class Dbcp(
    private val driver: String?, private val dataUrl: String?, private val login: String?,
    private val pass: String?, private val min: Int, private val max: Int, private val maxSt: Int
) : BasicDataSource(
) {
  init{
        super.setDriverClassName(driver)
        super.setDriverClassName(dataUrl)
        super.setDriverClassName(login)
        super.setDriverClassName(pass)
        super.setMinIdle(min)
        super.setMaxIdle(max)
        super.setMaxOpenPreparedStatements(maxSt)
    }

    companion object Builder {
        private var driver: String? = null
        private var dataUrl: String? = null
        private var login: String? = null
        private var pass: String? = null
        private var min: Int = 5
        private var max: Int = 10
        private var maxSt: Int = 100
        fun driver(dr: String) = apply { driver = dr }
        fun url(url: String) = apply { dataUrl = url }
        fun login(lg: String) = apply { login = lg }
        fun pass(ps: String) = apply { pass = ps }
        fun minIdle(mi: Int) = apply { min = mi }
        fun maxIdle(ma: Int) = apply { max = ma }
        fun maxSt(mSt: Int) = apply { maxSt = mSt }
        fun builder(): BasicDataSource {
            return Dbcp(driver, dataUrl, login, pass, min, max, maxSt)
        }
    }

}
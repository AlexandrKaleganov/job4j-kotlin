package ru.job4j.safe

import ru.job4j.safe.model.Account
import ru.job4j.safe.model.User


class BankService {
    private val users = HashMap<User, ArrayList<Account>>()

    fun addUser(user: User) {
        users[user] = ArrayList()
    }

    private fun findByRequisite(passport: String, requisite: String): Account? {
        val user = findByPassport(passport)
        return users[user]?.let {
            it.first { it.requsite == requisite }
        }
    }

    fun addAccount(passport: String?, account: Account?) {
        val user = findByPassport(passport)
        account?.let { users[user]?.add(account) }
    }


    fun findByPassport(passport: String?): User? {
        var rsl: User? = null
        for (user in users.keys) {
            if (user.pasport == passport) {
                rsl =  user
                break
            }
        }
        return rsl
    }

    fun transferMoney(srcPassport: String, srcRequisite: String,
                      destPassport: String, descRequisite: String, amount: Double): Boolean {
        val source = findByRequisite(srcPassport, srcRequisite)
        val dest = findByRequisite(destPassport, descRequisite)
        val rsl = source != null && dest != null
        if (rsl) {
            source?.balance = source?.balance?.minus(amount)!!
            dest?.balance = dest?.balance?.plus(amount)!!
        }
        return rsl
    }

}


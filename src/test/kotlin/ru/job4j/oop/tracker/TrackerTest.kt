package ru.job4j.oop.tracker


import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import ru.job4j.oop.tracker.model.Item

internal class TrackerTest : StringSpec({

    "Tracker().addItem(Item()).getId() = '0'" {
        Tracker().addItem(Item()).id.equals("") shouldBe false
    }

    "tr.addComment('0', 'comment') tr.findAll()[0].getComments()[0]= 'comment'" {
        val tr = Tracker()
        tr.addItem(Item())
        tr.addComment("0", "comment")
        tr.findAll()[0].getComments()[0] shouldBe "comment"
    }

    "findById().getName()  = 'item'" {
        val tr = Tracker()
        tr.addItem(Item(name = "item"))
        tr.findById("0").name shouldBe "item"    }

    "deleteItemById()  findAll().size  = '0'" {
        val tr = Tracker()
        val it = tr.addItem(Item())
        tr.deleteItemById(it.id)
        tr.findAll().size shouldBe 0
    }

    "findAll().size = 1" {
        val tr = Tracker()
        tr.addItem(Item())
        tr.findAll().size shouldBe 1   }

    "findAllByName() = 'name'" {
        val tr = Tracker()
        tr.addItem(Item(name = "name"))
        tr.findAllByName("name")[0].name shouldBe "name"      }

})
package ru.job4j.oop.tracker


import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import ru.job4j.oop.tracker.model.Item

internal class TrackerTest : StringSpec({

    "Tracker().addItem(Item()).getId() = '0'" {
        Tracker().addItem(Item()).getId() shouldBe "0"
    }

    "tr.addComment('0', 'comment') tr.findAll()[0].getComments()[0]= 'comment'" {
        val tr = Tracker()
        tr.addItem(Item())
        tr.addComment("0", "comment")
        tr.findAll()[0].getComments()[0] shouldBe "comment"
    }

    "findById().getName()  = 'item'" {
        val tr = Tracker()
        val item = Item();
        item.setName("item")
        tr.addItem(item)
        tr.findById("0").getName() shouldBe "item"    }

    "deleteItemById()  findAll().size  = '0'" {
        val tr = Tracker()
        tr.addItem(Item())
        tr.deleteItemById("0")
        tr.findAll().size shouldBe 0
    }

    "findAll().size = 1" {
        val tr = Tracker()
        tr.addItem(Item())
        tr.findAll().size shouldBe 1   }

    "findAllByName() = 'name'" {
        val tr = Tracker()
        val item = Item();
        item.setName("name")
        tr.addItem(item)
        tr.findAllByName("name")[0].getName() shouldBe "name"      }

})
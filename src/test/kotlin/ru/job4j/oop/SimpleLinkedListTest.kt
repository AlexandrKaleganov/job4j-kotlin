package ru.job4j.oop

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

internal class SimpleLinkedListTest : StringSpec({
    "add() get(0)='test' size() = 1" {
        val list = SimpleLinkedList<String>()
        list.add("test")
        list.get(0) shouldBe "test"
        list.getSize() shouldBe 1
    }
    "add('1') add('2') deleteFirst() get(0) = '2'" {
        val list = SimpleLinkedList<String>()
        list.add("1")
        list.add("2")
        list.deleteFirst()
        list.get(0) shouldBe "2"
        list.getSize() shouldBe 1
    }
    "add('1') add('2') addLast('3')  get(2) = '3' size() = 3  getLast() = '3' getFirst() = '1'" {
        val list = SimpleLinkedList<String>()
        list.add("1")
        list.add("2")
        list.addLast("3")
        list.get(2) shouldBe "3"
        list.getSize() shouldBe 3
        list.getLast() shouldBe "3"
        list.getFirst() shouldBe "1"
    }
    "add('1') add('2') addLast('3')  deleteLast()  size() = 2  getLast() = '2'" {
        val list = SimpleLinkedList<String>()
        list.add("1")
        list.add("2")
        list.addLast("3")
        list.deleteLast()
        list.getSize() shouldBe 2
        list.getLast() shouldBe "2"
    }
    "add('1') add('2')  contains('2') = true contains('3') = false" {
        val list = SimpleLinkedList<String>()
        list.add("1")
        list.add("2")
        list.contains("2") shouldBe true
        list.contains("3") shouldBe false
    }
    "iterator()" {
        val list = SimpleLinkedList<String>()
        list.add("1")
        list.add("2")
        val itr = list.iterator()
        itr.hasNext() shouldBe true
        itr.next() shouldBe "1"
        itr.hasNext() shouldBe true
        itr.next() shouldBe "2"
        itr.hasNext() shouldBe false
    }
}) {
}
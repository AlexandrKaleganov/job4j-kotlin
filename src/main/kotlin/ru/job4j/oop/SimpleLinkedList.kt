package ru.job4j.oop

/**
 * реализация linkedList  с итератором
 */
class SimpleLinkedList<T> : Iterable<T>, ListIterator<T> {
    private var first: Node<T>? = null
    private var last: Node<T>? = null
    private var size = 0
    private var index = 0;
    override fun iterator() = LinkedIt()
    fun add(value: T) {
        addLast(value)
    }

    /**
     * добавление элемента в конец
     */
    fun addLast(e: T) {
        val newLink: Node<T> = Node(value = e)
        if (first == null) {
            refPrime(newLink)
        } else {
            last?.next = newLink
            newLink.prev = last
            this.last = newLink
        }
        size++
    }

    /**
     * рефакторинг добавления  первого элемента происходит везде одинаково
     * добавляется он в конец или в начало
     */
    private fun refPrime(newLink: Node<T>) {
        newLink.prev = first
        first = newLink
        newLink.next = this.last
        this.last = newLink
    }

    fun get(index: Int): T {
        var result: Node<T>? = null
        if (isCheck(index)) {
            result = first
            for (i in 0 until index) {
                result = result?.next
            }
        } else {
            result = last
            for (i in getSize() - 1 downTo index + 1) {
                result = last?.prev
            }
        }
        if (result != null)
            return result.value else throw IndexOutOfBoundsException("данного индекса не существует или вы вывалились за пределы массива")

    }

    /**
     * данный метод проверяет существует ли данный индекс
     * и поверяет с какой стороны быстрее искать искомый индекс
     */
    private fun isCheck(index: Int): Boolean {
        whenIndexOfBound(index)
        return index + 1 <= getSize() / 2
    }

    /**
     * проверка есть ли в контейнере элементы
     */
    private fun isCheckElement() {
        if (size <= 0) {
            throw java.util.NoSuchElementException("в контейнере отсутствуют элементы")
        }
    }

    /**
     * проверяет выходим ли мы за рамки существующих элементов
     * и проверяет есть ли хотя-бы один элемент
     */
    private fun whenIndexOfBound(index: Int) {
        if (size - 1 < index || size == 0) {
            throw IndexOutOfBoundsException("данного индекса не существует или вы вывалились за пределы массива")
        }
    }

    fun getSize() = size

    /**
     * удаление первого элемента
     */
    fun deleteFirst(): T? {
        isCheckElement()
        val temp: Node<T>? = first
        if (size == 1) {
            first = temp?.next
        } else {
            first = temp?.next
            first?.prev = temp?.prev
        }
        size--
        return temp?.value
    }

    /**
     * удаление последнего элемента
     */
    fun deleteLast(): T? {
        isCheckElement()
        val temp: Node<T>? = last
        if (size == 1) {
            last = temp?.prev
        } else {
            last = last?.prev
            last!!.next = temp?.next
        }
        size--
        return temp?.value
    }

    /**
     * вернуть последний элемент
     */
    fun getLast() = last?.value

    /**
     * вернуть первый элемент
     */
    fun getFirst() = first?.value

    /**
     * вернёт тру если элемент есть в листе
     */
    operator fun contains(e: T) = indexOf(e) != -1

    @Synchronized
    private fun indexOf(e: T): Int {
        var res = -1
        var temp: Node<T>? = first
        for (i in 0 until size) {
            if (temp?.value === e) {
                res = i
                break
            }
            temp = temp?.next
        }
        return res
    }

    inner class LinkedIt : Iterator<T> {
        private var iter: Node<T>? = first

        override fun hasNext(): Boolean {
            return iter != null
        }

        override fun next(): T {
            var element: T? = null
            if (!hasNext())
                throw NoSuchElementException()
            else {
                element = iter?.value as T
                iter = iter!!.next
            }
            return element
        }

    }

    class Node<T>(val value: T, var prev: Node<T>? = null, var next: Node<T>? = null)

    override fun hasNext() = index in 0 until size

    override fun hasPrevious() = index in 1..size

    override fun next(): T {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        return get(index++)
    }

    override fun nextIndex() = index

    override fun previous(): T {
        if (hasPrevious() || get(index) == null) {
            throw NoSuchElementException()
        } else {
            return get(index--)
        }
    }

    override fun previousIndex() = index - 1
}
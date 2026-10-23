package com.stimmax.lessons.lesson14.homeworks


// 1. Событие: вечеринка. Создайте класс Party, который описывает вечеринку.
// У него должны быть свойства location (String) и attendees (Int).
//Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.

class Party(val location: String, var attendees: Int) {
    fun details() {
        println("$location - ${attendees} людей придет")
    }
}

fun task1() {
    val party = Party("Reddisson", 100)
    party.details()  // Вечеринка в Редиссоне на 100 человек
}

// 2/ Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию.
// У него должно быть свойство type (String) и intensity (Int).
//Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.

class Emotion(var type: String, var intensity: Int) {
    fun express() {
        println("Эмоция - $type, интенсивность - $intensity")
    }
}

fun task2() {
    val sadness = Emotion("Груcть", 2)
    sadness.express()
}

// 3. Природное явление: луна. Создайте объект Moon, который будет представлять Луну.
// Добавьте свойства isVisible (Boolean), чтобы отображать, видна ли Луна в данный момент, и phase (String),
//чтобы отображать текущую фазу Луны (например, "Full Moon", "New Moon"). Добавьте метод showPhase(), который выводит текущую фазу Луны.
object Moon {
    val isVisible: Boolean = true
    val phase: String = "Full Moon"

    fun showPhase() {
        if (isVisible) {
            println("The moon is visible, and it's currently a $phase.")
        } else {
            println("The moon is not visible right now.")
        }
    }
}

fun task3() {
    Moon.showPhase()  // The moon is visible, and it's currently a Full Moon.
}

// 4. Покупка: продукт. Создайте дата класс для продукта, который будет представлять продукт в магазине.
//У него должны быть свойства “название”, “цена”, “количество”.

data class ShopItem(val name: String, val quantity: Int, val price: Double)

fun task4() {
    val pasta = ShopItem("Pasta Барилла", 1, 12.99)
    println(pasta)
}
// 5/ Мероприятие: концерт. Создайте класс, который будет представлять концерт.
//У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”.
//Также приватное поле “проданные билеты”. Добавьте метод, который выводит информацию о концерте и метод “купить билет”,
// который увеличивает количество проданных билетов на один.


class Concert(
    val groupName: String,
    val place: String,
    val price: Double,
    val vmestimost: Int
) {

    private var soldTickets: Int = 0

    fun info() {
        println("Концерт: $groupName, Место: $place, Цена: $price, Вместимость: $vmestimost")
    }

    fun buyTicket() {
        if (soldTickets < vmestimost) {
            soldTickets++

            println("Билет успешно куплен на концерт группы $groupName!")
        } else {
            println("К сожалению, все билеты на концерт группы $groupName проданы!")
        }
    }

}

fun main() {
    val myConcert = Concert("Linkin Park", "Стадион Лужники", 5000.0, 2)

    myConcert.info()

    myConcert.buyTicket()
    myConcert.buyTicket()
    myConcert.buyTicket() // все продано!

    myConcert.info()
}


// Задание 6. Стеллаж и полки.
// Цель задания: Создать систему управления складским пространством с использованием классов "Стеллаж" и "Полка стеллажа".
// Класс Shelf (Полка Стеллажа)
// Характеристики:
// Вместимость полки (capacity): максимальная сумма букв всех названий предметов, которые могут быть размещены на полке.
// Список предметов (items): хранит названия предметов на полке.

// Методы:

// Добавление Предмета (addItem):
// Принимает название предмета.
// Проверяет, поместится ли предмет на полку, учитывая длину его названия и текущее заполнение полки.
// Возвращает true и добавляет предмет, если есть место. В противном случае возвращает false.
// Удаление Предмета (removeItem):
// Принимает название предмета.
// Удаляет предмет, если он найден на полке.
// Возвращает true, если предмет был удален, и false, если такой предмет не найден.
// Проверка Вместимости (canAccommodate):
// Принимает название предмета.
// Определяет, вместится ли предмет на полку.
// Возвращает true, если предмет вместится, и false, если места недостаточно.
// Проверка наличия предмета (containsItem):
// Принимает название предмета
// Возвращает true если такой предмет есть
// Получение списка предметов (getItems):
// Возвращает неизменяемый список предметов

class Shelf(val capacity: Int) {

    private val items = mutableListOf<String>()

    fun containsItem(name: String): Boolean {
        return items.contains(name)
    }

    // сумма букв всех предметов
    fun getCurrentUsedSpace(): Int {
        return items.sumOf { it.length }
    }

    fun getRemainingCapacity(): Int {
        return capacity - getCurrentUsedSpace()
    }

    //  поместится ли новый предмет?
    fun canAccommodate(name: String): Boolean {
        return name.length <= getRemainingCapacity()
    }

    // Добавление предмета
    fun addItem(name: String): Boolean {
        if (!canAccommodate(name)) {
            return false // Места недостаточно
        }
        items.add(name)
        return true //  добавлен
    }

    // Удаление предмета
    fun removeItem(name: String): Boolean {

        return items.remove(name)
    }

    // Получение списка предметов
    fun getItems(): List<String> {
        return items.toList()
    }
}


// Класс Rack (Стеллаж)

// Характеристики:

// Список полок (shelves): хранит полки стеллажа.
// Максимальное количество полок.
// Методы:

// Добавление Полки (addShelf):
// Добавляет новую полку в стеллаж.
// Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен или была попытка добавить полку которая уже установлена.
// Удаление Полки (removeShelf):
// Принимает индекс полки для удаления.
// Удаляет полку по указанному индексу.
// Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.
// Добавление Предмета (addItem):
// Добавляет предмет на первую свободную полку.
// Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.
// Удаление Предмета (removeItem):
// Находит и удаляет только один предмет с любой полки.
// Возвращает true, если предмет был удален, и false, если такой предмет не найден.
// Проверка наличия предмета на стеллаже (containsItem):
// Возвращает true если предмет есть на одной из полок
// Получение списка полок (getShelves):
// Возвращает неизменяемый список полок
// Печать Содержимого (printContents):
// Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов. Информацию выводить в наглядном читаемом виде
// Сложное удаление полки (advancedRemoveShelf):
// Принимает индекс полки для удаления
// Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается, его нужно пропустить и попробовать разместить следующий.
// Удаляет полку с оставшимися предметами
// Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет. */


class Rack(private val maxShelves: Int) {

    private val shelves = mutableListOf<Shelf>()

    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.contains(shelf) || shelves.size == maxShelves) {
            return false
        }
        shelves.add(shelf)
        return true
    }

    fun removeShelf(index: Int): List<String> {
        if (index !in shelves.indices) {
            return emptyList()
        }
        val items = shelves[index].getItems()
        shelves.removeAt(index)
        return items
    }

    fun addItem(name: String): Boolean {
        if (shelves.isEmpty()) {
            return false
        }
        for (shelf in shelves) {
            if (shelf.canAccommodate(name)) {
                return shelf.addItem(name)
            }
        }
        return false
    }

    fun removeItem(name: String): Boolean {
        for (shelf in shelves) {
            if (shelf.containsItem(name)) {
                return shelf.removeItem(name)
            }
        }
        return false
    }

    fun containsItem(name: String): Boolean {
        return shelves.any { it.containsItem(name) }
    }

    fun getShelves() = shelves.toList()

    fun printContents() {
        for (i in shelves.indices) {
            val capacity = shelves[i].capacity
            val accessiblePlace = capacity - shelves[i].getItems()
                .map { it.length }
                .sum()
            val meta = "$i вместимость: $capacity доступно: $accessiblePlace"
            val items = shelves[i].getItems().joinToString()
            println(meta)
            println("Предметы: $items")
            println()
        }
    }

    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in shelves.indices) {
            return emptyList()
        }
        val notReplacedItems = mutableListOf<String>()
        val otherShelves = shelves - shelves[index]
        for (item in shelves[index].getItems()) {
            if (otherShelves.none { it.addItem(item) }) {
                notReplacedItems.add(item)
            }
        }
        shelves.removeAt(index)
        return notReplacedItems.toList()
    }
}
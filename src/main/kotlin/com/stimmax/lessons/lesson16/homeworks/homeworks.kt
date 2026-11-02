package com.stimmax.lessons.lesson16.homeworks
//Переопределение методов

// Животные и Их Звуки
// Базовый класс: Animal с методом makeSound().
// Классы наследники: Dog, Cat, Bird.
// Базовый метод makeSound() в классе Animal выводит "This animal makes no sound."
// Переопределите метод makeSound() в каждом классе-наследнике, чтобы Dog выводил "Bark", Cat - "Meow", Bird - "Tweet". Обогати вывод звуков цветом.
// Создайте список животных List<Animal> и вызовите в цикле метод makeSound()

object Colors {
  const val YELLOW = "\u001B[33m"
  const val BLACK = "\u001B[30m"
  const val RED = "\u001B[31m"
  const val GREEN = "\u001B[32m"
  }
  


open class Animal {

    open fun makeSound() {
        println("This animal makes no sound.")
    }
}


class Dog : Animal() {
    override fun makeSound() {
        println("${Colors.GREEN}Bark${Colors.RESET}")
    }
}

class Cat : Animal() {
    override fun makeSound() {
        println("${Colors.RED}Meow${Colors.RESET}")
    }
}

class Bird : Animal() {
    override fun makeSound() {
        println("${Colors.YELLOW}Tweet${Colors.RESET}")
    }
}

fun task1() {

    val animals: List<Animal> = listOf(Dog(), Cat(), Bird(), Animal())

    for (animal in animals) {
        animal.makeSound()
    }
}

// Геометрические Фигуры и Их Площадь
// Абстрактный (базовый) класс: Shape с open методом area().
// Классы наследники: Circle, Square, Triangle.
// Метод area() возвращает 0.0.
// Переопределите метод area() в каждом классе-наследнике для расчета площади соответствующей фигуры.
// Подсказка: каждый класс должен иметь аргументы конструктора, позволяющие вычислить площадь (для круга это радиус, для квадрата это сторона, для треугольника это две стороны и угол между ними)
// Создай набор геометрических фигур и выведи в цикле их площадь  


abstract class Shape(val name: String) {
    abstract fun area(): Double
}

// Круг
class Circle(val radius: Double) : Shape("Круг") {
    private val pi = 3.14

    override fun area(): Double {
        return pi * radius * radius
    }
}

// Квадрат
class Square(val side: Double) : Shape("Квадрат") {
    override fun area(): Double {
        return side * side
    }
}

// Треугольник
class Triangle(
    val a: Double, 
    val b: Double, 
    val c: Double
) : Shape("Треугольник") {
    
    override fun area(): Double {
        val p = (a + b + c) / 2.0
        // Math.sqrt
        return Math.sqrt(p * (p - a) * (p - b) * (p - c))
    }
}

fun task2() {
    val shapes: List<Shape> = listOf(
        Circle(radius = 5.0),
        Square(side = 4.0),
        Triangle(a = 3.0, b = 4.0, c = 5.0)
    )

for (shape in shapes) {
    println("Площадь фигуры ${shape.name}: ${shape.area()}")
}

}


// Принтер
// Создай абстрактный принтер, который имеет абстрактный метод печати, принимающий в качестве аргумента строку.
// Создай классы наследники: лазерный и струйный
// Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно чёрными буквами на белом фоне (хорошо работает на тёмной теме)
// Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно цветными буквами на цветном фоне. Слова должны быть разноцветны. Можно сделать список пар с цветом текста и фона и проходить циклически по этому списку при выводе текста. Проверить работу на длинном тексте


abstract class Printer {
    abstract fun printText(text: String)
}

// Лазерный принтер
class LaserPrinter : Printer() {
    private val blackTextWhiteBg = "\u001B[30;47m"
    private val reset = "\u001B[0m"

    override fun printText(text: String) {
        val words = text.split(" ")
        
        for (word in words) {
            println("$blackTextWhiteBg$word$reset")
        }
    }
}

// Струйный принтер
class InkjetPrinter : Printer() {
    private val reset = "\u001B[0m"

    // Список пар (Цвет текста, Цвет фона)
    private val colorPairs = listOf(
        Pair("\u001B[31m", "\u001B[44m"), // Красный текст, Синий фон
        Pair("\u001B[32m", "\u001B[45m"), // Зеленый текст, Пурпурный фон
        Pair("\u001B[33m", "\u001B[46m"), // Желтый текст, Голубой фон
        Pair("\u001B[35m", "\u001B[42m"), // Пурпурный текст, Зеленый фон
        Pair("\u001B[36m", "\u001B[41m")  // Голубой текст, Красный фон
    )

    override fun printText(text: String) {
        val words = text.split(" ")

        for ((index, word) in words.withIndex()) {
            // Оператор % (остаток от деления) зацикливает индекс. 
            val colorIndex = index % colorPairs.size
            val (textColor, bgColor) = colorPairs[colorIndex]

            println("$textColor$bgColor$word$reset")
        }
    }
}

fun task3() {
    val longText = "Котлин это прекрасный современный язык программирования который позволяет писать чистый и безопасный код"

    println("РАБОТА ЛАЗЕРНОГО ПРИНТЕРА")
    val laser: Printer = LaserPrinter()
    laser.printText(longText)

    println("РАБОТА СТРУЙНОГО ПРИНТЕРА")
    val inkjet: Printer = InkjetPrinter()
    inkjet.printText(longText)
}

// Перегрузка методов

// Класс “Корзина товаров”: содержит поле словаря из ID товаров и их количества.
// Базовый метод addToCart(itemId) добавляет одну единицу товара к уже существующим в корзине.
// Выполнить перегрузку addToCart который:
// Принимает два аргумента (itemId и количество amount)
// Принимает словарь из id и количества и добавляет всё в корзину
// Принимает список из id (добавляет по одной единице).
// Учесть, что если товар уже есть в корзине, нужно увеличить его количество, если нет - добавить.
// Попробуй создать корзину и положить в неё товар разными способами, потом распечатать корзину в консоль.
// Переопредели у корзины метод toString для красивого форматирования содержимого таблицы, включая итоговое количество артикулов и общее количество всего товара в корзине.


class Cart {
    // Поле словаря: Ключ - ID товара (String), Значение - количество (Int)
    private val items = mutableMapOf<String, Int>()

    fun addToCart(itemId: String) {
        // Если товара нет, getOrDefault вернет 0. Увеличиваем на 1.
        items[itemId] = items.getOrDefault(itemId, 0) + 1
    }

    fun addToCart(itemId: String, amount: Int) {
        if (amount <= 0) return 
        items[itemId] = items.getOrDefault(itemId, 0) + amount
    }

    fun addToCart(newItems: Map<String, Int>) {
        for ((itemId, amount) in newItems) {
            addToCart(itemId, amount)
        }
    }


    fun addToCart(itemIds: List<String>) {
        for (itemId in itemIds) {
            addToCart(itemId)
        }
    }
    

override fun toString(): String {
    if (items.isEmpty()) {
        return "Корзина пуста"
    }

    val sb = StringBuilder()
    
    // Шаблон для строк таблицы: 
    val rowTemplate = "| %-12s | %-12s |\n"
    val dataTemplate = "| %-12s | %-12d |\n"
    val border = "---------------------------------\n"

    // Строим верх таблицы
    sb.append(border)
    sb.append(String.format(rowTemplate, "ID Товара", "Количество"))
    sb.append(border)
    
    var totalQuantity = 0

    //Перебираем словарь и добавляем каждую позицию в таблицу
    for ((itemId, quantity) in items) {
        sb.append(String.format(dataTemplate, itemId, quantity))
        totalQuantity += quantity // Суммируем количество
    }
    
    // Добавляем низ с итогами
    sb.append(border)
    sb.append("Всего артикулов (уникальных): ${items.size}\n")
    sb.append("Общее количество товара:      $totalQuantity\n")
    sb.append(border)
    
    return sb.toString()
}
}
fun task4() {
    val cart = Cart()


    cart.addToCart("A1") 
    cart.addToCart("A1") 

    cart.addToCart("C3", 5) 

    val list = listOf("A1", "D4")
    cart.addToCart(list)


    val map = mapOf("B2" to 3, "E5" to 10)
    cart.addToCart(map) 

    println(cart) 
}

// Класс “Логгер”: представляет из себя инструмент для вывода информации в консоль с разным префиксами уровня логирования (INFO, WARNING, ERROR, DEBUG)
// Базовый метод log(message) выводит в консоль сообщение message с префиксом INFO
// Выполнить перегрузку метода log, который:
// Принимает уровень логирования и сообщение. Выводит сообщения типа WARNING жёлтым цветом, а ERROR белым цветом на красном фоне.
// Принимает список сообщений и все их выводит с уровнем INFO
// Принимает объект типа Exception и выводит его поле message с префиксом уровня ERROR
// Попробуй создать логгер и добавить в него сообщения разными способами. Проверь вывод в консоли.


class Logger {

    private val reset = "\u001B[0m"
    private val yellowText = "\u001B[33m"
    private val whiteTextRedBg = "\u001B[37;41m"


    fun log(message: String) {
        println("[INFO]: $message")
    }

 
    fun log(level: String, message: String) {

        when (level.uppercase()) {
            "WARNING" -> println("${yellowText}[WARNING]: $message$reset")
            "ERROR" -> println("${whiteTextRedBg}[ERROR]: $message$reset")
            else -> println("[$level]: $message") 
        }
    }


    fun log(messages: List<String>) {
        for (message in messages) {

            log(message)
        }
    }


    fun log(exception: Exception) {

        val errorMessage = exception.message ?: "Неизвестная ошибка"

        log("ERROR", errorMessage)
    }
}

fun task5() {
    val logger = Logger()


    logger.log("Приложение успешно запустилось.")


    logger.log("WARNING", "Предупреждение!")
    logger.log("error", "Ошибка!") 
    logger.log("DEBUG", "Отладка: Имя Пользователя - Джон Доу") 


    val infoList = listOf("Вход в систему", "Товар добавлен", "Заказ оформлен")
    logger.log(infoList)


    val myException = Exception("Критический сбой: Доступ запрещен!")
    

    logger.log(myException)
}

fun main() {
	task1() 
    task2() 
	task3() 
    task4() 
	task5() 

}
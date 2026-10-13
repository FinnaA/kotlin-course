package com.stimmax.lessons.lesson11.homeworks

// 1. Не принимает аргументов и не возвращает значения.
public fun task1(): Unit {

}

// 2.Принимает два целых числа и возвращает их сумму.
public fun task2(a: Int, b: Int): Int {
    return a + b
}

// 3. Принимает строку и ничего не возвращает.
public fun task3(someString: String) {}

//4. Принимает список целых чисел и возвращает среднее значение типа Double.
public fun task4(numbers: List<Int>): Double {
    if (numbers.size == 0) {
        return 0.0
    }
    var sum = 0.0
    for (number in numbers) {
        sum = sum + number
    }

    return sum / numbers.size
}

// 5. Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun task5(someString: String?): Int? {
    if (someString != null) {
        return someString.length
    } else {
        // Если строка оказалась null, возвращаем null
        return null
    }
}

// 6. Не принимает аргументов и возвращает nullable вещественное число.
public fun task6(): Double? {
    return null
    // return 100.0
}

//7. Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun task7(someNumbers: List<Int>?) {}

//8. Принимает целое число и возвращает nullable строку.
public fun task8(someNumber: Int): String? {
    return null
}

//9. Не принимает аргументов и возвращает список nullable строк.
public fun task9(): List<String?> {
    return listOf()
}

//10. Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
public fun task10(someString: String?, someNumber: Int?): Boolean? {
    return true // ну или null или false
}

//11. Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.

public fun multiplyByTwo(number: Int): Int {
    return number * 2
}

// 12. Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.

public fun isEven(number: Int): Boolean {
    return number % 2 == 0
}

// 13. Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n. Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.

public fun printNumbersUntil(n: Int) {
    if (n < 1) {
        return
    }
    for (i in 1..n) {
        println(i)
    }
}

//14. Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке. Если отрицательных чисел нет, функция должна вернуть null.
public fun findFirstNegative(numbers: List<Int>): Int? {
    for (number in numbers) {
        if (number < 0) {
            return number
        }
    }

    return null
}

//15. Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.

public fun processList(strings: List<String?>) {
    for (str in strings) {
        if (str == null) {
            return
        }
        println(str)
    }
}

package com.stimmax.lessons.lesson09.homeworks

fun homework() {
//1. Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val numbers1: Array<Int> = arrayOf(1, 2, 3, 4, 5)

// 2. Создайте пустой массив строк размером 10 элементов.
    val emptyArray: Array<String> = Array(size = 10) { "" }

//3. Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.

    val doubleArray = Array(size = 5) { 0.0 }
    for (index in doubleArray.indices) {
        doubleArray[index] = (index * 2).toDouble()
    }

// 4. Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
    val newArray: Array<Int> = Array(size = 5) { 0 }
    for (index in newArray.indices) {
        newArray[index] = index * 3
    }

//5. Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.

    val nullArray: Array<String?> = arrayOf(null, "", "")


// 6. Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val intArray: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val newIntArray: Array<Int> = Array(size = intArray.size) { 0 }

    for (index in intArray.indices) {
        newIntArray[index] = intArray[index]
    }

//7. Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
    val firstArray: Array<Int> = arrayOf(10, 20, 30, 40, 50)
    val secondArray: Array<Int> = Array(size = firstArray.size) { 10 }
    val firdArray: Array<Int> = Array(size = firstArray.size) { 0 }
    for (index in firstArray.indices) {
        firdArray[index] = firstArray[index] - secondArray[index]
        println("$index: ${firdArray[index]}")

    }

// 8. Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.

    val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    var index1 = 0
    var result = -1

    while (index1 < numbers.size) {
        if (numbers[index1] == 5) {
            result = index1
            break
        }
        index1++
    }

    println(result)


// 9. Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
    val chet = "чётное"
    val neChet = "нечётное"
    val integerArray: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    var index = 0

    while (index < integerArray.size) {
        val number = integerArray[index]
        if (number % 2 == 0) {
            println("$number $chet")
        } else {
            println("$number $neChet")
        }
        index++
    }

// 10. Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.

    val task1: Array<String> = arrayOf("Я", "Люблю", "Конфеты", "и", "Котлин")
    val sub = "Котлин"

    fun findstring(task1: Array<String>, sub: String) {
        for (text in task1) {
            if (text.contains(sub)) {
                println("Найденный элемент: $text")
                return
            }
        }
        println("Элемент с подстрокой '$sub' не найден")
    }

// 1. Создайте пустой неизменяемый список целых чисел.
    val readOnlyList: List<Int> = emptyList()

// 2. Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val helloList: List<String> = listOf("Hello", "World", "Kotlin")

//3. Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    val mutableList2: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)


//4. Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    val mutableList3: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    mutableList3.add(6)
    mutableList3.add(7)
    mutableList3.add(8)

// 5. Имея изменяемый список строк, удалите из него определенный элемент (например, "World").

    val mutableList5: MutableList<String> = mutableListOf("Hello", "World")
    mutableList5.removeAt(index = 1)

// 6. Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    val numbersList6: List<Int> = listOf(1, 2, 3, 4, 5)
    for (index in numbersList6.indices) {
        println("${numbersList6[index]}")
    }

//7. Создайте список строк и получите из него второй элемент, используя его индекс.
    val someList: List<String> = listOf("я", "Люблю", "Тортики")
    val second = someList[1]

// 8.Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое значение).
    val mutableList8: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    mutableList8[2] = 100

//9. Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
    val firstList: List<String> = listOf("я", "Люблю", "Тортики")
    val secondtList9: List<String> = listOf("и", "Люблю", "Котлин")
    val thirdList: MutableList<String> = mutableListOf()
    for (items in firstList) {
        thirdList.add(items)
    }
    for (items in secondtList9) {
        thirdList.add(items)
    }

//10. Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    val numbersList10: List<Int> = listOf(7, 3, 9, 2, 8, 5)
    var min = numbersList10[0]
    var max = numbersList10[0]
    for (number in numbersList10) {
        if (number < min) {
            min = number
        }
        if (number > max) {
            max = number
        }
    }
    println("Минимальный: $min")
    println("Максимальный: $max")

//11. Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
    val numbersList: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val chetNumbersList: MutableList<Int> = mutableListOf()

    for (number in numbersList) {
        if (number % 2 == 0) {
            chetNumbersList.add(number)
        }
    }

//1. Создайте пустое неизменяемое множество целых чисел.
    val numbersSet: Set<Int> = setOf()

//2. Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    val numbersSet2: Set<Int> = setOf(1, 2, 3)

//3. Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
    val mutableStringsSet: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")

//4. Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    val mutableStringSet: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")
    mutableStringSet.add("Swift")
    mutableStringSet.add("Go")

//5. Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    val numbersSet3: MutableSet<Int> = mutableSetOf(1, 2, 3)
    numbersSet3.remove(element = 2)

//6. Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    val numbersSet4: Set<Int> = setOf(1, 2, 3)
    for (number in numbersSet4) {
        println(" $number ")
    }

//7. Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка. Нужно распечатать булево значение true если строка есть. Реши задачу через цикл.

    fun checkContains(stringSet: Set<String>, searchString: String): Boolean {
        for (item in stringSet) {
            if (item == searchString) {
                return true
            }
        }
        return false
    }

    fun task7() {
        val languages = setOf("Kotlin", "Java", "Python")
        val result = checkContains(languages, "Kotlin")
        println(result)

        val result2 = checkContains(languages, "Swift")
        println(result2)
    }
//8. Создайте неизменяемое множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
    val stringSet: Set<String> = setOf("Kotlin", "Тортики", "БлекДжек")
    val mutableList: MutableList<String> = mutableListOf()
    for (element in stringSet) {
        mutableList.add(element)
    }
}






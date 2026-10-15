package com.stimmax.lessons.lesson12.homeworks


fun main() {

    val numbers = listOf(1, 2, 4, 44, -4, 0, 39, 6, 8, -2, 265, 17, 31, 46)


// 1.Проверить, что размер коллекции больше 5 элементов.
    val check1 = numbers.size > 5

//2. Проверить, что коллекция пустая
    if (numbers.isEmpty()) {
        println("Коллекция пуста")
    } else {
        println("В коллекции ${numbers.size} значений")
    }
//3. Проверить, что коллекция не пустая isNotEmpty
    if (numbers.isNotEmpty()) {
        println("Коллекция пуста")
    } else {
        println("В коллекции ${numbers.size} значений")
    }
//4.Взять элемент по индексу или создать значение если индекса не существует
    val elementOrElse = numbers.getOrElse(index = 10) { -1 }
    println(elementOrElse) // Вывод: -1

//5. Собрать коллекцию в строку
    val numbersString = numbers.joinToString()
    println(numbersString)

//6. Посчитать сумму всех значений
    val sumNumbers = numbers.sum()
    println(sumNumbers)

//7. Посчитать среднее

    val averageOfNumbers = numbers.average()
    println(averageOfNumbers)

//8. Взять максимальное число
    val maxNumber = numbers.maxOrNull()
    println(maxNumber)

//9.Взять минимальное число
    val minNumber = numbers.minOrNull()
    println(minNumber)

//10. Взять первое число или null
    val firstNum = numbers.firstOrNull()
    println(firstNum)
//11. Проверить что коллекция содержит элемент
    if (numbers.contains(265)) {
        println("Коллекция содержит элемент")
    } else {
        println("В коллекции не содержит элемент")
    }


//12. Отфильтровать коллекцию по диапазону 18-30
    val filtered = numbers.filter {
        it in 18..30
    }
    println(filtered)

//13. Выбрать числа, которые не делятся на 2 и 3 одновременно
    val filtered2 = numbers.filterNot { it % 2 == 0 && it % 3 == 0 }

//14. Очистить текстовую коллекцию от null элементов
    val texts = listOf("Я", "всегда", "буду", null, "делать", "бэкапы")
    val cleanTexts = texts.filterNotNull()
    println(cleanTexts)

//15. Преобразовать текстовую коллекцию в коллекцию длин слов
    val wordLengths = texts.filterNotNull().map { it.length }

    println(wordLengths)

//16. Преобразовать текстовую коллекцию в мапу, где ключи - перевёрнутые слова, а значения - длина слов
    val texts2 = listOf("Я", "всегда", "буду", null, "делать", "бэкапы")
    val textMap = mutableMapOf<String, Int>()
    for (word in texts2.filterNotNull()) {
        var reversedWord = ""
        for (i in word.lastIndex downTo 0) {
            reversedWord += word[i]
        }
        textMap[reversedWord] = word.length
    }
    println(textMap)

//17. Отсортировать список в алфавитном порядке
    val words = listOf("Я", "всегда", "буду", "делать", "делать", "бэкапы")
    val sortedWords = words.sorted()

    println(sortedWords)

//18. Взять первые 3 элемента списка
    println(words.take(3))

//19. Распечатать квадраты элементов списка
    val numbersSquare = numbers.map { it * it }

    println(numbersSquare)
//20 Группировать список по первой букве слов
    val groupedMap = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val firstLetterUpper = word.first().toString().uppercase()
        if (!groupedMap.containsKey(firstLetterUpper)) {
            groupedMap[firstLetterUpper] = mutableListOf()
        }

        groupedMap[firstLetterUpper]?.add(word)
    }
//21 Очистить список от дублей
    val uniqueWords = words.distinct()
    println(uniqueWords)

//22 Отсортировать список по убыванию
    val sortedNumbers = numbers.sortedDescending()
    println(sortedNumbers)

//23 Взять последние 3 элемента списка
    val lastThree = numbers.takeLast(3)

    println(lastThree)

//24 Напиши функцию, которая принимает коллекцию чисел и возвращает строку с характеристикой коллекции используя конструкцию when

    fun gradeCollection(numbers: List<Int>): String {
        return when {
            numbers.isEmpty() -> "Пусто"
            numbers.size < 5 -> "Короткая"
            numbers.firstOrNull() == 0 -> "Стартовая"
            numbers.sum() > 10000 -> "Массивная"
            numbers.average() == 10.0 -> "Сбалансированная"
            numbers.joinToString("").length == 20 -> "Клейкая"
            (numbers.maxOrNull() ?: 0) < -10 -> "Отрицательная"
            (numbers.minOrNull() ?: 0) > 1000 -> "Положительная"
            numbers.contains(3) && numbers.contains(14) -> "Пи***тая"
            else -> "Уникальная"
        }
    }


    //Задача 25. Анализ учебных оценок
//Напиши функцию, которая принимает список чисел и возвращает список чисел.
//Пример данных: val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
//Цель: Отфильтровать удовлетворительные оценки (>=60), отсортировать оставшиеся по возрастанию и взять первые 3. Вызывай методы обработки и фильтрации последовательно один из другого, чтобы результат предыдущего метода являлся основой для следующего.
    fun filterGrades(grades: List<Int>): List<Int> {
        return grades
            .filter { it >= 60 }
            .sorted()
            .take(3)
    }

    fun task25() {
        val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
        val result = filterGrades(grades)

        println("Результат обработки: $result")
    }

//Задача 26. Создание каталога по первой букве
//Напиши функцию, которая принимает список строк и возвращает словарь с ключом - буквой и значением - списком строк.
//Начальные значения: val list = listOf(
//"Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор", "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба", "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир", "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
//)
//Цель: Привести все слова в списке к нижнему регистру, сгруппировать в каталог по первой букве используя метод groupBy

    fun createCatalogByFirstLetter(items: List<String>): Map<Char, List<String>> {
        return items
            .map { it.lowercase() }
            .groupBy { it.first() }
    }


        val list = listOf(
            "Стол",
            "табурет",
            "ваза",
            "Кружка",
            "Зеркало",
            "ковер",
            "Шкаф",
            "часы",
            "Люстра",
            "подушка",
            "Картина",
            "столик",
            "Вазон",
            "шторы",
            "Пуф",
            "книга",
            "Фоторамка",
            "светильник",
            "Коврик",
            "вешалка",
            "Подставка",
            "телевизор",
            "Комод",
            "полка",
            "Абажур",
            "диван",
            "Кресло",
            "занавеска",
            "Бра",
            "пепельница",
            "Глобус",
            "статуэтка",
            "Поднос",
            "фигурка",
            "Ключница",
            "плед",
            "Тумба",
            "игрушка",
            "Настенные часы",
            "подсвечник",
            "Журнальный столик",
            "сувенир",
            "Корзина для белья",
            "посуда",
            "Настольная лампа",
            "торшер",
            "Этажерка"
        )
    fun task26() {
        val catalog = createCatalogByFirstLetter(list)

        catalog.forEach { (letter, words) ->
            println("$letter: $words")
        }
    }
//Задание 27. Подсчёт средней длины слов в списке
//Напиши функцию, которая принимает список строк и возвращает строку.
//Начальные значения взять из предыдущей задачи.
//Цель: Перевести все слова в количество букв, подсчитать среднее значение. Вернуть форматированный текст с двумя знаками после запятой, используя функцию format и подходящий шаблон.

    fun calculateLength(items: List<String>): String {
        val wordLengths = items.map { it.length }
        val average = wordLengths.average()

        return "Средняя длина: ".format(average)
    }

    val result = calculateLength(list)
    println(result)


//Задание 28: Категоризация чисел
//Напиши функцию, которая принимает список чисел и возвращает словарь с ключами - строками и значениями - список чисел.
//Начальные значения: val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
//Цель: Отобрать уникальные числа, отсортировать по убыванию и сгруппировать по четности (“четные” и “нечетные”).

    val numbers2 = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
    fun task28(numbers: List<Int>): Map<String, List<Int>> {

        val processedNumbers = numbers2.distinct().sortedDescending()
        val result = mutableMapOf<String, MutableList<Int>>(
            "четные" to mutableListOf(),
            "нечетные" to mutableListOf()
        )

        for (num in processedNumbers) {
            if (num % 2 == 0) {
                result["четные"]?.add(num)
            } else {
                result["нечетные"]?.add(num)
            }
        }

        return result
    }

    val grouped = task28(numbers2)
    println(grouped)


//Задание 29: Поиск первого подходящего элемента
//Напиши функцию, которая принимает список чисел и число и возвращает nullable число.
//Начальные значения: val ages = listOf(22, 18, 30, 45, 17, null, 60) и число для проверки возраста, например 18.
//Цель: Найти первый возраст в списке, который соответствует условию (больше второго аргумента) и вернуть его, либо null если значения не нашлось.

    val ages = listOf(22, 18, 30, 45, 17, null, 60)
    fun findFirstOlderAge(ages: List<Int?>, minAge: Int): Int? {
        for (age in ages) {
            if (age != null && age > minAge) {
                return age
            }
        }

        return null
    }

    val result1 = findFirstOlderAge(ages, 18)
    println("Первый возраст больше 18: $result1")


}
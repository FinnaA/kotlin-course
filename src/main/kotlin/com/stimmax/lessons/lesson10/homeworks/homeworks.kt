package com.stimmax.lessons.lesson10.homeworks

// 1. Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
val task1: Map<Int, Int> = mapOf(1 to 10, 2 to 11, 3 to 12)

// 2. Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
val task22: Map<Float, Double> = mapOf(1.00f to 10.00, 2.00f to 11.00, 3.00f to 12.00)


fun lesson10() {
//3. Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
    val mutableMap: MutableMap<Int, String> = mutableMapOf(1 to "Москва", 2 to "Париж")


//4. Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
    mutableMap[3] = "Берлин"
    mutableMap[4] = "Простоквашино"

//5. Используя словарь из предыдущего задания, извлеките значение, используя ключ. Попробуй получить значение с ключом, которого в словаре нет.
    val city = mutableMap[1] //получение значение по ключу
    println(city)

    val noEntity = mutableMap[5]
    println(noEntity)


// 6. Удалите определенный элемент из изменяемого словаря по его ключу.
    mutableMap.remove(key = 1)

//7. Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение. Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)

    val map3: Map<Double, Int> = mapOf(10.0 to 2, 5.5 to 0, 12.0 to 4, -3.0 to 0)
    for ((key, value) in map3) {
        if (value == 0) {
            println("Ключ $key делим на $value: бесконечность")
        } else {
            val result = key / value
            println("Ключ $key делим на $value: $result")
        }
    }


//8. Измените значение для существующего ключа в изменяемом словаре.
    mutableMap[3] = "деревня Васюки"

// 9. Создайте два словаря и объедините их в третьем изменяемом словаре через циклы
    val map1 = mapOf("Яблоки" to 5, "Бананы" to 10)
    val map2 = mapOf("Апельсины" to 8, "Орехи" to 15)

    val combinedMap = mutableMapOf<String, Int>()

    for ((key, value) in map1) {
        combinedMap[key] = value
    }
    for ((key, value) in map2) {
        combinedMap[key] = value
    }

//10. Создайте словарь, где ключами являются строки, а значениями - списки целых чисел. Добавьте несколько элементов в этот словарь.
    val dynamicMap = mutableMapOf<String, List<Int>>(
        "Четные" to listOf(2, 4, 6),
        "Нечетные" to listOf(1, 3, 5)
    )
    dynamicMap["Разные числа"] = listOf(1, 3, 5, 7)
    val key = "Четные"
    val currentList = dynamicMap[key] // текущий список

    if (currentList != null) {
        dynamicMap[key] = currentList + 8
    }

//11. Создай словарь   в котором ключи - это целые числа, а значения - изменяемые множества строк. Добавь данные в словарь. Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку. Распечатай полученное множество.

    val map4: MutableMap<Int, MutableSet<String>> =
        mutableMapOf(1 to mutableSetOf("Котлин", "Тортики"), 2 to mutableSetOf("Котики"))
    map4[3] = mutableSetOf("Лес", "ООП")

    val keyToFind = 1
    val stringSet = map4[keyToFind]

    stringSet?.add("- Вот что я люблю")
    println("$keyToFind: $stringSet")


// 12. Создай словарь, где ключами будут пары чисел. Через перебор найди значение у которого пара будет содержать цифру 5 в качестве первого или второго значения.
    val map: Map<Pair<Int, Int>, String> = mapOf(
        Pair(1, 2) to "Первое значение",
        Pair(5, 10) to "Второе значение (5 на первом месте)",
        Pair(3, 5) to "Третье значение (5 на втором месте)",
        Pair(4, 8) to "Четвертое значение"
    )

    for ((key, value) in map) {
        if (key.first == 5 || key.second == 5) {
            println("Найдено совпадение!")
            println("Ключ-пара: (${key.first}, ${key.second}), Значение: \"$value\"")
            println("---")
        }
    }

// 1. Словарь библиотека: Ключи - автор книги, значения - список книг
    val library = mutableMapOf<String, MutableList<String>>(
        "Пушкин" to mutableListOf("Капитанская дочка", "Евгений Онегин"),
        "Пелевин" to mutableListOf("Generation", "Всякое") // он может написать еще книги
    )


//2. 	Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
    val plantList = mutableMapOf( // мутирующий мэп, потому что могут открыть новые растения
        "Цветы" to mutableListOf("Роза", "Ромашка"),
        "Деревья" to mutableListOf("Дуб", "Береза", "Сосна")
    )

//3. Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
    val championship: Map<String, List<String>> = mapOf( // состав меняться не будет
        "Спартак" to listOf("Онопко", "Акинфеев", "Березуцкий"),
        "Барса" to listOf("Роналду", "Роналдини", "Ривальдо")
    )

//4. Список назначений варча
    val treatmentCourse = mutableMapOf( // курс лечения может меняться
        "12.10.2026" to mutableListOf("Аспирин", "Витамин C"),
        "12.11.2026" to mutableListOf("Аспирин", "Витамин C", "Аторакс"),
        "12.12.2026" to mutableListOf("Витамин C")
    )

//5. Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.
    val travelList: Map<String, Map<String, List<String>>> = mapOf(
        "Италия" to mapOf(
            "Рим" to listOf("Колизей", "Пиццерия"),
            "Венеция" to listOf("Каналы", "Набережная")
        ),
        "Россия" to mapOf(
            "Суздаль" to listOf("День огурца", "Музей деревянного зодчества")
        )
    )

}


package com.stimmax.lessons.lesson08

// Создайте функцию, которая будет анализировать входящие фразы и применять к ним различные преобразования, делая текст более ироничным или забавным. Функция должна уметь распознавать ключевые слова или условия и соответственно изменять фразу.
fun task1(phrase: String): String {
    // стираем лишние пробелы по краям
    val trimmed = phrase.trim()

    return when {
        //  проверяем, состоит ли фраза только из одного слова
        trimmed.isNotEmpty() && !trimmed.contains(" ") ->
            "Иногда, $trimmed, но не всегда"

        // все остальные в любом порядке
        trimmed.startsWith("Я не уверен") ->
            "$trimmed, но моя интуиция говорит об обратном"

        trimmed.endsWith("без проблем") ->
            trimmed.replace("без проблем", "с парой интересных вызовов на пути")

        else -> {
            var result = trimmed
            if (result.contains("невозможно")) {
                result = result.replace("невозможно", "совершенно точно возможно, просто требует времени")
            }
            if (result.contains("катастрофа")) {
                result = result.replace("катастрофа", "интересное событие")
            }
            result
        }
    }
}

fun main() {

    println(task1("Это невозможно выполнить за один день"))
    println(task1("Я не уверен в успехе этого проекта"))
    println(task1("Произошла катастрофа на сервере"))
    println(task1("Этот код работает без проблем"))
    println(task1("Удача"))
}

// 2. Извлечение даты из строки лога
fun task2() {
    val log = "Пользователь вошел в систему -> 2021-12-01 09:48:23"

    val parts = log.split(" -> ")

    // делим  по пробелу на дату и время
    val dateTimeParts = parts[1].split(" ")
    val date = dateTimeParts[0]
    val time = dateTimeParts[1]

    println(date)
    println(time)
}

// 3. Дана строка с номером кредитной карты, например "4539 1488 0343 6467". Замаскируйте все цифры, кроме последних четырех, символами "*".
fun task3() {
    val card = "4539 1488 0343 6467"

    // стираем пробелы, чтобы остались только цифры
    val cleanCard = card.replace(" ", "")

    // берем последние 4 цифры
    val lastFour = cleanCard.takeLast(4)

    // повторяем звездочку столько раз, сколько символов мы спрятали
    val masked = "*".repeat(cleanCard.length - 4) + lastFour

    println(masked)
}

// 4. У вас есть электронный адрес, например "username@example.com". Преобразуйте его в строку "username [at] example [dot] com", используя функцию replace()

fun task4() {
    val email = "username@example.com"

    // заменяем сначала "@", а затем сразу "." в полученном результате
    val safeEmail = email
        .replace("@", " [at] ")
        .replace(".", " [dot] ")

    println(safeEmail)
}

//5. Дан путь к файлу, например "C:/Пользователи/Документы/report.txt" или "D:/good.themes/dracula.theme" (может быть любым). Извлеките название файла с расширением.

fun task5() {
    val path = "C:/Пользователи/Документы/report.txt"

    // делим строку по слэшу и берем последний элемент коллекции
    val fileName = path.split("/").last()

    println(fileName)
}

// 6. У вас есть фраза, например "Котлин лучший язык программирования" (может быть любой с разделителями слов - пробел). Создайте аббревиатуру из начальных букв слов

fun task6() {
    val phrase = "Котлин лучший язык программирования"

    var abbreviation = ""
    val words = phrase.split(" ")
    for (word in words) {
        if (word.isNotEmpty()) {
            abbreviation += word[0].uppercase()
        }
    }

    println(abbreviation)
}
package com.stimmax.lessons.lesson13.homeworks



fun main() {


    //1.Среднее время выполнения тестов

    val testTimes: Map<String, Double> = mapOf(
        "login" to 2.5,
        "search" to 1.2

    )

    val averageTime = testTimes.values.average()
    println("Среднее время выполнения: ${"%.2f".format(averageTime)} ")


    // 2. Список всех тестовых методов
    val testMetadata: Map<String, String> = mapOf(
        "testLogin" to "priority=high, author=Ann",
        "testRegister" to "priority=medium,author=Me"
    )

    val testMethods: Set<String> = testMetadata.keys
    println("Тестовые методы: $testMethods")


    // 3. Добавить новый тест в изменяемый словарь

    val mutableTestResults: MutableMap<String, String> = mutableMapOf(
        "testLogin" to "passed",
        "testRegister" to "failed",
        "testCheck" to "passed"
    )

    mutableTestResults.put("testPayment", "passed")
    println("Словарь : $mutableTestResults")


    // 4. Количество успешных тестов

    val testStatuses: Map<String, String> = mapOf(
        "testLogin" to "passed",
        "testRegister" to "failed",
        "testSearch" to "skipped"
    )

    val passedCount = testStatuses.count { it.value == "passed" }
    println("Количество успешных тестов: $passedCount")


    // 5. Удалить запись об исправленном баге

    val bugTracker: MutableMap<String, String> = mutableMapOf(
        "BUG1" to "open",
        "BUG2" to "fixed",
        "BUG3" to "open",
        "BUG4" to "fixed"
    )

    val fixedBug = "BUG2"
    bugTracker.remove(fixedBug)
    println("$fixedBug: $bugTracker")


    // 6. Сообщение о странице и статусе проверки

    val pageStatuses: Map<String, Int> = mapOf(
        "test.ru" to 200,
        "test.ru/about" to 200,
        "test.ru/old-page" to 404

    )

    pageStatuses.forEach { (url, status) ->
        println("Страница: $url Статус проверки: $status")
    }
    println()


    // 7 Сервисы с временем ответа выше порога

    val serviceResponseTimes: Map<String, Int> = mapOf(
        "AuthService" to 120,
        "PaymentService" to 850

    )

    val timeout = 500.0
    val slowServices = serviceResponseTimes.filterValues { it > timeout }
    println("Порог: $timeout мс")
    println("Слоупок сервисы: $slowServices")


    //8 Статус ответа для endpoint (если нет — не протестирован)

    val apiTestResults: Map<String, String> = mapOf(
        "/api/users" to "200 OK",
        "/api/products" to "404 Not Found"
    )

    val targetEndpoint = "/api/payments"
    val endpointStatus = apiTestResults.getOrDefault(targetEndpoint, "не был протестирован")
    println("Статус для '$targetEndpoint': $endpointStatus")


    // 9. Получить значение "browserType" — ответ не может быть null

    val testConfig1: Map<String, String> = mapOf(
        "browserType" to "Chrome",
        "timeout" to "30"
    )

    val browserType: String = testConfig1.getValue("browserType") // не вернёт null
    println("Browser Type: $browserType")


    // 10 Копия неизменяемого словаря с добавлением новой версии

    val softwareVersions: Map<String, String> = mapOf(
        "AppCore" to "2.0",
        "APIClient" to "3.0"
    )

    val updatedVersions: Map<String, String> = softwareVersions + ("DB" to "1.0")
    println("Исходный словарь:    $softwareVersions")
    println("Обновлённый словарь: $updatedVersions")


    // 11Настройки для модели или настройки по умолчанию

    val mobileSettings: Map<String, String> = mapOf(
        "Samsung" to "resolution=1080x2400",
        "iPhone " to "resolution=1170x2532"
    )

    val targetDevice = "Pixel "
    val deviceSettings = mobileSettings.getOrElse(targetDevice) {
        "resolution=1080x1920" // настройки по умолчанию
    }
    println("Настройки для '$targetDevice': $deviceSettings")


    // 12 Проверить наличие кода ошибки

    val testErrors: Map<String, String> = mapOf(
        "ERR1" to "NullPointerException",
        "ERR2" to "Timeout",
        "ERR3" to "Error:404"
    )

    val searchCode = "ERR2"
    val hasError = testErrors.containsKey(searchCode)
    println(" код '$searchCode': $hasError")


    // 13: Фильтрация тестов по версии в ключе ("TestID_Version")


    val testScenarios: Map<String, String> = mapOf(
        "TestID_2" to "Passed",
        "TestID_1" to "Failed"
    )

    val targetVersion = "_2"
    val filteredByVersion = testScenarios.filterKeys { it.contains(targetVersion) }
    println("Сценарии версии '$targetVersion': $filteredByVersion")


    // 14: Есть ли модули с неудачным тестированием


    val moduleTestResults: Map<String, String> = mapOf(
        "AuthModule" to "passed",
        "PaymentModule" to "failed"
    )

    val hasFailedModules = moduleTestResults.containsValue("failed")
    println("С неудачным тестированием: $hasFailedModules")


    // 15 Добавить настройки из другого словаря

    val testEnvironment: MutableMap<String, String> = mutableMapOf(
        "baseUrl" to "test.ru",
        "timeout" to "30"
    )
    val addSettings: Map<String, String> = mapOf(
        "retryCount" to "3",
        "logLevel" to "DEBUG",
        "screenFail" to "true"
    )

    testEnvironment.putAll(addSettings)


    //16: Объединить два неизменяемых словаря с багами

    val bugs1: Map<String, String> = mapOf(
        "B1" to "open",
        "B2" to "fixed"
    )
    val bugs2: Map<String, String> = mapOf(
        "B01" to "open",
        "B02" to "in progress",
        "B03" to "fixed"
    )

    val allBugs: Map<String, String> =
        (bugs1.entries + bugs2.entries)
            .associate { it.key to it.value }


    // 17. Очистить изменяемый словарь с временными данными


    val lastRunData: MutableMap<String, String> = mutableMapOf(
        "startTime" to "10:00",
        "endTime" to "10:15",
        "environment" to "stag"
    )

    lastRunData.clear()


    // 18  Исключить тесты со статусом "skipped" из отчёта

    val fullTestReport: Map<String, String> = mapOf(
        "testLogin" to "passed",
        "testRegister" to "skipped"
    )

    val reportWithoutSkipped = fullTestReport.filterNot { it.value == "skipped" }

    println(reportWithoutSkipped)


// 19 Копия конфигураций с удалением нескольких записей
    val testConfig: Map<String, String> = mapOf(
        "browserType" to "Chrome",
        "headless" to "true",
        "debugMode" to "true"
    )

    val cleanedConfig = testConfig - listOf(
        "debugMode", "headless")

        // 20. Отчёт — список строк "Test ID: результат"
 val testRes: Map<String, String> = mapOf(
    "Test 1" to "passed",
    "Test 2" to "failed",
    "Test 3" to "passed",
    "Test 4" to "skipped"
    )


    val report: List<String> = testRes.map { "${it.key}: ${it.value}" }

    report.forEach { println(it) }
    println()

    // 21 Преобразовать изменяемый словарь в неизменяемый

    val mutableLastRes: MutableMap<String, String> = mutableMapOf(
        "testLogin" to "passed",
        "testRegister" to "passed",
        "testCheckout" to "failed"
    )

    val archivedRes: Map<String, String> = mutableLastRes.toMap()


    // 22 Заменить числовые ID тестов на строковые

    val testsIds: Map<Int, String> = mapOf(
        1 to "один",
        2 to "два"
    )


    val testsWithStringIds: Map<String, String> =
        testsIds.mapKeys { it.key.toString() }

    println(testsWithStringIds) // Выведет: {"1"="один", "2"="два"}


    // Задача 23: Увеличить оценки производительности на 10%
    val performanceScores: Map<String, Double> = mapOf(
        "v1.0.0" to 250.0,
        "v1.1.0" to 230.0,
        "v2.0.0" to 180.0,
        "v2.1.0" to 175.0
    )


    val adjustedScores = performanceScores.mapValues { it.value * 1.1 }

    println(adjustedScores)


    // 24 Проверить, пуст ли словарь с ошибками компиляции


    val compilationErrors: Map<String, String> = emptyMap()

    if (compilationErrors.isEmpty()) {
        println("Ошибок  нет  успешно!")
    } else
        println("Обнаружены ошибки: $compilationErrors")




// 25 Убедиться, что словарь нагрузочного тестирования не пуст


val loadTestResults: Map<String, String> = mapOf(
    "sc1" to "passed",
    "sc2" to "passed",
    "sc3" to "failed"
)
if (loadTestResults.isNotEmpty()) println("Не пуст") else println("Пуст")



// 26 Проверить, прошли ли успешно все тесты

val allTestResults: Map<String, String> = mapOf(
    "testLogin" to "passed",
    "testRegister" to "passed",
    "testCheckout" to "passed"
)


val allPassed = allTestResults.all { it.value == "passed" }


// 27 Есть ли хотя бы один тест с ошибкой

val anydResults: Map<String, String> = mapOf(
    "testLogin" to "passed",
    "testRegister" to "failed",
    "testCheckout" to "passed"
)


val hasFailed = anydResults.any { it.value == "failed" }



// Задача 28: Неудачные тесты, содержащие "optional" в названии

val serviceTestResults: Map<String, String> = mapOf(
    "testPayment" to "passed",
    "testOptionalFeature" to "failed"
)

val failedOptionalTests = serviceTestResults.filter {
    it.value != "passed" && it.key.contains("optional", ignoreCase = true)
}
}

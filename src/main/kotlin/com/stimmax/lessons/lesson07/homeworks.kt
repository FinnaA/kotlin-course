package com.stimmax.lessons.lesson07

fun mainlesson07() {
//1. Напишите цикл for, который выводит числа от 1 до 5.
    for (i in 1..5) {
        println(i)
    }
//2. Напишите цикл for, который выводит четные числа от 1 до 10.
    for (i in 1..10) {
        if (i % 2 == 0)
            println(i)
    }

// 3. Создайте цикл for, который выводит числа от 5 до 1.
    for (i in 5 downTo 1) {
        println(i)
    }

// 3. Создайте цикл for, который выводит числа от 5 до 1.
    for (i in 5 downTo 1) {
        println(i)
    }

//4. Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
    for (i in 10 downTo 1 step 2) {
        println(i)
    }

// 5. Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
    for (i in 1..9 step 2) {
        println(i)
    }

// 6. Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
    for (i in 1..20 step 3) {
        println(i)
    }

// 7. Создайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
    val size: Int = 10
    for (i in 3 until size step 2) {
        println(i)
    }

// 8. Создайте цикл while, который выводит квадраты чисел от 1 до 5.
    var counter = 1
    while (counter <= 5) {
        println(counter * counter)
        counter++
    }


//9. Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
    var j = 10
    while (j > 5) {
        j--
    }
    println(j)

//10. Используйте цикл do while, чтобы вывести числа от 5 до 1.
    var k = 5
    do {
        println(k--)

    } while (k >= 1)

// 11. Создайте цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5.
    var l = 5
    do {
        println(l++)
    } while (l < 10)

// 12. Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.
    for (i in 1..10) {
        if (i == 6) break
        println(i)
    }

    println("Stop")

// 13. Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10.
    var m = 1
    while (true) {
        if (m == 10) break
        println(m)
        m++
    }
    println("Stop")


// 14. В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа.
    for (i in 1..10) {
        if (i % 2 == 0) continue
        println(i)
    }

// Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
    var i = 1

    while (i <= 10) {
        if (i % 3 != 0) {
            println(i)
        }
        i++
    }
}
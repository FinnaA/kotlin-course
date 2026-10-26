package com.stimmax.lessons.lesson15.homeworks

// Для каждого задания опиши в коде базовый класс с базовыми свойствами и если применимо - методами.

// Для производных классов также добавь специфичные для класса свойства. Детально описывать не нужно, упражнение на то, чтобы усвоить иерархию наследования и развитие функциональности у наследников.

// 1. Геометрические Фигуры
// --Базовый класс: Геометрическая Фигура
// ---Производные классы: Многоугольник, Круг
// ----Дополнительное разветвление для Многоугольник: Треугольник, Четырехугольник


open class GeometryFigures(
    val isSimetry: Boolean
) {
    open fun square() {
        println("Площадь фигуры")
    }
}

open class Circle(
    isSimetry: Boolean,
    val radius: Int
) : GeometryFigures(isSimetry)

open class Polygon(
    isSimetry: Boolean,
    val numberOfAngles: Int
) : GeometryFigures(isSimetry)

class Triangle(
    isSimetry: Boolean
) : Polygon(isSimetry, numberOfAngles = 3) {
    fun sumOfAngles() {
        println("Сумма углов")
    }
}

class Quadrilateral(
    isSimetry: Boolean,
    numberOfAngles: Int,
    val isRectangle: Boolean
) : Polygon(isSimetry, numberOfAngles) {
    fun perimetr() {
        println("Периметр")
    }
}

// 2. Учебные Заведения
// --Базовый класс: Учебное Заведение
// ---Производные классы: Школа, Университет
// ----Дополнительное разветвление для Университет: Аспирантура, Магистратура
// Базовый класс
open class EducationalInstitution(
    val name: String,
    val address: String
) {
    open fun openDoors() {
        println("Учебное заведение '$name' открыло свои двери для учащихся.")
    }
}

// Школа — прямой наследник Учебного Заведения
class School(
    name: String,
    address: String
) : EducationalInstitution(name, address) {

    fun conductLineup() {
        println("В школе линейка.")
    }
}

// Университет — прямой наследник Учебного Заведения
open class University(
    name: String,
    address: String,
    val numberOfFaculties: Int
) : EducationalInstitution(name, address) {

    fun conductSession() {
        println("Началась сессия.")
    }
}

// Магистратура — наследник Университета
class MagisterProgram(
    name: String,
    address: String,
    numberOfFaculties: Int,
    val scientificDirection: String
) : University(name, address, numberOfFaculties) {

    fun defendMasterThesis() {
        println("Студенты защищают диссертации.")
    }
}

// Аспирантура — наследник Университета
class PostgraduateProgram(
    name: String,
    address: String,
    numberOfFaculties: Int,
    val advisorName: String
) : University(name, address, numberOfFaculties) {

    fun publishArticle() {
        println("Аспирант публикует статью.")
    }
}


// 3. Иерархия Мебели
// --Базовый класс: Мебель
// ---Производные классы: Кухни, Гостинные
// ----Дополнительное разветвление для Кухни: Столы, Стулья
// Базовый класс для всей мебели
open class Furniture(
    val material: String,
    val price: Double
) {
    open fun assemble() {
        println("Мебель собирается по инструкции.")
    }
}

// Гостинные — прямой наследник Мебели
class LivingRoomFurniture(
    material: String,
    price: Double,
    val hasBacklight: Boolean
) : Furniture(material, price) {

    fun arrangeInRoom() {
        println("Мебель расставлена ")
    }
}

// Кухни — прямой наследник Мебели
open class KitchenFurniture(
    material: String,
    price: Double,
    val isWaterproof: Boolean
) : Furniture(material, price) {

    fun installSink() {
        println(" Устанавлиевается раковина.")
    }
}

// Столы — наследник Кухонной мебели
class KitchenTable(
    material: String,
    price: Double,
    isWaterproof: Boolean,
    val isExtendable: Boolean // Специфичное свойство: раздвижной ли стол
) : KitchenFurniture(material, price, isWaterproof) {

    fun extendTable() {
        if (isExtendable) {
            println("Стол разложен")
        } else {
            println("Этот стол не раскладывается.")
        }
    }
}

// Стулья — наследник Кухонной мебели
class KitchenChair(
    material: String,
    price: Double,
    isWaterproof: Boolean,
    val maxWeight: Int
) : KitchenFurniture(material, price, isWaterproof) {

    fun stack() {
        println("Стулья сложены ")
    }
}

// Это класс контейнера. Он абстрактный, это означает, что нельзя создавать экземлпяр этого класса, он нужен только для того, чтобы быть основой для подклассов.

// Создай подклассы этого контейнера, которые будут добавлять строку material (или коллекции или словари строк) в какое-то определённое место (места).

// Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)
// Второй класс должен получать список строк и вставлять их в начало контейнера но поочерёдно с теми данными, которые уже есть. То-есть, наш список должен появиться в контейнере по индексам 0, 2, 4 и так далее.
// Третий класс при добавлении строки должен отсортировать весь список метиралов в алфавитном порядке включая добавляемый материал.
// Четвёртый класс должен принимать словарь (ключи и значения строки). Каждая пара ключа и значения должна попадать в контейнер следующим образом - ключ в начало, значение в конец. Таким образом в начале должны быть ключи в обратном порядке, потом существующие материалы, потом все значения.

abstract class Materials {
    private val materials = mutableListOf<String>()
    fun addMaterial(material: String) {
        materials.add(material)
    }

    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }

    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}

class InsertFirstMaterial : Materials() {

    fun insert(item: String) {
        val materials = extractMaterials()
        addMaterial(item)
        materials.forEach {
            addMaterial(it)
        }
    }
}
// max
class InsertOneByOneMaterials : Materials() {

    fun insert(items: List<String>) {
        val materials = extractMaterials()
        val maxIndex = max(items.lastIndex, materials.lastIndex)
        for (i in 0..maxIndex) {
            if (i < items.size) {
                addMaterial(items[i])
            }
            if (i < materials.size) {
                addMaterial(materials[i])
            }
        }
    }
}

class InsertSortedMaterials : Materials() {

    fun insert(item: String) {
        val materials = (extractMaterials() + item).sorted()
        materials.forEach {
            addMaterial(it)
        }
    }
}

class InsertMapMaterials : Materials() {

    fun insert(items: Map<String, String>) {
        val materials = items.keys.reversed() + extractMaterials() + items.values
        materials.forEach {
            addMaterial(it)
        }
    }
}

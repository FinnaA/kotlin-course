package com.stimmax.lessons.lesson05.homeworks

fun mainlesson05() {


//задача про звук
    val soundBegin: Double = 100.0
    val coeff: Double? = 0.73 // может быть null
    val soundEnds = soundBegin * (coeff ?: 0.5)
    println(soundEnds)

//   задача про стоимость груза
    val shippingCost: Double = 100.00
    val cargoValue: Double? = null       // может быть null
    val insuranceCoeff: Double = 0.005
    val finalCargoValue = cargoValue ?: 50.0
    val insuranceCost = finalCargoValue * insuranceCoeff
    val fullCost = shippingCost + insuranceCost


//задача про давление
    val pressure: Int? = 100 // но может быть null
    val errorMessage: String = "Данные потеряны"
    val newPressure = pressure ?: errorMessage

}
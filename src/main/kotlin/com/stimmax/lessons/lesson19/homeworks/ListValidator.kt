package com.stimmax.lessons.lesson19.homeworks

class ListValidator<W : Number> : Validator<List<W?>> {
   
   override fun validate(element: List<W?>): Boolean {
       return element.all { it != null && it.toDouble() != 0.0 }
   }
}
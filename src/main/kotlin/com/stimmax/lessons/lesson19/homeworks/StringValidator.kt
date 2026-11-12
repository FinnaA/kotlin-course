package com.stimmax.lessons.lesson19.homeworks

class StringValidator : Validator<String?> {
   
   override fun validate(element: String?): Boolean {
       return element?.isNotBlank() ?: false
   }
}


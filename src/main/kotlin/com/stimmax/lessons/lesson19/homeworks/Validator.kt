package com.stimmax.lessons.lesson19.homeworks

interface Validator<T> {
   fun validate(element: T): Boolean
}
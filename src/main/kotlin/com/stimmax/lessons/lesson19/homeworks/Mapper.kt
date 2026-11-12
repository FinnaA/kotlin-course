package com.stimmax.lessons.lesson19.homeworks

interface Mapper<T, R> {
   fun map(element: T): R
   fun map(elements: List<T>): List<R>
}
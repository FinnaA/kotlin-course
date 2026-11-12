package com.stimmax.lessons.lesson19.homeworks

fun <I, D> transposition(map: Map<I, D>): Map<D, I> {
   return map.map { it }.associate { it.value to it.key }
}
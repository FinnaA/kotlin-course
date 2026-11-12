package com.stimmax.lessons.lesson19.homeworks

fun <M> getMiddleElement(list: List<M>): M? {
   if (list.size % 2 == 0) {
       return null
   }
   return list[list.size / 2]
}
package com.stimmax.lessons.lesson19.homeworks

class ListHolder<T> {
   
   private val list = mutableListOf<T>()
   
   fun add(element: T) {
       list.add(element)
   }
   
   fun get(): List<T> {
       return list.toList()
   }
}

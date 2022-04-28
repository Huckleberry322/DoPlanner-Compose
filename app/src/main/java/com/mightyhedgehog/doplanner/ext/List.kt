package com.mightyhedgehog.doplanner.ext

fun <T> MutableList<T>.findAndRemove(element: T): MutableList<T> {
    val index = this.indexOf(element)
    val newList = this.apply {
        removeAt(index)
    }
    return newList
}

package com.example.jetpackdemo.generateDirectorforsubtopic

fun main(){
    try {
        val a = 1
        val b = 0
        val c = a / b
        println("\n\nc = $c\n\n")
    } catch (e:Exception){
        println("stackTraceToString: "+e.stackTraceToString())
    }
}
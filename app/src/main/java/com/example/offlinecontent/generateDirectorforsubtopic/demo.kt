package com.example.offlinecontent.generateDirectorforsubtopic

import java.io.File

fun main() {

    var a = 0
    for (i in File("D:\\136683\\2\\1\\images").listFiles()!!) {
        if (i.extension.contains("jpeg")) {
            a += 1
            println(true)
        } else {
            println(false)
        }
    }

    println("No. of jpeg: $a")
}

//@RequiresApi(Build.VERSION_CODES.O)
/*
fun mainn() {

    val companies = Company(
        "Microsoft", 182268, listOf("California", "Washington", "Virginia")
    )

    val path = "D:\\2226481\\3\\2\\videoURL.json"
    try {
        File(path).bufferedWriter().use {
            val jsonString = Gson().toJson(companies)
            print(jsonString)
            it.write(jsonString)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }


    val a =1..4

    1 in a
}

class Company(
    var name: String,
    var employees: Int,
    var offices: List<String>
)*/

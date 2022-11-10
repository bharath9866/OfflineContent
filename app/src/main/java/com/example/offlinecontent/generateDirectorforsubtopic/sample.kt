package com.example.offlinecontent.generateDirectorforsubtopic

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.File
import java.io.IOException
import java.nio.file.FileAlreadyExistsException
import java.nio.file.NoSuchFileException
import java.text.SimpleDateFormat

@RequiresApi(Build.VERSION_CODES.O)
fun maisn() {
    try {
        val file = File("D:\\1111\\vi").listFiles()
        file.forEach {
            val src = File(it.absolutePath)
            val destinationName = src.name.toString().replace("videos","")
            if (!src.exists()) {
                throw NoSuchFileException("Source file doesn't exist")
            }

            val dest = File("D:\\1111\\videos\\$destinationName")
            if (dest.exists()) {
                throw FileAlreadyExistsException("Destination file already exist")
            }
            val success = src.renameTo(dest)
            src.delete()
            if (success) {
                println("Renaming succeeded")
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

@SuppressLint("SimpleDateFormat")
fun main(){
//    val dateAndTime = convertMilliToDateAndTimeFormat(null, "dd-MM-yyyy")
//    println(dateAndTime)

    println(list.indexOf(Demo(name = "English")))
}

@SuppressLint("SimpleDateFormat")
fun convertMilliToDateAndTimeFormat(
    milliseconds: Long?,
    format: String = "dd-MM-yyyy hh:mm aaa",
): String {
    return if (milliseconds == null || milliseconds == 0L)
        ""
    else String.format(SimpleDateFormat(format).format(milliseconds))
}

val list = arrayListOf(
    Demo(name = "All Subjects"),
    Demo(name = "Mathematics"),
    Demo(name = "Physics"),
    Demo(name = "Chemistry"),
    Demo(name = "Biology"),
    Demo(name = "Zoology"),
    Demo(name = "English"),

)

data class Demo(
    val id :Int = 0,
    val name:String = ""
)
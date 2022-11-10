package com.example.offlinecontent.generateDirectorforsubtopic


import android.os.Build
import androidx.annotation.RequiresApi
import java.io.File
import java.nio.file.Paths
import java.util.function.DoubleToLongFunction
import kotlin.io.path.fileSize


@RequiresApi(Build.VERSION_CODES.O)
fun main(){

//    val file = File("D:\\3486982")
//    println(bytesToKb(Paths.get("D:\\3486982\\2\\3\\getUserSubjectsPerExam.json").fileSize()))
//    println(kbToGb(bytesToKb(folderSize(file))))

    val src = "C:\\Users\\Lenovo\\Downloads\\BackUp\\IMPORTANT\\1654754761396.mp4"
    println(bytesToMb(Paths.get(src).fileSize()))

//    try {
//        val size = file.length()
//        println("The file size is ${bytesToKb(size)} bytes")
//    } catch (e: IOException) {
//        e.printStackTrace()
//    }

}

fun folderSize(directory: File): Long {
    var length: Long = 0
    if (directory.listFiles() != null) {
        for (file in directory.listFiles()) {
            length += if (file.isFile) file.length() else folderSize(file)
        }
    }
    return length
}

/**
 *
 * */
fun bytesToKb(bytes:Long): Long {
    val size_kb = bytes / 1024
    println("bytes: $bytes")
    println("Converted Size: $size_kb")
    return size_kb
}

fun bytesToMb(bytes:Long):Long{
    val size_kb = bytes/1024
    val size_mb = size_kb/1024
    return size_mb
}

fun mbToGb(mb:Long):Long{
    return (mb/1024)
}

fun kbToGb(kb:Long): Long {
    val size_mb = kb/1024
    val size_gb=size_mb/1024

    return size_gb
}


fun bytesToGb(bytes: Long): Long {
    val size_kb = bytes / 1024
    val size_mb = size_kb / 1024
    val size_gb = size_mb / 1024

    return size_gb
}
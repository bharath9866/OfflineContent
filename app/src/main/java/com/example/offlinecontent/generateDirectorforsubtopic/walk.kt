package com.example.jetpackdemo.generateDirectorforsubtopic

import android.os.Build
import androidx.annotation.RequiresApi
import java.nio.file.Files
import java.nio.file.Paths

@RequiresApi(Build.VERSION_CODES.O)
fun main(){
    var dir = "C:\\2268670\\7\\1\\2"

    var dirList:ArrayList<String> = arrayListOf()

    // Files.list(Paths.get(dir)).filter{ Files.isRegularFile(it) }

    Files.walk(Paths.get(dir).toRealPath())
        .filter {
            Files.isRegularFile(it)
        }
        .forEach {
            dirList.add(it.fileName.toString())
        }

    dirList.forEach { println(it) }

}
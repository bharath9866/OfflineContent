package com.example.offlinecontent.generateDirectorforsubtopic

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.IOException

/**
 * Java program to illustrate renaming and moving a file permanently to a new location
 * */
@RequiresApi(Build.VERSION_CODES.O)
@Throws(IOException::class)
fun main() {
    val dest = "D:\\MoveFiles\\2\\img2.txt"
    val src = "D:\\MoveFiles\\1\\img1.txt"

    fileCopy(src, dest)

}
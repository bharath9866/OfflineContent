package com.example.offlinecontent

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.offlinecontent.generateDirectorforsubtopic.fileCopy
import com.example.offlinecontent.generateDirectorforsubtopic.getVideos
import com.example.offlinecontent.generateDirectorforsubtopic.isFileExists
import com.example.offlinecontent.offlineContent.AESEnc
import com.example.offlinecontent.offlineContent.videoEncryption
import java.io.File

@RequiresApi(Build.VERSION_CODES.O)
fun main(){


//    val usersList = arrayListOf("ADM033")
//    usersList.forEachIndexed { index, user ->
//        uamRequest(user)?.apply {
////            getVideos("D", userDto?.userId?:0, gradeId = userDto?.grade?.gradeId?:0, examId = userDto?.exams?.get(0)?.examId?:0)
//            videoEncryption(
//                sourcePath = "F:\\${userDto?.userId?:0}\\${userDto?.grade?.gradeId?:0}\\${userDto?.exams?.get(0)?.examId?:0}\\decryptedVideos",
//                destinationPath = "F:\\${userDto?.userId?:0}\\${userDto?.grade?.gradeId?:0}\\${userDto?.exams?.get(0)?.examId?:0}\\videos"
//            )
//        }
//    }

    val key = AESEnc.generateKey("0123456789abcdef".toByteArray())
    val algorithm = "AES/CBC/PKCS5Padding"
    val ivParameterSpec = AESEnc.generateIv("fedcba9876543210".toByteArray())

    val src = "F:\\3585472\\3\\2\\decryptedVideos"
    val dest = "F:\\3585472\\3\\2\\videos"

    val list = File(src).listFiles()

    for(l in list){

        val name = l.name

        if(!isFileExists(File("${dest}${name}"))){
            val encryptedFile = File(dest + name)
            AESEnc.encryptFile(algorithm = algorithm, key = key,iv = ivParameterSpec, inputFile = l, outputFile = encryptedFile)

            println("File 1 FileDeleted(${name}):" + File(src + "\\" + name).delete())
        }else{
            println("File 1 FileDeleted(${name}):" + File(src + "\\" + name).delete())
        }
    }
}

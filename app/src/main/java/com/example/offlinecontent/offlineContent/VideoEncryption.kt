package com.example.offlinecontent.offlineContent

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.offlinecontent.generateDirectorforsubtopic.getImages
import com.example.offlinecontent.generateDirectorforsubtopic.getVideos
import com.example.offlinecontent.offlineContent.AESEnc.decryptFile
import com.example.offlinecontent.offlineContent.AESEnc.encryptFile
import com.example.offlinecontent.offlineContent.AESEnc.generateIv
import com.example.offlinecontent.offlineContent.AESEnc.generateKey
import com.example.offlinecontent.uamRequest
import java.io.File


@RequiresApi(Build.VERSION_CODES.O)
fun mainn(){

}

@RequiresApi(Build.VERSION_CODES.O)
fun main(){

    videoEncryption(sourcePath = "C:\\temp\\decryption", destinationPath = "C:\\temp\\encryption\\")

//    val usersList = arrayListOf("ADM001", "ADM002", "ADM003", "ADM004", "ADM005", "ADM006", "ADM010", "ADM011", "ADM014", "ADM017", "ADM018", "ADM019", "ADM022", "ADM023", "ADM024", "ADM025", "ADM026", "ADM027", "ADM033","ADM036", "ADM037", "ADM038", "ADM040", "ILTT7")
//
////    val usersList = arrayListOf("ADM002")
//    val totalImages: ArrayList<String> = arrayListOf()
//
//    usersList.forEachIndexed { index, user ->
//        uamRequest(user)?.apply {
//
//            getImages("C", userDto?.userId?:0, gradeId = userDto?.grade?.gradeId?:0, examId = userDto?.exams?.get(0)?.examId?:0, adm = user)
//
//            getVideos("C", userDto?.userId?:0, gradeId = userDto?.grade?.gradeId?:0, examId = userDto?.exams?.get(0)?.examId?:0)
////            videoEncryption(
////                sourcePath = "Y:\\${userDto?.userId?:0}\\${userDto?.grade?.gradeId?:0}\\${userDto?.exams?.get(0)?.examId?:0}\\decryptedVideos",
////                destinationPath = "Y:\\${userDto?.userId?:0}\\${userDto?.grade?.gradeId?:0}\\${userDto?.exams?.get(0)?.examId?:0}\\videos\\"
////            )
//
//        }
//    }
//
//    totalImages.distinct().forEach { println(it) }
}

/*
fun log10(n){
    return Math.round(100*Math.log(n)/Math.log(10))/100;
}
*/

fun maini(){
    val const = 100
    var values:Float = 200f

    repeat(100){
        print("${values}_${const} - ")

        println("${values/const}")

        values+=1

    }

    /*println(119.0.roundToInt())
    println(932/100*100+100)
    println(customRound(132))
    println(customRound(1302))
    println(customRound(13))
    println(customRound(180))
    println(customRound(199))*/
}

/*
1,2,3,4,5,6
*/

// function to round the number
fun customRound(n: Int): Int {
    val b = when(n.toString().length){
        2 -> 10
        3 -> 100
        4 -> 1000
        5 -> 10000
        6 -> 100000
        else -> 10
    }
    return ((n / b) * b) + b
}

@RequiresApi(Build.VERSION_CODES.O)
fun videoEncryption(sourcePath: String, destinationPath: String ) {
    try {
        //val sourcePath = "D:\\136683\\2\\2\\decryptedVideos"
        //val destinationPath = "D:\\136683\\2\\2\\videos\\"
        val key = generateKey("0123456789abcdef".toByteArray())
        val algorithm = "AES/CBC/PKCS5Padding"
        val ivParameterSpec = generateIv("fedcba9876543210".toByteArray())
        val directoryPath = File(sourcePath)
        val filesList = directoryPath.listFiles()
        for (file in filesList) {
            val filesList2 = file.listFiles()
            if (filesList2 != null) {
                for (file2 in filesList2) {
                    val filesList3 = file2.listFiles()
                    if (filesList3 != null) {
                        for (file3 in filesList3) {
                            val filesList4 = file3.listFiles()
                            if (filesList4 != null) {
                                for (file4 in filesList4) {
                                    val filesList5 = file4.listFiles()
                                    if (filesList5 != null) {
                                        for (file5 in filesList5) {
                                            val fileList6 = file5.listFiles()
                                            if (fileList6 != null) {
                                                for (file6 in fileList6) {
                                                    val fileList7 = file6.listFiles()
                                                    if (fileList7 != null) {
                                                    } else {
                                                        println("File name: " + file6.name)
                                                        println("File path: " + file6.absolutePath)
                                                        println("Size :" + file6.totalSpace)
                                                        println(" ")
                                                        val encryptedFile = File(destinationPath + file6.name)
                                                        encryptFile(
                                                            algorithm,
                                                            key,
                                                            ivParameterSpec,
                                                            file6,
                                                            encryptedFile
                                                        )
                                                        println(
                                                            "FileDeleted(${file6.name}):" + File(
                                                                sourcePath + "\\" + file6.name
                                                            ).delete()
                                                        )
                                                    }
                                                }
                                            } else {
                                                println("File name: " + file5.name)
                                                println("File path: " + file5.absolutePath)
                                                println("Size :" + file5.totalSpace)
                                                println(" ")
                                                val encryptedFile = File(destinationPath + file5.name)
                                                encryptFile(
                                                    algorithm,
                                                    key,
                                                    ivParameterSpec,
                                                    file5,
                                                    encryptedFile
                                                )
                                                println("FileDeleted(${file5.name}):" + File(sourcePath + "\\" + file5.name).delete())
                                            }
                                        }
                                    } else {
                                        println("File name: " + file4.name)
                                        println("File path: " + file4.absolutePath)
                                        println("Size :" + file4.totalSpace)
                                        println(" ")
                                        val encryptedFile = File(destinationPath + file4.name)
                                        encryptFile(
                                            algorithm,
                                            key,
                                            ivParameterSpec,
                                            file4,
                                            encryptedFile
                                        )
                                        println("FileDeleted(${file4.name}):" + File(sourcePath + "\\" + file4.name).delete())
                                    }
                                }
                            } else {
                                println("File name: " + file3.name)
                                println("File path: " + file3.absolutePath)
                                println("Size :" + file3.totalSpace)
                                println(" ")
                                val encryptedFile = File(destinationPath + file3.name)
                                encryptFile(
                                    algorithm,
                                    key,
                                    ivParameterSpec,
                                    file3,
                                    encryptedFile
                                )
                                println("FileDeleted(${file3.name}):" + File(sourcePath + "\\" + file3.name).delete())
                            }
                        }
                    } else {
                        println("File name: " + file2.name)
                        println("File path: " + file2.absolutePath)
                        println("Size :" + file2.totalSpace)
                        println(" ")
                        val encryptedFile = File(destinationPath + file2.name)
                        encryptFile(
                            algorithm,
                            key,
                            ivParameterSpec,
                            file2,
                            encryptedFile
                        )
                        println("FileDeleted(${file2.name}):" + File(sourcePath + "\\" + file2.name).delete())
                    }
                }
            } else {
                println("File name: " + file.name)
                println("File path: " + file.absolutePath)
                println("Size :" + file.totalSpace)
                val encryptedFile = File(destinationPath + file.name)
                encryptFile(algorithm, key, ivParameterSpec, file, encryptedFile)
//                decryptFile(algorithm, key, ivParameterSpec, file, encryptedFile)
                println("File 1 FileDeleted(${file.name}):" + File(sourcePath + "\\" + file.name))
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}


//        File inputFile = Paths.get("src/1.01_Prerequisites.mp4")
//                .toFile();
//        File encryptedFile = new File("1.01_Prerequisites_enc.mp4");
//
//            File inputFile2 = Paths.get("src/1.02 Learning Objectives.mp4")
//                    .toFile();
//            File encryptedFile2 = new File("1.02 Learning Objectives_enc.mp4");
//
//            File inputFile3 = Paths.get("src/1.05 Diversity In The Living World.mp4")
//                    .toFile();
//            File encryptedFile3 = new File("1.05 Diversity In The Living World_enc.mp4");
//
//        AESEnc.encryptFile(algorithm, key, ivParameterSpec, inputFile, encryptedFile);
//        AESEnc.encryptFile(algorithm, key, ivParameterSpec, inputFile2, encryptedFile2);
//        AESEnc.encryptFile(algorithm, key, ivParameterSpec, inputFile3, encryptedFile3);


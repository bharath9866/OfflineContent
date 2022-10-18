package com.example.offlinecontent.offlineContent

import com.example.offlinecontent.offlineContent.AESEnc.encryptFile
import com.example.offlinecontent.offlineContent.AESEnc.generateIv
import com.example.offlinecontent.offlineContent.AESEnc.generateKey
import java.io.File


fun main(){
    videoEncryption("D:\\3486982\\2\\3\\decryptedVideos", "D:\\3486982\\2\\3\\video\\")
}

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
//                                                        println(
//                                                            "FileDeleted(${file6.name}):" + File(
//                                                                sourcePath + "\\" + file6.name
//                                                            ).delete()
//                                                        )
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
//                                                println("FileDeleted(${file5.name}):" + File(sourcePath + "\\" + file5.name).delete())
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
//                                        println("FileDeleted(${file4.name}):" + File(sourcePath + "\\" + file4.name).delete())
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
//                                println("FileDeleted(${file3.name}):" + File(sourcePath + "\\" + file3.name).delete())
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
//                        println("FileDeleted(${file2.name}):" + File(sourcePath + "\\" + file2.name).delete())
                    }
                }
            } else {
                println("File name: " + file.name)
                println("File path: " + file.absolutePath)
                println("Size :" + file.totalSpace)
                println(" ")
                val encryptedFile = File(destinationPath + file.name)
                encryptFile(algorithm, key, ivParameterSpec, file, encryptedFile)
//                println("File 1 FileDeleted(${file.name}):" + File(sourcePath + "\\" + file.name).delete())
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


package com.example.jetpackdemo.generateDirectorforsubtopic

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.File
import java.nio.file.Paths


// getting list of videos from videoURL.txt list
@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val dir = "D"
    val userId = 2226481
    val gradeId = 3
    val examId = 1
    val subjectId = 5
    val chapterId = 129
    val topicId = 504
    val subTopicId = 5057

    val listNos : ArrayList<String> = arrayListOf()

    var s3Location = "Z:\\il-cms-assets-local\\media\\"
    //val fromChaptersVideoURLPath = "${dir}:\\${userId}\\${gradeId}\\${examId}\\${subjectId}\\${chapterId}\\videoURL.txt"

    val examPath = "${dir}:\\${userId}\\${gradeId}\\${examId}"

    val path = File(examPath)

    val subjects = path.listFiles()
    var duplicateFile = 0

    if(subjects!=null) {
        for (subject in subjects) {
            val chapters = subject.listFiles()
            if (chapters != null) {
                for (chapter in chapters) {
                    val topics = chapter.listFiles()
                    if (topics != null) {
                        for (topic in topics) {
                            if (topic.name == "videoURL.txt") {
                                File(topic.absolutePath).inputStream().bufferedReader().use { element ->
                                    val temp = element.readLine().split(",")

                                    // Checking is there any file exist or not
                                    /*for(ele in temp){
                                        val src = "Z:\\il-cms-assets-local\\media\\$ele" // it's like s3 Database
                                        if(isFileExists(File(src))){
                                            println(ele)
                                        }
                                    }*/

                                    // checking for non-mp4 videos
                                    for(ele in temp) {
                                        val src = "Z:\\il-cms-assets-local\\media\\$ele" // it's like s3 Database

                                        val dest = "${dir}:\\${userId}\\${gradeId}\\${examId}\\decryptedVideos"
                                        if (!File(dest).exists()) {
                                            createDirectory(Paths.get(dest))
                                        }

                                        if (isFileExists(File(src))) {
                                            duplicateFile += fileCopy(src, dest + "\\$ele")
                                            listNos.add(ele)
                                            // Printing Non-MP4 Videos
                                        } else {
                                            File("${dir}:\\${userId}\\${gradeId}\\${examId}\\videoNotExist.txt").appendText(ele + "\n")
                                            print("Video NotExist:: S: ${subject.name}, C: ${chapter.name}, T: ${topic.name}, ${File(src).name}")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    // Printing Non-MP4 Files in a Text File
    File("${dir}:\\Content\\content\\${gradeId}\\${examId}\\nonMp4.txt").delete()
    listNos.distinct().forEach { element ->
        if (!element.contains(".mp4", true)) {
            File("${dir}:\\${userId}\\${gradeId}\\${examId}\\nonMp4.txt").appendText(element + "\n")
        }
    }

    println("Total No.Of Videos in a List: "+listNos.distinct().count())

    print("\n\nTotal No. Of duplicate files are there in a list: $duplicateFile\n")
}

fun findingVideoNumbers(){

    val subjects= File("D:\\2226481\\3\\2").listFiles()

    if(!subjects.isNullOrEmpty()) {
        for (chapter in subjects) {
            val topics = chapter.listFiles()
            if (!topics.isNullOrEmpty()) {
                for (topic in topics) {
                    val files = topic.listFiles()
                    if(files!=null) {
                        for (file in files) {
                            if (file.name.contains("videoURL.txt")) {

                                File(file.absolutePath).inputStream().bufferedReader().use { element ->
                                    val temp = element.readLine().split(",")
                                    for (ele in temp) {
                                        println("S: ${chapter.name}, C: ${topic.name}, T: ${file.name}, FileName: $ele")
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }

}
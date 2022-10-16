package com.example.jetpackdemo.generateDirectorforsubtopic

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.jetpackdemo.generateDirectorforsubtopic.modal.getUserSubjectsPerExam.GetUserSubjectsPerExam
import com.example.offlinecontent.generateDirectorforsubtopic.bytesToMb
import com.example.offlinecontent.generateDirectorforsubtopic.createDirectory
import com.example.offlinecontent.generateDirectorforsubtopic.mbToGb
import com.google.gson.Gson
import java.io.File
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.fileSize

@RequiresApi(Build.VERSION_CODES.O)
fun main(){
    //getSubjectImages("D", 136683, 7, 1)
    //images("D", 136683, 2, 2)
    //images("D", 136683, 7, 1)
    getVideos("D", 3486982, 2, 3)
}


/**
 * Parameter - usage have to constants
 * 1. download : which is used to download the content from s3 bucket
 * 2. getSizeOfTheContent: which is used to get the size of all videos without downloading content
 */
@RequiresApi(Build.VERSION_CODES.O)
fun getVideos(dir:String, userId: Int, gradeId: Int, examId:Int, usage:String = "getSizeOfTheContent") {

    val listNos : ArrayList<String> = arrayListOf()

    val examPath = "${dir}:\\${userId}\\${gradeId}\\${examId}"

    val path = File(examPath)

    val subjects = path.listFiles()
    var duplicateFile = 0

    var sizeOfTheContent:Long = 0L

    if(File("${dir}:\\${userId}\\${gradeId}\\${examId}\\nonMp4.txt").exists()){
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\nonMp4.txt").delete()
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\nonMp4.txt").createNewFile()
    } else {
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\nonMp4.txt").createNewFile()
    }


    if(File("${dir}:\\${userId}\\${gradeId}\\${examId}\\videoNotExist.txt").exists()){
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\videoNotExist.txt").delete()
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\videoNotExist.txt").createNewFile()
    } else {
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\videoNotExist.txt").createNewFile()
    }

    if(subjects!=null) {
        for (subject in subjects) {
            val chapters = subject.listFiles()
            if (chapters != null) {
                for (chapter in chapters) {
                    val topics = chapter.listFiles()
                    if (topics != null) {
                        for (topic in topics) {
                            if(topic!=null) {
                                if (topic.name == "videoURL.txt") {

                                    File(topic.absolutePath).inputStream().bufferedReader()
                                        .use { element ->
                                            try {
                                                val temp = element.readLine().split(",")

                                                // checking for non-mp4 videos
                                                temp.forEachIndexed{ i: Int, ele: String ->

                                                    val src = "Z:\\il-cms-assets-local\\media\\$ele" // it's like s3 Database


                                                        if (isFileExists(File(src))) {


                                                                val encryptedPath = "${dir}:\\${userId}\\${gradeId}\\${examId}\\videos"

                                                                if(!File(encryptedPath).exists()){

                                                                    createDirectory(Paths.get(encryptedPath))

                                                                }

                                                            if (usage.contains("download")) {

                                                                try {
                                                                    if(isFileExists(File(encryptedPath+"\\$ele"))) {
                                                                        println("$ele file is already Encrypted")

                                                                    } else {

                                                                        if(File(src).extension.contains("mp4")) {
    //                                                                        val decryptedVideosPath = "$chapter\\videos"

                                                                            print("S: ${subject.name}, C: ${chapter.name}, T: ${topic.name}, ${File(src).name}, ")

                                                                            val decryptedVideosPath = "${dir}:\\${userId}\\${gradeId}\\${examId}\\decryptedVideos"

                                                                            if (!File(decryptedVideosPath).exists()) {
                                                                                createDirectory(Paths.get(decryptedVideosPath))
                                                                            }

                                                                                duplicateFile += fileCopy(src,decryptedVideosPath + "\\$ele")

                                                                        } else {

                                                                            File("${dir}:\\${userId}\\${gradeId}\\${examId}\\nonMp4.txt").appendText(File(src).name+  "\n")

                                                                        }

                                                                        listNos.add(ele)

                                                                    }

                                                                } catch (e: Exception) {
                                                                    println(e)
    //                                                                duplicateFile += fileCopy(src, decryptedVideosPath + "\\$ele")
    //                                                                listNos.add(ele)
                                                                }

                                                            // Printing Non-MP4 Videos
                                                            }
                                                            else if (usage.contains("getSizeOfTheContent")) {

                                                                sizeOfTheContent += bytesToMb(Paths.get(src).fileSize())

                                                            }
                                                        } else {
                                                            File("${dir}:\\${userId}\\${gradeId}\\${examId}\\videoNotExist.txt").appendText(ele + "\n")
                                                            print("Video NotExist:: S: ${subject.name}, C: ${chapter.name}, T: ${topic.name}, ")
                                                            println(File(src).name)
                                                        }


                                                    }


                                            } catch (e: Exception){
                                                println(e.stackTraceToString())
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
    listNos.distinct().forEach { element ->
        if (!element.contains(".mp4", true)) {
            //File("${dir}:\\${userId}\\${gradeId}\\${examId}\\nonMp4.txt").writeText("")
            File("${dir}:\\${userId}\\${gradeId}\\${examId}\\nonMp4.txt").appendText(element + "\n")
        }
    }

    println("Total No.Of Videos in a List: " + listNos.distinct().count())
    print("dir: ${dir}, userId: ${userId}, gradeId: ${gradeId}, examdId: $examId -- ")
    println("Size of the Content: " + mbToGb(sizeOfTheContent))

//    println("\n\nTotal No. Of duplicate files are there in a list: $duplicateFile\n")

    /*val videosPath = "${dir}:\\${userId}\\${gradeId}\\${examId}\\videos"
    if (!File(videosPath).exists()) {
        createDirectory(Paths.get(videosPath))
    }*/

//    videoEncryption(sourcePath = "${examPath}\\decryptedVideos", destinationPath = "${videosPath}\\")
}

@RequiresApi(Build.VERSION_CODES.O)
fun getThumbnailImages(dir:String, userId: Int, gradeId: Int, examId:Int) {

    val listNos : ArrayList<String> = arrayListOf()

    val examPath = "${dir}:\\${userId}\\${gradeId}\\${examId}"

    val path = File(examPath)

    val subjects = path.listFiles()
    var duplicateFile = 0

    if(File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotSupported.txt").exists()){
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotSupported.txt").delete()
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotSupported.txt").createNewFile()
    } else {
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotSupported.txt").createNewFile()
    }


    if(File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotExist.txt").exists()){
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotExist.txt").delete()
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotExist.txt").createNewFile()
    } else {
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotExist.txt").createNewFile()
    }

    if(subjects!=null) {
        for (subject in subjects) {
            val chapters = subject.listFiles()
            if (chapters != null) {
                for (chapter in chapters) {
                    val topics = chapter.listFiles()
                    if (topics != null) {
                        for (topic in topics) {
                            if(topic!=null) {
                                if (topic.name == "Thumbnail.txt") {

                                    File(topic.absolutePath).inputStream().bufferedReader()
                                        .use { element ->
                                            try {
                                                val temp = element.readLine().split(",")

                                                // checking for non-mp4 videos
                                                for (ele in temp) {


                                                    val src = "Z:\\il-cms-assets-local\\media\\$ele" // it's like s3 Database

                                                    val decryptedVideosPath = "${dir}:\\${userId}\\${gradeId}\\${examId}\\thumbnails"
                                                    if (!File(decryptedVideosPath).exists()) {
                                                        createDirectory(Paths.get(decryptedVideosPath))
                                                    }



                                                    if (isFileExists(File(src))) {

                                                        print("S: ${subject.name}, C: ${chapter.name}, T: ${topic.name}, ${File(src).name}, ")

                                                        try {

                                                            if(File(src).extension.contains("mp4")) {

                                                                duplicateFile += fileCopy(src,decryptedVideosPath + "\\$ele")

                                                            } else {
                                                                File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotSupported.txt").appendText(File(src).name+  "\n")
                                                            }

                                                            listNos.add(ele)

                                                        } catch (e: Exception) {
                                                            duplicateFile += fileCopy(src, decryptedVideosPath + "\\$ele")
                                                            listNos.add(ele)
                                                        }


                                                        // Printing Non-MP4 Videos
                                                    } else {

                                                        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotExist.txt").appendText(ele + "\n")
                                                        print("Thumbnail NotExist:: S: ${subject.name}, C: ${chapter.name}, T: ${topic.name}, ")
                                                        println(File(src).name)
                                                    }

                                                }
                                            } catch (e: Exception){
                                                println(e.stackTraceToString())
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


    /*// Printing Non-MP4 Files in a Text File
    listNos.distinct().forEach { element ->
        if (!element.contains(".mp4", true)) {
            //File("${dir}:\\${userId}\\${gradeId}\\${examId}\\nonMp4.txt").writeText("")
            File("${dir}:\\${userId}\\${gradeId}\\${examId}\\nonMp4.txt").appendText(element + "\n")
        }
    }*/

    println("Total No.Of Videos in a List: " + listNos.distinct().count())

//    println("\n\nTotal No. Of duplicate files are there in a list: $duplicateFile\n")

    /*val videosPath = "${dir}:\\${userId}\\${gradeId}\\${examId}\\videos"
    if (!File(videosPath).exists()) {
        createDirectory(Paths.get(videosPath))
    }*/

//    videoEncryption(sourcePath = "${examPath}\\decryptedVideos", destinationPath = "${videosPath}\\")
}

// take ids from image.txt and store that id based images.jpg to another destination
@RequiresApi(Build.VERSION_CODES.O)
fun getImages(dir:String, userId: Int, gradeId: Int, examId:Int) {
//    val dir = dir
//    val userId = userId
//    val gradeId = gradeId
//    val examId = examId


    // HAVE TO CHANGE DESTINATION PATH

    // D:\2226481\3\2\1\99\1071\2416
    val path = "${dir}:\\${userId}\\${gradeId}\\${examId}"

    if(File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotSupported.txt").exists()){
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotSupported.txt").delete()
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotSupported.txt").createNewFile()
    } else {
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotSupported.txt").createNewFile()
    }

    if (File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotExist.txt").exists()) {
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotExist.txt").delete()
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotExist.txt").createNewFile()
    } else {
        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotExist.txt").createNewFile()
    }

    val subjects = File(path).listFiles()

    val totalImages: ArrayList<String> = arrayListOf()

    if (subjects != null) {
        for (subject in subjects) {
            // TODO: Get Subject Images
            if(subject.name == "getUserSubjectsPerExam.json"){
                val imageNumList = getSubjectImages(dir, userId, gradeId, examId)
                val temp = arrayListOf<String>()

                imageNumList?.forEach {
                    temp.add(it.split("?")[0].replace("https://il-cms-assets.s3.ap-south-1.amazonaws.com/media/", ""))
                }

                temp.forEach {

                    val src = "Z:\\il-cms-assets-local\\media\\$it"
                    val dest = "${dir}:\\${userId}\\${gradeId}\\${examId}\\images\\"

                    if (!File("${dir}:\\${userId}\\${gradeId}\\${examId}\\images").exists()) {
                        createDirectory(Paths.get("${dir}:\\${userId}\\${gradeId}\\${examId}\\images"))
                    }



                    if (isFileExists(File(src))) {

                        if (fileCopy(src, dest + it) == 1) {
                            totalImages.add(File("${dir}:\\${userId}\\${gradeId}\\${examId}\\images\\$it").name)
                        }

                    } else {


                        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotExist.txt").appendText(it + "\n")

                        print("Image NotExist:: ${File(src).name}")

                    }

                }
            }

            // TODO: Get Remaining Images from All Subjects
            val chapters = subject.listFiles()
            if (chapters != null) {
                for (chapter in chapters) {
                    val topics = chapter.listFiles()
                    if (topics != null) {
                        for (topic in topics) {
                            val subtopics = topic.listFiles()
                            if (subtopics != null) {
                                for (subtopic in subtopics) {
                                    val flashcards = subtopic.listFiles()
                                    if (flashcards != null) {
                                        for (flashcard in flashcards) {
                                            if (flashcard.name == "image.txt") {

                                                val imageList =
                                                    getImageNumList(flashcard.absolutePath)
                                                val temp = arrayListOf<String>()

                                                imageList?.forEach {
                                                    temp.addAll(it.split(","))
                                                }

                                                temp.forEach {

                                                    val src = "Z:\\il-cms-assets-local\\media\\$it"
                                                    val dest = "${dir}:\\${userId}\\${gradeId}\\${examId}\\images\\"

                                                    if (!File("${dir}:\\${userId}\\${gradeId}\\${examId}\\images").exists()) {
                                                        createDirectory(Paths.get("${dir}:\\${userId}\\${gradeId}\\${examId}\\images"))
                                                    }



                                                    if (isFileExists(File(src))) {

                                                        print("S: ${subject.name}, C: ${chapter.name}, T: ${topic.name}, ST: ${subtopic.name}, ")

                                                        if(File(src).extension.contains("jpg", ignoreCase = true) || File(src).extension.contains("png", ignoreCase = true) || File(src).extension.contains("jpeg", ignoreCase = true)) {

                                                            if (fileCopy(src, dest + it) == 1) {

                                                                totalImages.add(File("${dir}:\\${userId}\\${gradeId}\\${examId}\\images\\$it").name)

                                                            }

                                                        } else {

                                                            File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotSupported.txt").appendText(File(src).name +  "\n")

                                                        }

                                                    } else {

                                                        File("${dir}:\\${userId}\\${gradeId}\\${examId}\\imageNotExist.txt").appendText(
                                                            it + "\n"
                                                        )
                                                        print("Image NotExist:: S: ${subject.name}, C: ${chapter.name}, T: ${topic.name}, ")
                                                        print(File(src).name)

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
            }
        }
    }


    println("Total Number of Images in ExamId[$examId]: ${totalImages.distinct().count()}")
}

fun getSubjectImages(dir:String, userId: Int, gradeId: Int, examId:Int): ArrayList<String>? {

    val paths = File("${dir}:\\${userId}\\${gradeId}\\${examId}").listFiles()

    val imageNumList: ArrayList<String>? = arrayListOf()

    if(paths!=null){
        for(path in paths){
            if(path.name == "getUserSubjectsPerExam.json") {
                val inputStream:InputStream = File(path.absolutePath).inputStream()

                val lineList = mutableListOf<String>()

                inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }

                var response = ""

                lineList.forEach { response += "\n" + it }

                val modalImage = Gson().fromJson(response, GetUserSubjectsPerExam::class.java).data?.subjectNode

                if(modalImage!=null){
                    for(i in 0 until modalImage.size){
                        modalImage[i].icon?.let { imageNumList?.add(it) }
                    }
                }
            }
        }
    }

    return imageNumList

}


fun main1(){
    val results: MutableList<String> = ArrayList()

    val path = File("Z:\\il-cms-assets-local\\media")

    val files: ArrayList<File> = path.listFiles() as ArrayList<File>

    //If this pathname does not denote a directory, then listFiles() returns null.

    for (file in files) {
        if (file.isFile) {
            results.add(file.name)
            print(results.lastIndex)
        }
    }

    print(results)
}


// Pending Videos from Z: Drive
@RequiresApi(Build.VERSION_CODES.O)
fun main11(){
    var inputStream: InputStream = File("D:\\videosURLs\\NotExist.txt").inputStream()

    val linelist =ArrayList<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { linelist.add(it) } }

    var duplicateFile = 0

    linelist.forEach {
        val src = "Z:\\il-cms-assets-local\\media\\$it"
        val dest = "D:\\videosURLs\\2226481\\pendingVideos\\"

        if(isFileExists(File(src))){
            duplicateFile += fileCopy(src, dest+it)
        } else {
            println(File(src).name)
        }
    }
    print("\n\nTotal No. Of duplicate files are there in a list: $duplicateFile\n")
}


@RequiresApi(Build.VERSION_CODES.O)
fun imageNotExist(){
    val list = arrayListOf("1645178743147.png", "1645178767835.png", "1645178729231.png")
    var imageNotExist = 0
    list.forEach {
        if(isFileExists(File("Z:\\il-cms-assets-local\\media\\$it"))){
            fileCopy("Z:\\il-cms-assets-local\\media\\$it", "D:\\2226481\\3\\1\\images\\$it")
        } else {
            imageNotExist += 1
            println("NotExist: $imageNotExist")
        }
    }
    println("Total No.Of Images NotExist: $imageNotExist")
}

@RequiresApi(Build.VERSION_CODES.O)
fun notExistingVideoes(){
    val videoNotExist:ArrayList<String> = arrayListOf()

    File("D:\\2226481\\3\\1\\videoNotExist.txt").inputStream().bufferedReader().useLines {
        lines -> lines.forEach {
            videoNotExist.add(it)
        }
    }

    var notexist = 0

    videoNotExist.forEach {
        if (isFileExists(File("Z:\\il-cms-assets-local\\media\\$it"))) {
            fileCopy("Z:\\il-cms-assets-local\\media\\$it", "D:\\2226481\\3\\1\\decryptedVideos\\$it")
        }  else {
            notexist += 1
            println("NotExist: $notexist")
        }
    }

    println(notexist)


 /*?.forEach {
        presentVideoList.add(it.name)
        File("D:\\2226481\\3\\1\\temp.txt").appendText(it.name+"\n")
    }*/



   /* list.forEach {
        val src = "Z:\\il-cms-assets-local\\media\\$it"
        val dest = "D:\\2226481\\3\\1\\decryptedVideos\\$it"

        if(isFileExists(File(src))){
            fileCopy(src, dest)
        } else {
            println(File(src).name)
        }
    }*/

    /*val list = arrayListOf("1645178743147.png", "1645178729231.png", "1645178767835.png")
    list.forEach {
        val src = "Z:\\il-cms-assets-local\\media\\$it"
        val dest = "D:\\2226481\\3\\3\\images\\$it"
        fileCopy(src, dest)
    }*/
}

fun mainn(){
    var src = File("D:\\videosURLs\\2226481\\rescue")
    val fileLists = src.listFiles()
    var temp = 0
    for(fileList in fileLists){
        println(fileList.absolutePath + " $temp")
    }

}


// Checking how many non-Mp4 files
fun main2(){
    var str = ".mp4"
}


fun maintemp(){
    val local = File("D:\\2226481\\3\\1\\decryptedVideos").listFiles()
    /*for(file in local){
        println(file)
    }*/

    val exam = File("D:\\2226481\\3\\1").listFiles()
    for(subject in exam){
        val chapter = subject.listFiles()
        if(chapter!= null){
            for(topic in chapter){
                val files = topic.listFiles()
                if (files != null) {
                    for (file in files) {
                        if (file.name == "videoURL.txt") {
                            File(file.absolutePath).inputStream().bufferedReader().use {
                                val temp = it.readLine().split(",")
                                for(i in temp){
                                    println(i)
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    /*val file = File("Z:\\il-cms-assets-local\\media").listFiles()
    file.forEach {
        println(it.extension)
    }*/
}

// Comparing videolist names
fun findDuplicateVideos(){
    val videoDir = File("C:\\Content\\content\\videos")
    val videos = videoDir.listFiles()

    val videoDirList : ArrayList<String> = arrayListOf()
    for( video in videos){
        videoDirList.add(video.name)
    }

}

/**
 * It copy Single File from one [src] Dir to [dest] Dir
 * */
@RequiresApi(Build.VERSION_CODES.O)
fun fileCopy(src: String, dest: String): Int{
    val src1 = Paths.get(src)
    val dest1 = Paths.get(dest)
    var duplicateFile = 0

    try {

        if (!File(dest).exists()) {
            val output = Files.copy(src1, dest1)
            if (output != null) {
                println("File Copied successfully from $src to $dest")
            } else {
                println("File Not Copied Successfully")
            }
        } else {
            duplicateFile = 1
            println("File Exist already on Destination of $dest")
        }

    } catch (e: Exception) {
        print(e.stackTraceToString())
    }

    return duplicateFile
}


// Checking Subfolder in Z: Drive
@RequiresApi(Build.VERSION_CODES.O)
fun main3() {


    var subDirOne = "Z:\\il-cms-assets-local\\media\\story-1-1\\"
    var subDirTwo = "Z:\\il-cms-assets-local\\media\\web-1\\"
    var subDirThree = "Z:\\il-cms-assets-local\\media\\web-2\\"
    var subDirFour = "Z:\\il-cms-assets-local\\media\\web-3\\"

    //Files.copy(Paths.get(subDirFour+"1654849534100.mp4"), Paths.get("C:\\temp"))


    val inputStream: InputStream = File("D:\\videosURLs\\NotExist.txt").inputStream()

    // println(inputStream)

    val lineList = mutableListOf<String>()

    var nums: ArrayList<String>? = arrayListOf()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }

    lineList.forEach {
        if (isFileExists(File(subDirFour + it))) {
            println("Exist: $it")
        } else {
            println("Not Exist: $it")
        }
    }
}

fun checkVideoOrImageExist(){
    if (isFileExists(File("Z:\\il-cms-assets-local\\media\\1643295014960.mp4"))){
        print("Exist")
    } else{
        print("Not Exist")
    }
}

/*@RequiresApi(Build.VERSION_CODES.O)
fun main(){
    val src = "This PC\\Lenovo Tab M8\\SanDisk SD card\\Content\\content\\videos"
    val dest = "F:\\Content\\content\\videos"
    var files = File(src).listFiles()
    for(file in files){
        // fileCopy(file.absolutePath, dest)
        println(file)
    }
}*/





private fun getImageNumList(pathname: String):ArrayList<String>? {
    val inputStream:InputStream = File(pathname).inputStream()

    val lineList = ArrayList<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach{ lineList.add(it)} }

    return lineList
}

fun <T> hasDuplicates(arr: Array<T>): Boolean {
    return arr.size != arr.distinct().count();
}

fun isFileExists(file: File): Boolean {
    return file.exists() && !file.isDirectory
}
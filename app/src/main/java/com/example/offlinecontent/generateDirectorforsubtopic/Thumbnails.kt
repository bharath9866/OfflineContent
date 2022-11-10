package com.example.offlinecontent.generateDirectorforsubtopic

import com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandvideos.TopicsAndVideos
import com.google.gson.Gson
import java.io.File
import java.io.InputStream

fun main(){
    val path = "D:\\3585443\\2\\3"
    val subjects = File(path).listFiles()
    for (subject in subjects){
        val chapters = subject.listFiles()
        if (chapters != null){
            for(chapter in chapters){
                val topics = chapter.listFiles()
                if(topics!=null){
                    for(topic in topics){
                        if(topic!=null){
                            if(topic.name.contains("topicsAndVideos.json")){

                                try {
//                                    val thumbnailPathString = chapter.absolutePath+"\\Thumbnail.txt"

//                                    if(!File(thumbnailPathString).exists()){
//                                        println("subject: ${subject}, chapter :${chapter}, topic: ${topic}, Thumbnail: "+ File(thumbnailPathString).createNewFile())
//                                    }

                                    val topicAndVideosJSONResponse = chapter.absolutePath+"\\topicsAndVideos.json"

                                    val videoList = nonMp4VideoListFun(topicAndVideosJSONResponse)

//                                    val thumbnailNumList = getThumbnailList(topicAndVideosJSONResponse)

/*                                    File(thumbnailPathString).bufferedWriter().use {
                                        if (thumbnailNumList != null) {
                                            for (i in 0 until (thumbnailNumList.size)) {
                                                if ((thumbnailNumList.size - 1) != i) {
                                                    it.write(thumbnailNumList[i].split("?")[0].replace("https://il-cms-assets.s3.ap-south-1.amazonaws.com/media/","")+",")
                                                } else {
                                                    it.write(thumbnailNumList[i].split("?")[0].replace("https://il-cms-assets.s3.ap-south-1.amazonaws.com/media/",""))
                                                }
                                            }
                                        }
                                    }*/

                                } catch (e: Exception) {
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


fun nonMp4VideoListFun(pathname: String): ArrayList<String>? {
    val inputStream: InputStream = File(pathname).inputStream()

    val lineList = mutableListOf<String>()

    val videoId:ArrayList<String>? = arrayListOf()
    val title:ArrayList<String>? = arrayListOf()
    val videoNumList:ArrayList<String>? = arrayListOf()
    val returnList:ArrayList<String>? = arrayListOf()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }

    var response = ""

    lineList.forEach { response += "\n" + it }

    val modalVideo = Gson().fromJson(response, TopicsAndVideos::class.java).data?.topics

    if (modalVideo != null) {
        for(i in 0 until modalVideo.size){
            for(j in 0 until (modalVideo[i].videos?.size ?: 0)){
                val temp = modalVideo[i].videos?.get(j)?.videoURL?.let { it.split("?")[0].replace("https://il-cms-assets.s3.ap-south-1.amazonaws.com/media/","") }

                val src = "Z:\\il-cms-assets-local\\media\\$temp"
                if(isFileExists(File(src))) {
                    if (temp?.contains("mp4") != true) {
                            modalVideo[i].videos?.get(j)?.videoId?.let { videoId?.add(it) }
                            modalVideo[i].videos?.get(j)?.title?.let { title?.add(it) }
                            modalVideo[i].videos?.get(j)?.videoURL?.let { videoNumList?.add(it.split("?")[0].replace("https://il-cms-assets.s3.ap-south-1.amazonaws.com/media/",""))
                        }
                    }
                }

            }
        }
    }

    videoNumList?.forEachIndexed { index, item ->
        returnList?.add("${videoId?.get(index)}\t${title?.get(index)}\t${videoNumList[index]}")
    }

    return returnList
}

fun getThumbnailList(pathname: String): ArrayList<String>? {
    val inputStream: InputStream = File(pathname).inputStream()

    val lineList = mutableListOf<String>()

    val thumbnailNumList:ArrayList<String>? = arrayListOf()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }

    var response = ""

    lineList.forEach { response += "\n" + it }

    val modalVideo = Gson().fromJson(response, TopicsAndVideos::class.java).data?.topics
    
    if (modalVideo != null) {
        for(i in 0 until modalVideo.size){
            for(j in 0 until (modalVideo[i].videos?.size ?: 0)){
                modalVideo[i].videos?.get(j)?.thumbnail?.let { thumbnailNumList?.add(it) }
            }
        }
    }

    return thumbnailNumList
}

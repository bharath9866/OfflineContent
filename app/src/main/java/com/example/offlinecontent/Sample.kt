package com.example.offlinecontent

import android.util.Log
import apps.infinitylearn.lms.studentReport.detailedReport.domain.modal.detailedAnalysis.DetailedAnalysisReportResponse
import com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandvideos.VideoJSON
import com.google.gson.Gson
import java.io.File
import java.io.InputStream

fun main(){

    val path = "C:\\Users\\Lenovo\\StudioProjects\\OfflineContent\\app\\src\\main\\java\\com\\example\\offlinecontent\\generateDirectorforsubtopic\\modal\\DetailedReportJSON.json"

    val modalVideo = Gson().fromJson(jsonResponse(path), DetailedAnalysisReportResponse::class.java)

    modalVideo.data.get(0).schedulewiseReport?.allSubjects?.subjectWiseReport?.forEach { println(it.subjectName) }

//    add()

//    println(detailMilliToTime(-2211769215000))

//    val milliseconds = timeToMilli(h = 1, m = 1, s = 0)
//
//    println(milliseconds)
//
//    println(detailMilliToTime(105000))

}


fun timeToMilli(h: Int = 0, m: Int = 0, s: Int = 0): Long {
    val seconds = s * 1000L
    val minutes = m * 60000L
    val hours = h * 3600000L
    return seconds + minutes + hours
}

fun detailMilliToTime(timeMs: Long): String {

    val totalSeconds = timeMs / 1000
    val minutes = totalSeconds/60%60
    val seconds = totalSeconds%60
    val hours = totalSeconds/3600

    val m = if(minutes<=9) "0" else ""
    val h = if(hours<= 9) "0" else ""
    val s = if(seconds<= 9) "0" else ""


    return if (timeMs != 0L) {
        if (hours != 0L && minutes != 0L && seconds == 0L) {
            "$h${hours}h $m${minutes}m"
        } else if (hours == 0L && minutes != 0L && seconds != 0L) {
            "$m${minutes}m $s${seconds}s"
        } else if (hours == 0L && minutes == 0L && seconds != 0L) {
            "$s${seconds}s"
        } else if(hours==0L && minutes != 0L && seconds ==0L){
            "$m${minutes}m $s${seconds}s"
        } else {
            "$h${hours}h $m${minutes}m $s${seconds}s"
        }
    } else {
        "0m 0s"
    }

}

fun jsonResponse(pathName: String): String {

    val inputStream: InputStream = File(pathName).inputStream()

    val lineList:ArrayList<String> = arrayListOf()

    var response = ""

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }

    lineList.forEach{
        response+= "\n"+it
    }

    return response
}

fun add(){
    try{

        val a = 1
        val b = 0
        val c = a/b
        println(c)

    } catch (e:ArithmeticException){
        Log.d("", "$e")
    } catch (e:RuntimeException){
        Log.d("", "$e")
    }
}
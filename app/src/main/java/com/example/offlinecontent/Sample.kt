package com.example.offlinecontent

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.offlinecontent.generateDirectorforsubtopic.fileCopy
import com.example.offlinecontent.generateDirectorforsubtopic.modal.detailedAnalysis.DetailedAnalysisReportResponse
import com.example.offlinecontent.generateDirectorforsubtopic.modal.tokenModal.UAMResponse
import com.example.offlinecontent.offlineContent.AESEnc
import com.example.offlinecontent.offlineContent.createDirectory
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.delay
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.nio.file.Paths
import java.util.*
import java.util.concurrent.TimeUnit

fun uamRequest(uid:String, password:String = "test123"): UAMResponse? {

    val client: OkHttpClient = OkHttpClient().newBuilder().build()

    val mediaType: MediaType = "application/json".toMediaTypeOrNull()!!

    val body: RequestBody =
        "{\"uid\": \"${uid}\", \"password\":\"${password}\"}".toRequestBody(mediaType)

    val request: Request = Request.Builder()
        .url("https://api.infinitylearn.com/api/authentication/login")
        .method("POST", body)
        .addHeader("accept", "application/json")
        .addHeader("Authorization", "Bearer")
        .addHeader("X-Tenant", "srichaitanya")
        .addHeader("isMultiSessionRequired", "false")
        .addHeader("Content-Type", "application/json")
        .build()

    val response: Response = client.newCall(request).execute()

    val string = response.body?.string()

    return Gson().fromJson(string, UAMResponse::class.java)

}

fun time(): Long {
    return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())
}
@OptIn(ExperimentalStdlibApi::class)
@RequiresApi(Build.VERSION_CODES.O)
suspend fun mainn(args: Array<String>) {

        println(time())
        delay(5000)
        println(time())


//    val milliseconds: Long = LocalDateTime.now().toString()

//    val seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds)

//    println("$milliseconds Milliseconds = $seconds seconds")
}

fun mainii(){
    var arr:ArrayList<Int>? = arrayListOf()

    arr = null
    println(arr?.size)
    arr = arrayListOf()
    println(arr?.size)

    /*var j = 0
    for (i in 0 until (arr?.size?: -1)){
        j += 1
        println(j)
    }*/

}

fun mainmm() {
    val paper = "Paper1"
    var name = ""
     val temp = paper.substring(0,1).uppercase() + paper.substring(1).lowercase()
     temp.forEach {
        name += if(it.isDigit()){
            " $it"
        } else {
            it.toString()
        }
    }
    println(name)

    /*val client: OkHttpClient = OkHttpClient().newBuilder()
        .build()
    val mediaType: MediaType? = "application/json".toMediaTypeOrNull()
    val body: RequestBody =
        "{\r\n    \"uid\": \"213278204\",\r\n    \"password\": \"test123\"\r\n}".toRequestBody(
            mediaType)
    val request: Request = Request.Builder()
        .url("https://testlms.ilteach.com/api/authentication/login")
        .method("POST", body)
        .addHeader("accept", "application/json")
        .addHeader("Authorization", "Bearer")
        .addHeader("X-Tenant", "srichaitanya")
        .addHeader("isMultiSessionRequired", "false")
        .addHeader("Content-Type", "application/json")
        .build()
    val response: Response = client.newCall(request).execute()
    println(response.body?.string())*/
}
fun mainn() {

    val mapper = jacksonObjectMapper()

    val person = mapper.readValue(File("C:\\Users\\Lenovo\\StudioProjects\\OfflineContent\\app\\src\\main\\java\\com\\example\\offlinecontent\\generateDirectorforsubtopic\\json\\DetailedReportJSON.json"), DetailedAnalysisReportResponse::class.java)

    println(person.data)

}


fun mainm() {


    try {
        val jsonPath = "C:\\Users\\Lenovo\\StudioProjects\\OfflineContent\\app\\src\\main\\java\\com\\example\\offlinecontent\\generateDirectorforsubtopic\\json\\DetailedReportJSON.json"
        val jsonString = jsonResponse(jsonPath)


        println(jsonString)

//        val objec = jacksonObjectMapper().readValues<DetailedAnalysisReportResponse>(File(jsonPath))

    } catch (e: JsonParseException) {
        e.printStackTrace();
    } catch (e: JsonSyntaxException) {
        e.printStackTrace();
    } catch (e: IOException) {
        e.printStackTrace();
    }


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
    val minutes = totalSeconds / 60 % 60
    val seconds = totalSeconds % 60
    val hours = totalSeconds / 3600

    val m = if (minutes <= 9) "0" else ""
    val h = if (hours <= 9) "0" else ""
    val s = if (seconds <= 9) "0" else ""


    return if (timeMs != 0L) {
        if (hours != 0L && minutes != 0L && seconds == 0L) {
            "$h${hours}h $m${minutes}m"
        } else if (hours == 0L && minutes != 0L && seconds != 0L) {
            "$m${minutes}m $s${seconds}s"
        } else if (hours == 0L && minutes == 0L && seconds != 0L) {
            "$s${seconds}s"
        } else if (hours == 0L && minutes != 0L && seconds == 0L) {
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

    val lineList: ArrayList<String> = arrayListOf()

    var response = ""

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }

    lineList.forEach {
        response += "\n" + it
    }

    return response
}

fun add() {
    try {

        val a = 1
        val b = 0
        val c = a / b
        println(c)

    } catch (e: ArithmeticException) {
        Log.d("", "$e")
    } catch (e: RuntimeException) {
        Log.d("", "$e")
    }
}
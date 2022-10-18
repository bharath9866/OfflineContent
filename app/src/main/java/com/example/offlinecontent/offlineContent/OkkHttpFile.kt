package com.example.offlinecontent.offlineContent


import android.os.Build
import androidx.annotation.RequiresApi
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import okhttp3.MediaType.Companion.toMediaType
import java.io.IOException
import java.io.InputStream
import java.util.concurrent.TimeUnit

fun main(){
    val json = bowlingJson("Bharath", "Kumar")
    println(json)
}



fun post(url: String, json: String) {
    val JSON = "application/json; charset=utf-8".toMediaType();
    val body = ""
}

fun bowlingJson(player1:String, player2:String):String{
    return "{'winCondition':'HIGH_SCORE','name':'Bowling','round':4,'lastSaved':1367702411696,'dateStarted':1367702378785,'players':[{'name':'$player1','history':[10,8,6,7,8],'color':-13388315,'total':39},{'name':'$player2','history':[6,10,5,10,10],'color':-48060,'total':41}]}";
}

// code request code here
@Throws(IOException::class)
fun doGetRequest(url: String?, token: String?, tenantName:String?, tenant:Int?, subTenant:Int?): String {
    var client = OkHttpClient()
    client.setConnectTimeout(30, TimeUnit.SECONDS)
    client.setReadTimeout(30, TimeUnit.SECONDS)
    val request: Request = Request.Builder()
        .header(
            "Authorization",
            "Bearer $token",
        ).header(
            "X-Tenant",
            "$tenantName"
        ).header(
            "tenantId",
            "$tenant"
        ).header(
            "subTenantId",
            "$subTenant"
        )
        .url(url)
        .build()// PA04 Token
    val response = client.newCall(request).execute()
    // return response.body().byteStream()
    return if (response.isSuccessful) {
        response.body().string()
    } else {
        return response.isSuccessful.toString() + " : " + response.code().toString()
    }
    // return response.isSuccessful
}

@RequiresApi(Build.VERSION_CODES.N)
fun getSelfResponse(url: String, token:String, tenantName:String?, tenant:Int?, subTenant:Int?): String {

    val getReponse: InputStream = doGetRequest(
        url = url,
        token = token,
        tenantName = tenantName,
        tenant = tenant,
        subTenant = subTenant
    ).byteInputStream()

    return if(!getReponse.toString().contains("false")){

        val lineList = mutableListOf<String>()

        getReponse.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }

        var response = ""

        lineList.forEach { response += it }

        response
    } else {
        getReponse.toString()
    }

    /*
    val fileName = "C:\\223647\\16\\5\\2\\230\\topicsAndSubtopics.json"
    if(!File(fileName).exists()) {
        print(File(fileName).createNewFile())
    }

    File(fileName).bufferedWriter().use { out ->
        out.write(response)
    }
    */
}


@RequiresApi(Build.VERSION_CODES.N)
fun mainnn(){
    val tenantId = 2
    val subTenantId = 43
    val userId = 3486982
    val gradeId = 2
    val examId = 3
    val tenantName = "srichaitanya"
    val subjectId = 2
    val chapterId = 148
    val topicId = 1578
    val subTopicId = 2958
    val token = "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIyMjQzMzQ4NDAiLCJUZW5hbnRJZCI6MiwiUm9sZU5hbWUiOiJTdHVkZW50IiwiREJJZCI6IjM0ODY5ODIiLCJGaXJzdE5hbWUiOiJNIExBWE1JIiwiVGVuYW50Q29kZSI6InNyaWNoYWl0YW55YSIsIkxhc3ROYW1lIjoiUFJBU0FOQSIsImV4cCI6MTY2NDQ2MzU3NywiUm9sZUlkIjoiMSIsImlhdCI6MTY2NDM3NzE3N30.Iix3pRoDctWj_UXWpwkzmQbnCJ_t0OmK1juUa0zJfE0"

//    val BASEURL = "https://selflearnapi.devinfinitylearn.in/api/" // Preprod BaseUrl
    val BASEURL = "https://selflearnapi.infinitylearn.com/api/" // Prod BaseURL

    val getSubject = getSelfResponse(url = BASEURL+"selflearn/getUserSubjectsPerExam?examId=${examId}&gradeId=${gradeId}&userId=${userId}", token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)
    println("\nSubjectJson: $getSubject")


//    val getChapters = getSelfResponse(url = BASEURL+"selflearn/getUserChaptersForExamAndSubject?examId=${examId}&gradeId=${gradeId}&subjectId=${subjectId}&userId=${userId}", token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)
//    println("\nChaptersId: $getChapters")
//
//
//    val topicSubtopics = getSelfResponse(url = BASEURL+"selflearn/topicsAndSubtopics?examId=${examId}&gradeId=${gradeId}&subjectId=${subjectId}&chapterId=${chapterId}&userId=${userId}", token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)
//    println("\nTopicAndSubtopic: $topicSubtopics")
//
//    val flashcards = getSelfResponse(url = BASEURL+"selflearn/getuserflashcardsAndQuestions?examId=${examId}&gradeId=${gradeId}&subjectId=${subjectId}&chapterId=${chapterId}&topicId=${topicId}&subtopicId=${subTopicId}&userId=${userId}", token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)
//    println("\nFlashcard: $flashcards")
//
//
//    val topicsAndVideos = getSelfResponse(url= BASEURL+"selflearn/topicsAndVideos?examId=${examId}&gradeId=${gradeId}&subjectId=${subjectId}&chapterId=${chapterId}&userId=${userId}", token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)
//    println("\nTopicsAndVideos: $topicsAndVideos")
//
//
//    val getUserTopicsForExamAndSubjectAndChapter = getSelfResponse(url= BASEURL+"selflearn/getUserTopicsForExamAndSubjectAndChapter?examId=${examId}&gradeId=${gradeId}&subjectId=${subjectId}&chapterId=${chapterId}&userId=${userId}", token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)
//    println("\nPractice: $getUserTopicsForExamAndSubjectAndChapter")
//
//
//    val articulation = getSelfResponse(url= BASEURL+"articulation/getUserStoriesAndDetailsforChapter?chapterId=${chapterId}&examId=${examId}&gradeId=${gradeId}", token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)
//    println("\narticulation: $articulation")
//
//    val getUserDocumentsAndDetailsfoChapter = getSelfResponse(url= BASEURL+"document/getUserDocumentsAndDetailsforChapter?chapterId=${chapterId}&examId=${examId}&gradeId=${gradeId}", token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)
//    println("\ngetUserDocumentsAndDetailsfoChapter: $getUserDocumentsAndDetailsfoChapter")


}

//eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJJTDE2IiwiUm9sZU5hbWUiOiJTdHVkZW50IiwiREJJZCI6IjIyMjY0ODEiLCJGaXJzdE5hbWUiOiJLSVNIT1JFIiwiVGVuYW50Q29kZSI6InNyaWNoYWl0YW55YSIsIkxhc3ROYW1lIjoiQ0giLCJleHAiOjE2NTU0NTAyODAsImlhdCI6MTY1NTM2Mzg4MH0.7F0pPyAiQ5UWqXFen_KaG2CkE5Ejrn7CcCZB1I7x04s
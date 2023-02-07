package com.example.offlinecontent.offlineContent


import android.os.Build
import androidx.annotation.RequiresApi
import com.example.offlinecontent.generateDirectorforsubtopic.modal.getUserSubjectsPerExam.GetUserSubjectsPerExam
import com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandvideos.TopicsAndVideos
import com.example.offlinecontent.offlineContent.Utilities.readJsonFile
import com.example.offlinecontent.offlineContent.Utilities.writeJsonFile
import com.google.gson.Gson
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import java.io.*
import java.util.concurrent.TimeUnit

@RequiresApi(Build.VERSION_CODES.O)
fun main(){

//        val BASEURL = "https://selflearnapi.devinfinitylearn.in/api/" // Preprod BaseUrl
    val BASEURL = "https://selflearnapi.infinitylearn.com/api/" // Prod BaseURL

    var getSubject = ""

    var examId = 0
    var gradeId = 0
    var userId = 0
    var accessToken = ""
    var tenantName = ""
    var tenantId = 0
    var subTenant = 0


    getUAMToken("ADM040")?.apply {
        examId = userDto?.exams?.get(0)?.examId ?: 0
        userId = userDto?.userId ?: 0
        gradeId = userDto?.grade?.gradeId ?: 0
        accessToken = this.accessToken?:""
        tenantName = this.tenantName?:""
        tenantId = userDto?.tenantId?:0
        subTenant = userDto?.subTenant ?: 0
    }

    // Example of Hitting API
    getSelfLearnApiResponse(
        requestUrl = BASEURL+"selflearn/topicsAndVideos?examId=$examId&gradeId=$gradeId&subjectId=2&chapterId=229&userId=$userId",
        token = accessToken,
        tenantName = tenantName,
        tenantId = tenantId,
        subTenant = subTenant
    )

    Gson().fromJson("C:\\Users\\Lenovo\\Desktop\\testing.json".readJsonFile(), TopicsAndVideos::class.java).data?.topics

}














//    val getSubject = getSelfResponse(url = BASEURL+"selflearn/getUserSubjectsPerExam?examId=${examId}&gradeId=${gradeId}&userId=${userId}", token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)
//    println("\nSubjectJson: $getSubject")
//
//
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

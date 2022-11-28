package com.example.offlinecontent.offlineContent

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.offlinecontent.generateDirectorforsubtopic.getImages
import com.example.offlinecontent.generateDirectorforsubtopic.getVideos
import com.example.offlinecontent.generateDirectorforsubtopic.modal.getUserSubjectsPerExam.GetUserSubjectsPerExam
import com.example.offlinecontent.generateDirectorforsubtopic.modal.getuserchaptersforexamandsubject.GetUserChaptersForExamAndSubject
import com.example.offlinecontent.generateDirectorforsubtopic.modal.getuserflashcardsandquestions.GetUserFlashCardsAndQuestions
import com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandsubtopics.Data
import com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandsubtopics.TopicsAndSubtopics
import com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandvideos.TopicsAndVideos
import com.example.offlinecontent.generateDirectorforsubtopic.writeToExcelFile
import com.example.offlinecontent.uamRequest
import com.google.gson.Gson
import com.google.gson.JsonIOException
import com.google.gson.JsonSyntaxException
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@RequiresApi(Build.VERSION_CODES.O)
fun main() {

    /**
     * INPUTS
     */
    val usersList = arrayListOf("ADM040")
    val drive = "D"

    /**
     * CALLING FUNCTIONS
     */
    uamRequest("ADM040")?.apply {
        offLineSelfLearn(
            drive = "D",
            userId = userDto?.userId ?: 0,
            gradeId = userDto?.grade?.gradeId ?: 0,
            examId = userDto?.exams?.get(0)?.examId ?: 0,
            token = accessToken ?: "",
            tenantName = tenantName,
            tenantId = userDto?.tenantId ?: 0,
            subTenantId = userDto?.subTenant ?: 0
        )
    }

    usersList.forEachIndexed { index, user ->
        uamRequest(user)?.apply {
//            getImages(drive, userDto?.userId?:0, userDto?.grade?.gradeId?:0, examId = userDto?.exams?.get(0)?.examId?:0)
            getVideos(drive, userDto?.userId?:0, userDto?.grade?.gradeId?:0, examId = userDto?.exams?.get(0)?.examId?:0)
            videoEncryption(
                sourcePath = "$drive:\\${userDto?.userId?:0}\\${userDto?.grade?.gradeId?:0}\\${userDto?.exams?.get(0)?.examId?:0}\\decryptedVideos",
                destinationPath = "$drive:\\${userDto?.userId?:0}\\${userDto?.grade?.gradeId?:0}\\${userDto?.exams?.get(0)?.examId?:0}\\videos"
            )
        }
    }


    //    getImages("E", 3205748, 13, 7)
//        getVideos("F", 3585440, 2, 3)
    //    videoEncryption("D:\\3486982\\2\\3\\decrypted", "F:\\3486982\\2\\3\\videos")

}


//var subjectId = 1 // PhysicsId: 1, ChemistryId: 2, MathematicsId: 3, BotanyId: 4, ZoologyId: 5
@RequiresApi(Build.VERSION_CODES.O)
fun offLineSelfLearn(drive:String, userId: Int, gradeId: Int, examId:Int, token:String, tenantName:String?, tenantId: Int?, subTenantId:Int? ) {


//     val BASEURL = "https://selflearnapi.devinfinitylearn.in/api/" // Preprod BaseUrl
    val BASEURL = "https://selflearnapi.infinitylearn.com/api/" // Prod BaseURL

    val chapterIdList : ArrayList<Int> = arrayListOf()

    val subjectIdList : ArrayList<Int> = arrayListOf()

    val getSubjects_url  = BASEURL+"selflearn/getUserSubjectsPerExam?examId=${examId}&gradeId=${gradeId}&userId=${userId}"

    val varGetSubjectResponse = getSelfResponse(url = getSubjects_url, token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)

    // SUBJECTS
    if(!varGetSubjectResponse.contains("false : ", true)) {

        val userIdDir = "${drive}:\\${userId}"
        val gradeIdDir = "${drive}:\\${userId}\\${gradeId}"
        val examIdDir = "${drive}:\\${userId}\\${gradeId}\\${examId}"

        if(!File(userIdDir).exists()){
            createDirectory(Paths.get(userIdDir))
        }

        if(!File(gradeIdDir).exists()){
            createDirectory(Paths.get(gradeIdDir))
        }

        if(!File(examIdDir).exists()){
            createDirectory(Paths.get(examIdDir))
        }

        //createDirectory(Paths.get("${drive}:\\${userId}\\${gradeId}\\${examId}\\${subjectIdList[s]}"))

        // Store Subject Json File
        val subjectJSONPath = "${drive}:\\${userId}\\${gradeId}\\${examId}\\getUserSubjectsPerExam.json"

        if (!File(subjectJSONPath).exists()) {
            println("SubjectJSONFile Created: " + File(subjectJSONPath).createNewFile())
        }
        File(subjectJSONPath).bufferedWriter().use { out ->
            out.write(varGetSubjectResponse)
        }

        // Create Subject Directory
        // Subject Loop to Store Subject Node Id's in a list and creating Subject Directories using NodeId's
        val subjectModalData = Gson().fromJson(varGetSubjectResponse, GetUserSubjectsPerExam::class.java).data

        if (subjectModalData != null) {
        if(subjectModalData.subjectNode.isNotEmpty()) {

                subjectIdList.clear()
                for(s in 0 until subjectModalData.subjectNode.size){
                    subjectIdList.add(subjectModalData.subjectNode[s].nodeId!!)

                    createDirectory(Paths.get("${drive}:\\${userId}\\${gradeId}\\${examId}\\${subjectIdList[s]}"))

                     /* ----------------------------------------- CHAPTERS ------------------------------------------- */

                    val getChapter_Url = BASEURL+"selflearn/getUserChaptersForExamAndSubject?examId=${examId}&gradeId=${gradeId}&subjectId=${subjectIdList[s]}&userId=${userId}"
                    val varGetChapterResponse = getSelfResponse(getChapter_Url, token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)

                    if(!varGetChapterResponse.contains("false : ", true)){

                        // Creating CHAPTER JSON File
                        val chapterJSONPath = "${drive}:\\${userId}\\${gradeId}\\${examId}\\${subjectIdList[s]}\\getUserChaptersForExamAndSubject.json"

                        if(!File(chapterJSONPath).exists()){
                            println("Subject: ${subjectIdList[s]}, ChapterJSONFile Created: "+File(chapterJSONPath).createNewFile())
                        }
                        File(chapterJSONPath).bufferedWriter().use { out ->
                            out.write(varGetChapterResponse)
                        }

                        // Reading ChapterModalData
                        val chapterModalData = Gson().fromJson(varGetChapterResponse, GetUserChaptersForExamAndSubject::class.java).data

                        if (chapterModalData != null) {
                            if(chapterModalData.chapterNodes.isNotEmpty()){

                                chapterIdList.clear()
                                for(c in 0 until chapterModalData.chapterNodes.size){ // Chapter List

                                    chapterModalData.chapterNodes[c].nodeId?.let { chapterIdList.add(it) }

                                    createDirectory(Paths.get("${drive}:\\${userId}\\${gradeId}\\${examId}\\${subjectIdList[s]}\\${chapterIdList[c]}"))

                                    /* ----------------------------------- Creating and Writing ArticulationJSON File ------------------------------------- */
                                    val articulationJSONPath = "${drive}:\\${userId}\\${gradeId}\\${examId}\\${subjectIdList[s]}\\${chapterIdList[c]}\\articulation.json"

                                    val getArticulation_url = BASEURL+"articulation/getUserStoriesAndDetailsforChapter?chapterId=${chapterIdList[c]}&examId=${examId}&gradeId=${gradeId}"
                                    if(!File(articulationJSONPath).exists()){
                                        println("\nSubject: ${subjectIdList[s]}, Chapter: ${chapterIdList[c]}, ArticulationJSONFile Created: "+File(articulationJSONPath).createNewFile())
                                    }
                                    File(articulationJSONPath).bufferedWriter().use { out ->
                                        out.write(getSelfResponse(getArticulation_url, token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId))
                                    }


                                    // TopicAndVideos File
                                    val getTopicVideos_url = BASEURL+"selflearn/topicsAndVideos?examId=${examId}&gradeId=${gradeId}&subjectId=${subjectIdList[s]}&chapterId=${chapterIdList[c]}&userId=${userId}"

                                    if(getTopicVideos_url.contains("false : ", true)){
                                        print(", TopicAndVideo Json Throws $getTopicVideos_url")
                                    } else {
                                        if(getTopicVideos_url.isEmpty()){
                                            print(", TopicAndVidoeFileIsFull: False")
                                        } else {


                                            val topicAndVideosJSONResponse = "${drive}:\\${userId}\\${gradeId}\\${examId}\\${subjectIdList[s]}\\${chapterIdList[c]}\\topicsAndVideos.json"

                                            if(!File(topicAndVideosJSONResponse).exists()){
                                                println("Subject: ${subjectIdList[s]}, Chapter: ${chapterIdList[c]}, Topic and Videos Json File: "+File(topicAndVideosJSONResponse).createNewFile())
                                            }

                                            File(topicAndVideosJSONResponse).bufferedWriter().use { out ->
                                                out.write(getSelfResponse(getTopicVideos_url, token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId))
                                            }

                                            print(", TopicAndVideoJsonFile: True")

                                            // ---------------------------------------------- Creating VideoNumsList[videoURL.txt] -----------------------------------------------
                                            val videosNumsListTxtFile = "${drive}:\\${userId}\\${gradeId}\\${examId}\\${subjectIdList[s]}\\${chapterIdList[c]}\\videoURL.txt"
                                            if(!File(videosNumsListTxtFile).exists()){
                                                println(File(videosNumsListTxtFile).createNewFile())
                                            }

                                            try {
                                                val tempVideoNumsList = getVideoNumList(topicAndVideosJSONResponse)

                                                File(videosNumsListTxtFile).bufferedWriter().use {
                                                    if (tempVideoNumsList != null) {
                                                        for (i in 0 until (tempVideoNumsList.size)) {
                                                            if ((tempVideoNumsList.size - 1) != i) {
                                                                it.write(tempVideoNumsList[i].split("?")[0].replace("https://il-cms-assets.s3.ap-south-1.amazonaws.com/media/","")+",")
                                                            } else {
                                                                it.write(tempVideoNumsList[i].split("?")[0].replace("https://il-cms-assets.s3.ap-south-1.amazonaws.com/media/",""))
                                                            }
                                                        }
                                                    }
                                                }

                                            } catch (e: JsonSyntaxException) {
                                                println(e.stackTraceToString())
                                            }
                                        }
                                    }


                                    // ---------------------------------------------- Creating practiceJSONPath -----------------------------------------------
                                    val practiceJSONPath = "${drive}:\\${userId}\\${gradeId}\\${examId}\\${subjectIdList[s]}\\${chapterIdList[c]}\\getUserTopicsForExamAndSubjectAndChapter.json"
                                    val getPractice_url = BASEURL+"selflearn/getUserTopicsForExamAndSubjectAndChapter?examId=${examId}&gradeId=${gradeId}&subjectId=${subjectIdList[s]}&chapterId=${chapterIdList[c]}&userId=${userId}"
                                    if(!File(practiceJSONPath).exists()){
                                        println("Subject: ${subjectIdList[s]}, Chapter: ${chapterIdList[c]}, Practice Json Path: "+File(practiceJSONPath).createNewFile())
                                    }
                                    File(practiceJSONPath).bufferedWriter().use { out ->
                                        out.write(getSelfResponse(getPractice_url, token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId))
                                    }

                                    // ---------------------------------------------- Creating TopicSubtopicJSON File -----------------------------------------------
                                    val topicAndSubtopicJSONPath = "${drive}:\\${userId}\\${gradeId}\\${examId}\\${subjectIdList[s]}\\${chapterIdList[c]}\\topicsAndSubtopics.json"

                                    val getTopicSubtopic_url = getSelfResponse(BASEURL+"selflearn/topicsAndSubtopics?examId=${examId}&gradeId=${gradeId}&subjectId=${subjectIdList[s]}&chapterId=${chapterIdList[c]}&userId=${userId}", token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)

                                    if(!File(topicAndSubtopicJSONPath).exists()){
                                        println("Subject: ${subjectIdList[s]}, Chapter: ${chapterIdList[c]}, TopicAndSubtopicJSONFile: " + File(topicAndSubtopicJSONPath).createNewFile())
                                    }

                                    File(topicAndSubtopicJSONPath).bufferedWriter().use { out ->
                                        out.write(getTopicSubtopic_url)
                                    }

                                    // ---------------------------------------------- Creating Topic and Subtopic Directory -----------------------------------------------
                                    val topicSubtopicModalData = Gson().fromJson(getTopicSubtopic_url, TopicsAndSubtopics::class.java).data
                                    val topicSubtopicMap = topicSubtopicModalData?.let { topicSubtopicMap(it, subjectIdList[s], chapterIdList[c]) }
                                    if (topicSubtopicMap != null) {

                                        var topic = ""
                                        var subtopicDir = ""
                                        var subtopicValue = arrayListOf<Int>()

                                        for (topicIdAsKey in topicSubtopicMap.keys) {
                                            topic = "${drive}:\\${userId}\\${gradeId}\\${examId}\\${subjectIdList[s]}\\${chapterIdList[c]}\\${topicIdAsKey}"
                                            if(!File(topic).exists()){
                                                createDirectory(Paths.get(topic))
                                            }

                                            subtopicValue = topicSubtopicMap[topicIdAsKey]!!

                                            for(subTopicIdAsValue in 0 until subtopicValue.size) {
                                                if (subtopicValue.size == 0) {
                                                    continue
                                                } else {
                                                    subtopicDir = "${drive}:\\${userId}\\${gradeId}\\${examId}\\${subjectIdList[s]}\\${chapterIdList[c]}\\${topicIdAsKey}\\${subtopicValue[subTopicIdAsValue]}"
                                                    if (!File(subtopicDir).exists()) {
                                                        createDirectory(Paths.get(subtopicDir))


                                                        val getFlashCard_url = getSelfResponse(BASEURL + "selflearn/getuserflashcardsAndQuestions?examId=${examId}&gradeId=${gradeId}&subjectId=${subjectIdList[s]}&chapterId=${chapterIdList[c]}&topicId=${topicIdAsKey}&subtopicId=${subtopicValue[subTopicIdAsValue]}&userId=${userId}", token = token, tenantName = tenantName, tenant = tenantId, subTenant = subTenantId)

                                                        // Printing Id's for Cross Check
                                                        print("\nSubject: ${subjectIdList[s]}, Chapter: ${chapterIdList[c]}, Topic: ${topicIdAsKey}, Subtopic: ${subtopicValue[subTopicIdAsValue]} = ")

                                                        if (getFlashCard_url.contains("false : ", true)) {
                                                            print(", FlashCardJson Throws $getFlashCard_url")
                                                            /*File(flashCardJSONPath).bufferedWriter()
                                                                .use { out ->
                                                                    out.write("")
                                                                }*/
                                                        } else {

                                                            // Check FlashCard Response is Empty or not
                                                            if(getFlashCard_url.isEmpty()) {
                                                                print(", FlashCardJsonFileIsFull: False")
                                                            } else {
                                                                val flashCardJSONPath = "$subtopicDir\\getuserflashcardsAndQuestions.json"
                                                                if (!File(flashCardJSONPath).exists()) {
                                                                    File(flashCardJSONPath).createNewFile()
                                                                }
                                                                File(flashCardJSONPath).bufferedWriter().use { out ->
                                                                        out.write(getFlashCard_url)
                                                                }

                                                                print(", FlashCardJsonFileIsFull: True")

                                                                var flashCardTempId : String? = null

                                                                try {

                                                                    val flashCardTitleMediaList = getImageNumList("${subtopicDir}\\getuserflashcardsAndQuestions.json")

                                                                    if (flashCardTitleMediaList?.isNotEmpty() == true) {

                                                                        // ---------------------------------------------- Creating image.txt -----------------------------------------------
                                                                        val imageTextPath = "$subtopicDir\\image.txt"
                                                                        if (!File(imageTextPath).exists()) {
                                                                            File(imageTextPath).createNewFile() // Image Text File is Creating
                                                                        }

                                                                        File(imageTextPath).bufferedWriter().use{

                                                                            for(i in 0 until (flashCardTitleMediaList.size)){
                                                                                if((flashCardTitleMediaList.size-1) != i){
                                                                                    it.write(flashCardTitleMediaList[i].split("?")[0].replace("https://il-cms-assets.s3.ap-south-1.amazonaws.com/media/","")+",")
                                                                                } else {
                                                                                    it.write(flashCardTitleMediaList[i].split("?")[0].replace("https://il-cms-assets.s3.ap-south-1.amazonaws.com/media/",""))
                                                                                }
                                                                            }

                                                                        }

                                                                        if(File(imageTextPath).exists()) {

                                                                            if (File(imageTextPath).length() != 0L) {
                                                                                print(", ImageTextFileIsFull: True")
                                                                            } else {
                                                                                print(", ImageTextFileIsFull: Empty")
                                                                            }

                                                                        } else {
                                                                                print(", ImageTextFileIsFull: False")
                                                                        }
                                                                    }

                                                                } catch (e: JsonSyntaxException){
                                                                    println("\n\nJsonSyntax EXCEPTION: ${e.stackTraceToString()}" )
                                                                    println("on SUBJECT: ${subjectIdList[s]}, CHAPTER: ${chapterIdList[c]}, TOPIC: $topicIdAsKey, SUBTOPIC: ${subtopicValue[subTopicIdAsValue]}, FlashCards: $flashCardTempId")
                                                                } catch(e: JsonIOException){
                                                                    println("\n\nJsonIO EXCEPTION: ${e.stackTraceToString()}" )
                                                                    println("on SUBJECT: ${subjectIdList[s]}, CHAPTER: ${chapterIdList[c]}, TOPIC: $topicIdAsKey, SUBTOPIC: ${subtopicValue[subTopicIdAsValue]}, FlashCards: $flashCardTempId")
                                                                } catch(e: NullPointerException) {
                                                                    println("\n\nNullPointer EXCEPTION: ${e.stackTraceToString()}")
                                                                    println("on SUBJECT: ${subjectIdList[s]}, CHAPTER: ${chapterIdList[c]}, TOPIC: $topicIdAsKey, SUBTOPIC: ${subtopicValue[subTopicIdAsValue]}, FlashCards: $flashCardTempId")
                                                                } catch(e: IllegalStateException) {
                                                                    println("\n\nIllegalState EXCEPTION: ${e.stackTraceToString()}")
                                                                    println("on SUBJECT: ${subjectIdList[s]}, CHAPTER: ${chapterIdList[c]}, TOPIC: $topicIdAsKey, SUBTOPIC: ${subtopicValue[subTopicIdAsValue]}, FlashCards: $flashCardTempId")
                                                                } catch (e: Exception){
                                                                    println("\n\nEXCEPTION: ${e.stackTraceToString()}" )
                                                                    println("on SUBJECT: ${subjectIdList[s]}, CHAPTER: ${chapterIdList[c]}, TOPIC: $topicIdAsKey, SUBTOPIC: ${subtopicValue[subTopicIdAsValue]}, FlashCards: $flashCardTempId")
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
            }
        }
    } else println("Subject Response $varGetSubjectResponse")
}

private fun getImageNumList(pathname: String):ArrayList<String>?{
    val inputStream:InputStream = File(pathname).inputStream()

    val lineList = mutableListOf<String>()

    val imageNumList:ArrayList<String>? = arrayListOf()

    inputStream.bufferedReader().useLines { lines -> lines.forEach{ lineList.add(it)} }

    var response = ""

    lineList.forEach{ response += "\n" + it}

    val modalImage = Gson().fromJson(response, GetUserFlashCardsAndQuestions::class.java).flashcards

    if (modalImage!=null){
        for(i in 0 until modalImage.size){
            modalImage[i].titleMedia?.let { imageNumList?.add(it) }
        }
    }
    return imageNumList
}

fun getVideoNumList(pathname: String): ArrayList<String>? {
    val inputStream: InputStream = File(pathname).inputStream()

    val lineList = mutableListOf<String>()

    val videoNumList:ArrayList<String>? = arrayListOf()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }

    var response = ""

    lineList.forEach { response += "\n" + it }

    val modalVideo = Gson().fromJson(response, TopicsAndVideos::class.java).data?.topics


    if (modalVideo != null) {
        for(i in 0 until modalVideo.size){
            for(j in 0 until (modalVideo[i].videos?.size ?: 0)){
                modalVideo[i].videos?.get(j)?.videoURL?.let { videoNumList?.add(it) }
            }
        }
    }

    return videoNumList
}



// Get Topic and Subtopic Id's in a HashMap
fun topicSubtopicMap(data: Data, subjectId: Int, chapterId: Int) : HashMap<Int, ArrayList<Int>> {
    val topicSubtopicMap: HashMap<Int, ArrayList<Int>> = hashMapOf()
    
    topicSubtopicMap.clear()
    for (i in 0 until (data.topics.size ?: 0)) {
        var topicId: Int = 0
        val subTopicId: ArrayList<Int> = arrayListOf()

        topicId = data.topics[i].nodeId ?: 0

        for (j in 0 until (data.topics[i].subtopics.size ?: 0)) {
            subTopicId.add(data.topics[i].subtopics[j].nodeId ?: 0)
        }
        topicSubtopicMap[topicId] = subTopicId

    }

    print("\nSubject: $subjectId ,Chapter: $chapterId, TopicSubtopic MapList: $topicSubtopicMap")
    return topicSubtopicMap
}


@RequiresApi(Build.VERSION_CODES.O)
fun createDirectory(directory: Path): List<Path> {
    return try {
        Files.createDirectory(directory).toList()
    } catch (e: Exception) {
        emptyList()
    }
}

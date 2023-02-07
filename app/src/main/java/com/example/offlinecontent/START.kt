package com.example.offlinecontent

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.offlinecontent.generateDirectorforsubtopic.getImages
import com.example.offlinecontent.generateDirectorforsubtopic.getVideos
import com.example.offlinecontent.offlineContent.getUAMToken
import com.example.offlinecontent.offlineContent.offLineSelfLearn
import com.example.offlinecontent.offlineContent.videoEncryption

fun maini(){
    println("Hello World!")
}

@RequiresApi(Build.VERSION_CODES.O)
fun main() {

    val usersList = arrayListOf("ADM028")
    val DRIVE = "D"


    usersList.forEachIndexed { index, uid ->

        getUAMToken(uid)?.apply {

            offLineSelfLearn(
                drive = DRIVE,
                userId = userDto?.userId ?: 0,
                gradeId = userDto?.grade?.gradeId ?: 0,
//                examId = userDto?.exams?.get(0)?.examId ?: 0,
                examId = 1,
                token = accessToken ?: "",
                tenantName = tenantName,
                tenantId = userDto?.tenantId ?: 0,
                subTenantId = userDto?.subTenant ?: 0
            )

            getImages(
                drive = DRIVE,
                userId = userDto?.userId ?: 0,
                gradeId = userDto?.grade?.gradeId ?: 0,
                examId = userDto?.exams?.get(0)?.examId ?: 0
            )

            getVideos(
                drive = DRIVE,
                userId =userDto?.userId ?: 0,
                gradeId = userDto?.grade?.gradeId ?: 0,
//                examId = userDto?.exams?.get(0)?.examId ?: 0,
                examId = 1,
                subTenantId = userDto?.subTenant?:0,
            )

            videoEncryption(
                sourcePath = "$DRIVE:\\${userDto?.userId?:0}\\${userDto?.grade?.gradeId?:0}\\${userDto?.exams?.get(0)?.examId?:0}\\decryptedVideos",
                destinationPath = "$DRIVE:\\${userDto?.userId?:0}\\${userDto?.grade?.gradeId?:0}\\${userDto?.exams?.get(0)?.examId?:0}\\videos"
            )

        }
    }
}
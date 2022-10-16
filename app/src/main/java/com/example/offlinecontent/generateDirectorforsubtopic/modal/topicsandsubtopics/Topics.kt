package com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandsubtopics

import com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandsubtopics.CompletedNodes
import com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandsubtopics.Subtopics
import com.google.gson.annotations.SerializedName

data class Topics(
    @SerializedName("nodeId"                       ) var nodeId                       : Int?                 = null,
    @SerializedName("nodeName"                     ) var nodeName                     : String?              = null,
    @SerializedName("orderId"                      ) var orderId                      : Int?                 = null,
    @SerializedName("seqNum"                       ) var seqNum                       : Int?                 = null,
    @SerializedName("publishedFlashcardCount"      ) var publishedFlashcardCount      : Int?                 = null,
    @SerializedName("publishedVideoCount"          ) var publishedVideoCount          : Int?                 = null,
    @SerializedName("totalPublishedFlashcardCount" ) var totalPublishedFlashcardCount : String?              = null,
    @SerializedName("totalPublishedVideoCount"     ) var totalPublishedVideoCount     : String?              = null,
    @SerializedName("totalFlashcardCount"          ) var totalFlashcardCount          : Int?                 = null,
    @SerializedName("totalVideoCount"              ) var totalVideoCount              : Int?                 = null,
    @SerializedName("totalCompletedFlashcardCount" ) var totalCompletedFlashcardCount : Int?                 = null,
    @SerializedName("totalCompletedVideoCount"     ) var totalCompletedVideoCount     : Int?                 = null,
    @SerializedName("levelInprogress"              ) var levelInprogress              : Int?                 = null,
    @SerializedName("completedNodes"               ) var completedNodes               : CompletedNodes?      = CompletedNodes(),
    @SerializedName("practiceAttempted"            ) var practiceAttempted            : Boolean?             = null,
    @SerializedName("practiceProgress"             ) var practiceProgress             : Int?                 = null,
    @SerializedName("totalExercises"               ) var totalExercises               : String?              = null,
    @SerializedName("isCompleted"                  ) var isCompleted                  : String?              = null,
    @SerializedName("completedDate"                ) var completedDate                :String?              = null,
    @SerializedName("subtopics"                    ) var subtopics                    : ArrayList<Subtopics> = arrayListOf(),
    @SerializedName("videos"                       ) var videos                       : String?              = null

)

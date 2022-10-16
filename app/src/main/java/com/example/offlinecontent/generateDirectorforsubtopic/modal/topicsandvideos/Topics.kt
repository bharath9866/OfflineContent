package com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandvideos

import com.google.gson.annotations.SerializedName


data class Topics (

    @SerializedName("nodeId"                       ) var nodeId                       : Int?              = 0,
    @SerializedName("nodeName"                     ) var nodeName                     : String?           = "",
    @SerializedName("orderId"                      ) var orderId                      : String?              = "",
    @SerializedName("seqNum"                       ) var seqNum                       : String?              = "",
    @SerializedName("publishedFlashcardCount"      ) var publishedFlashcardCount      : String?              = "",
    @SerializedName("publishedVideoCount"          ) var publishedVideoCount          : String?              = "",
    @SerializedName("totalPublishedFlashcardCount" ) var totalPublishedFlashcardCount : String?           = "",
    @SerializedName("totalPublishedVideoCount"     ) var totalPublishedVideoCount     : String?           = "",
    @SerializedName("totalFlashcardCount"          ) var totalFlashcardCount          : String?              = "",
    @SerializedName("totalVideoCount"              ) var totalVideoCount              : String?              = "",
    @SerializedName("totalCompletedFlashcardCount" ) var totalCompletedFlashcardCount : String?              = "",
    @SerializedName("totalCompletedVideoCount"     ) var totalCompletedVideoCount     : String?              = "",
    @SerializedName("levelInprogress"              ) var levelInprogress              : String?           = "",
    @SerializedName("completedNodes"               ) var completedNodes               : CompletedNodes? = CompletedNodes(),
    @SerializedName("practiceAttempted"            ) var practiceAttempted            : String?           = "",
    @SerializedName("practiceProgress"             ) var practiceProgress             : String?           = "",
    @SerializedName("totalExercises"               ) var totalExercises               : String?           = "",
    @SerializedName("isCompleted"                  ) var isCompleted                  : String?           = "",
    @SerializedName("completedDate"                ) var completedDate                : String?           = "",
    @SerializedName("subtopics"                    ) var subtopics                    : String?           = "",
    @SerializedName("videos"                       ) var videos                       : ArrayList<Videos>? = arrayListOf()

)


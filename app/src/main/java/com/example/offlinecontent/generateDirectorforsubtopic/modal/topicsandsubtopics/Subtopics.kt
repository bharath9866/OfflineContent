package com.example.jetpackdemo.generateDirectorforsubtopic.modal.topicsandsubtopics

import com.google.gson.annotations.SerializedName

data class Subtopics(
    @SerializedName("nodeId"                  ) var nodeId                  : Int?     = null,
    @SerializedName("nodeName"                ) var nodeName                : String?  = null,
    @SerializedName("orderId"                 ) var orderId                 : Int?     = null,
    @SerializedName("seqNum"                  ) var seqNum                  : Int?     = null,
    @SerializedName("description"             ) var description             : String?  = null,
    @SerializedName("publishedFlashcardCount" ) var publishedFlashcardCount : Int?     = null,
    @SerializedName("publishedVideoCount"     ) var publishedVideoCount     : Int?     = null,
    @SerializedName("totalFlashcardCount"     ) var totalFlashcardCount     : Int?     = null,
    @SerializedName("totalVideoCount"         ) var totalVideoCount         : Int?     = null,
    @SerializedName("practiceProgress"        ) var practiceProgress        : String?  = null,
    @SerializedName("totalExercises"          ) var totalExercises          : String?  = null,
    @SerializedName("isCompleted"             ) var isCompleted             : Boolean? = null,
    @SerializedName("completedDate"           ) var completedDate           : String?     = null,
    @SerializedName("isBookmarked"            ) var isBookmarked            : Boolean? = null,
    @SerializedName("bookmarkedDate"          ) var bookmarkedDate          : String?  = null
)

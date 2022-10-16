package com.example.jetpackdemo.generateDirectorforsubtopic.modal.getUserSubjectsPerExam

import com.google.gson.annotations.SerializedName

data class ChildNodes(
    @SerializedName("active"                       ) var active                       : Boolean? = null,
    @SerializedName("description"                  ) var description                  : String?  = "",
    @SerializedName("icon"                         ) var icon                         : String?  = "",
    @SerializedName("color"                        ) var color                        : String?  = "",
    @SerializedName("nodeId"                       ) var nodeId                       : Int?     = 0,
    @SerializedName("nodeName"                     ) var nodeName                     : String?  = "",
    @SerializedName("orderId"                      ) var orderId                      : Int?     = 0,
    @SerializedName("seqNum"                       ) var seqNum                       : Int?     = 0,
    @SerializedName("levelInprogress"              ) var levelInprogress              : String?  = "",
    @SerializedName("completedNodes"               ) var completedNodes               : String?  = "",
    @SerializedName("practiceAttempted"            ) var practiceAttempted            : String?  = "",
    @SerializedName("practiceProgress"             ) var practiceProgress             : Int?     = 0,
    @SerializedName("publishedFlashcardCount"      ) var publishedFlashcardCount      : String?  = "",
    @SerializedName("publishedVideoCount"          ) var publishedVideoCount          : String?  = "",
    @SerializedName("totalPublishedFlashcardCount" ) var totalPublishedFlashcardCount : Int?     = 0,
    @SerializedName("totalPublishedVideoCount"     ) var totalPublishedVideoCount     : Int?     = 0,
    @SerializedName("totalFlashcardCount"          ) var totalFlashcardCount          : Int?     = 0,
    @SerializedName("totalVideoCount"              ) var totalVideoCount              : Int?     = 0,
    @SerializedName("totalExercises"               ) var totalExercises               : Int?     = 0,
    @SerializedName("isCompleted"                  ) var isCompleted                  : String?  = "",
    @SerializedName("completedDate"                ) var completedDate                : String?  = "",
    @SerializedName("isBookmarked"                 ) var isBookmarked                 : String?  = "",
    @SerializedName("bookmarkedDate"               ) var bookmarkedDate               : String?  = "",
    @SerializedName("totalCompletedVideoCount"     ) var totalCompletedVideoCount     : Int?     = 0,
    @SerializedName("totalCompletedFlashcardCount" ) var totalCompletedFlashcardCount : Int?     = 0,
    @SerializedName("totalChildNodeCount"          ) var totalChildNodeCount          : String?  = "",
    @SerializedName("isChapterUnlocked"            ) var isChapterUnlocked            : Boolean? = null,
    @SerializedName("totalUnlockedChaptersCount"   ) var totalUnlockedChaptersCount   : String?  = ""
)

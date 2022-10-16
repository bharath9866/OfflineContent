package com.example.offlinecontent.generateDirectorforsubtopic.modal.getuserchaptersforexamandsubject

import com.google.gson.annotations.SerializedName

data class ChildNodes(
    @SerializedName("active"                       ) var active                       : Boolean? = null,
    @SerializedName("description"                  ) var description                  : String?  = null,
    @SerializedName("icon"                         ) var icon                         : String?  = null,
    @SerializedName("color"                        ) var color                        : String?  = null,
    @SerializedName("nodeId"                       ) var nodeId                       : Int?     = null,
    @SerializedName("nodeName"                     ) var nodeName                     : String?  = null,
    @SerializedName("orderId"                      ) var orderId                      : Int?     = null,
    @SerializedName("seqNum"                       ) var seqNum                       : Int?     = null,
    @SerializedName("levelInprogress"              ) var levelInprogress              : String?  = null,
    @SerializedName("completedNodes"               ) var completedNodes               : String?  = null,
    @SerializedName("practiceAttempted"            ) var practiceAttempted            : String?  = null,
    @SerializedName("practiceProgress"             ) var practiceProgress             : Int?     = null,
    @SerializedName("publishedFlashcardCount"      ) var publishedFlashcardCount      : String?  = null,
    @SerializedName("publishedVideoCount"          ) var publishedVideoCount          : String?  = null,
    @SerializedName("totalPublishedFlashcardCount" ) var totalPublishedFlashcardCount : Int?     = null,
    @SerializedName("totalPublishedVideoCount"     ) var totalPublishedVideoCount     : Int?     = null,
    @SerializedName("totalFlashcardCount"          ) var totalFlashcardCount          : Int?     = null,
    @SerializedName("totalVideoCount"              ) var totalVideoCount              : Int?     = null,
    @SerializedName("totalExercises"               ) var totalExercises               : Int?     = null,
    @SerializedName("isCompleted"                  ) var isCompleted                  : String?  = null,
    @SerializedName("completedDate"                ) var completedDate                : String?  = null,
    @SerializedName("isBookmarked"                 ) var isBookmarked                 : String?  = null,
    @SerializedName("bookmarkedDate"               ) var bookmarkedDate               : String?  = null,
    @SerializedName("totalCompletedVideoCount"     ) var totalCompletedVideoCount     : Int?     = null,
    @SerializedName("totalCompletedFlashcardCount" ) var totalCompletedFlashcardCount : Int?     = null,
    @SerializedName("totalChildNodeCount"          ) var totalChildNodeCount          : String?  = null,
    @SerializedName("isChapterUnlocked"            ) var isChapterUnlocked            : Boolean? = null,
    @SerializedName("totalUnlockedChaptersCount"   ) var totalUnlockedChaptersCount   : String?  = null
)

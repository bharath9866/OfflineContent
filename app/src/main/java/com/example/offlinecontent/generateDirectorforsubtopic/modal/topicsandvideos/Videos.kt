package com.example.jetpackdemo.generateDirectorforsubtopic.modal.topicsandvideos

import com.google.gson.annotations.SerializedName

data class Videos(
    @SerializedName("subtopicId"           ) var subtopicId           : String?     = "",
    @SerializedName("videoId"              ) var videoId              : String?     = "",
    @SerializedName("title"                ) var title                : String?  = "",
    @SerializedName("description"          ) var description          : String?  = "",
    @SerializedName("duration"             ) var duration             : String?  = "",
    @SerializedName("thumbnail"            ) var thumbnail            : String?  = "",
    @SerializedName("videoURL"             ) var videoURL             : String?  = "",
    @SerializedName("isCompleted"          ) var isCompleted          : Boolean? = false,
    @SerializedName("completeddate"        ) var completeddate        : String?  = "",
    @SerializedName("isBookmarked"         ) var isBookmarked         : Boolean? = false,
    @SerializedName("bookmarkedDate"       ) var bookmarkedDate       : String?  = "",
    @SerializedName("watchedContentInSecs" ) var watchedContentInSecs : String?     = ""
)
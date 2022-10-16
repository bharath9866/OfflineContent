package com.example.jetpackdemo.generateDirectorforsubtopic.modal.getuserflashcardsandquestions

import com.google.gson.annotations.SerializedName

data class Questions(
    @SerializedName("flashCardId"      ) var flashCardId     : String?   = null,
    @SerializedName("old_qb_id"        ) var oldQbId         : String?   = null,
    @SerializedName("question_id"      ) var questionId      : String?   = null,
    @SerializedName("tenant_id"        ) var tenantId        : String?   = null,
    @SerializedName("question_type"    ) var questionType    : String?   = null,
    @SerializedName("difficulty_level" ) var difficultyLevel : String?   = null,
    @SerializedName("isCorrectAnswer"  ) var isCorrectAnswer : Boolean?   = null,
    @SerializedName("timetakenInSecs"  ) var timetakenInSecs : String?   = null,
    @SerializedName("isSkipped"        ) var isSkipped       : Boolean?   = null,
    @SerializedName("isBookmarked"     ) var isBookmarked    : Boolean?   = null,
    @SerializedName("bookmarkedDate"   ) var bookmarkedDate  : String?   = null,
    @SerializedName("userAnswers"      ) var userAnswers     : String?   = null,
    @SerializedName("question"         ) var question        : Question? = Question()
)

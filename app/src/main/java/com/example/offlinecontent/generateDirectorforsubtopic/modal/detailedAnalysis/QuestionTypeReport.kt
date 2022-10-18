package com.example.offlinecontent.generateDirectorforsubtopic.modal.detailedAnalysis

import com.google.gson.annotations.SerializedName

data class QuestionTypeReport(
    @SerializedName("questionTypeId") var questionTypeId: String? = null,
    @SerializedName("questionType") var questionType: String? = null,
    @SerializedName("attempted") var attempted: Int? = null,
    @SerializedName("accuracy") var accuracy: Int? = null,
    @SerializedName("avgTimePerQuestion") var avgTimePerQuestion: Long? = null,
    @SerializedName("qcount") var qcount: Int? = null
)

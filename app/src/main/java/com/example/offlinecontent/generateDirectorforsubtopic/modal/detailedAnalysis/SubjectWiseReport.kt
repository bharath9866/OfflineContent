package com.example.offlinecontent.generateDirectorforsubtopic.modal.detailedAnalysis

import com.google.gson.annotations.SerializedName

data class SubjectWiseReport(
    @SerializedName("subjectId") var subjectId: Int? = null,
    @SerializedName("subjectName") var subjectName: String? = null,
    @SerializedName("attempted") var attempted: Int? = null,
    @SerializedName("accuracy") var accuracy: Int? = null,
    @SerializedName("avgTimePerQuestion") var avgTimePerQuestion: Long? = null,
    @SerializedName("avgTimePerCorrectQuestion") var avgTimePerCorrectQuestion: Long? = null,
    @SerializedName("avgTimePerInCorrectQuestion") var avgTimePerInCorrectQuestion: Long? = null,
    @SerializedName("qcount") var qcount: Int? = null,
    @SerializedName("isPartialMarkingEnabled") var isPartialMarkingEnabled: Boolean? = null
)

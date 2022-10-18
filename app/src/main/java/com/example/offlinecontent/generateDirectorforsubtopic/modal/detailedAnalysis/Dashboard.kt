package com.example.offlinecontent.generateDirectorforsubtopic.modal.detailedAnalysis

import com.google.gson.annotations.SerializedName

data class Dashboard(
    @SerializedName("totalTimeTaken") var totalTimeTaken: Long? = null,
    @SerializedName("avgTimeTaken") var avgTimeTaken: Long? = null,
    @SerializedName("avgTimePerCorrectQuestion") var avgTimePerCorrectQuestion: Long? = null,
    @SerializedName("avgTimePerInCorrectQuestion") var avgTimePerInCorrectQuestion: Long? = null,
    @SerializedName("accuracy") var accuracy: Int? = null,
    @SerializedName("score") var score: Int? = null,
    @SerializedName("totalMarks") var totalMarks: Int? = null,
    @SerializedName("correct") var correct: Int? = null,
    @SerializedName("wrong") var wrong: Int? = null,
    @SerializedName("unattempted") var unattempted: Int? = null,
    @SerializedName("partialCorrect") var partialCorrect: Int? = null,
)

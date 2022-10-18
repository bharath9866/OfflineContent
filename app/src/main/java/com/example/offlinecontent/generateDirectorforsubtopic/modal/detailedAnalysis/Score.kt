package com.example.offlinecontent.generateDirectorforsubtopic.modal.detailedAnalysis

import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("topScore") var topScore: Int? = null,
    @SerializedName("lowestScore") var lowestScore: Int? = null,
    @SerializedName("score") var score: Int? = null,
    @SerializedName("avgScore") var avgScore: Double? = null,
)
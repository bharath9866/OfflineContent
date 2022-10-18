package com.example.offlinecontent.generateDirectorforsubtopic.modal.detailedAnalysis

import com.example.offlinecontent.generateDirectorforsubtopic.modal.detailedAnalysis.*
import com.google.gson.annotations.SerializedName

data class SubjectWise(
    @SerializedName("subjectId") var subjectId: Int? = null,
    @SerializedName("subjectName") var subjectName: String? = null,
    @SerializedName("isPartialMarkingEnabled") var isPartialMarkingEnabled: Boolean? = null,
    @SerializedName("dashboard") var dashboard: Dashboard? = Dashboard(),
    @SerializedName("score") var score: Score? = Score(),
    @SerializedName("ranks") var ranks: Ranks? = Ranks(),
    @SerializedName("chapterWiseReports") var chapterWiseReports: ArrayList<ChapterWiseReports> = arrayListOf(),
    @SerializedName("questionTypeReport") var questionTypeReport: ArrayList<QuestionTypeReport> = arrayListOf(),
)

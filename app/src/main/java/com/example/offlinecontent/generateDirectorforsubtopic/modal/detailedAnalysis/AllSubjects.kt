package com.example.offlinecontent.generateDirectorforsubtopic.modal.detailedAnalysis

import com.google.gson.annotations.SerializedName


data class AllSubjects(

    @SerializedName("dashboard") var dashboard: Dashboard? = Dashboard(),
    @SerializedName("score") var score: Score? = Score(),
    @SerializedName("ranks") var ranks: Ranks? = Ranks(),
    @SerializedName("subjectWiseReport") var subjectWiseReport: ArrayList<SubjectWiseReport> = arrayListOf(),
    @SerializedName("questionTypeReport") var questionTypeReport: ArrayList<QuestionTypeReport> = arrayListOf(),

    )

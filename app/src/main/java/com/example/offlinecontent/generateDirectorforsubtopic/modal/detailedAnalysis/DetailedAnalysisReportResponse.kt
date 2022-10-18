package com.example.offlinecontent.generateDirectorforsubtopic.modal.detailedAnalysis

import com.google.gson.annotations.SerializedName

data class DetailedAnalysisReportResponse(
    @SerializedName("status"  ) var status  : Boolean?        = null,
    @SerializedName("message" ) var message : String?         = null,
    @SerializedName("data"    ) var data    : ArrayList<Data> = arrayListOf()
)
data class Data (
    @SerializedName("paper"              ) var paper              : String?             = null,
    @SerializedName("scheduleId"         ) var scheduleId         : Int?                = null,
    @SerializedName("schedulewiseReport" ) var schedulewiseReport : ScheduleWiseReport? = ScheduleWiseReport()
)
data class ScheduleWiseReport (
    @SerializedName("allSubjects"                    ) var allSubjects                    : AllSubjects?                              = AllSubjects(),
    @SerializedName("subjectWise"                    ) var subjectWise                    : ArrayList<SubjectWise>                    = arrayListOf(),
    @SerializedName("questionwiseTimeAnalysisReport" ) var questionWiseTimeAnalysisReport : ArrayList<QuestionwiseTimeAnalysisReport> = arrayListOf()
)
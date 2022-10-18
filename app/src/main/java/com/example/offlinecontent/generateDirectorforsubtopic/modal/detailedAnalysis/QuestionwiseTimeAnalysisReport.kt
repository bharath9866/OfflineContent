package com.example.offlinecontent.generateDirectorforsubtopic.modal.detailedAnalysis

import com.google.gson.annotations.SerializedName

data class QuestionwiseTimeAnalysisReport(
    @SerializedName("SCHEDULE_ID") var scheduleId: Int? = null,
    @SerializedName("TEST_ID") var testId: Int? = null,
    @SerializedName("SPENT_TIME") var spentTime: Long? = null,
    @SerializedName("Que_SNO") var quesSno: Int? = null,
    @SerializedName("ATTEMPT_STATUS") var attemptStatus: String? = null,
    @SerializedName("SUBJECT_NAME") var subjectName: String? = null,
    @SerializedName("TOTAL_MARKS") var totalMarks:Int? = null,
    @SerializedName("ACHIEVED_MARKS") var achievedMarks:Int? = null,
)
package com.example.offlinecontent.generateDirectorforsubtopic.modal.detailedAnalysis

import com.google.gson.annotations.SerializedName


data class ChapterWiseReports(

    @SerializedName("chapterId") var chapterId: Int? = null,
    @SerializedName("chapterName") var chapterName: String? = null,
    @SerializedName("attempted") var attempted: Int? = null,
    @SerializedName("accuracy") var accuracy: Int? = null,
    @SerializedName("avgTimePerQuestion") var avgTimePerQuestion: Long? = null,
    @SerializedName("qcount") var qcount: Int? = null

)

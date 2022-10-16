package com.example.jetpackdemo.generateDirectorforsubtopic.modal.getUserSubjectsPerExam

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("childLevel") var childLevel: String? = "",
    @SerializedName("childNodes") var subjectNode: ArrayList<ChildNodes> = arrayListOf(),
    @SerializedName("examId") var examId: Int? = 0,
    @SerializedName("examName") var examName: String? = "",
    @SerializedName("examDisplayName") var examDisplayName: String? = "",
    @SerializedName("examDescription") var examDescription: String? = "",
    @SerializedName("parentLevel") var parentLevel: String? = "",
    @SerializedName("parentNode") var parentNode: ParentNode? = ParentNode()
)

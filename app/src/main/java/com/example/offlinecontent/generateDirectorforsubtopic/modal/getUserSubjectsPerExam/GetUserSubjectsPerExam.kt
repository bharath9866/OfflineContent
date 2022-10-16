package com.example.jetpackdemo.generateDirectorforsubtopic.modal.getUserSubjectsPerExam

import com.google.gson.annotations.SerializedName

data class GetUserSubjectsPerExam(
    @SerializedName("data"    ) var data    : Data?    = Data(),
    @SerializedName("message" ) var message : String?  = "",
    @SerializedName("status"  ) var status  : Boolean? = null
)

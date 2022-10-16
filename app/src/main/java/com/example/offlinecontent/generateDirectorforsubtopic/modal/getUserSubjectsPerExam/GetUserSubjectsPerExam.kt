package com.example.offlinecontent.generateDirectorforsubtopic.modal.getUserSubjectsPerExam

import com.example.offlinecontent.generateDirectorforsubtopic.modal.getUserSubjectsPerExam.Data
import com.google.gson.annotations.SerializedName

data class GetUserSubjectsPerExam(
    @SerializedName("data"    ) var data    : Data?    = Data(),
    @SerializedName("message" ) var message : String?  = "",
    @SerializedName("status"  ) var status  : Boolean? = null
)

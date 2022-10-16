package com.example.jetpackdemo.generateDirectorforsubtopic.modal.getuserchaptersforexamandsubject

import com.google.gson.annotations.SerializedName

data class GetUserChaptersForExamAndSubject(
    @SerializedName("data"    ) var data    : Data?    = Data(),
    @SerializedName("message" ) var message : String?  = null,
    @SerializedName("status"  ) var status  : Boolean? = null
)

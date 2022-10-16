package com.example.jetpackdemo.generateDirectorforsubtopic.modal.topicsandsubtopics

import com.google.gson.annotations.SerializedName

data class TopicsAndSubtopics(
    @SerializedName("data"    ) var data    : Data?    = Data(),
    @SerializedName("message" ) var message : String?  = "",
    @SerializedName("status"  ) var status  : Boolean? = null
)

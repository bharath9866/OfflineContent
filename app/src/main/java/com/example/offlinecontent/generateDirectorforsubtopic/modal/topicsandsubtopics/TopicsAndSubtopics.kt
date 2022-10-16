package com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandsubtopics

import com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandsubtopics.Data
import com.google.gson.annotations.SerializedName

data class TopicsAndSubtopics(
    @SerializedName("data"    ) var data    : Data?    = Data(),
    @SerializedName("message" ) var message : String?  = "",
    @SerializedName("status"  ) var status  : Boolean? = null
)

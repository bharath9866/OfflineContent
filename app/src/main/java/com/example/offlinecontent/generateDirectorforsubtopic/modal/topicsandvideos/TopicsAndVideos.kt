package com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandvideos

import com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandvideos.Data
import com.google.gson.annotations.SerializedName

data class TopicsAndVideos(
    @SerializedName("data"    ) var data    : Data?    = Data(),
    @SerializedName("message" ) var message : String?  = "",
    @SerializedName("status"  ) var status  : Boolean? = false
)
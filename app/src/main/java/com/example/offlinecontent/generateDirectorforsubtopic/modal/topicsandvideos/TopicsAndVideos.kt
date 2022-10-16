package com.example.jetpackdemo.generateDirectorforsubtopic.modal.topicsandvideos

import com.google.gson.annotations.SerializedName

data class TopicsAndVideos(
    @SerializedName("data"    ) var data    : Data?    = Data(),
    @SerializedName("message" ) var message : String?  = "",
    @SerializedName("status"  ) var status  : Boolean? = false
)
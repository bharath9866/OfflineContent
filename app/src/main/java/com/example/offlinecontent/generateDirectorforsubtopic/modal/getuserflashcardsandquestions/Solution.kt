package com.example.jetpackdemo.generateDirectorforsubtopic.modal.getuserflashcardsandquestions

import com.google.gson.annotations.SerializedName

data class Solution(
    @SerializedName("data") var data: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("_visible") var Visible: Boolean? = null
)

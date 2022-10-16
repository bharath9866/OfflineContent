package com.example.jetpackdemo.generateDirectorforsubtopic.modal.getuserflashcardsandquestions

import com.google.gson.annotations.SerializedName

data class Flashcards(
    @SerializedName("flashCardId") var flashCardId: String? = null,
    @SerializedName("flashcardType") var flashcardType: String? = null,
    @SerializedName("flashcardTypeId") var flashcardTypeId: Int? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("titleMedia") var titleMedia: String? = null,
    @SerializedName("summary") var summary: String? = null,
    @SerializedName("sequenceId") var sequenceId: Int? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("statusId") var statusId: String? = null,
    @SerializedName("questionIds") var questionIds: ArrayList<String>? = null
)

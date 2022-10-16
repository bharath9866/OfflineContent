package com.example.offlinecontent.generateDirectorforsubtopic.modal.getuserflashcardsandquestions

import com.google.gson.annotations.SerializedName

data class GetUserFlashCardsAndQuestions(
    @SerializedName("flashcards") var flashcards: ArrayList<Flashcards>? = null,
    @SerializedName("questions") var questions: ArrayList<Questions>? = null
)

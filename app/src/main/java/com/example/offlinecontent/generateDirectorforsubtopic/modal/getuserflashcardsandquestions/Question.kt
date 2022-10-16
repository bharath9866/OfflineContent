package com.example.offlinecontent.generateDirectorforsubtopic.modal.getuserflashcardsandquestions

import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("question_text") var questionText: String? = null,
    @SerializedName("answer_options") var answerOptions: ArrayList<String>? = arrayListOf(),
    @SerializedName("hints") var hints: ArrayList<Solution>? = null,
    @SerializedName("option_based_feedback") var optionBasedFeedback: ArrayList<String>? = arrayListOf(),
    @SerializedName("child_questions") var childQuestions: ArrayList<String>? = arrayListOf(),
    @SerializedName("correct_answer") var correctAnswer: ArrayList<String>? = arrayListOf(),
    @SerializedName("solution") var solution: ArrayList<Solution>? = arrayListOf()
)

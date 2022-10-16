package com.example.jetpackdemo.generateDirectorforsubtopic.modal.topicsandvideos

import com.google.gson.annotations.SerializedName

data class Subtopics (

	@SerializedName("nodeId") val nodeId : Int,
	@SerializedName("nodeName") val nodeName : String,
	@SerializedName("orderId") val orderId : Int,
	@SerializedName("seqNum") val seqNum : Int,
	@SerializedName("description") val description : String,
	@SerializedName("publishedFlashcardCount") val publishedFlashcardCount : Int,
	@SerializedName("publishedVideoCount") val publishedVideoCount : Int,
	@SerializedName("totalFlashcardCount") val totalFlashcardCount : Int,
	@SerializedName("totalVideoCount") val totalVideoCount : Int,
	@SerializedName("practiceProgress") val practiceProgress : String,
	@SerializedName("totalExercises") val totalExercises : String,
	@SerializedName("isCompleted") val isCompleted : String,
	@SerializedName("completedDate") val completedDate : String,
	@SerializedName("isBookmarked") val isBookmarked : String,
	@SerializedName("bookmarkedDate") val bookmarkedDate : String
)
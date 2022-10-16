package com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandvideos

import com.google.gson.annotations.SerializedName

data class Data (
	@SerializedName("topics" ) var topics : ArrayList<Topics>? = arrayListOf()
)
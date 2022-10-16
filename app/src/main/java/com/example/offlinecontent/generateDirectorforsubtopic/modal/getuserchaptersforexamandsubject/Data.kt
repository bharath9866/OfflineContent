package com.example.offlinecontent.generateDirectorforsubtopic.modal.getuserchaptersforexamandsubject

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("childLevel"      ) var childLevel      : String?               = null,
    @SerializedName("childNodes"      ) var chapterNodes      : ArrayList<ChildNodes> = arrayListOf(),
    @SerializedName("examId"          ) var examId          : Int?                  = null,
    @SerializedName("examName"        ) var examName        : String?               = null,
    @SerializedName("examDisplayName" ) var examDisplayName : String?               = null,
    @SerializedName("examDescription" ) var examDescription : String?               = null,
    @SerializedName("parentLevel"     ) var parentLevel     : String?               = null,
    @SerializedName("parentNode"      ) var parentNode      : ParentNode?           = ParentNode()
)

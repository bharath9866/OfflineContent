package com.example.offlinecontent.generateDirectorforsubtopic.modal.detailedAnalysis

import com.google.gson.annotations.SerializedName


data class Ranks (

    @SerializedName("airRank"         ) var airRank         : Int? = null,
    @SerializedName("stateRank"       ) var stateRank       : Int? = null,
    @SerializedName("cityRank"        ) var cityRank        : Int? = null,
    @SerializedName("branchRank"      ) var branchRank      : Int? = null,
    @SerializedName("orientationRank" ) var orientationRank : Int? = null,
    @SerializedName("sectionRank"     ) var sectionRank     : Int? = null

)

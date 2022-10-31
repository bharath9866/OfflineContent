package com.example.offlinecontent.generateDirectorforsubtopic.modal.tokenModal

import com.google.gson.annotations.SerializedName

data class UAMRequest(
    @SerializedName("uid") var uid: String? = null,
    @SerializedName("password") var password: String? = null,
){
    override fun toString(): String {
        return "{\r\n  \"uid\": ${this.uid},\r\n  \"password\": ${this.password}\r\n}"
    }
}


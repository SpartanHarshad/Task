package com.harshad.taskapp.data
import com.google.gson.annotations.SerializedName;

class Response {
    @SerializedName("id")
    var id: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("width")
    var width = 0

    @SerializedName("height")
    var height = 0
}
package com.example.necomplus.models

import com.fasterxml.jackson.annotation.JsonProperty

data class Image(    @JsonProperty("#text")
                     var text :String?,var size:String) {
}
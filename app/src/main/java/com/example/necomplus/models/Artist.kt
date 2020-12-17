package com.example.necomplus.models

data class Artist(var name:String,
                  var listeners:String,
                  var mbid:String,
                  var url:String,
                  var streamable:String,
                  var image : List<Image>) {
}



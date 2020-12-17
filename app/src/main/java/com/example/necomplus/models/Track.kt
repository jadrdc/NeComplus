package com.example.necomplus.models

data class Track(var name:String,
                 var playcount:String,
                 var listeners:String,
                 var mbid:String,
                 var url:String,
                 var streamable:String,
                 var artist:Artist,
                 var image : List<Image>)

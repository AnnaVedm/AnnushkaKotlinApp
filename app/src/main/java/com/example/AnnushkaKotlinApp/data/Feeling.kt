package com.example.AnnushkaKotlinApp.data

data class FeelingResponse(val success:Boolean,
                           val data: List<Feeling>)


data class Feeling(val id:Int, val title:String, val position:Int, val image:String)
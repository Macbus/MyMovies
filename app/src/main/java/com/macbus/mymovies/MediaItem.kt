package com.macbus.mymovies

import com.macbus.mymovies.MediaItem.*

data class MediaItem(
    val id: Int,
    val title: String,
    val thumb :String,
    val type: Type

){
    enum class Type {PHOTO, VIDEO}
}
fun getMedia() = (1..12).map{
    MediaItem(
        id = it,
        title = "Title $it",
        thumb = "https://loremflickr.com/400/400/$it/",
        type = if(it % 3==0) Type.VIDEO else Type.PHOTO
    )
}

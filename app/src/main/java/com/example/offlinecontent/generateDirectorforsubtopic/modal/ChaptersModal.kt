package com.example.offlinecontent.generateDirectorforsubtopic.modal

import com.example.offlinecontent.generateDirectorforsubtopic.modal.topicsandvideos.Chapter

data class ChaptersModal(
    var chapters: ArrayList<Chapter> = arrayListOf()
)

data class ChapterObj(
    var chapterId: Int? = null,
    var imageNum: ArrayList<String> = arrayListOf()
)

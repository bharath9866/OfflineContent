package com.example.offlinecontent.generateDirectorforsubtopic

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import io.github.techgnious.IVCompressor
import io.github.techgnious.dto.VideoFormats
import io.github.techgnious.utils.IVFileUtils
import java.io.File
import java.io.FileOutputStream


@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    println(x.arr.sortedBy { it })

    val ctx: Context

    val compressor = IVCompressor()

    val converter = compressor.convertVideoFormat(
        IVFileUtils.copyToByteArray(File("C:\\temp\\decryption\\1656659033217.mov")),
        VideoFormats.valueOf("mov"),
        VideoFormats.MP4
    )

    val out = FileOutputStream("C:\\temp\\conversion\\1656659033217.mp4")
    out.write(converter)
    out.close()

}

data class CompressingVideo(
    val id:Int = 0,
    val arr:ArrayList<Int> = arrayListOf()
)

val x = CompressingVideo(
    id = 0,
    arr = arrayListOf(3,2,4,1)
)
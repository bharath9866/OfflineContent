package com.example.offlinecontent.generateDirectorforsubtopic

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import io.github.techgnious.IVCompressor
import io.github.techgnious.dto.VideoFormats
import io.github.techgnious.utils.IVFileUtils
import java.io.File


@RequiresApi(Build.VERSION_CODES.O)
fun main() {

    val ctx: Context

    val compressor = IVCompressor()

    val outputStream = File("C:\\temp\\conversion\\1656659033217.mp4")

    val converter = compressor.convertVideoFormat(
        IVFileUtils.copyToByteArray(File("C:\\temp\\decryption\\1656659033217.mov")),
        VideoFormats.MOV,
        VideoFormats.MP4
    )


}

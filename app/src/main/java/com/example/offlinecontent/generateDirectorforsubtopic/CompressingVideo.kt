package com.example.offlinecontent.generateDirectorforsubtopic

import android.os.Build
import androidx.annotation.RequiresApi
import io.github.techgnious.IVCompressor
import net.bramp.ffmpeg.FFmpeg
import net.bramp.ffmpeg.FFprobe
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths


@RequiresApi(Build.VERSION_CODES.O)
fun main(){

    val file = File("")
    val compressor = IVCompressor()


    val filePath = "/path/to/file"

    // file to byte[], Path

    // file to byte[], Path
    val bytes: ByteArray = Files.readAllBytes(Paths.get(filePath))

//    compressor.convertVideoFormat(bytes)
//    val file = File("")
//    compressor.reduceVideoSize(file.getBytes(), VideoFormats.MP4, ResizeResolution.R480P);


    val ffmpeg = FFmpeg("/path/to/ffmpeg")
    val ffprobe = FFprobe("/path/to/ffprobe")
    
}

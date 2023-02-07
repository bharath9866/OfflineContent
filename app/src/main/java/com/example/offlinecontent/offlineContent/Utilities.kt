package com.example.offlinecontent.offlineContent

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.offlinecontent.generateDirectorforsubtopic.modal.detailedAnalysis.DetailedAnalysisReportResponse
import com.example.offlinecontent.offlineContent.Utilities.readJsonFile
import com.google.gson.Gson
import java.io.*
import java.nio.file.Files
import java.nio.file.Path
import java.util.*
import java.util.concurrent.TimeUnit

object Utilities {

    /**
     * @param readJsonFile Function is used to read Json to String From Local Storage.
     */
    fun File.readJsonFile(): String {

        val fis = FileInputStream(this)
        val inputStreamReader = DataInputStream(fis)
        val br = BufferedReader(InputStreamReader(inputStreamReader))
        val inputString = br.use { it.readText() }
        inputStreamReader.close()
        return inputString
    }

    /**
     * @param readJsonFile Function is used to read Json to String From Local Storage.
     */
    fun String.readJsonFile(): String {
        val fis = FileInputStream(File(this))
        val inputStreamReader = DataInputStream(fis)
        val br = BufferedReader(InputStreamReader(inputStreamReader))
        val inputString = br.use { it.readText() }
        inputStreamReader.close()
        return inputString
    }


    /**
     * @param writeJsonFile this function is used to write data in given File format for Local Storage.
     *
     *
     * For Example:
     *
     *
     *     [FilePath.writeJsonFile(Content of the File)]
     */
    fun File.writeJsonFile(content:String) {
        if(!this.exists()){
            println("$this :: " +this.createNewFile())
        }
        this.bufferedWriter().use { out ->
            out.write(content)
        }
    }

    /**
     * @param writeJsonFile this function is used to write data in given File format for Local Storage.
     *
     *
     * For Example:
     *
     *
     *     [FilePath.writeJsonFile(Content of the File)]
     */
    fun String.writeJsonFile(content:String) {
        if(!File(this).exists()){
            println("$this :: " +File(this).createNewFile())
        }
        File(this).bufferedWriter().use { out ->
            out.write(content)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createDirectory(directory: Path): List<Path> {
        return try {
            Files.createDirectory(directory).toList()
        } catch (e: Exception) {
            emptyList()
        }
    }


    /**
     * @param time function is used to get the current system time.
     */
    fun time(): Long {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())
    }


    fun timeToMilli(h: Int = 0, m: Int = 0, s: Int = 0): Long {
        val seconds = s * 1000L
        val minutes = m * 60000L
        val hours = h * 3600000L
        return seconds + minutes + hours
    }


    fun convertTimestampToString(timeInMs: Float): String {
        val totalSeconds = (timeInMs / 1000).toInt()
        val seconds = totalSeconds % 60
        val minutes = totalSeconds / 60 % 60
        val hours = totalSeconds / 3600
        val formatter = Formatter()
        return if (hours > 0) {
            formatter.format("%d:%02d:%02d", hours, minutes, seconds).toString()
        } else {
            formatter.format("%02d:%02d", minutes, seconds).toString()
        }
    }


}


fun main() {

    val file = File("C:\\Users\\Lenovo\\StudioProjects\\OfflineContent\\app\\src\\main\\java\\com\\example\\offlinecontent\\generateDirectorforsubtopic\\json\\DetailedReportJSON.json")

    val person = Gson().fromJson(file.readJsonFile(), DetailedAnalysisReportResponse::class.java)

    println(person.data[0].paper)

}
package com.example.offlinecontent

import java.io.File

fun main() {

    val str = "<math>\n" +
            "    <m:semantics>\n" +
            "      <m:mrow>\n" +
            "        <m:msup>\n" +
            "          <m:mrow>\n" +
            "            <m:mn>20</m:mn>\n" +
            "          </m:mrow>\n" +
            "          <m:mn>0</m:mn>\n" +
            "        </m:msup>\n" +
            "        <m:mi>C</m:mi>\n" +
            "        <m:mfenced>\n" +
            "          <m:mrow>\n" +
            "            <m:msub>\n" +
            "              <m:mi>&#x03B1;</m:mi>\n" +
            "              <m:mrow>\n" +
            "                <m:mi>s</m:mi>\n" +
            "                <m:mi>t</m:mi>\n" +
            "                <m:mi>e</m:mi>\n" +
            "                <m:mi>e</m:mi>\n" +
            "                <m:mi>l</m:mi>\n" +
            "              </m:mrow>\n" +
            "            </m:msub>\n" +
            "            <m:mo>=</m:mo>\n" +
            "            <m:mn>1.2</m:mn>\n" +
            "            <m:mo>&#x00D7;</m:mo>\n" +
            "            <m:msup>\n" +
            "              <m:mrow>\n" +
            "                <m:mn>10</m:mn>\n" +
            "              </m:mrow>\n" +
            "              <m:mrow>\n" +
            "                <m:mo>&#x2212;</m:mo>\n" +
            "                <m:mn>5</m:mn>\n" +
            "              </m:mrow>\n" +
            "            </m:msup>\n" +
            "            <m:mmultiscripts>\n" +
            "              <m:mi>C</m:mi>\n" +
            "              <m:mprescripts />\n" +
            "              <m:none />\n" +
            "              <m:mn>0</m:mn>\n" +
            "            </m:mmultiscripts>\n" +
            "            <m:msup>\n" +
            "              <m:mrow></m:mrow>\n" +
            "              <m:mrow>\n" +
            "                <m:mo>&#x2212;</m:mo>\n" +
            "                <m:mn>1</m:mn>\n" +
            "              </m:mrow>\n" +
            "            </m:msup>\n" +
            "          </m:mrow>\n" +
            "        </m:mfenced>\n" +
            "      </m:mrow>\n" +
            "    </m:semantics>\n" +
            "  </math>"

    str.forEach {
        println(it)
    }



}
























//    val files = File("Z:\\il-cms-assets-local\\media").listFiles()?.groupBy { it.extension }
//
//    println(files?.keys)
//    files?.keys?.forEach { key ->
//        println()
//        println(key)
//        files.getValue(key).forEach { value ->
//            println(value)
//        }
//    }
//
//
////    val processBuilder = ProcessBuilder("C:\\Users\\mkyong\\hello.bat")
//
////or
//
//
////or
//    val processBuilder = ProcessBuilder()
//    processBuilder.command("cmd", "/c", "hello.bat")
//    val dir = File("C:\\Users\\mkyong\\")
//    processBuilder.directory(dir)
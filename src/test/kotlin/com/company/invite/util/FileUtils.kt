package com.company.invite.util

import java.io.InputStream

object FileUtils {
    private val temporaryFolder = System.getProperty("java.io.tmpdir")

    fun loadFile(path: String): InputStream =
        this.javaClass.classLoader.getResourceAsStream(path)

    fun getFilePath(path: String): String =
        this.javaClass.classLoader.getResource(path).path

    fun getTempFilePath(filename: String): String =
        "${temporaryFolder}${filename}"
}
package me.kbrewster.config.methods

import java.io.File

interface SaveWriteMethod {

    fun save(file: File, data: HashMap<String, Any>)

    fun load(file: File): HashMap<String, Any>
}
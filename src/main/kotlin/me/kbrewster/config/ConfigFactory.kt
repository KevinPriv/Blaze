package me.kbrewster.config

import me.kbrewster.config.methods.JsonMethod
import java.io.File
import java.security.NoSuchAlgorithmException

object ConfigFactory {

    @JvmStatic @JvmOverloads
    fun createFileConfig(filePath: String, mode: String = "json"): Config {
        val file = File(filePath).apply {
            createNewFile()
        }
        return when(mode) {
            "json" -> FileConfiguration(JsonMethod(), file)
            "xml" -> TODO()
            "property" -> TODO()
            else -> throw NoSuchAlgorithmException("\'$mode\' is not valid!")
        }
    }

}
package me.kbrewster.config

import me.kbrewster.config.methods.SaveWriteMethod
import java.io.File

internal class FileConfiguration<T: SaveWriteMethod>(private val method: T, val file: File): Config {

    private val data = HashMap<String, Any>()

    override fun save() {
        this.method.save(file, data)
    }

    override fun load() {
        this.data.putAll(this.method.load(file))
    }

    override fun addConfig(config: Any) {
        this.data[config.javaClass.name] = config
    }

    override fun getConfig(config: Class<*>): Any? {
        return this.data[config.name] // commented as nullable makes more sense in this situation ?: throw ClassNotFoundException("Could not find class in loaded config.")
    }

    override fun removeConfig(config: Any) {
        this.data.remove(config.javaClass.name)
    }

    override fun removeConfig(config: Class<*>) {
        this.data.remove(config.name)
    }

    override fun getData(): Map<String, Any> {
        return this.data
    }


}
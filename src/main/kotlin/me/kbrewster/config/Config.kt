package me.kbrewster.config

import me.kbrewster.config.impl.Loadable
import me.kbrewster.config.impl.Saveable

interface Config: Saveable, Loadable {

    fun addConfig(config: Any)

    fun getConfig(config: Class<*>): Any?

    fun removeConfig(config: Any)

    fun removeConfig(config: Class<*>)

    fun getData(): Map<String, Any>
}
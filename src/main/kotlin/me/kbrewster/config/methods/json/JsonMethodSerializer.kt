package me.kbrewster.config.methods.json

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import me.kbrewster.config.Property
import java.lang.reflect.Type

class JsonMethodSerializer: JsonSerializer<Property<*>> {

    override fun serialize(src: Property<*>, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        return Gson().toJsonTree(src.value)
    }

}
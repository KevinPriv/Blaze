package me.kbrewster.config.methods

import com.google.gson.*
import java.io.File
import me.kbrewster.config.Property
import me.kbrewster.config.methods.json.JsonMethodDeserializer
import me.kbrewster.config.methods.json.JsonMethodExclusionStrategy
import me.kbrewster.config.methods.json.JsonMethodSerializer

class JsonMethod: SaveWriteMethod {

    private val gson = GsonBuilder()
            .addSerializationExclusionStrategy(JsonMethodExclusionStrategy())
            .registerTypeAdapter(Property::class.java, JsonMethodSerializer())
            .registerTypeAdapter(Property::class.java, JsonMethodDeserializer())
            .setPrettyPrinting()
            .create()

    override fun save(file: File, data: HashMap<String, Any>) {
        file.writeText(gson.toJson(data))
    }

    override fun load(file: File): HashMap<String, Any> {
        val jsonObj = JsonParser().parse(file.readText()).asJsonObject
        return HashMap<String, Any>().apply {
            jsonObj.keySet().forEach {
                this[it] = gson.fromJson(jsonObj.getAsJsonObject(it), Class.forName(it))
            }
        }
    }

}
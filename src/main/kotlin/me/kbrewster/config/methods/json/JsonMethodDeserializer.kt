package me.kbrewster.config.methods.json

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import me.kbrewster.config.Property
import java.lang.reflect.Type
import java.util.regex.Pattern

class JsonMethodDeserializer: JsonDeserializer<Property<*>> {

    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Property<*> {
        val typeName = typeOfT.typeName
        val pattern = Pattern.compile("<(.+)>")
        if(!pattern.matcher(typeName).find()) {
            return Property<Any>(Gson().fromJson(json, when  {
                json.isJsonPrimitive -> when {
                    json.asJsonPrimitive.isBoolean -> Boolean::class.java
                    json.asJsonPrimitive.isNumber -> Number::class.java
                    json.asJsonPrimitive.isString -> String::class.java
                    else -> throw UnsupportedOperationException("Primitive is unsupported. " +
                            "Did not come under boolean, number or string.")
                }
                else -> throw UnsupportedOperationException("Tried to save non primitive object. " +
                        "Currently unsupported for kotlin classes.")
            }))
        }
        return Property<Any>(Gson().fromJson(json, Class.forName(typeName.replace(Regex(".*<|>.*"), ""))))

    }
}
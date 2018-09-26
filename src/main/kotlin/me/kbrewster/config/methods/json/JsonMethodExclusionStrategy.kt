package me.kbrewster.config.methods.json

import com.google.gson.ExclusionStrategy
import com.google.gson.FieldAttributes
import me.kbrewster.config.Property

class JsonMethodExclusionStrategy: ExclusionStrategy {

    override fun shouldSkipClass(clazz: Class<*>) = false

    override fun shouldSkipField(f: FieldAttributes) = f.declaredClass != Property::class.java

}
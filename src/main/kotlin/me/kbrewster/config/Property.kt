package me.kbrewster.config

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


class Property<T>(var value: T): ReadWriteProperty<Any, T> {

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return this.value
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        this.value = value
    }
}

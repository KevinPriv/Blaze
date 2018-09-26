package me.kbrewster.eventbus

open class CancellableEvent: AbstractEvent() {

    var cancelled = false
        @JvmName("isCancelled") get

}
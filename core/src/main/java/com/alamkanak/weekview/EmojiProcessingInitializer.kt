package com.alamkanak.weekview

import android.content.Context
import androidx.emoji.text.EmojiCompat
import androidx.startup.Initializer

@Suppress("unused")
class EmojiProcessingInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        val emojiCompat = try {
            EmojiCompat.get()
        } catch (e: IllegalStateException) {
            null
        }
        val emojiProcessor: TextProcessor = { emojiCompat?.process(it) ?: it }
        TextProcessors.register(emojiProcessor)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}

package com.shootermind.app.core.locale

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat

object AppLocaleManager {
    fun setEnglish() {
        setLocale("en")
    }

    fun setMacedonian() {
        setLocale("mk")
    }

    private fun setLocale(languageTag: String) {
        AppCompatDelegate.setApplicationLocales(
            LocaleListCompat.forLanguageTags(languageTag)
        )
    }
}

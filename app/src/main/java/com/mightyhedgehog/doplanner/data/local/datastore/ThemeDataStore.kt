package com.mightyhedgehog.doplanner.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerStyle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val THEME_STORAGE_NAME = "theme_data"
val Context.themeDataStore: DataStore<Preferences> by preferencesDataStore(name = THEME_STORAGE_NAME)

class ThemeDataStore(private val dataStore: DataStore<Preferences>) {
    companion object {
        val STYLE_THEME_KEY = stringPreferencesKey("theme_style")
    }

    val getStyle: Flow<String?> = dataStore.data
        .map { preferences ->
            preferences[STYLE_THEME_KEY] ?: DoPlannerStyle.ORANGE.name
        }

    suspend fun saveStyle(style: String) {
        dataStore.edit { preferences ->
            preferences[STYLE_THEME_KEY] = style
        }
    }
}

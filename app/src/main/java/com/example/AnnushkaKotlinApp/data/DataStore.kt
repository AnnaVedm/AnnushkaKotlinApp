package com.example.AnnushkaKotlinApp.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")


class DataStore(val context: Context){
    val USER_EMAIL  = stringPreferencesKey("user_email")
    val emailFlow : Flow<String> = context.dataStore.data.map {
            preferences ->
        preferences[USER_EMAIL] ?: ""
    }
    val USER_NAME  = stringPreferencesKey("user_name")
    val nameFlow : Flow<String> = context.dataStore.data.map {
            preferences ->
        preferences[USER_NAME] ?: ""
    }
    val USER_AVATAR  = stringPreferencesKey("user_avatar")
    val avatarFlow : Flow<String> = context.dataStore.data.map {
            preferences ->
        preferences[USER_AVATAR] ?: ""
    }
    val USER_ID  = stringPreferencesKey("user_id")
    val idFlow : Flow<String> = context.dataStore.data.map {
            preferences ->
        preferences[USER_ID] ?: ""
    }
    val USER_TOKEN  = stringPreferencesKey("user_token")
    val tokenFlow : Flow<String> = context.dataStore.data.map {
            preferences ->
        preferences[USER_TOKEN] ?: ""
    }
    suspend fun setUser( user:User) {
        context.dataStore.edit { settings ->
            settings[USER_EMAIL] = user.email
            settings[USER_NAME] = user.nickName
            settings[USER_ID] = user.id
            settings[USER_AVATAR] = user.avatar
            settings[USER_TOKEN] = user.token
        }
    }
}
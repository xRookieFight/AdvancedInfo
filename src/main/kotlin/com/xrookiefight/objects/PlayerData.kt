package com.xrookiefight.objects

import java.util.UUID

data class PlayerData(
    val username: String,
    val address: String,
    val deviceId: String,
    val deviceModel: String,
    val deviceOS: String,
    val language: String,
    val xuid: String,
    val clientUUID: UUID,
    val clientID: Long
) {
    override fun toString(): String = super.toString()
}

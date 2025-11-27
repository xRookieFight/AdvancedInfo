package com.xrookiefight

import cn.nukkit.Player
import cn.nukkit.network.protocol.types.Platform
import cn.nukkit.plugin.PluginBase
import com.xrookiefight.command.PlayerInfoCommand
import com.xrookiefight.objects.PlayerData

class Main : PluginBase() {

    companion object {
        lateinit var instance: Main
            private set

        fun getPlayerData(player: Player) : PlayerData {
            return PlayerData(
                player.name,
                player.address,
                player.loginChainData.deviceId,
                player.loginChainData.deviceModel,
                Platform.getPlatformByID(player.loginChainData.deviceOS).name,
                player.languageCode.name,
                player.xuid,
                player.loginChainData.clientUUID,
                player.loginChainData.clientId
            )
        }
    }

    override fun onEnable() {
        instance = this
        server.commandMap.register("advancedinfo", PlayerInfoCommand())
    }
}
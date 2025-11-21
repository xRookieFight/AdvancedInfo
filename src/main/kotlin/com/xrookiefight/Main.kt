package com.xrookiefight

import cn.nukkit.Player
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
                getPlayerOS(player.loginChainData.deviceOS),
                player.languageCode.name,
                player.xuid,
                player.loginChainData.clientUUID,
                player.loginChainData.clientId
            )
        }

        fun getPlayerOS(deviceOS: Int) : String {
            return when (deviceOS) {
                -1 -> "Unknown"
                1 -> "Android"
                2 -> "IOS"
                3 -> "MacOS"
                4 -> "Amazon"
                5 -> "Samsung Gear VR"
                6 -> "Microsoft HoloLens"
                7 -> "Windows 10"
                8 -> "Windows 11"
                9 -> "Dedicated"
                10 -> "TvOS"
                11 -> "PlayStation"
                12 -> "Nintendo"
                13 -> "Xbox"
                else -> "Windows Phone"
            }
        }
    }

    override fun onEnable() {
        instance = this
        server.commandMap.register("advancedinfo", PlayerInfoCommand())
    }
}
package com.xrookiefight.command

import cn.nukkit.Player
import cn.nukkit.command.Command
import cn.nukkit.command.CommandSender
import com.xrookiefight.Main

class PlayerInfoCommand : Command(
    "advancedinfo",
    "Shows online player advanced information",
    "/advancedinfo <player>",
    arrayOf("playerinfo")
) {

    init { permission = "advancedinfo.command"}

    override fun execute(sender: CommandSender, commandLabel: String, args: Array<out String>?): Boolean {
        if (sender !is Player) {
            sender.sendMessage("§cThis command can only be executed in-game.")
            return false
        }

        if (args !== null && args.isNotEmpty()){
            val target = sender.server.getPlayer(args[0])

            if (target !== null){
                val playerData = Main.getPlayerData(target)
                sender.sendMessage("""
        §6§l=== PLAYER INFORMATION ===
        §r§eUsername: §f${playerData.username}
        §eIP Address: §f${playerData.address}
        §eDevice ID: §f${playerData.deviceId}
        §eDevice Model: §f${playerData.deviceModel}
        §eDevice OS: §f${playerData.deviceOS}
        §eLanguage: §f${playerData.language}
        §eXUID: §f${playerData.xuid}
        §eClient UUID: §f${playerData.clientUUID}
        §eClient ID: §f${playerData.clientID}
        §6§l=======================
    """.trimIndent())
                return true
            } else {
                sender.sendMessage("§cPlayer not found!")
            }
        } else {
            sender.sendMessage("§cUsage: §4$usage")
        }
        return false
    }
}

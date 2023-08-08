package net.nwtg.thermalapi.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class ThermalAPISaveGameTimeMsgProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((("\u00A76" + "[" + "ThermalAPI" + "] " + "\u00A7f" + "| ") + "" + ("\u00A76" + "[" + "ThermalAPI CMD" + "] "))), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((("\u00A79" + "config" + "\u00A7f" + ": ") + "This saves the game time to a config file.")), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((("\u00A79" + "nbtBlock <position>" + "\u00A7f" + ": ") + "This saves the game time to block nbt.")), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((("\u00A79" + "nbtBlock <entity>" + "\u00A7f" + ": ") + "This saves the game time to entity nbt.")), false);
	}
}

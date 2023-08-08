package net.nwtg.thermalapi.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class TemperatureMsgProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((("\u00A76" + "[" + "ThermalAPI" + "] " + "\u00A7f" + "| ") + "" + ("\u00A76" + "[" + "Temperature CMD" + "] "))), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((("\u00A79" + "time" + "\u00A7f" + ": ") + "The root command for time temperature.")), false);
	}
}

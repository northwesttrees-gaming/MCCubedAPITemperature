package net.nwtg.thermalapi.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class TemperatureTimeGetMsgProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((("\u00A76" + "[" + "ThermalAPI" + "] " + "\u00A7f" + "| ") + "" + ("\u00A76" + "[" + "Temperature CMD" + "] "))), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((("\u00A79" + "increment" + "\u00A7f" + ": ") + "Gets the increment time temperature value.")), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((("\u00A79" + "shift" + "\u00A7f" + ": ") + "Gets the shift time temperature value.")), false);
	}
}

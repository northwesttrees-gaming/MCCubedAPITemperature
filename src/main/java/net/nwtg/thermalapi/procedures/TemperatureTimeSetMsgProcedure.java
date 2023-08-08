package net.nwtg.thermalapi.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class TemperatureTimeSetMsgProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((("\u00A76" + "[" + "ThermalAPI" + "] " + "\u00A7f" + "| ") + "" + ("\u00A76" + "[" + "Temperature CMD" + "] "))), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((("\u00A79" + "increment <value>" + "\u00A7f" + ": ") + "Sets the increment time temperature value.")), false);
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((("\u00A79" + "shift <value>" + "\u00A7f" + ": ") + "Sets the shift time temperature value.")), false);
	}
}

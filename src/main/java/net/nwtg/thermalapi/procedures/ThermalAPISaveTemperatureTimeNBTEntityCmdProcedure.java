package net.nwtg.thermalapi.procedures;

import net.nwtg.thermalapi.network.ThermalapiModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class ThermalAPISaveTemperatureTimeNBTEntityCmdProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		double temperature = 0;
		temperature = ThermalapiModVariables.WorldVariables.get(world).worldTimeTemperature;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "entity")) {
				entityiterator.getPersistentData().putDouble("thermalapiTimeTemperature", temperature);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}

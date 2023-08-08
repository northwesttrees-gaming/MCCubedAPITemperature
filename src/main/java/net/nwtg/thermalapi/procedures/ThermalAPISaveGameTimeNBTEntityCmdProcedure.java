package net.nwtg.thermalapi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class ThermalAPISaveGameTimeNBTEntityCmdProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		double gameTime = 0;
		gameTime = world.dayTime() % 24000;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "entity")) {
				entityiterator.getPersistentData().putDouble("thermalapiGameTime", gameTime);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}

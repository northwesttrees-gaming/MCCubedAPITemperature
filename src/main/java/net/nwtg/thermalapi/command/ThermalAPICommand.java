
package net.nwtg.thermalapi.command;

import org.checkerframework.checker.units.qual.s;

import net.nwtg.thermalapi.procedures.ThermalAPISaveTemperatureTimeNBTEntityCmdProcedure;
import net.nwtg.thermalapi.procedures.ThermalAPISaveTemperatureTimeNBTBlockCmdProcedure;
import net.nwtg.thermalapi.procedures.ThermalAPISaveTemperatureTimeMsgProcedure;
import net.nwtg.thermalapi.procedures.ThermalAPISaveTemperatureTimeConfigCmdProcedure;
import net.nwtg.thermalapi.procedures.ThermalAPISaveTemperatureMsgProcedure;
import net.nwtg.thermalapi.procedures.ThermalAPISaveMsgProcedure;
import net.nwtg.thermalapi.procedures.ThermalAPISaveGameTimeNBTEntityCmdProcedure;
import net.nwtg.thermalapi.procedures.ThermalAPISaveGameTimeNBTBlockCmdProcedure;
import net.nwtg.thermalapi.procedures.ThermalAPISaveGameTimeMsgProcedure;
import net.nwtg.thermalapi.procedures.ThermalAPISaveGameTimeConfigCmdProcedure;
import net.nwtg.thermalapi.procedures.ThermalAPISaveGameMsgProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

@Mod.EventBusSubscriber
public class ThermalAPICommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("thermalapi").requires(s -> s.hasPermission(3)).then(Commands.literal("game").then(Commands.literal("time").then(Commands.literal("config").executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			ThermalAPISaveGameTimeConfigCmdProcedure.execute(world);
			return 0;
		})).then(Commands.literal("nbtBlock").then(Commands.argument("position", BlockPosArgument.blockPos()).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			ThermalAPISaveGameTimeNBTBlockCmdProcedure.execute(world, arguments);
			return 0;
		}))).then(Commands.literal("nbtEntity").then(Commands.argument("entity", EntityArgument.entities()).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			ThermalAPISaveGameTimeNBTEntityCmdProcedure.execute(world, arguments);
			return 0;
		}))).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			ThermalAPISaveGameTimeMsgProcedure.execute(entity);
			return 0;
		})).then(Commands.literal("temperature").then(Commands.literal("time").then(Commands.literal("config").executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			ThermalAPISaveTemperatureTimeConfigCmdProcedure.execute(world);
			return 0;
		})).then(Commands.literal("nbtBlock").then(Commands.argument("position", BlockPosArgument.blockPos()).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			ThermalAPISaveTemperatureTimeNBTBlockCmdProcedure.execute(world, arguments);
			return 0;
		}))).then(Commands.literal("nbtEntity").then(Commands.argument("entity", EntityArgument.entities()).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			ThermalAPISaveTemperatureTimeNBTEntityCmdProcedure.execute(world, arguments);
			return 0;
		}))).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			ThermalAPISaveTemperatureTimeMsgProcedure.execute(entity);
			return 0;
		})).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			ThermalAPISaveTemperatureMsgProcedure.execute(entity);
			return 0;
		})).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			ThermalAPISaveGameMsgProcedure.execute(entity);
			return 0;
		})).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			ThermalAPISaveMsgProcedure.execute(entity);
			return 0;
		}));
	}
}

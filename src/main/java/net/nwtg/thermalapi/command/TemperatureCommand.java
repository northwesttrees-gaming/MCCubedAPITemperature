
package net.nwtg.thermalapi.command;

import org.checkerframework.checker.units.qual.s;

import net.nwtg.thermalapi.procedures.TemperatureTimeSetShiftCmdProcedure;
import net.nwtg.thermalapi.procedures.TemperatureTimeSetMsgProcedure;
import net.nwtg.thermalapi.procedures.TemperatureTimeSetIncrementCmdProcedure;
import net.nwtg.thermalapi.procedures.TemperatureTimeMsgProcedure;
import net.nwtg.thermalapi.procedures.TemperatureTimeGetShiftCmdProcedure;
import net.nwtg.thermalapi.procedures.TemperatureTimeGetMsgProcedure;
import net.nwtg.thermalapi.procedures.TemperatureTimeGetIncrementCmdProcedure;
import net.nwtg.thermalapi.procedures.TemperatureMsgProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;

import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class TemperatureCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("temperature").requires(s -> s.hasPermission(3)).then(Commands.literal("time").then(Commands.literal("get").then(Commands.literal("increment").executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			TemperatureTimeGetIncrementCmdProcedure.execute(world, entity);
			return 0;
		})).then(Commands.literal("shift").executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			TemperatureTimeGetShiftCmdProcedure.execute(world, entity);
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

			TemperatureTimeGetMsgProcedure.execute(entity);
			return 0;
		})).then(Commands.literal("set").then(Commands.literal("increment").then(Commands.argument("value", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			TemperatureTimeSetIncrementCmdProcedure.execute(world, arguments, entity);
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

			TemperatureTimeSetMsgProcedure.execute(entity);
			return 0;
		})).then(Commands.literal("shift").then(Commands.argument("value", DoubleArgumentType.doubleArg(-12000, 12000)).executes(arguments -> {
			ServerLevel world = arguments.getSource().getLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null)
				entity = FakePlayerFactory.getMinecraft(world);
			Direction direction = entity.getDirection();

			TemperatureTimeSetShiftCmdProcedure.execute(world, arguments, entity);
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

			TemperatureTimeSetMsgProcedure.execute(entity);
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

			TemperatureTimeSetMsgProcedure.execute(entity);
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

			TemperatureTimeMsgProcedure.execute(entity);
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

			TemperatureMsgProcedure.execute(entity);
			return 0;
		}));
	}
}

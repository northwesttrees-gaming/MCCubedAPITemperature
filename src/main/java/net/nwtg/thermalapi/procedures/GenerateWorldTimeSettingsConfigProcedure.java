package net.nwtg.thermalapi.procedures;

import net.nwtg.thermalapi.network.ThermalapiModVariables;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.File;

public class GenerateWorldTimeSettingsConfigProcedure {
	public static void execute(LevelAccessor world) {
		File file = new File("");
		com.google.gson.JsonObject mainObject = new com.google.gson.JsonObject();
		if (!world.isClientSide()) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/thermalapi/maps/"
					+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "/worlds/"
					+ ThermalapiModVariables.WorldVariables.get(world).worldWeatherName), File.separator + "time_temperature_settings.json");
			if (!file.exists()) {
				try {
					file.getParentFile().mkdirs();
					file.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				mainObject.addProperty("shift", 0);
				mainObject.addProperty("increment", 0.5);
			}
		}
	}
}

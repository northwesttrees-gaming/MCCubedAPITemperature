package net.nwtg.thermalapi.procedures;

import net.nwtg.thermalapi.network.ThermalapiModVariables;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

@Mod.EventBusSubscriber
public class WorldTimeTemperatureProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		File file = new File("");
		com.google.gson.JsonObject mainObject = new com.google.gson.JsonObject();
		double timeShift = 0;
		double timeIncrement = 0;
		double worldTime = 0;
		double timePeriod = 0;
		double timeOffset = 0;
		if (!world.isClientSide()) {
			file = new File((FMLPaths.GAMEDIR.get().toString() + "/config/thermalapi/maps/"
					+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "/worlds/"
					+ ThermalapiModVariables.WorldVariables.get(world).worldWeatherName), File.separator + "time_temperature_settings.json");
			if (file.exists()) {
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						mainObject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						timeShift = mainObject.get("shift").getAsDouble();
						timeIncrement = mainObject.get("increment").getAsDouble();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				timePeriod = 0;
				timeOffset = 0;
				worldTime = world.dayTime() % 24000;
				for (int index0 = 0; index0 < 96; index0++) {
					if (worldTime >= timePeriod && worldTime < timePeriod + 250) {
						ThermalapiModVariables.WorldVariables.get(world).worldTimeTemperature = (timeOffset + timeShift) - timeIncrement * 12;
						ThermalapiModVariables.WorldVariables.get(world).syncData(world);
						break;
					} else {
						if (timePeriod >= 21000 && timePeriod < 24000 || timePeriod >= 0 && timePeriod < 9000) {
							timeOffset = timeOffset + timeIncrement;
						} else if (timePeriod >= 9000 && timePeriod < 21000) {
							timeOffset = timeOffset - timeIncrement;
						}
						timePeriod = timePeriod + 250;
					}
				}
			}
		}
	}
}

package net.nwtg.thermalapi.procedures;

import net.nwtg.thermalapi.network.ThermalapiModVariables;
import net.nwtg.thermalapi.ThermalapiMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SetWorldFileNameProcedure {
	@SubscribeEvent
	public static void onWorldLoad(net.minecraftforge.event.level.LevelEvent.Load event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		String dimensionID = "";
		double substring = 0;
		if ((ThermalapiModVariables.WorldVariables.get(world).worldWeatherName).isEmpty()) {
			substring = 0;
			dimensionID = "" + (world instanceof Level _lvl ? _lvl.dimension() : Level.OVERWORLD);
			for (int index0 = 0; index0 < (int) ((dimensionID).length() - 2); index0++) {
				if ((dimensionID.substring((int) substring, (int) (substring + 2))).equals("/ ")) {
					dimensionID = dimensionID.substring((int) (substring + 2), (int) ((dimensionID).length() - 1));
					dimensionID = dimensionID.replace(":", "_");
					ThermalapiMod.LOGGER.info("TemperatureAPI: " + "Generated a new dimensionID for a world called: " + dimensionID);
					break;
				}
				substring = substring + 1;
			}
			ThermalapiModVariables.WorldVariables.get(world).worldWeatherName = dimensionID;
			ThermalapiModVariables.WorldVariables.get(world).syncData(world);
		}
		if (!(ThermalapiModVariables.WorldVariables.get(world).worldWeatherName).isEmpty()) {
			GenerateWorldTimeSettingsConfigProcedure.execute(world);
		}
	}
}

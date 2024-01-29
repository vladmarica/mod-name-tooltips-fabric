package com.vladmarica.modnametooltips;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.util.Identifier;

public class ModNameTooltips implements ClientModInitializer {

	private final Identifier POST_DEFAULT_PHASE = new Identifier("modnametooltips", "postdefault");

	@Override
	public void onInitializeClient() {
		// Register a new event phase for the ItemTooltipCallback event that runs after the default phase
		// This is to ensure that the mod name line is the last line in the tooltip
		ItemTooltipCallback.EVENT.addPhaseOrdering(Event.DEFAULT_PHASE, POST_DEFAULT_PHASE);
		ItemTooltipCallback.EVENT.register(POST_DEFAULT_PHASE, new ModNameItemTooltipCallback());
	}
}

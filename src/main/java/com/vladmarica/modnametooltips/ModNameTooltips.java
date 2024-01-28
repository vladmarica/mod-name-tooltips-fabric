package com.vladmarica.modnametooltips;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;


public class ModNameTooltips implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ItemTooltipCallback.EVENT.register(new ModNameItemTooltipCallback());
	}
}
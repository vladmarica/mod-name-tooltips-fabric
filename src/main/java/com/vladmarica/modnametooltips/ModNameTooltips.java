package com.vladmarica.modnametooltips;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ModNameTooltips implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("mod-name-tooltips-fabric");

	@Override
	public void onInitializeClient() {
		ItemTooltipCallback.EVENT.register(new ModNameItemTooltipCallback());
	}
}
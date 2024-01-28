package com.vladmarica.modnametooltips;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.commons.lang3.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModNameItemTooltipCallback implements ItemTooltipCallback {

    private static final Style STYLE = Style.EMPTY.withColor(Formatting.BLUE).withItalic(true);

    private final Map<String, String> modIdToNameCache;

    public ModNameItemTooltipCallback() {
        modIdToNameCache = new HashMap<>();
        for (ModContainer modContainer : FabricLoader.getInstance().getAllMods()) {
            modIdToNameCache.put(modContainer.getMetadata().getId(),  modContainer.getMetadata().getName());
        }
    }

    @Override
    public void getTooltip(ItemStack stack, TooltipContext context, List<Text> lines) {
        Identifier id = Registry.ITEM.getId(stack.getItem());
        String modName = modIdToNameCache.getOrDefault(id.getNamespace(), StringUtils.capitalize(id.getNamespace()));

        for (Text existingLine : lines) {
            if (modName.equals(existingLine.getString().trim())) {
                return;
            }
        }

        lines.addAll(Text.of(modName).getWithStyle(STYLE));
    }
}

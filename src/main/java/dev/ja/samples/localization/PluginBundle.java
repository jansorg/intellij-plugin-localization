package dev.ja.samples.localization;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

public class PluginBundle extends DynamicPluginBundle {
    public static final PluginBundle INSTANCE = new PluginBundle();

    @NotNull
    public static String get(@NotNull @PropertyKey(resourceBundle = "messages.pluginBundle") String key, Object @NotNull ... params) {
        return INSTANCE.getMessage(key, params);
    }

    private PluginBundle() {
        super("messages.pluginBundle");
    }
}

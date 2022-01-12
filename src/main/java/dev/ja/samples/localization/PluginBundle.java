package dev.ja.samples.localization;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

import java.util.function.Supplier;

public class PluginBundle extends DynamicPluginBundle {
    public static final PluginBundle INSTANCE = new PluginBundle();

    public static @NotNull String get(@NotNull @PropertyKey(resourceBundle = "messages.pluginBundle") String key,
                                      Object @NotNull ... params) {
        return INSTANCE.getMessage(key, params);
    }

    public static @NotNull Supplier<@Nls String> lazy(@NotNull @PropertyKey(resourceBundle = "messages.pluginBundle") String key,
                                                      Object @NotNull ... params) {
        return INSTANCE.getLazyMessage(key, params);
    }

    private PluginBundle() {
        super("messages.pluginBundle");
    }
}

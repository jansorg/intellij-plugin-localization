package dev.ja.samples.localization;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.ui.components.JBLabel;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Localized configurable.
 * Make sure to override getDisplayName().
 */
public class SampleConfigurable implements Configurable {
    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return PluginBundle.get("configurable.label");
    }

    @Override
    public @Nullable JComponent createComponent() {
        return new JBLabel(PluginBundle.get("configurable.form.label"));
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() throws ConfigurationException {
    }
}

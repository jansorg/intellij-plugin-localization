package dev.ja.samples.localization;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

import static dev.ja.samples.localization.PluginBundle.lazy;

public class SampleAction extends AnAction {
    public SampleAction() {
        super(lazy("action.dev.ja.sampleAction.text"), lazy("action.dev.ja.sampleAction.description"), null);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        var message = PluginBundle.get("sampleAction.message");
        var title = PluginBundle.get("sampleAction.title");
        Messages.showInfoMessage(message, title);
    }
}

package dev.ja.samples.localization;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class SampleAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        var message = PluginBundle.get("sampleAction.message");
        var title = PluginBundle.get("sampleAction.title");
        Messages.showInfoMessage(message, title);
    }
}

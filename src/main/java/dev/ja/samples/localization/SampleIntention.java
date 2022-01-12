package dev.ja.samples.localization;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;

public class SampleIntention extends BaseIntentionAction {
    public SampleIntention() {
        setText(PluginBundle.get("sampleIntention.text"));
    }

    @Override
    public @NotNull @IntentionFamilyName String getFamilyName() {
        return PluginBundle.get("sampleIntention.familyName");
    }

    @Override
    public boolean startInWriteAction() {
        return false;
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
        return true;
    }

    @Override
    public void invoke(@NotNull Project project, Editor editor, PsiFile file) throws IncorrectOperationException {
        var message = PluginBundle.get("sampleIntention.message");
        var title = PluginBundle.get("sampleIntention.title");
        Messages.showInfoMessage(message, title);
    }
}

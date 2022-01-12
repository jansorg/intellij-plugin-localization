package dev.ja.samples.localization;

import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.XmlElementVisitor;
import com.intellij.psi.xml.XmlText;
import org.jetbrains.annotations.NotNull;

/**
 * Inspection which follows IntelliJ's default.
 * Due to the limitations of the SDK it's not fully localized.
 */
public class SampleInspection extends LocalInspectionTool {
    @Override
    public @NotNull PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly, @NotNull LocalInspectionToolSession session) {
        return new XmlElementVisitor() {
            @Override
            public void visitXmlText(XmlText text) {
                holder.registerProblem(text, PluginBundle.get("sampleInspection.warning"));
            }
        };
    }
}

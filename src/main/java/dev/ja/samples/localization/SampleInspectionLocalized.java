package dev.ja.samples.localization;

import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.lang.LangBundle;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.XmlElementVisitor;
import com.intellij.psi.xml.XmlText;
import com.intellij.util.ResourceUtil;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

/**
 * Hacked inspection to support localized inspection name, group name, and description.
 */
public class SampleInspectionLocalized extends LocalInspectionTool {
    @Override
    public @Nls(capitalization = Nls.Capitalization.Sentence) @NotNull String getDisplayName() {
        return PluginBundle.get("sampleInspectionLocalized.name");
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Sentence) @NotNull String getGroupDisplayName() {
        return PluginBundle.get("sampleInspectionLocalized.group");
    }

    @Override
    public @NotNull PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly, @NotNull LocalInspectionToolSession session) {
        return new XmlElementVisitor() {
            @Override
            public void visitXmlText(XmlText text) {
                holder.registerProblem(text, PluginBundle.get("sampleInspectionLocalized.warning"));
            }
        };
    }

    /**
     * Loads the HTML description file from `inspectionDescriptions_<language code>.
     * <p>
     * For example: <code>inspectionDescriptions_zh/myInspectionId.html</code>
     * <p>
     * fixme: this is a hack to get a localized inspection description.
     *   This will only work if you configure hasStaticDescription="true" in plugin.xml
     */
    @Override
    public @Nullable @Nls String getStaticDescription() {
        var locale = LangBundle.getLocale();
        if (!locale.equals(Locale.ENGLISH)) {
            var description = loadDescription(locale.getLanguage());
            if (description != null) {
                return description;
            }
        }
        return super.getStaticDescription();
    }

    private @Nullable String loadDescription(@NotNull String suffix) {
        try {
            var folderName = "inspectionDescriptions_" + suffix;
            var fileName = getShortName() + ".html";
            var stream = ResourceUtil.getResourceAsStream(SampleInspectionLocalized.class.getClassLoader(), folderName, fileName);
            return stream == null ? null : ResourceUtil.loadText(stream);
        } catch (Exception e) {
            // fixme better handle this in production code
            return null;
        }
    }
}

package lk.chathurabuddi.file.type.jrxml;

import com.intellij.openapi.fileTypes.LanguageFileType;
import lk.chathurabuddi.util.JrxmlIcons;
import lk.chathurabuddi.lang.jrxml.JrxmlLanguage;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class JrxmlFileType extends LanguageFileType {
    public static final JrxmlFileType INSTANCE = new JrxmlFileType();

    private JrxmlFileType() {
        super(JrxmlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Jasper source file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Jasper report source file, written in XML";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "jrxml";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return JrxmlIcons.FILE;
    }
}

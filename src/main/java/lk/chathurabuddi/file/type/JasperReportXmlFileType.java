package lk.chathurabuddi.file.type;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import lk.chathurabuddi.lang.JasperReportXmlLanguage;
import lk.chathurabuddi.util.Icons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Copyright (c) 2018 KPMG Technology Solutions
 *
 * @author chathurabuddi
 * @version 1.0.0
 */
public class JasperReportXmlFileType extends LanguageFileType {

    public static final JasperReportXmlFileType INSTANCE = new JasperReportXmlFileType();

    private JasperReportXmlFileType() {
        super(JasperReportXmlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Jasper Report XML file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Jasper Report XML source file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "jrxml";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Icons.JRXML;
    }
}

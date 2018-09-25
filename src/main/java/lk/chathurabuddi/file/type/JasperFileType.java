package lk.chathurabuddi.file.type;

import com.intellij.openapi.fileTypes.LanguageFileType;
import lk.chathurabuddi.lang.JasperLanguage;
import lk.chathurabuddi.util.Icons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.Icon;


/**
 * Copyright (c) 2018 KPMG Technology Solutions
 *
 * @author chathurabuddi
 * @version 1.0.0
 */
public class JasperFileType extends LanguageFileType {

    public static final JasperFileType INSTANCE = new JasperFileType();

    private JasperFileType() {
        super(JasperLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Jasper file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Jasper Report compiled file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "jasper";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return Icons.JASPER;
    }
}

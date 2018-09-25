package lk.chathurabuddi.lang;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2018 KPMG Technology Solutions
 *
 * @author chathurabuddi
 * @version 1.0.0
 */
public class JasperLanguage extends Language {

    public static final JasperLanguage INSTANCE = new JasperLanguage();

    private JasperLanguage() {
        super("Jasper");
    }
}

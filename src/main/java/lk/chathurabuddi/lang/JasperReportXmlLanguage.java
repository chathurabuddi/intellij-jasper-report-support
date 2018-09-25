package lk.chathurabuddi.lang;

import com.intellij.lang.Language;

/**
 * Copyright (c) 2018 KPMG Technology Solutions
 *
 * @author chathurabuddi
 * @version 1.0.0
 */
public class JasperReportXmlLanguage extends Language {

    public static final JasperReportXmlLanguage INSTANCE = new JasperReportXmlLanguage();

    private JasperReportXmlLanguage() {
        super("JasperReportXml");
    }
}

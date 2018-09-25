package lk.chathurabuddi.file;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import lk.chathurabuddi.file.type.JasperFileType;
import lk.chathurabuddi.file.type.JasperReportXmlFileType;
import org.jetbrains.annotations.NotNull;

/**
 * Copyright (c) 2018 KPMG Technology Solutions
 *
 * @author chathurabuddi
 * @version 1.0.0
 */
public class JasperReportFileTypeFactory extends FileTypeFactory {

    @Override
    public void createFileTypes(@NotNull FileTypeConsumer consumer) {
        consumer.consume(JasperFileType.INSTANCE, JasperFileType.INSTANCE.getDefaultExtension());
        consumer.consume(JasperReportXmlFileType.INSTANCE, JasperReportXmlFileType.INSTANCE.getDefaultExtension());
    }
}

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Chathura Buddhika
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package lk.chathurabuddi.lang.jrxml.autocomplete;

import java.net.URL;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.xml.XmlFile;
import com.intellij.xml.XmlSchemaProvider;
import lk.chathurabuddi.file.type.jrxml.JrxmlFileTypeFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JrxmlSchemaProvider extends XmlSchemaProvider {
    private static final Logger LOG = Logger.getInstance(JrxmlSchemaProvider.class);

    @Override
    public boolean isAvailable(final @NotNull XmlFile file) {
        return JrxmlFileTypeFactory.isJrxml(file);
    }

    @Nullable
    @Override
    public XmlFile getSchema(@NotNull String url, @Nullable Module module, @NotNull PsiFile baseFile) {
        return module != null && JrxmlFileTypeFactory.isJrxml(baseFile) ? getReference(module) : null;
    }

    private static XmlFile getReference(@NotNull Module module) {
        final URL resource = JrxmlSchemaProvider.class.getResource("/lk/chathurabuddi/xsd/jasperreport.xsd");
        final VirtualFile fileByURL = VfsUtil.findFileByURL(resource);
        if (fileByURL == null) {
            LOG.error("xsd not found");
            return null;
        }

        PsiFile psiFile = PsiManager.getInstance(module.getProject()).findFile(fileByURL);
        LOG.assertTrue(psiFile != null);
        return (XmlFile)psiFile.copy();
    }
}

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

package lk.chathurabuddi.file.type.jrxml;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class JrxmlFileTypeFactory {

    @NonNls public static final String JRXML_EXTENSION = "jrxml";
    @NonNls static final String DOT_JRXML_EXTENSION = "." + JRXML_EXTENSION;

    public static boolean isJrxml(@NotNull PsiFile file) {
        final VirtualFile virtualFile = file.getViewProvider().getVirtualFile();
        return isJrxml(virtualFile);
    }

    public static boolean isJrxml(@NotNull VirtualFile virtualFile) {
        if (JRXML_EXTENSION.equals(virtualFile.getExtension())) {
            final FileType fileType = virtualFile.getFileType();
            if (fileType == getFileType() && !fileType.isBinary()) {
                return virtualFile.getName().endsWith(DOT_JRXML_EXTENSION);
            }
        }
        return false;
    }

    @NotNull
    public static FileType getFileType() {
        return FileTypeManager.getInstance().getFileTypeByExtension(JRXML_EXTENSION);
    }
}

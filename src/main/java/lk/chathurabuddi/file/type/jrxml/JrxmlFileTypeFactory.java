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

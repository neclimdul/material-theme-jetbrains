/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015-2021 Elior "Mallowigi" Boukhobza
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */
package com.mallowigi.idea.tree

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.projectView.ProjectViewNode
import com.intellij.ide.projectView.ProjectViewNodeDecorator
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.packageDependencies.ui.PackageDependenciesNode
import com.intellij.ui.ColoredTreeCellRenderer
import com.mallowigi.idea.config.MTFileColorsPage
import com.mallowigi.idea.config.application.MTConfig

/**
 * Colored folders node decorator
 *
 */
class MTColoredFoldersNodeDecorator : ProjectViewNodeDecorator {
  override fun decorate(node: PackageDependenciesNode, cellRenderer: ColoredTreeCellRenderer) {
    // do nothing
  }

  override fun decorate(node: ProjectViewNode<*>, data: PresentationData) {
    val file = node.virtualFile ?: return

    if (MTConfig.getInstance().isStyledDirectories) applyDirectoriesColor(data, file)
  }

  private fun applyDirectoriesColor(data: PresentationData, file: VirtualFile) {
    if (file.isDirectory) data.setAttributesKey(MTFileColorsPage.DIRECTORIES)
  }
}

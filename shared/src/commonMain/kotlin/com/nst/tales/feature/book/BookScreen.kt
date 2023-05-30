package com.nst.tales.feature.book

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.domain.model.ChapterModel
import com.nst.tales.design.scaffold.GradientScaffold
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.accent3
import com.nst.tales.feature.book.inner.PageComponent

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun BookScreen(
    bookModel: BookModel,
) {
    GradientScaffold {
        BoxWithConstraints(Modifier.fillMaxSize()) {
            val height = this.maxHeight

            val listState = rememberLazyListState()
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(AppTheme.indents.x0),
                flingBehavior = rememberSnapFlingBehavior(lazyListState = listState),
            ) {
                item {
                    FirstCover(height)
                }
                items(bookModel.chapters) {
                    Page(height, it)
                }
                item {
                    LastCover(height)
                }
            }
        }
    }
}

@Composable
private fun FirstCover(
    height: Dp
) {
    Box(Modifier.fillMaxWidth().height(height).background(Color.Cyan))
}

@Composable
private fun LastCover(
    height: Dp
) {
    Box(Modifier.fillMaxWidth().height(height).background(Color.Magenta))
}

@Composable
private fun Page(
    height: Dp,
    chapterModel: ChapterModel
) {
    PageComponent(
        Modifier
            .fillMaxWidth()
            .heightIn(min = height)
            .background(AppTheme.colors.accent3()),
        chapterModel
    )
}
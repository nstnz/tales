package com.nst.tales.design.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.design.image.AsyncImage
import com.nst.tales.design.spacer.SpacerComponent
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.accent2
import com.nst.tales.design.theme.background1
import com.nst.tales.design.theme.textDarkSecondary

@Composable
internal fun BookComponent(
    modifier: Modifier,
    bookModel: BookModel
) {
    CardComponent(
        modifier,
        padding = AppTheme.indents.x0
    ) {
        Box(Modifier.fillMaxSize()) {
            AsyncImage(bookModel.image, modifier = Modifier.fillMaxSize())
            Column(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(AppTheme.colors.background1(), AppTheme.shapes.x3)
                    .padding(AppTheme.indents.x3)
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = AppTheme.colors.accent2(),
                    style = AppTheme.typography.body1,
                    text = bookModel.name
                )
                SpacerComponent { x1 }
                Text(
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = AppTheme.colors.textDarkSecondary(),
                    style = AppTheme.typography.body3,
                    text = bookModel.chapters.firstOrNull()?.text.orEmpty(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
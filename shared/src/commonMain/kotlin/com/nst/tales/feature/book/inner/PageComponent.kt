package com.nst.tales.feature.book.inner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nst.tales.common.domain.model.ChapterModel
import com.nst.tales.common.domain.model.PageTemplate
import com.nst.tales.design.image.AsyncImage
import com.nst.tales.design.spacer.SpacerComponent
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.textDarkDefault
import com.nst.tales.design.theme.textLightDefault

@Composable
internal fun PageComponent(
    modifier: Modifier,
    chapterModel: ChapterModel,
) {
    when (PageTemplate.getByIndex(chapterModel.template)) {
        PageTemplate.TopImageFull -> TopImageFull(chapterModel, modifier)
        PageTemplate.BottomImageFull -> BottomImageFull(chapterModel, modifier)
        PageTemplate.ImageFull -> ImageFull(chapterModel, modifier)
        PageTemplate.TopImageSmall -> TopImageSmall(chapterModel, modifier)
        PageTemplate.BottomImageSmall -> BottomImageSmall(chapterModel, modifier)
        PageTemplate.SplitImageFull -> SplitImageFull(chapterModel, modifier)
        PageTemplate.InnerText -> InnerText(chapterModel, modifier)
    }
}

@Composable
private fun ImageFull(
    chapterModel: ChapterModel,
    modifier: Modifier,
) {
    BoxWithConstraints(modifier) {
        AsyncImage(
            chapterModel.images.firstOrNull().orEmpty(),
            modifier
        )
        Box(
            Modifier.fillMaxWidth()
                .padding(bottom = AppTheme.indents.x3)
                .align(Alignment.BottomCenter),
            contentAlignment = Alignment.Center
        ) {
            ChapterComponent(chapterModel, AppTheme.colors.textLightDefault())
        }
    }
}

@Composable
private fun InnerText(
    chapterModel: ChapterModel,
    modifier: Modifier,
) {
    Box(modifier) {
        AsyncImage(
            chapterModel.images.firstOrNull().orEmpty(),
            modifier
        )
        Box(
            Modifier.padding(AppTheme.indents.x4).fillMaxWidth().align(Alignment.Center)
                .background(Color(chapterModel.color), AppTheme.shapes.x3)
                .heightIn(min = 400.dp),
            contentAlignment = Alignment.Center
        ) {
            ChapterComponent(chapterModel, AppTheme.colors.textDarkDefault())
        }
    }
}

@Composable
private fun SplitImageFull(
    chapterModel: ChapterModel,
    modifier: Modifier,
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        BoxWithConstraints(Modifier.fillMaxWidth()) {
            val height = this.maxWidth / 2
            AsyncImage(
                chapterModel.images.firstOrNull().orEmpty(),
                Modifier.fillMaxWidth().height(height)
            )
        }
        SpacerComponent { x4 }
        Box(
            Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            ChapterComponent(chapterModel, AppTheme.colors.textDarkDefault())
        }
        SpacerComponent { x4 }
        BoxWithConstraints(Modifier.fillMaxWidth()) {
            val height = this.maxWidth / 2
            AsyncImage(
                chapterModel.images.getOrNull(1).orEmpty(),
                Modifier.fillMaxWidth().height(height)
            )
        }
    }
}

@Composable
private fun TopImageSmall(
    chapterModel: ChapterModel,
    modifier: Modifier,
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        SpacerComponent { x4 }
        AsyncImage(chapterModel.images.firstOrNull().orEmpty(), Modifier.size(256.dp))
        SpacerComponent { x4 }
        Box(
            Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            ChapterComponent(chapterModel, AppTheme.colors.textDarkDefault())
        }
        SpacerComponent { x4 }
    }
}

@Composable
private fun BottomImageSmall(
    chapterModel: ChapterModel,
    modifier: Modifier,
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        SpacerComponent { x4 }
        Box(
            Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            ChapterComponent(chapterModel, AppTheme.colors.textDarkDefault())
        }
        SpacerComponent { x4 }
        AsyncImage(chapterModel.images.firstOrNull().orEmpty(), Modifier.size(256.dp))
        SpacerComponent { x6 }
    }
}

@Composable
private fun TopImageFull(
    chapterModel: ChapterModel,
    modifier: Modifier,
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(chapterModel.images.firstOrNull().orEmpty(), Modifier.fillMaxWidth())
        SpacerComponent { x4 }
        Box(
            Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            ChapterComponent(chapterModel, AppTheme.colors.textDarkDefault())
        }
        SpacerComponent { x4 }
    }
}

@Composable
private fun BottomImageFull(
    chapterModel: ChapterModel,
    modifier: Modifier,
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        SpacerComponent { x4 }
        Box(
            Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            ChapterComponent(chapterModel, AppTheme.colors.textDarkDefault())
        }
        SpacerComponent { x4 }
        AsyncImage(chapterModel.images.firstOrNull().orEmpty(), Modifier.fillMaxWidth())
    }
}


@Composable
private fun ChapterComponent(
    chapterModel: ChapterModel,
    color: Color
) {
    val alignment = listOf(
        TextAlign.Center,
        TextAlign.End,
        TextAlign.Start
    ).random()

    Column(
        Modifier.fillMaxWidth().padding(horizontal = AppTheme.indents.x5),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Chapter 1",
            style = AppTheme.typography.body1,
            color = color,
            textAlign = alignment
        )
        Text(
            text = chapterModel.name,
            style = AppTheme.typography.large3,
            color = color,
            textAlign = alignment
        )
        SpacerComponent { x4 }
        Text(
            text = chapterModel.text,
            style = AppTheme.typography.body2,
            color = color,
            textAlign = alignment
        )
    }
}
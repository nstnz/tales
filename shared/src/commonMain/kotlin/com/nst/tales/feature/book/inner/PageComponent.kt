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
import com.nst.tales.common.domain.model.ChapterPartModel
import com.nst.tales.common.domain.model.PageTemplate
import com.nst.tales.design.image.AsyncImage
import com.nst.tales.design.spacer.SpacerComponent
import com.nst.tales.design.theme.AppTheme
import com.nst.tales.design.theme.textDarkDefault
import com.nst.tales.design.theme.textLightDefault

@Composable
internal fun PageComponent(
    modifier: Modifier,
    chapterModel: ChapterPartModel,
) {
    when (chapterModel.template) {
        PageTemplate.TopImageFull -> TopImageFull(chapterModel, modifier)
        PageTemplate.BottomImageFull -> BottomImageFull(chapterModel, modifier)
        PageTemplate.ImageFull -> ImageFull(chapterModel, modifier)
        PageTemplate.TopImageSmall -> TopImageSmall(chapterModel, modifier)
        PageTemplate.BottomImageSmall -> BottomImageSmall(chapterModel, modifier)
        PageTemplate.SplitImageFull -> SplitImageFull(chapterModel, modifier)
        PageTemplate.InnerText -> InnerText(chapterModel, modifier)
        PageTemplate.OnlyText -> OnlyText(chapterModel, modifier)
    }
}

@Composable
private fun ImageFull(
    chapterModel: ChapterPartModel,
    modifier: Modifier,
) {
    BoxWithConstraints(modifier) {
        AsyncImage(
            chapterModel.image,
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
private fun OnlyText(
    chapterModel: ChapterPartModel,
    modifier: Modifier,
) {
    Box(
        modifier
            .background(Color(chapterModel.color), AppTheme.shapes.x3)
            .padding(vertical = AppTheme.indents.x6)
            .padding(horizontal = AppTheme.indents.x2),
        contentAlignment = Alignment.Center
    ) {
        ChapterComponent(chapterModel, AppTheme.colors.textDarkDefault())
    }
}

@Composable
private fun InnerText(
    chapterModel: ChapterPartModel,
    modifier: Modifier,
) {
    Box(modifier) {
        AsyncImage(
            chapterModel.image,
            modifier
        )
        Box(
            Modifier.padding(AppTheme.indents.x4).fillMaxWidth().align(Alignment.Center)
                .background(Color(chapterModel.color), AppTheme.shapes.x3)
                .heightIn(min = 400.dp)
                .padding(vertical = AppTheme.indents.x3),
            contentAlignment = Alignment.Center
        ) {
            ChapterComponent(chapterModel, AppTheme.colors.textDarkDefault())
        }
    }
}

@Composable
private fun SplitImageFull(
    chapterModel: ChapterPartModel,
    modifier: Modifier,
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        BoxWithConstraints(Modifier.fillMaxWidth()) {
            val height = this.maxWidth / 2
            AsyncImage(
                chapterModel.image,
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
                chapterModel.image,
                Modifier.fillMaxWidth().height(height)
            )
        }
    }
}

@Composable
private fun TopImageSmall(
    chapterModel: ChapterPartModel,
    modifier: Modifier,
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        SpacerComponent { x4 }
        AsyncImage(chapterModel.image, Modifier.size(256.dp))
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
    chapterModel: ChapterPartModel,
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
        AsyncImage(chapterModel.image, Modifier.size(256.dp))
        SpacerComponent { x6 }
    }
}

@Composable
private fun TopImageFull(
    chapterModel: ChapterPartModel,
    modifier: Modifier,
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(chapterModel.image, Modifier.fillMaxWidth())
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
    chapterModel: ChapterPartModel,
    modifier: Modifier,
) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        SpacerComponent { x4 }
        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            ChapterComponent(chapterModel, AppTheme.colors.textDarkDefault())
        }
        SpacerComponent { x4 }
        AsyncImage(chapterModel.image, Modifier.fillMaxWidth())
    }
}


@Composable
private fun ChapterComponent(
    chapterModel: ChapterPartModel,
    color: Color,
    alignment: TextAlign = TextAlign.Center
) {
    Column(
        Modifier.fillMaxWidth().padding(horizontal = AppTheme.indents.x5),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        chapterModel.name?.let {
            Text(
                text = chapterModel.name.split(':').first().trim(),
                style = AppTheme.typography.body1,
                color = color,
                textAlign = alignment
            )
            Text(
                text = chapterModel.name.split(':').last().trim(),
                style = AppTheme.typography.large3,
                color = color,
                textAlign = alignment
            )
            SpacerComponent { x4 }
        }

        Text(
            text = chapterModel.text,
            style = AppTheme.typography.body2,
            color = color,
            textAlign = alignment
        )
    }
}
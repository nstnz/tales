package com.nst.tales.common.domain.model

data class ChapterModel(
    val name: String,
    val text: String,
    val images: List<String>,
    val template: Int,
    val color: Long
) {

    fun splitIntoParts(): List<ChapterPartModel> {
        val list = mutableListOf<ChapterPartModel>()
        val sentences = text.split(
            '.',
            ignoreCase = false
        )
        val count = sentences.size/2 - 1
        val firstPart = sentences.take(count)
            .joinToString(separator = ".") { it } + "."
            .trim()
        val secondPart = sentences.takeLast(sentences.size - count)
            .joinToString(separator = ".") { it }.trim()

        when (PageTemplate.getByIndex(template)) {
            PageTemplate.TopImageFull -> {
                list.add(
                    ChapterPartModel(
                        text = firstPart,
                        image = images.first(),
                        color = color,
                        template = PageTemplate.TopImageFull,
                        name = name
                    )
                )
                list.add(
                    ChapterPartModel(
                        text = secondPart,
                        image = images.last(),
                        color = color,
                        template = PageTemplate.BottomImageFull,
                        name = null
                    )
                )
            }
            PageTemplate.BottomImageFull -> {
                list.add(
                    ChapterPartModel(
                        text = firstPart,
                        image = images.first(),
                        color = color,
                        template = PageTemplate.BottomImageFull,
                        name = name
                    )
                )
                list.add(
                    ChapterPartModel(
                        text = secondPart,
                        image = images.last(),
                        color = color,
                        template = PageTemplate.TopImageSmall,
                        name = null
                    )
                )
            }
            PageTemplate.ImageFull ->  {
                list.add(
                    ChapterPartModel(
                        text = text,
                        image = images.first(),
                        color = color,
                        template = PageTemplate.ImageFull,
                        name = name
                    )
                )
            }
            PageTemplate.TopImageSmall -> {
                list.add(
                    ChapterPartModel(
                        text = text,
                        image = images.first(),
                        color = color,
                        template = PageTemplate.TopImageSmall,
                        name = name
                    )
                )
            }
            PageTemplate.BottomImageSmall -> {
                list.add(
                    ChapterPartModel(
                        text = text,
                        image = images.first(),
                        color = color,
                        template = PageTemplate.BottomImageSmall,
                        name = name
                    )
                )
            }
            PageTemplate.SplitImageFull -> {
                list.add(
                    ChapterPartModel(
                        text = firstPart,
                        image = images.first(),
                        color = color,
                        template = PageTemplate.SplitImageFull,
                        name = name
                    )
                )
                list.add(
                    ChapterPartModel(
                        text = secondPart,
                        image = images.first(),
                        color = color,
                        template = PageTemplate.OnlyText,
                        name = null
                    )
                )
            }
            PageTemplate.InnerText -> {
                list.add(
                    ChapterPartModel(
                        text = firstPart,
                        image = images.first(),
                        color = color,
                        template = PageTemplate.InnerText,
                        name = name
                    )
                )
                list.add(
                    ChapterPartModel(
                        text = secondPart,
                        image = images.last(),
                        color = color,
                        template = PageTemplate.BottomImageFull,
                        name = null
                    )
                )
            }

            PageTemplate.OnlyText -> {
                list.add(
                    ChapterPartModel(
                        text = text,
                        image = images.first(),
                        color = color,
                        template = PageTemplate.OnlyText,
                        name = name
                    )
                )
            }
        }
        return list
    }
}

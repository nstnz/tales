package com.nst.tales.common.domain.model

enum class PageTemplate(val index: Int) {
    TopImageFull(0),
    BottomImageFull(1),
    ImageFull(2),
    TopImageSmall(3),
    BottomImageSmall(4),
    SplitImageFull(5),
    InnerText(6),
    OnlyText(7),
    ;

    companion object {
        fun getByIndex(index: Int) = values().firstOrNull { it.index == index } ?: TopImageFull
    }
}
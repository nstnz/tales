package com.nst.tales.common.domain.usecase

import com.nst.tales.common.data.BookRepository
import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.domain.model.ChapterModel
import com.nst.tales.common.domain.model.PageTemplate
import com.nst.tales.design.theme.getColorsForBook
import com.nst.tales.randomUUID
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlin.random.Random

internal class CreateBookUseCase(
    private val dispatcher: CoroutineDispatcher,
    private val repository: BookRepository
) {

    private val random: Random = Random.Default

    suspend operator fun invoke() = withContext(dispatcher) {
        repository.saveBook(
            BookModel(
                id = randomUUID(),
                name = "Book number ${random.nextInt()}",
                image = "https://blog-cdn.reedsy.com/uploads/2019/12/boy-at-the-back.jpg",
                chapters = listOf(
                    ChapterModel(
                        name = "Chapter number ${random.nextInt()}",
                        text = "Chapter number ${random.nextInt()}",
                        template = PageTemplate.values().random().index,
                        color = getColorsForBook().random(),
                        images = emptyList()
                    )
                )
            )
        )
    }
}
package com.nst.tales.common.domain.usecase

import com.nst.tales.common.data.BookRepository
import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.domain.model.ChapterModel
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
                id = random.nextLong().toString(),
                name = "Book number ${random.nextInt()}",
                image = "https://blog-cdn.reedsy.com/uploads/2019/12/boy-at-the-back.jpg",
                chapters = listOf(
                    ChapterModel(
                        name = "Chapter number ${random.nextInt()}",
                        text = "Chapter number ${random.nextInt()}",
                        images = emptyList()
                    )
                )
            )
        )
    }
}
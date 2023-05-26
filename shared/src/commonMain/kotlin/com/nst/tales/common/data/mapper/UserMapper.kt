package com.nst.tales.common.data.mapper

import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.domain.model.ChapterModel
import com.nst.tales.common.domain.model.UserModel

internal class UserMapper {

    fun map(map: Map<String, *>): UserModel = UserModel(
        id = map["id"].toString(),
        name = map["name"]?.toString().orEmpty(),
        books = when (val result = map["books"]) {
            is HashMap<*, *> -> getBooksFromMap(result)
            is List<*> -> getBooksFromList(result)
            else -> emptyList()
        }
    )

    private fun getBooksFromMap(map: HashMap<*, *>): List<BookModel> {
        return map.map {
            val values = it.value as HashMap<*, *>
            createBook(values)
        }
    }

    private fun getBooksFromList(list: List<*>): List<BookModel> {
        return list.filterNotNull().firstOrNull()?.let {
            val values = it as HashMap<*, *>
            listOf(createBook(values))
        } ?: emptyList()
    }

    private fun createBook(values: HashMap<*, *>): BookModel {
        val chapters = values["chapters"]
        return BookModel(
            id = values["id"]?.toString().orEmpty(),
            name = values["name"]?.toString().orEmpty(),
            image = values["image"]?.toString().orEmpty(),
            chapters = when (val result = chapters) {
                is HashMap<*, *> -> getChapters(result)
                is List<*> -> getChapters(result)
                else -> emptyList()
            }
        )
    }

    private fun getChapters(chapters: List<*>): List<ChapterModel> =
        chapters.filterNotNull().filterIsInstance<HashMap<*, *>>().map {
            ChapterModel(
                name = it["name"].toString(),
                text = it["text"].toString(),
                images = emptyList()
            )
        }

    private fun getChapters(chapters: HashMap<*, *>): List<ChapterModel> =
        listOf(
            ChapterModel(
                name = chapters["name"].toString(),
                text = chapters["text"].toString(),
                images = emptyList()
            )
        )
}
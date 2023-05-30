package com.nst.tales.common.data.mapper

import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.domain.model.ChapterModel
import com.nst.tales.common.domain.model.UserModel

internal class UserMapper {

    fun map(map: Map<String, *>): UserModel = UserModel(
        id = map["id"].toString(),
        name = map["name"]?.toString().orEmpty(),
        age = map["age"] as? Int,
        isGirl = map["isGirl"] as? Boolean,
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
                is HashMap<*, *> -> listOf(getChapters(result))
                is List<*> -> getChapters(result)
                else -> emptyList()
            }
        )
    }

    private fun getChapters(chapters: List<*>): List<ChapterModel> =
        chapters.filterNotNull().filterIsInstance<HashMap<*, *>>().map {
            getChapters(it)
        }

    private fun getChapters(chapters: HashMap<*, *>): ChapterModel =
        ChapterModel(
            name = chapters["name"].toString(),
            text = chapters["text"].toString(),
            template = chapters["template"].toString().toIntOrNull() ?: 0,
            color = chapters["color"].toString().toLongOrNull() ?: 0,
            images = emptyList()
        )
}
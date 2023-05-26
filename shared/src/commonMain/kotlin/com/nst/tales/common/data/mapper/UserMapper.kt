package com.nst.tales.common.data.mapper

import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.domain.model.ChapterModel
import com.nst.tales.common.domain.model.UserModel

internal class UserMapper {

    fun map(map: Map<String, *>): UserModel = UserModel(
        id = map["id"].toString(),
        name = map["name"]?.toString().orEmpty(),
        books = (map["books"] as HashMap<*, *>)
            .map {
                val values = it.value as HashMap<*, *>
                val chapters = values["chapters"] as? List<HashMap<*, *>>
                BookModel(
                    id = it.key.toString(),
                    name = values["name"].toString(),
                    chapters = chapters?.filterNotNull()?.map {
                        ChapterModel(
                            name = it["name"].toString(),
                            text = it["text"].toString(),
                            images = emptyList()
                        )
                    } ?: emptyList()
                )
            }
    )
}
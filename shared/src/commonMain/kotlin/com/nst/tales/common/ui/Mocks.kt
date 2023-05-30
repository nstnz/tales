package com.nst.tales.common.ui

import com.nst.tales.common.domain.model.BookModel
import com.nst.tales.common.domain.model.ChapterModel
import com.nst.tales.common.domain.model.PageTemplate
import com.nst.tales.common.domain.model.UserModel
import com.nst.tales.design.theme.getColorsForBook

internal fun mockUser() = UserModel(
    id = "",
    name = "Nastya",
    age = 10,
    isGirl = true,
    books = listOf(
        mockBook(),
        mockBook(),
        mockBook(),
        mockBook(),
    )
)

internal fun mockBook() = BookModel(
    id = "1",
    name = "Booky book",
    image = "",
    chapters = listOf(
        mockChapter(
            "Chapter 1: The Mysterious Forest",
            "Once upon a time, there was a little girl named Lily who lived in a small village near a mysterious forest. Everyone warned her not to go inside, but Lily was curious. One day, she decided to explore the forest and see what secrets it held. As she walked deeper into the forest, she heard strange noises and saw unfamiliar creatures. Suddenly, she stumbled upon a beautiful garden filled with colorful flowers."
        ),
        mockChapter(
            "Chapter 2: The Enchanted Garden",
            "Lily was amazed by the beauty of the garden and decided to explore it further. She saw a small cottage in the distance and decided to investigate. As she approached the cottage, she saw an old woman sitting outside. The woman introduced herself as the keeper of the garden and invited Lily inside. Inside the cottage, Lily saw a magical book that revealed the secrets of the garden.",
        ),
        mockChapter(
            "Chapter 3: The Quest for the Golden Key",
            "The book revealed that there was a golden key hidden deep within the garden. The key would unlock a secret door that led to a treasure trove of magical objects. Lily was excited to find the key and explore the treasure trove. The old woman gave her a map and some clues to help her find the key. Lily set off on her quest, determined to find the key and unlock the door.",
        ),
        mockChapter(
            "Chapter 4: The Secret Door",
            "After hours of searching, Lily finally found the golden key. She rushed back to the cottage and unlocked the secret door. Inside, she saw a room filled with magical objects - potions, wands, and even a flying broomstick! The old woman explained that these objects were gifts from fairies and other magical creatures. Lily was amazed and grateful for the opportunity to explore this hidden world.",
        ),
        mockChapter(
            "Chapter 5: Return Home",
            "As much as Lily enjoyed exploring the enchanted garden, she knew it was time to return home. She said goodbye to the old woman and thanked her for the adventure of a lifetime. Lily returned to her village, eager to share her story with her family and friends. From that day on, she was known as the brave girl who explored the mysterious forest and discovered the enchanted garden.",
        ),
    )
)

internal fun mockChapter(
    name: String,
    text: String
) = ChapterModel(
    name = name,
    text = text,
    template = PageTemplate.values().random().index,
    color = getColorsForBook().random(),
    images = listOf(
        "https://thumbs.dreamstime.com/b/group-kids-outdoors-looking-down-camera-square-format-128588960.jpg"
    )
)
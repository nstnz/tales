package com.nst.tales

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.completion.CompletionRequest
import com.aallam.openai.api.completion.TextCompletion
import com.aallam.openai.api.http.Timeout
import com.aallam.openai.api.image.ImageCreation
import com.aallam.openai.api.image.ImageSize
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import kotlin.time.Duration.Companion.seconds

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    @OptIn(BetaOpenAI::class)
    suspend fun doAction() {
        var text = ""

        val openAI = OpenAI(
            token = "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",
            timeout = Timeout(socket = 60.seconds),
        )

        val completionRequest = CompletionRequest(
            model = ModelId("text-davinci-003"),
            prompt = "Generate a tale for kids till 5 years old, 5 chapters, reading time 10 minutes",
            echo = false,
            maxTokens = 1
        )
       /* openAI.completions(completionRequest).collect {
            text += it.choices.first().text

            if (text.endsWith("End")) {
                println(text)
            }
        }*/

        val images = openAI.imageURL( // or openAI.imageJSON
            creation = ImageCreation(
                prompt = """Once upon a time, there lived a little boy named Jake. He loved to play in the garden of his home. One particular day, as he was playing, he noticed something sparkly on the ground. He bent down closer and discovered it was a magical seed. Jake, not knowing where it had come from, decided to take it with him.
                https://www.artistsandillustrators.co.uk/uploads/tinymce/images/aug11p57.jpg watercolor style""".trimIndent().replace("\n", ""),
                n = 2,
                size = ImageSize.is1024x1024
            )
        )

        images.forEach {
            println(it.url)
        }
    }
}
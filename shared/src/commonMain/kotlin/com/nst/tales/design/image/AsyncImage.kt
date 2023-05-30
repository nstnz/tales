package com.nst.tales.design.image

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import com.nst.tales.toImageBitmap
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.utils.io.core.use

@Composable
internal fun AsyncImage(
    url: String,
    modifier: Modifier = Modifier
) {
    if (!url.startsWith("http")) {
        return
    }

    var image by remember { mutableStateOf<ImageBitmap?>(null) }
    image?.let {
        androidx.compose.foundation.Image(
            modifier = modifier,
            bitmap = it,
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
    } ?: run {
        Spacer(modifier = modifier)
    }
    LaunchedEffect(key1 = url, block = {
        val bytes: ByteArray = HttpClient().use { client ->
            client.get(url).body()
        }
        image = bytes.toImageBitmap()
    })
}
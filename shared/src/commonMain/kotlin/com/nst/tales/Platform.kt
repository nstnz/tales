package com.nst.tales

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
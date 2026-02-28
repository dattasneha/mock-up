package com.snehadatta.mockup

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
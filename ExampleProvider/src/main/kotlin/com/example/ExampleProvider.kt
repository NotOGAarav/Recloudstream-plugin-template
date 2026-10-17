package com.example

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

abstract class DangalBase(
    override var name: String,
    private val streamUrl: String
) : MainAPI() {
    override var mainUrl = "https://live-dangal.akamaized.net"
    override var lang = "hi"
    override val supportedTypes = setOf(TvType.Live)
    override val hasMainPage = true
    override val mainPage = mainPageOf("main" to "Dangal")

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        val item = newLiveSearchResponse("Dangal (Hindi)", streamUrl, TvType.Live)
        return newHomePageResponse(request.name, listOf(item), hasNext = false)
    }

    override suspend fun load(url: String): LoadResponse =
        newLiveStreamLoadResponse("Dangal (Hindi)", url, url)

    override suspend fun loadLinks(
        data: String,
        isCasting: Boolean,
        subtitleCallback: (SubtitleFile) -> Unit,
        callback: (ExtractorLink) -> Unit
    ): Boolean {
        callback(newExtractorLink(name, name, data, ExtractorLinkType.M3U8))
        return true
    }
}

class Dangal1 : DangalBase("Dangal - Link 1", "https://live-dangal.akamaized.net/liveabr/playlist.m3u8")
// class Dangal2 : DangalBase("Dangal - Link 2", "PASTE_LINK_2")
// class Dangal3 : DangalBase("Dangal - Link 3", "PASTE_LINK_3")

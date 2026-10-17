package com.example

import com.lagradost.cloudstream3.plugins.BasePlugin
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin

@CloudstreamPlugin
class ExamplePlugin : BasePlugin() {
    override fun load() {
        registerMainAPI(Dangal1())
        // registerMainAPI(Dangal2())
        // registerMainAPI(Dangal3())
    }
}

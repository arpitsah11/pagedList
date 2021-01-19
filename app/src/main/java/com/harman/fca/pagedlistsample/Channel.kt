package com.harman.fca.pagedlistsample

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
class Channel
@JvmOverloads constructor(

    @field: Element
    var title: String? = null
)
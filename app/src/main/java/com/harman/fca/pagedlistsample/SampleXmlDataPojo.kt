package com.harman.fca.pagedlistsample

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "rss", strict = false)
class SampleXmlDataPojo @JvmOverloads constructor(
    @field: Element
    var channel: Channel? = null
)


/*@Root(name = "atom" , strict = false)
class Atom{

    @Attribute
    var href :String? = null

    @Attribute
    var rel :String? = null

    @Attribute
    var type :String? = null
}

@Root(name = "image", strict = false)
class Image{
    @Element
    var url :String? = null

    @Element
    var title :String? = null

    @Element
    var link :String? = null

    @Element
    var width :Int = 0

    @Element
    var height :Int = 0
}

@Root(name = "item", strict = false)
class ItemXML{

    @Element
    var title : String ?= null

    @Element
    var link : String ?= null

    @Element
    var comments : String ?= null

    @Element(name = "dc:creator")
    var creator : String ?= null

    @Element
    var description : String ?= null

    @Element(name = "wfw:commentRss")
    var wfw : String ?= null

    @Element(name = "slash:comments")
    var slash_comment : String ?= null

    @ElementArray(entry = "category")
    val category: Array<String> ? = null

}*/

package com.wajahatkarim3.soapretrofitdemo.models

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "HolidayCode", strict = false)
class HolidayCodeModel {

    @field:Element(name = "Code", required = false)
    private var Code: String? = null

    @field:Element(name = "Description", required = false)
    private var Description: String? = null

}
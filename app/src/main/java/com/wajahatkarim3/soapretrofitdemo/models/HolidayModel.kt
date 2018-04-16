package com.wajahatkarim3.soapretrofitdemo.models

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Holiday", strict = false)
data class HolidayModel (

    @field:Element(name = "Country", required = false)
    var Country: String? = null,

    @field:Element(name = "HolidayCode", required = false)
    var HolidayCode: String? = null,

    @field:Element(name = "Descriptor", required = false)
    var Descriptor: String? = null,

    @field:Element(name = "HolidayType", required = false)
    var HolidayType: String? = null,

    @field:Element(name = "DateType", required = false)
    var DateType: String? = null,

    @field:Element(name = "BankHoliday", required = false)
    var BankHoliday: String? = null,

    @field:Element(name = "Date", required = false)
    var Date: String? = null,

    @field:Element(name = "RelatedHolidayCode", required = false)
    var RelatedHolidayCode: String? = null
)

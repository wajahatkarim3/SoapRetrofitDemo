package com.wajahatkarim3.soapretrofitdemo.models

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Holiday", strict = false)
data class HolidayModel (

    @field:Element(name = "Country", required = false)
    private var Country: String? = null,

    @field:Element(name = "HolidayCode", required = false)
    private var HolidayCode: String? = null,

    @field:Element(name = "Descriptor", required = false)
    private var Descriptor: String? = null,

    @field:Element(name = "HolidayType", required = false)
    private var HolidayType: String? = null,

    @field:Element(name = "DateType", required = false)
    private var DateType: String? = null,

    @field:Element(name = "BankHoliday", required = false)
    private var BankHoliday: String? = null,

    @field:Element(name = "RelatedHolidayCode", required = false)
    private var RelatedHolidayCode: String? = null
)

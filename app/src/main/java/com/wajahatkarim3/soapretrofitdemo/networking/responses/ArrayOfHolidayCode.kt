package com.wajahatkarim3.soapretrofitdemo.networking.responses

import com.wajahatkarim3.soapretrofitdemo.models.HolidayCodeModel
import com.wajahatkarim3.soapretrofitdemo.models.HolidayModel
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList
import org.simpleframework.xml.Root

@Root(name = "soap12:Envelope")
@NamespaceList(
        Namespace(prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        Namespace(prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        Namespace(prefix = "soap12", reference = "http://www.w3.org/2003/05/soap-envelope"),
        Namespace(reference = "http://www.holidaywebservice.com/HolidayService_v2/"))
class ArrayOfHolidayCode {

    @field:ElementList(entry = "HolidayCode", inline = true, required = false)
    var holidayCodesList: List<HolidayCodeModel>? = null
}
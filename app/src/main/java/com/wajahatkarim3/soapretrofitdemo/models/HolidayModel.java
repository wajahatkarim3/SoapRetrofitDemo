package com.wajahatkarim3.soapretrofitdemo.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Holiday", strict = false)
public class HolidayModel {

    @Element(name = "Country", required = false)
    private String Country;

    @Element(name = "HolidayCode", required = false)
    private String HolidayCode;

    @Element(name = "Descriptor", required = false)
    private String Descriptor;

    @Element(name = "HolidayType", required = false)
    private String HolidayType;

    @Element(name = "DateType", required = false)
    private String DateType;

    @Element(name = "BankHoliday", required = false)
    private String BankHoliday;

    @Element(name = "RelatedHolidayCode", required = false)
    private String RelatedHolidayCode;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getHolidayCode() {
        return HolidayCode;
    }

    public void setHolidayCode(String holidayCode) {
        HolidayCode = holidayCode;
    }

    public String getDescriptor() {
        return Descriptor;
    }

    public void setDescriptor(String descriptor) {
        Descriptor = descriptor;
    }

    public String getHolidayType() {
        return HolidayType;
    }

    public void setHolidayType(String holidayType) {
        HolidayType = holidayType;
    }

    public String getDateType() {
        return DateType;
    }

    public void setDateType(String dateType) {
        DateType = dateType;
    }

    public String getBankHoliday() {
        return BankHoliday;
    }

    public void setBankHoliday(String bankHoliday) {
        BankHoliday = bankHoliday;
    }

    public String getRelatedHolidayCode() {
        return RelatedHolidayCode;
    }

    public void setRelatedHolidayCode(String relatedHolidayCode) {
        RelatedHolidayCode = relatedHolidayCode;
    }
}

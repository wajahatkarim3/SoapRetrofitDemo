package com.wajahatkarim3.soapretrofitdemo.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.wajahatkarim3.soapretrofitdemo.R;

public class CurrentDateDecorator implements DayViewDecorator {

    private Drawable highlightDrawable;
    private Context context;

    public CurrentDateDecorator( Context context) {
        this.context = context;
        //highlightDrawable = this.context.getResources().getDrawable(R.drawable.circlebackground);
        highlightDrawable = new ColorDrawable(context.getResources().getColor(R.color.cardview_light_background));
    }
    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return day.equals(CalendarDay.today());
    }

    @Override
    public void decorate(DayViewFacade view) {

        view.setBackgroundDrawable(highlightDrawable);
        view.addSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.colorPrimary)));
        view.addSpan(new StyleSpan(Typeface.BOLD));
        view.addSpan(new RelativeSizeSpan(1.5f));
        view.addSpan(new UnderlineSpan());
        //view.addSpan(new RoundedBackgroundSpan(context.getResources().getColor(R.color.colorAccent), context.getResources().getColor(android.R.color.white)));

    }
}

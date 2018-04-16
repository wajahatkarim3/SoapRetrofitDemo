package com.wajahatkarim3.soapretrofitdemo.custom;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;

import static com.prolificinteractive.materialcalendarview.spans.DotSpan.DEFAULT_RADIUS;

public class CustmMultipleDotSpan implements LineBackgroundSpan {


    private final float radius;
    private int[] color = new int[0];



    public CustmMultipleDotSpan() {
        this.radius = DEFAULT_RADIUS;
        this.color[0] = 0;
    }


    public CustmMultipleDotSpan(int color) {
        this.radius = DEFAULT_RADIUS;
        this.color[0] = 0;
    }


    public CustmMultipleDotSpan(float radius) {
        this.radius = radius;
        this.color[0] = 0;
    }


    public CustmMultipleDotSpan(float radius, int[] color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void drawBackground(
            Canvas canvas, Paint paint,
            int left, int right, int top, int baseline, int bottom,
            CharSequence charSequence,
            int start, int end, int lineNum
    ) {

        int total = color.length > 5 ? 5 : color.length;
        int leftMost = (total - 1) * -10;

        for (int i = 0; i < total; i++) {
            int oldColor = paint.getColor();
            if (color[i] != 0) {
                paint.setColor(color[i]);
            }
            canvas.drawCircle((left + right) / 2 - leftMost, bottom + radius, radius, paint);
            paint.setColor(oldColor);
            leftMost = leftMost + 20;
        }
    }
}
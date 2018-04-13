package com.wajahatkarim3.soapretrofitdemo.custom;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

public class RoundedBackgroundSpan extends ReplacementSpan
{
    private final int _padding = 20;
    private int _backgroundColor;
    private int _textColor;

    public RoundedBackgroundSpan(int backgroundColor, int textColor) {
        super();
        _backgroundColor = backgroundColor;
        _textColor = textColor;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        return (int) (_padding + paint.measureText(text.subSequence(start, end).toString()) + _padding);
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint)
    {
        float width = paint.measureText(text.subSequence(start, end).toString());
        RectF rect = new RectF(x - _padding, top, x + width + _padding, bottom);
        paint.setColor(_backgroundColor);
        //canvas.drawRoundRect(rect, 20, 20, paint);
        canvas.drawCircle(x+_padding+2, bottom/2, 30, paint);
        paint.setColor(_textColor);
        paint.setTextSize(30);
        canvas.drawText(text, start, end, x+3, y-5, paint);
    }
}
package com.lee.metronome.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SpeedController extends View {
    static float width, height;
    float midx, midy;
    public Paint textPaint;
    public Paint circlePaint;
    public Paint circlePaint2;
    public Paint linePaint;

    String angle;
    float currdeg, deg = 3, downDeg, prewCurrdeg;
    boolean isIncreasing, isDescreasing;
    public static int themeColor = Color.parseColor("#B24242");

    int progressColor, lineColor;

    onProgressChangedListener mListener;

    String label;

    public interface onProgressChangedListener {
        void onProgressChange(int progress);
    }

    public void setOnProgressChangedListener(onProgressChangedListener listener) {
        mListener = listener;
    }

    public SpeedController(Context context) {
        super(context);
        init();
    }

    public SpeedController(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        init();
    }

    void init() {
        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(20);
        textPaint.setFakeBoldText(true);
        textPaint.setTextAlign(Paint.Align.CENTER);

        circlePaint = new Paint();
        circlePaint.setColor(Color.parseColor("#222222"));
        circlePaint.setStyle(Paint.Style.FILL);

        circlePaint2 = new Paint();
        circlePaint2.setColor(themeColor);
        circlePaint2.setStyle(Paint.Style.FILL);

        linePaint = new Paint();
        linePaint.setColor(themeColor);
        linePaint.setStrokeWidth(7);
        angle = "0.0";
        label = "Label";
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        midx = (float) getWidth() / 2;
        midy = (float) getHeight() / 2;

        int ang = 0;
        float x = 0, y = 0;
        int radius = (int) (Math.min(midx, midy) * ((float) 14.5 / 16));
        float deg2 = Math.max(3, deg);

        float deg3 = Math.min(deg, 21);

        for (int i = (int) deg2; i < 22; i++) {
            float tmp = (float) i / 24;
            x = midx + (float) (radius * Math.sin(2 * Math.PI * (1.0 - tmp)));
            y = midy + (float) (radius * Math.cos(2 * Math.PI * (1.0 - tmp)));

            circlePaint.setColor(Color.parseColor("#111111"));
            canvas.drawCircle(x, y, ((float) radius / 15), circlePaint);
        }


    }
}

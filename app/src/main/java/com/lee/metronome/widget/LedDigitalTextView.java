package com.lee.metronome.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.AppCompatTextView;

import android.util.AttributeSet;
import com.lee.metronome.R;

/**
 * Created by ryLee on 2019-07-01.
 */

public class LedDigitalTextView extends AppCompatTextView {
    public LedDigitalTextView(Context context, AttributeSet attributes) {
        super(context, attributes);
        init(context);
    }

    private void init(Context context) {
        Typeface font = ResourcesCompat.getFont(context, R.font.liquid_crystal_normal);
        setTypeface(font);
    }
}
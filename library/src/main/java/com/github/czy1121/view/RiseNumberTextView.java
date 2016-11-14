/*
 *    Copyright 2016 czy1121
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.github.czy1121.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.github.czy1121.risenumbertextview.R;

import java.text.DecimalFormat;


public class RiseNumberTextView extends TextView {

    private RiseAnimator mAnimator;
    public RiseNumberTextView(Context context) {
        this(context, null, 0);
    }

    public RiseNumberTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RiseNumberTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mAnimator = new RiseAnimator(this);
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RiseNumberTextView);

        String pattern = a.getString(R.styleable.RiseNumberTextView_rntPattern);
        int duration = a.getInteger(R.styleable.RiseNumberTextView_rntDuration, 1000);
        a.recycle();

        if (!TextUtils.isEmpty(pattern)) {
            mAnimator.setPattern(pattern);
        }
        mAnimator.setDuration(duration);
    }

    public RiseAnimator animator() {
        return mAnimator;
    }
    public void riseTo(float to) {
        mAnimator.riseTo(to);
    }
    public void rise(float from, float to) {
        mAnimator.rise(from, to);
    }
    public void rise() {
        mAnimator.start();
    }

    public static class RiseAnimator extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
        public static RiseAnimator with(TextView tv) {
            return new RiseAnimator(tv);
        }
        DecimalFormat mFormat;
        final TextView view;
        private float mFrom = 0f;
        private float mValue = 0f;
        public RiseAnimator(TextView tv) {
            view = tv;
            mFormat = new DecimalFormat("0.000");
            setInterpolator(new LinearInterpolator());
            setDuration(1000);
            addUpdateListener(this);
        }
        public DecimalFormat getFormat() {
            return mFormat;
        }
        public RiseAnimator setPattern(String pattern) {
            mFormat.applyPattern(pattern);
            return this;
        }
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            view.setText(mFormat.format((float)animation.getAnimatedValue()));
        }
        public void riseTo(float to) {
            rise(mValue, to);
        }
        public void rise(float from, float to) {
            if (Float.isNaN(from) || Float.isNaN(to)) {
                return;
            }
            mFrom = from;
            mValue = to;
            setFloatValues(mFrom, mValue);
            start();
        }
    }
}

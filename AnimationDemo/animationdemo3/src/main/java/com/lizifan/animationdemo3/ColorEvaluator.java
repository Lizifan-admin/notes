package com.lizifan.animationdemo3;

import android.animation.TypeEvaluator;

public class ColorEvaluator implements TypeEvaluator {
    private int currentRed = -1;
    private int currentGreen = -1;
    private int currentBlue = -1;
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        String startColor = (String)startValue;
        String endColor = (String)endValue;
        int startRed = Integer.parseInt(startColor.substring(1, 3), 16);
        int startGreen = Integer.parseInt(startColor.substring(3, 5), 16);
        int startBlue = Integer.parseInt(startColor.substring(5, 7), 16);
        int endRed = Integer.parseInt(endColor.substring(1, 3), 16);
        int endGreen = Integer.parseInt(endColor.substring(3, 5), 16);
        int endBlue = Integer.parseInt(endColor.substring(5, 7), 16);
        if (currentRed == -1){
            currentRed = startRed;
        }
        if (currentGreen == -1){
            currentGreen = startGreen;
        }
        if (currentBlue == -1){
            currentBlue = startBlue;
        }
        int redDiff = Math.abs(startRed - endRed);
        int greenDiff = Math.abs(startGreen - endGreen);
        int blueDiff = Math.abs(startBlue - endBlue);
        int colorDiff = redDiff + greenDiff + blueDiff;
        if (currentRed != endRed) {
            currentRed = getCurrentColor(startRed, endRed, colorDiff, 0, fraction);
        } else if (currentGreen != endGreen) {
            currentGreen = getCurrentColor(startGreen, endGreen, colorDiff, redDiff, fraction);
        } else if (currentBlue != endBlue) {
            currentBlue = getCurrentColor(startBlue, endBlue, colorDiff, redDiff + greenDiff, fraction);
        }
        String currentColor = "#" + getHexString(currentRed)
                + getHexString(currentGreen) + getHexString(currentBlue);
        return currentColor;
    }
    private int getCurrentColor(int startColor,int endColor,int colorDiff,int offset,float fraction){
        int currentColor;
        if (startColor > endColor) {
            currentColor = (int) (startColor - (fraction * colorDiff - offset));
            if (currentColor < endColor) {
                currentColor = endColor;
            }
        } else {
            currentColor = (int) (startColor + (fraction * colorDiff - offset));
            if (currentColor > endColor) {
                currentColor = endColor;
            }
        }
        return currentColor;
    }
    private String getHexString(int value) {
        String hexString = Integer.toHexString(value);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        return hexString;
    }

}

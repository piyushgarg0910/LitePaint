package com.gargpiyush.android.litepaint.path;

import android.graphics.Path;

/**
 * Created by Piyush Garg on 2/19/2019.
 */

public class PaintMotion {

    public int color;
    public boolean blur;
    public int strokeWidth;
    public Path path;

    public PaintMotion(int color, boolean blur, int strokeWidth, Path path) {
        this.color = color;
        this.blur = blur;
        this.strokeWidth = strokeWidth;
        this.path = path;
    }
}

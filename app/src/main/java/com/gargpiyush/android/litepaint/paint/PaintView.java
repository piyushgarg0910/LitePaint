package com.gargpiyush.android.litepaint.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import com.gargpiyush.android.litepaint.R;
import com.gargpiyush.android.litepaint.path.PaintMotion;

import java.util.ArrayList;

/**
 * Created by Piyush Garg on 2/19/2019.
 */

public class PaintView extends View {

    public static int brushSize = 12;
    public static final int defaultColor = R.color.black;
    public static final int backgroundColor = R.color.white;
    private static final float tolerance = 5;
    private float x,y;
    private Path path;
    private Paint paint;
    private ArrayList<PaintMotion> paintMotionArrayList = new ArrayList<>();
    private ArrayList<PaintMotion> undoMotion = new ArrayList<>();
    private int color;
    private int bg_color = backgroundColor;
    private int strokeWidth = brushSize;
    private boolean blur;
    private MaskFilter mBlur;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint bitmapPaint = new Paint(android.graphics.Paint.DITHER_FLAG);

    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setXfermode(null);
        paint.setAlpha(0xff);
        color = context.getResources().getColor(defaultColor,null);
        paint.setColor(color);
        mBlur = new BlurMaskFilter(5, BlurMaskFilter.Blur.NORMAL);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public ArrayList<PaintMotion> getPaintMotionArrayList() {
        return paintMotionArrayList;
    }

    public ArrayList<PaintMotion> getUndoMotion() {
        return undoMotion;
    }

    public void init(DisplayMetrics metrics) {
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;

        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }

    public void normal() {
        blur = false;
    }

    public void blur() {
        blur = true;
    }

    public void clear() {
        bg_color = backgroundColor;
        paintMotionArrayList.clear();
        normal();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas mCanvas) {
        mCanvas.save();
        canvas.drawColor(getResources().getColor(bg_color,null));

        for (PaintMotion paintMotion : paintMotionArrayList) {
            paint.setColor(paintMotion.color);
            paint.setStrokeWidth(paintMotion.strokeWidth);
            paint.setMaskFilter(null);

            if (paintMotion.blur)
                paint.setMaskFilter(mBlur);

            canvas.drawPath(paintMotion.path, paint);

        }

        mCanvas.drawBitmap(bitmap, 0, 0, bitmapPaint);
        mCanvas.restore();
    }

    private void touchStart(float mx, float my) {
        path = new Path();
        PaintMotion paintMotion = new PaintMotion(color, blur, strokeWidth, path);
        paintMotionArrayList.add(paintMotion);

        path.reset();
        path.moveTo(mx, my);
        x = mx;
        y = my;
    }

    private void touchMove(float mx, float my) {
        float dx = Math.abs(x - mx);
        float dy = Math.abs(y - my);

        if (dx >= tolerance || dy >= tolerance) {
            path.quadTo(x, y, (x + mx) / 2, (y + my) / 2);
            x = mx;
            y = my;
        }
    }

    private void touchUp() {
        path.lineTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                touchStart(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE :
                touchMove(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP :
                touchUp();
                invalidate();
                break;
        }
        return true;
    }
}

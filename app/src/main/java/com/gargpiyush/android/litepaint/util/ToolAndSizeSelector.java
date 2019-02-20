package com.gargpiyush.android.litepaint.util;

import android.content.Context;
import android.widget.Toast;

import com.gargpiyush.android.litepaint.R;
import com.gargpiyush.android.litepaint.paint.PaintView;

/**
 * Created by Piyush Garg on 2/19/2019.
 */

class ToolAndSizeSelector {

    private PaintView paintView;
    private Context context;
    private String s1;
    private String s2;

    ToolAndSizeSelector(Context context, PaintView paintView) {
        this.paintView = paintView;
        this.context = context;
    }

    void toolSelection(int tool){
        switch (tool){
            case R.id.BrushButton:
                paintView.setColor(context.getResources().getColor(R.color.black,null));
                paintView.normal();
                s1 = "Brush";
                break;
            case R.id.RollerButton:
                paintView.setColor(context.getResources().getColor(R.color.black,null));
                paintView.blur();
                s1 = "Roller";
                break;
            case R.id.EraserButton:
                paintView.setColor(context.getResources().getColor(R.color.white,null));
                paintView.normal();
                s1 = "Eraser";
                break;
        }
    }

    boolean sizeSelection(int size){
        switch (size){
            case R.id.SmallSize:
                paintView.setStrokeWidth(12);
                s2 = "Small";
                toastFinal();
                return true;
            case R.id.XSmallSize:
                paintView.setStrokeWidth(6);
                s2 = "Extra Small";
                toastFinal();
                return true;
            case R.id.MediumSize:
                paintView.setStrokeWidth(18);
                s2 = "Medium";
                toastFinal();
                return true;
            case R.id.LSize:
                paintView.setStrokeWidth(96);
                s2 = "Large";
                toastFinal();
                return true;
            case R.id.XLargeSize:
                paintView.setStrokeWidth(192);
                s2 = "Extra Large";
                toastFinal();
                return true;
            default:
                return false;
        }
    }

    private void toastFinal(){
        Toast.makeText(context,"Tool: " + s1 + ", Size: " + s2,Toast.LENGTH_SHORT).show();
    }

    void undo(){
        if (paintView.getPaintMotionArrayList().size()>0)
        {
            paintView.getUndoMotion().add(paintView.getPaintMotionArrayList()
                    .remove(paintView.getPaintMotionArrayList().size()-1));
            paintView.invalidate();
        }
        Toast.makeText(context,"Tool: Undo",Toast.LENGTH_SHORT).show();
    }

    void redo(){
        if (paintView.getUndoMotion().size()>0)
        {
            paintView.getPaintMotionArrayList().add(paintView.getUndoMotion()
                    .remove(paintView.getUndoMotion().size()-1));
            paintView.invalidate();
        }
        Toast.makeText(context,"Tool: Redo",Toast.LENGTH_SHORT).show();
    }
}

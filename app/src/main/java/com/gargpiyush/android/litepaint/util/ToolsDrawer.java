package com.gargpiyush.android.litepaint.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.design.widget.FloatingActionButton;
import com.gargpiyush.android.litepaint.R;
import com.gargpiyush.android.litepaint.paint.PaintView;

import java.util.List;

/**
 * Created by Piyush Garg on 2/19/2019.
 */

public class ToolsDrawer {

    private List <FloatingActionButton> floatingActionButtons;
    private static boolean plusCheck = false;
    private static boolean brushCheck = false;
    private static boolean rollerCheck = false;
    private static boolean eraserCheck = false;
    private Context context;
    private ToolAndSizeSelector toolSizeSelector;
    private PaintView paintView;

    public ToolsDrawer(List<FloatingActionButton> floatingActionButtons, Context context, PaintView paintView) {
        this.floatingActionButtons = floatingActionButtons;
        this.context = context;
        this.paintView = paintView;
        this.toolSizeSelector = new ToolAndSizeSelector(context,this.paintView);
        setFABColors();
    }

    private void setFABColors (){
        floatingActionButtons.get(0).setBackgroundTintList(ColorStateList.valueOf(
                context.getResources().getColor(R.color.pink,context.getTheme())));
        floatingActionButtons.get(1).setBackgroundTintList(ColorStateList.valueOf(
                context.getResources().getColor(R.color.pink,context.getTheme())));
        floatingActionButtons.get(2).setBackgroundTintList(ColorStateList.valueOf(
                context.getResources().getColor(R.color.pink,context.getTheme())));
        floatingActionButtons.get(3).setBackgroundTintList(ColorStateList.valueOf(
                context.getResources().getColor(R.color.pink,context.getTheme())));
        floatingActionButtons.get(4).setBackgroundTintList(ColorStateList.valueOf(
                context.getResources().getColor(R.color.pink,context.getTheme())));
        floatingActionButtons.get(6).setBackgroundTintList(ColorStateList.valueOf(
                context.getResources().getColor(R.color.orange,context.getTheme())));
        floatingActionButtons.get(7).setBackgroundTintList(ColorStateList.valueOf(
                context.getResources().getColor(R.color.orange,context.getTheme())));
        floatingActionButtons.get(8).setBackgroundTintList(ColorStateList.valueOf(
                context.getResources().getColor(R.color.orange,context.getTheme())));
        floatingActionButtons.get(9).setBackgroundTintList(ColorStateList.valueOf(
                context.getResources().getColor(R.color.orange,context.getTheme())));
        floatingActionButtons.get(10).setBackgroundTintList(ColorStateList.valueOf(
                context.getResources().getColor(R.color.orange,context.getTheme())));

        floatingActionButtons.get(0).setRippleColor(ColorStateList.valueOf(
                context.getResources().getColor(R.color.black,context.getTheme())));
        floatingActionButtons.get(1).setRippleColor(ColorStateList.valueOf(
                context.getResources().getColor(R.color.black,context.getTheme())));
        floatingActionButtons.get(2).setRippleColor(ColorStateList.valueOf(
                context.getResources().getColor(R.color.black,context.getTheme())));
        floatingActionButtons.get(3).setRippleColor(ColorStateList.valueOf(
                context.getResources().getColor(R.color.black,context.getTheme())));
        floatingActionButtons.get(4).setRippleColor(ColorStateList.valueOf(
                context.getResources().getColor(R.color.black,context.getTheme())));
        floatingActionButtons.get(5).setRippleColor(ColorStateList.valueOf(
                context.getResources().getColor(R.color.black,context.getTheme())));
        floatingActionButtons.get(6).setRippleColor(ColorStateList.valueOf(
                context.getResources().getColor(R.color.black,context.getTheme())));
        floatingActionButtons.get(7).setRippleColor(ColorStateList.valueOf(
                context.getResources().getColor(R.color.black,context.getTheme())));
        floatingActionButtons.get(8).setRippleColor(ColorStateList.valueOf(
                context.getResources().getColor(R.color.black,context.getTheme())));
        floatingActionButtons.get(9).setRippleColor(ColorStateList.valueOf(
                context.getResources().getColor(R.color.black,context.getTheme())));
        floatingActionButtons.get(10).setRippleColor(ColorStateList.valueOf(
                context.getResources().getColor(R.color.black,context.getTheme())));
    }

    public void OpenDrawer(int FloatingActionButtonID) {
        boolean sizeSelected = false;
        switch (FloatingActionButtonID){
            case R.id.PlusButton:
                toolsExpand();
                break;
            case R.id.BrushButton:
                brushCheck = true;
                rollerCheck = false;
                eraserCheck = false;
                setFABColors();
                floatingActionButtons.get(0).setBackgroundTintList(ColorStateList.valueOf(
                        context.getResources().getColor(R.color.black,context.getTheme())));
                toolSizeSelector.toolSelection(R.id.BrushButton);
                sizeExpand();
                break;
            case R.id.RollerButton:
                brushCheck = false;
                rollerCheck = true;
                eraserCheck = false;
                setFABColors();
                floatingActionButtons.get(1).setBackgroundTintList(ColorStateList.valueOf(
                        context.getResources().getColor(R.color.black,context.getTheme())));
                toolSizeSelector.toolSelection(R.id.RollerButton);
                sizeExpand();
                break;
            case R.id.EraserButton:
                brushCheck = false;
                rollerCheck = false;
                eraserCheck = true;
                setFABColors();
                floatingActionButtons.get(2).setBackgroundTintList(ColorStateList.valueOf(
                        context.getResources().getColor(R.color.black,context.getTheme())));
                toolSizeSelector.toolSelection(R.id.EraserButton);
                sizeExpand();
                break;
            case R.id.RedoButton:
                closeSizeDrawer();
                setFABColors();
                toolSizeSelector.redo();
                break;
            case R.id.UndoButton:
                closeSizeDrawer();
                setFABColors();
                toolSizeSelector.undo();
                break;
            case R.id.SmallSize:
                sizeSelected = toolSizeSelector.sizeSelection(R.id.SmallSize);
                break;
            case R.id.XSmallSize:
                sizeSelected = toolSizeSelector.sizeSelection(R.id.XSmallSize);
                break;
            case R.id.MediumSize:
                sizeSelected = toolSizeSelector.sizeSelection(R.id.MediumSize);
                break;
            case R.id.LSize:
                sizeSelected = toolSizeSelector.sizeSelection(R.id.LSize);
                break;
            case R.id.XLargeSize:
                sizeSelected = toolSizeSelector.sizeSelection(R.id.XLargeSize);
                break;
        }
        if (sizeSelected){
            closeFullDrawer();
        }
    }

    private void toolsExpand (){
        if (!plusCheck) {
            floatingActionButtons.get(0).animate().translationY(-250.0f);
            floatingActionButtons.get(1).animate().translationY(-150.0f);
            floatingActionButtons.get(1).animate().translationX(-125.0f);
            floatingActionButtons.get(2).animate().translationX(-175.0f);
            floatingActionButtons.get(3).animate().translationY(150.0f);
            floatingActionButtons.get(3).animate().translationX(-125.0f);
            floatingActionButtons.get(4).animate().translationY(250.0f);
            floatingActionButtons.get(6).animate().translationX(-175.0f);
            floatingActionButtons.get(7).animate().translationX(-175.0f);
            floatingActionButtons.get(8).animate().translationX(-175.0f);
            floatingActionButtons.get(9).animate().translationX(-175.0f);
            floatingActionButtons.get(10).animate().translationX(-175.0f);
            floatingActionButtons.get(5).setImageResource(R.drawable.ic_minus);
            plusCheck = true;
        } else {
            setFABColors();
            closeFullDrawer();
        }
    }

    private void sizeExpand(){
        if (brushCheck){
            closeSizeDrawer();
            floatingActionButtons.get(6).animate().translationX(-300.0f);
            floatingActionButtons.get(6).animate().translationY(-150.0f);
            floatingActionButtons.get(7).animate().translationX(-350.0f);
            floatingActionButtons.get(8).animate().translationX(-300.0f);
            floatingActionButtons.get(8).animate().translationY(150.0f);
        }
        else if (rollerCheck){
            closeSizeDrawer();
            floatingActionButtons.get(9).animate().translationX(-300.0f);
            floatingActionButtons.get(9).animate().translationY(-150.0f);
            floatingActionButtons.get(10).animate().translationX(-300.0f);
            floatingActionButtons.get(10).animate().translationY(150.0f);
        }
        else if (eraserCheck){
            closeSizeDrawer();
            floatingActionButtons.get(6).animate().translationX(-215.0f);
            floatingActionButtons.get(6).animate().translationY(-275.0f);
            floatingActionButtons.get(7).animate().translationX(-300.0f);
            floatingActionButtons.get(7).animate().translationY(-150.0f);
            floatingActionButtons.get(8).animate().translationX(-350.0f);
            floatingActionButtons.get(9).animate().translationX(-300.0f);
            floatingActionButtons.get(9).animate().translationY(150.0f);
            floatingActionButtons.get(10).animate().translationX(-215.0f);
            floatingActionButtons.get(10).animate().translationY(275.0f);
        }
    }

    private void closeSizeDrawer(){
        floatingActionButtons.get(6).animate().translationX(-175.0f);
        floatingActionButtons.get(6).animate().translationY(0.0f);
        floatingActionButtons.get(7).animate().translationX(-175.0f);
        floatingActionButtons.get(7).animate().translationY(0.0f);
        floatingActionButtons.get(8).animate().translationX(-175.0f);
        floatingActionButtons.get(8).animate().translationY(0.0f);
        floatingActionButtons.get(9).animate().translationX(-175.0f);
        floatingActionButtons.get(9).animate().translationY(0.0f);
        floatingActionButtons.get(10).animate().translationX(-175.0f);
        floatingActionButtons.get(10).animate().translationY(0.0f);
    }

    private void closeFullDrawer(){
        plusCheck = false;
        setFABColors();
        floatingActionButtons.get(0).animate().translationY(0.0f);
        floatingActionButtons.get(1).animate().translationY(0.0f);
        floatingActionButtons.get(1).animate().translationX(0.0f);
        floatingActionButtons.get(2).animate().translationX(0.0f);
        floatingActionButtons.get(3).animate().translationY(0.0f);
        floatingActionButtons.get(3).animate().translationX(0.0f);
        floatingActionButtons.get(4).animate().translationY(0.0f);
        floatingActionButtons.get(6).animate().translationX(0.0f);
        floatingActionButtons.get(7).animate().translationX(0.0f);
        floatingActionButtons.get(8).animate().translationX(0.0f);
        floatingActionButtons.get(9).animate().translationX(0.0f);
        floatingActionButtons.get(10).animate().translationX(0.0f);
        floatingActionButtons.get(6).animate().translationY(0.0f);
        floatingActionButtons.get(7).animate().translationY(0.0f);
        floatingActionButtons.get(8).animate().translationY(0.0f);
        floatingActionButtons.get(9).animate().translationY(0.0f);
        floatingActionButtons.get(10).animate().translationY(0.0f);
        floatingActionButtons.get(5).setImageResource(R.drawable.ic_add);
    }
}

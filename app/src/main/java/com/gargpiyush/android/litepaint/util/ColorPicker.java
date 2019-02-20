package com.gargpiyush.android.litepaint.util;

import android.content.Context;
import android.widget.Toast;

import com.gargpiyush.android.litepaint.R;
import com.gargpiyush.android.litepaint.paint.PaintView;

/**
 * Created by Piyush Garg on 2/18/2019.
 */

public class ColorPicker {

    private Context context;
    private PaintView paintView;
    private String string;

    public ColorPicker(Context context, PaintView paintView) {
        this.context = context;
        this.paintView = paintView;
    }

    public void setColor(int buttonID){
        switch (buttonID){
            case R.id.BlueColorButton:
                paintView.setColor(context.getResources().getColor(R.color.blue,null));
                string = "Blue";
                toastFinal();
                break;
            case R.id.PurpleColorButton:
                paintView.setColor(context.getResources().getColor(R.color.purple,null));
                string = "Purple";
                toastFinal();
                break;
            case R.id.MagentaColorButton:
                paintView.setColor(context.getResources().getColor(R.color.magenta,null));
                string = "Magenta";
                toastFinal();
                break;
            case R.id.MaroonColorButton:
                paintView.setColor(context.getResources().getColor(R.color.maroon,null));
                string = "Maroon";
                toastFinal();
                break;
            case R.id.PinkColorButton:
                paintView.setColor(context.getResources().getColor(R.color.pink,null));
                string = "Pink";
                toastFinal();
                break;
            case R.id.BrownColorButton:
                paintView.setColor(context.getResources().getColor(R.color.brown,null));
                string = "Brown";
                toastFinal();
                break;
            case R.id.OrangeColorButton:
                paintView.setColor(context.getResources().getColor(R.color.orange,null));
                string = "Orange";
                toastFinal();
                break;
            case R.id.YellowColorButton:
                paintView.setColor(context.getResources().getColor(R.color.yellow,null));
                string = "Yellow";
                toastFinal();
                break;
            case R.id.lGreenColorButton:
                paintView.setColor(context.getResources().getColor(R.color.lightGreen,null));
                string = "Light Green";
                toastFinal();
                break;
            case R.id.dGreenColorButton:
                paintView.setColor(context.getResources().getColor(R.color.darkGreen,null));
                string = "Dark Green";
                toastFinal();
                break;
            case R.id.WhiteColorButton:
                paintView.setColor(context.getResources().getColor(R.color.white,null));
                string = "White";
                toastFinal();
                break;
            case R.id.BlackColorButton:
                paintView.setColor(context.getResources().getColor(R.color.black,null));
                string = "Black";
                toastFinal();
                break;
        }
    }

    private void toastFinal(){
        Toast.makeText(context,"Color: " + string,Toast.LENGTH_SHORT).show();
    }
}

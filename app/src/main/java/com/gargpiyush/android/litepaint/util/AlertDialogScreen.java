package com.gargpiyush.android.litepaint.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.gargpiyush.android.litepaint.R;
import com.gargpiyush.android.litepaint.paint.PaintView;

/**
 * Created by Piyush Garg on 2/20/2019.
 */

public class AlertDialogScreen {

    public void showAlert(final Context context, PaintView paintView, String s1, String s2){
        new AlertDialog
                .Builder(context, R.style.AlertDialogTheme)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(s1)
                .setMessage(s2)
                .setPositiveButton(R.string.positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (s1.equals(context.getResources().getString(R.string.dialog_title))) {
                            paintView.clear();
                            Toast.makeText(context, "Canvas Cleared",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            ((Activity)context).finish();
                        }
                    }
                })
                .setNegativeButton(R.string.negative,null)
                .show();
    }
}

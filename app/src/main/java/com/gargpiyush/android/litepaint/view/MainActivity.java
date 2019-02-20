package com.gargpiyush.android.litepaint.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import com.gargpiyush.android.litepaint.R;
import java.util.List;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Piyush Garg on 2/18/2019.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.StartButton)
    Button startButton;

    @BindViews({R.id.LiteTextImage, R.id.PaintTextImage, R.id.PaintImage})
    List<ImageView> imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        TranslateAnimation animation = new TranslateAnimation(0.0f,0.0f,
                -200.0f,0.0f);
        animation.setInterpolator(new LinearInterpolator());
        animation.setDuration(2000);


        TranslateAnimation animation1 = new TranslateAnimation(0.0f,0.0f,
                200.0f,0.0f);
        animation1.setInterpolator(new LinearInterpolator());
        animation1.setDuration(2000);

        RotateAnimation animation2 = new RotateAnimation(0.0f, 360.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        animation2.setInterpolator(new LinearInterpolator());
        animation2.setDuration(2000);

        imageViews.get(0).startAnimation(animation);
        imageViews.get(1).startAnimation(animation1);
        imageViews.get(2).startAnimation(animation2);
    }

    @OnClick (R.id.StartButton)
    public void Start (View view){
        Intent intent = new Intent(MainActivity.this,PaintActivity.class);
        MainActivity.this.startActivity(intent);
        MainActivity.this.finish();
    }
}
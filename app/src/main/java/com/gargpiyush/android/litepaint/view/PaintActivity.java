package com.gargpiyush.android.litepaint.view;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gargpiyush.android.litepaint.R;
import com.gargpiyush.android.litepaint.paint.PaintView;
import com.gargpiyush.android.litepaint.util.AlertDialogScreen;
import com.gargpiyush.android.litepaint.util.ColorPicker;
import com.gargpiyush.android.litepaint.util.ToolsDrawer;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Piyush Garg on 2/18/2019.
 */

public class PaintActivity extends AppCompatActivity {

    @BindView(R.id.ColorSelectionButton)
    Button button;

    @BindView(R.id.ColorPaletteDrawer)
    LinearLayout linearLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.NavigationDrawer)
    NavigationView navigationView;

    @BindViews({R.id.BlueColorButton,R.id.PurpleColorButton,R.id.MagentaColorButton,
            R.id.MaroonColorButton,R.id.PinkColorButton,R.id.BrownColorButton,
            R.id.OrangeColorButton,R.id.YellowColorButton,R.id.lGreenColorButton,
            R.id.dGreenColorButton, R.id.WhiteColorButton,R.id.BlackColorButton})
    List<Button> buttonList;

    @BindViews({R.id.BrushButton,R.id.RollerButton,R.id.EraserButton,R.id.UndoButton,
            R.id.RedoButton,R.id.PlusButton,R.id.XSmallSize,R.id.SmallSize,R.id.MediumSize,
            R.id.LSize,R.id.XLargeSize})
    List<FloatingActionButton> floatingActionButtons;

    @BindView(R.id.paint_view)
    PaintView paintView;

    ColorPicker colorPicker;
    ToolsDrawer toolsDrawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.paint_activity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        paintView.init(displayMetrics);
        toolsDrawer = new ToolsDrawer(floatingActionButtons,PaintActivity.this,paintView);
        colorPicker = new ColorPicker(PaintActivity.this, paintView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()){
                    case R.id.help:
                        Fragment fragment = new HelpFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.drawer_layout,fragment,"helpFragment").addToBackStack("helpFragment");
                        fragmentTransaction.commit();
                        Toast.makeText(PaintActivity.this,
                                R.string.help,Toast.LENGTH_SHORT).show();
                        return true;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.clear_screen:
                new AlertDialogScreen().showAlert(this,paintView,
                        getResources().getString(R.string.dialog_title),
                        getResources().getString(R.string.dialog_message));
                return true;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick(R.id.ColorSelectionButton)
    public void openDrawer(View view){
        if (linearLayout.isShown()){
            linearLayout.setVisibility(View.INVISIBLE);
        }
        else {
            linearLayout.setVisibility(View.VISIBLE);
        }
    }

    @OnClick({R.id.BlueColorButton,R.id.PurpleColorButton,R.id.MagentaColorButton,
            R.id.MaroonColorButton,R.id.PinkColorButton,R.id.BrownColorButton,
            R.id.OrangeColorButton,R.id.YellowColorButton,R.id.lGreenColorButton,
            R.id.dGreenColorButton,R.id.WhiteColorButton,R.id.BlackColorButton})
    public void pickColor(Button button) {
        colorPicker.setColor(button.getId());
    }

    @OnClick({R.id.BrushButton,R.id.RollerButton,R.id.EraserButton,R.id.UndoButton,
            R.id.RedoButton,R.id.PlusButton,R.id.XSmallSize,R.id.SmallSize,R.id.MediumSize,
            R.id.LSize,R.id.XLargeSize})
    public void OpenTools(FloatingActionButton floatingActionButton) {
        toolsDrawer.OpenDrawer(floatingActionButton.getId());
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
            getSupportFragmentManager().popBackStack();
        }
        else {
            new AlertDialogScreen().showAlert(this,paintView,
                    getResources().getString(R.string.close_application_title),
                    getResources().getString(R.string.close_application_message));
        }
    }
}
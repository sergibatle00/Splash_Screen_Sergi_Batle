package com.example.splash_screen_sergi_batle;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView logo1;
    TextView logo2;
    TableLayout table;
    TableRow row;
    Animation fade1;
    Animation spinin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo1 = findViewById(R.id.TextViewTopTitle);
        logo2 = findViewById(R.id.TextViewBottomTitle);
        fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        spinin = AnimationUtils.loadAnimation(this, R.anim.custom_anim);

        animateAllViews();
    }


    private void clearAllAnimations() {
        for (int i = 0; i < table.getChildCount(); i++) {
            row = (TableRow) table.getChildAt(i);
            row.clearAnimation();
        }
    }


    private void animateAllViews() {
        LayoutAnimationController controller =
                new LayoutAnimationController(spinin);
        table = findViewById(R.id.TableLayout01);
        for (int i = 0; i < table.getChildCount(); i++) {
            row = (TableRow) table.getChildAt(i);
            row.setLayoutAnimation(controller);
        }
        clearAllAnimations();
    }


    private void animateLogos() {
        logo1.startAnimation(fade1);
        logo2.startAnimation(fade1);
    }


    @Override
    protected void onPause() {
        super.onPause();
        // Stop the animation
        logo1.clearAnimation();
        logo2.clearAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Resume the animation
        animateLogos();
    }
}
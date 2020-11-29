package com.example.constraintlayout;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class CuppcakeActivity extends AppCompatActivity {
    private boolean isLargeLayout = false;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuppcake_animation_layout);
        ConstraintSet constraintSet = new ConstraintSet();
        ConstraintSet constraintSet1 = new ConstraintSet();

        constraintSet1.clone(this, R.layout.activity_cuppcake_animation_transition_layout);

        ConstraintLayout constraintLayout = findViewById(R.id.constraint_layout);
        constraintSet.clone(constraintLayout);

        Button bakeButton = findViewById(R.id.button_bake);

        bakeButton.setOnClickListener(v -> {
            TransitionManager.beginDelayedTransition(constraintLayout);
            if (isLargeLayout)
                constraintSet.applyTo(constraintLayout);
            else
                constraintSet1.applyTo(constraintLayout);
            isLargeLayout = !isLargeLayout;
        });


    }
}

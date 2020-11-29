package com.example.constraintlayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class StateActivity extends AppCompatActivity {
    Handler handler = new Handler();
    boolean changed = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cl_states_start);
        ConstraintLayout stateConstraintLayout = findViewById(R.id.stateConstraintLayout);
        stateConstraintLayout.loadLayoutDescription(R.xml.constraint_layout_states_example);
        Button stateButton = findViewById(R.id.buttonBakeCake);
        stateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateConstraintLayout.setState(R.id.loading, 0, 0);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (changed)
                            stateConstraintLayout.setState(R.id.start, 0, 0);
                        else
                            stateConstraintLayout.setState(R.id.end, 0, 0);

                        changed = !changed;
                    }
                }, 3000L);

            }
        });
    }
}

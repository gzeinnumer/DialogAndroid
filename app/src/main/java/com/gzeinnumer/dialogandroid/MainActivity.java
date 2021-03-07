package com.gzeinnumer.dialogandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.timepicker.TimeFormat;
import com.gzeinnumer.da.dialog.timePickerDialog.TimeDialog;
import com.gzeinnumer.da.dialog.timePickerDialog.callback.TimeDialogPositiveCallBack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimeDialog(getSupportFragmentManager())
                        .setTitle("Time")
                        .setHour(17)
                        .setMinute(17)
                        .setTimeFormat(TimeFormat.CLOCK_24H)
                        .addOnPositiveButtonClickListener(new TimeDialogPositiveCallBack() {
                            @Override
                            public void timeResult(int hours, int minutes) {
                                Toast.makeText(MainActivity.this, hours + ":" + minutes, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build()
                        .show();
            }
        });
    }
}
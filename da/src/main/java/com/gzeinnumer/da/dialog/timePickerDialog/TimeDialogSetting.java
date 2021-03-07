package com.gzeinnumer.da.dialog.timePickerDialog;

import android.view.View;

import androidx.fragment.app.FragmentManager;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;
import com.gzeinnumer.da.dialog.timePickerDialog.callback.TimeDialogPositiveCallBack;

public class TimeDialogSetting {
    protected static final String TAG = "TimeDialog";
    protected FragmentManager supportFragmentManager;
    protected MaterialTimePicker materialTimePicker;
    protected TimeDialogPositiveCallBack timeValueResult;
    protected String title = "Pick Time";
    protected int timeFormat = TimeFormat.CLOCK_24H;
    protected int hour = 0;
    protected int minute = 0;

    protected void buildDialog() {
        materialTimePicker = new MaterialTimePicker.Builder()
                .setTimeFormat(timeFormat)
                .setTitleText(title)
                .setHour(hour)
                .setMinute(minute)
                .build();
        if (timeValueResult != null) {
            materialTimePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    timeValueResult.timeResult(materialTimePicker.getHour(), materialTimePicker.getMinute());
                }
            });
        }
    }
}

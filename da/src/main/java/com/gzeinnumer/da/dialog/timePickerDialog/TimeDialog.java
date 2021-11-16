package com.gzeinnumer.da.dialog.timePickerDialog;

import androidx.fragment.app.FragmentManager;

import com.gzeinnumer.da.dialog.timePickerDialog.callback.TimeDialogPositiveCallBack;

public class TimeDialog extends TimeDialogSetting {

    public TimeDialog() {
    }

    public TimeDialog(FragmentManager supportFragmentManager) {
        this.supportFragmentManager = supportFragmentManager;
    }

    public TimeDialog setTitle(String title) {
        this.title = (CharSequence)title;
        return this;
    }

    public TimeDialog setTitle(CharSequence title) {
        this.title = title;
        return this;
    }

    public TimeDialog setTimeFormat(int timeFormat) {
        this.timeFormat = timeFormat;
        return this;
    }

    public TimeDialog addOnPositiveButtonClickListener(TimeDialogPositiveCallBack timeValueResult) {
        this.timeValueResult = timeValueResult;
        return this;
    }

    public TimeDialog build() {
        buildDialog();
        return this;
    }

    public void show() {
        materialTimePicker.show(supportFragmentManager, TAG);
    }

    public TimeDialog setHour(int hour) {
        if (hour >= 0 && hour <= 23)
            this.hour = hour;
        return this;
    }

    public TimeDialog setMinute(int minute) {
        if (minute >= 0 && minute <= 60)
            this.minute = minute;
        return this;
    }
}

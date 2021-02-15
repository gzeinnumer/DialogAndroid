package com.gzeinnumer.da.dialog.timePickerDialog;

public class TimeValueResult {
    private final int hour;
    private final int minutes;

    public TimeValueResult(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }
}

package com.gzeinnumer.dialogandroid;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.timepicker.TimeFormat;
import com.gzeinnumer.da.constant.ButtonStyle;
import com.gzeinnumer.da.constant.DialogType;
import com.gzeinnumer.da.dialog.confirmDialog.ConfirmDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.multi.MultiDatePickerDialog;
import com.gzeinnumer.da.dialog.datePickerDialog.single.SingleDatePickerDialog;
import com.gzeinnumer.da.dialog.infoDialog.InfoDialog;
import com.gzeinnumer.da.dialog.loadingDialog.LoadingDialog;
import com.gzeinnumer.da.dialog.numberPicker.NumberPickerDialog;
import com.gzeinnumer.da.dialog.timePickerDialog.TimeDialog;
import com.gzeinnumer.da.dialog.timePickerDialog.callback.TimeDialogPositiveCallBack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        confirmDialog();
        infoDialog();
        numberPickerDialog();
        loadingDialog();
        singleDatePickerDialog();
        multiDatePickerDialog();
        timeDialog();
    }

    private void confirmDialog() {
        findViewById(R.id.ConfirmDialog).setOnClickListener(v -> new ConfirmDialog(getSupportFragmentManager())
                .setTitle("ini title")
                .setContent("ini content")
                .onCancelPressedCallBack(() -> Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show())
                .onOkPressedCallBack(() -> Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show())
                .show());
    }

    private void infoDialog() {
        findViewById(R.id.InfoDialog).setOnClickListener(v -> new InfoDialog(getSupportFragmentManager())
                .setAnimationStyle(R.style.CustomDialogStyle)
                .setButtonAllCaps(false)
                .autoDismisOnSecond(5)
                .setButtonGravity(Gravity.CENTER)
                .setContentAlignment(View.TEXT_ALIGNMENT_CENTER)
                .setTitleColor(getResources().getColor(R.color.black))
                .setButtonStyle(ButtonStyle.ButtonText)
//                .setButtonColor(getResources().getColor(R.color.colorPrimary))
                .setDialogType(DialogType.DialogSuccess)
                .setTitle("ini title")
                .setContent("ini content")
                .onOkPressedCallBack(() -> Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show())
                .show());
    }

    private void numberPickerDialog() {
        findViewById(R.id.NumberPickerDialog).setOnClickListener(v -> new NumberPickerDialog(getSupportFragmentManager())
                .setLastValue(12)
                .setTitle("ini title")
                .setContent("ini content")
                .onOkPressedCallBack(value -> Toast.makeText(MainActivity.this, "Nilai nya " + value, Toast.LENGTH_SHORT).show())
                .onCancelPressedCallBack(() -> Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show())
                .show());
    }

    private void loadingDialog() {
        findViewById(R.id.LoadingDialog).setOnClickListener(v -> {
            LoadingDialog loadingDialog = new LoadingDialog(getSupportFragmentManager())
                    .setContent("ini content");

            loadingDialog.show();

            new Handler().postDelayed(() -> loadingDialog.dismis(), 4000);
        });
    }

    private void singleDatePickerDialog() {
        findViewById(R.id.SingleDatePickerDialog).setOnClickListener(v -> new SingleDatePickerDialog(getSupportFragmentManager())
                .setTimeZone("GMT")
                .setTitle("Pilih tanggal")
                .setSelectedToday(true)
                .setTimeFormat("dd/MM/yyyy") //pastikan polanya sama
                .setStartDate("1/08/2020") //pastikan polanya sama
                .setEndDate("31/12/2020") //pastikan polanya sama
                .onOkPressedCallBack(value -> Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show())
                .build()
                .show());
    }

    private void multiDatePickerDialog() {
        findViewById(R.id.MultiDatePickerDialog).setOnClickListener(v -> new MultiDatePickerDialog(getSupportFragmentManager())
                .setTimeZone("GMT")
                .setTitle("Pilih tanggal")
                .setTimeFormat("dd/MM/yyyy") //pastikan 3 pola ini sama
                .setStartDate("1/08/2020") //pastikan 3 pola ini sama
                .setEndDate("31/12/2020") //pastikan 3 pola ini sama
                .onOkPressedCallBack((firstDate, secondDate) -> Toast.makeText(MainActivity.this, firstDate + " - " + secondDate, Toast.LENGTH_SHORT).show())
                .build()
                .show());
    }

    private void timeDialog() {
        findViewById(R.id.TimeDialog).setOnClickListener(v -> new TimeDialog(getSupportFragmentManager())
                .setTitle("Time")
                .setHour(17)
                .setMinute(17)
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .addOnPositiveButtonClickListener((hours, minutes) -> Toast.makeText(MainActivity.this, hours + ":" + minutes, Toast.LENGTH_SHORT).show())
                .build()
                .show());
    }
}
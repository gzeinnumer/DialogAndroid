package com.gzeinnumer.dialogandroid;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.da.constant.ButtonStyle;
import com.gzeinnumer.da.dialog.confirmDialog.ConfirmDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ConfirmDialog(getSupportFragmentManager())
//                .setTitle("ini title")
                .setButtonStyle(ButtonStyle.ButtonContained)
                .setContent("ini content")
                .setButtonOkColor(getResources().getColor(R.color.light_blue_A100))
                .setButtonCancelColor(getResources().getColor(R.color.grey_20))
                .setBtnCancelTitleColor(getResources().getColor(R.color.red_500))
                .onCancelPressedCallBack(new ConfirmDialog.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .onOkPressedCallBack(new ConfirmDialog.OnOkPressed() {
                    @Override
                    public void onOkPressed() {
                        Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}
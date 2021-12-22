package com.gzeinnumer.da.dialog.debug;

import android.graphics.drawable.Drawable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gzeinnumer.da.constant.ButtonStyle;
import com.gzeinnumer.da.constant.DialogType;

public class DebugDialog extends DebugDialogSetting {

    public static final String TAG = "CustomDialog";

    private FragmentManager _context;
    private FragmentTransaction _transaction;

    public DebugDialog() {
    }

    public DebugDialog(FragmentManager context) {
        this._context = context;

        _transaction = _context.beginTransaction();
        Fragment previous = _context.findFragmentByTag(DebugDialog.TAG);
        if (previous != null) {
            _transaction.remove(previous);
        }
    }

    public DebugDialog setAnimationStyle(int animationStyle) {
        this.animationStyle = animationStyle;
        return this;
    }

    //CANVAS
    public DebugDialog setDialogCanvas(Drawable resource) {
        this.shapeCanvas = resource;
        return this;
    }

    //TITLE
    public DebugDialog setTitleSize(int size) {
        this.tvTitleSize = size;
        return this;
    }

    public DebugDialog setTitleAlignment(int alignment) {
        this.tvTitleAlignment = alignment;
        return this;
    }

    //CONTENT
    public DebugDialog setContent(String content) {
        this.tvContentValue = (CharSequence)content;
        return this;
    }

    public DebugDialog setContent(CharSequence content) {
        this.tvContentValue = content;
        return this;
    }

    public DebugDialog setContentSize(int size) {
        this.tvContentSize = size;
        return this;
    }

    public DebugDialog setContentColor(int color) {
        this.tvContentColor = color;
        return this;
    }

    //OK
    public DebugDialog setBtnOkTitle(String title) {
        this.dBtnOkValue = title;
        return this;
    }

    public DebugDialog setBtnOkTitleColor(int color) {
        this.btnTextColorOk = color;
        return this;
    }

    //OK ICON
    public DebugDialog setOkIconLeft(int icon) {
        this.okIconL = icon;
        return this;
    }

    public DebugDialog setOkIconTop(int icon) {
        this.okIconT = icon;
        return this;
    }

    public DebugDialog setOkIconRight(int icon) {
        this.okIconR = icon;
        return this;
    }

    public DebugDialog setOkIconBottom(int icon) {
        this.okIconB = icon;
        return this;
    }

    //BUTTON STYLE
    public DebugDialog setButtonTextSize(int size) {
        this.dBtnTextSize = size;
        return this;
    }

    public DebugDialog setButtonColor(int color) {
        this.buttonColor = color;
        return this;
    }

    //ACTION CALLBACK
    public DebugDialog onCancelPressedCallBack(OnCancelPressed callBack) {
        this.onCancelPressed = callBack;
        return this;
    }

    public DebugDialog onOkPressedCallBack(OnOkPressed callBack) {
        this.onOkPressed = callBack;
        return this;
    }

    //cancleable
    public DebugDialog setCanceledOnTouchOutside(boolean enableOnTouch) {
        this.canceledOnTouchOutside = enableOnTouch;
        return this;
    }

    public void show() {
        this.show(_transaction, DebugDialog.TAG);
    }

    //callback
    public interface OnCancelPressed {
        void onCancelPressed();
    }

    public interface OnOkPressed {
        void onOkPressed();
    }
}
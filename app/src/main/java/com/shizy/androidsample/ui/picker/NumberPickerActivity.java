package com.shizy.androidsample.ui.picker;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import com.shizy.androidsample.R;

/**
 * Created by shizy on 2017/6/4.
 */

public class NumberPickerActivity extends AppCompatActivity {

    private static final String[] VALUES = new String[]{"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_picker);
        NumberPicker picker = (NumberPicker) findViewById(R.id.picker);
        initPicker(picker);
    }

    public void alertDialog(View view) {
        NumberPicker picker = new NumberPicker(this);
        initPicker(picker);
        new AlertDialog.Builder(this, android.support.v7.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert)
                .setView(picker)
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", null)
                .show();
    }

    private void initPicker(NumberPicker picker) {
        picker.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        picker.setDisplayedValues(VALUES);
        picker.setMinValue(0);
        picker.setMaxValue(VALUES.length - 1);
        picker.setWrapSelectorWheel(false);
    }

}

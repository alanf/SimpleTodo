package com.professionalaf.alan.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    public static final String ItemPositionKey = "itemPosition";
    public static final String ItemTextKey = "itemText";
    public static final int EditItemSuccessCode = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String itemText = getIntent().getStringExtra(ItemTextKey);
        EditText editText = (EditText) findViewById(R.id.etEditItem);
        editText.setText(itemText);
    }

    public void onSaveItem(View v) {
        Intent data = new Intent();
        int position = getIntent().getIntExtra(ItemPositionKey, -1);
        data.putExtra(ItemPositionKey, position);

        EditText editText = (EditText) findViewById(R.id.etEditItem);
        data.putExtra(ItemTextKey, editText.getText().toString());

        setResult(EditItemSuccessCode, data);
        finish();
    }
}

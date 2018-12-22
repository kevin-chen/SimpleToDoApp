package com.example.kchen0503.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.kchen0503.simpletodo.MainActivity.ITEM_POSITION;
import static com.example.kchen0503.simpletodo.MainActivity.ITEM_TEXT;

public class EditItemActivity extends AppCompatActivity {

    // Track edit item
    EditText etItemText;
    // Position of edited item in list
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        // Resolve edit text from layout
        etItemText = (EditText) findViewById(R.id.editText);
        // set edit text value from intent extra
        etItemText.setText(getIntent().getStringExtra(ITEM_TEXT));
        // update position from intent extra
        position = getIntent().getIntExtra(ITEM_POSITION, 0);
        // update the title bar of the activity
        getSupportActionBar().setTitle("Edit Item");
    }

    // handler for save button
    public void onSaveItem(View v) {
        // prepare new intent for result
        Intent i = new Intent();
        i.putExtra(ITEM_TEXT, etItemText.getText().toString());
        // pass original position as extra
        i.putExtra(ITEM_POSITION, position);
        // set the intent as the result of the activity
        setResult(RESULT_OK, i);
        // close the activity and redirect to main
        finish();
    }
}

package com.thoughtworks;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.thoughtworks.service.ResultsFromWeb;

public class GameDepo extends ListActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = (ListView) findViewById(R.id.listView);


        
        View view = findViewById(R.id.searchButton);
        view.setOnKeyListener(new CustomKeyListener((EditText) findViewById(R.id.editTextId)));
    }

    static class CustomKeyListener implements View.OnKeyListener {
        private EditText editTextView;

        public CustomKeyListener(EditText editTextView) {
            this.editTextView = editTextView;
        }

        public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
            if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
                new ResultsFromWeb().find(editTextView.getText());

            }
            return false;
        }
    }
}

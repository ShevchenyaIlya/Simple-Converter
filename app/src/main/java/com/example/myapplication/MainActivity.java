package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mainTextView;
    CharSequence converterCategory;
    EditText editText1;
    EditText editText2;

    Spinner spinner_from;
    Spinner spinner_to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = (TextView) findViewById(R.id.textView);
        editText1 = (EditText) findViewById(R.id.etNum1);
        editText2 = (EditText) findViewById(R.id.etNum2);

        spinner_from = (Spinner) findViewById(R.id.first_spinner);
        spinner_to = (Spinner) findViewById(R.id.second_spinner);

        editText1.setInputType(InputType.TYPE_NULL);
        editText1.setTextIsSelectable(true);

        editText2.setInputType(InputType.TYPE_NULL);
        editText2.setTextIsSelectable(true);
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        menu.add("Distance");
        menu.add("Weight");
        menu.add("Currency");

        return super.onCreateOptionsMenu(menu);
    }

    private void initViews() {
        findViewById(R.id.key_0).setOnClickListener(this);
        findViewById(R.id.key_1).setOnClickListener(this);
        findViewById(R.id.key_2).setOnClickListener(this);
        findViewById(R.id.key_3).setOnClickListener(this);
        findViewById(R.id.key_4).setOnClickListener(this);
        findViewById(R.id.key_5).setOnClickListener(this);
        findViewById(R.id.key_6).setOnClickListener(this);
        findViewById(R.id.key_7).setOnClickListener(this);
        findViewById(R.id.key_8).setOnClickListener(this);
        findViewById(R.id.key_9).setOnClickListener(this);
        findViewById(R.id.key_clear).setOnClickListener(this);
        findViewById(R.id.key_done).setOnClickListener(this);
        findViewById(R.id.key_dot).setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        if (view.getTag() != null && "number_button".equals(view.getTag())) {
            editText1.append(((TextView) view).getText());
            return;
        }
        switch (view.getId()) {
            case R.id.key_clear: {
                Editable editable = editText1.getText();
                int charCount = editable.length();
                if (charCount > 0) {
                    editable.delete(charCount - 1, charCount);
                }
            }
            break;

            case R.id.key_done: {
                if (mainTextView.getText().equals("Choose category!")) {
                    Toast.makeText(this, "Warning. Choose category!", Toast.LENGTH_LONG).show();
                }
                else {
                    String first_value = spinner_from.getSelectedItem().toString();
                    String second_value = spinner_to.getSelectedItem().toString();

                    Converter converter = new Converter(editText1, editText2, this);
                    converter.convertValues(first_value, second_value, converterCategory);
                }
            }
            break;
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
        CharSequence title = item.getTitle();

        if ("Distance".contentEquals(title)) {
            mainTextView.setText(R.string.distance_category);

            String[] distanceSpinner = new String[] {
                    "Meters", "Kilometers", "Miles",
            };
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, distanceSpinner);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_from.setAdapter(adapter);
            spinner_to.setAdapter(adapter);

        } else if ("Weight".contentEquals(title)) {
            mainTextView.setText(R.string.weight_category);

            String[] distanceSpinner = new String[] {
                    "Grams", "Kilograms", "Pounds",
            };
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, distanceSpinner);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_from.setAdapter(adapter);
            spinner_to.setAdapter(adapter);

        } else if ("Currency".contentEquals(title)) {
            mainTextView.setText(R.string.currency_category);

            String[] currencySpinner = new String[] {
                    "BYN", "RUB", "USD", "EUR"
            };
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, currencySpinner);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_from.setAdapter(adapter);
            spinner_to.setAdapter(adapter);
        }
        converterCategory = title;

        return super.onOptionsItemSelected(item);
    }

    public void swapValuesClick(View view) {
        String firstEditorValue = editText1.getText().toString();
        String secondEditorValue = editText2.getText().toString();
        if (!firstEditorValue.equals("") && !secondEditorValue.equals("")) {
            editText1.setText(secondEditorValue);
            editText2.setText(firstEditorValue);

            String firstSpinnerValue = spinner_from.getSelectedItem().toString();
            String secondSpinnerValue = spinner_to.getSelectedItem().toString();

            spinner_from.setSelection(((ArrayAdapter) spinner_from.getAdapter()).getPosition(secondSpinnerValue));
            spinner_to.setSelection(((ArrayAdapter) spinner_to.getAdapter()).getPosition(firstSpinnerValue));
        }
    }

    public void leftSaveButtonClick(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", editText1.getText().toString());
        clipboard.setPrimaryClip(clip);
    }

    public void rightSaveButtonClick(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", editText2.getText().toString());
        clipboard.setPrimaryClip(clip);
    }
}

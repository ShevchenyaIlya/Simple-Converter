package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "";

    private static final String TAG = "myLogs";

//    final int MENU_COLOR_RED = 1;
//    final int MENU_COLOR_GREEN = 2;
//    final int MENU_COLOR_BLUE = 3;
//
//    final int MENU_SIZE_22 = 4;
//    final int MENU_SIZE_26 = 5;
//    final int MENU_SIZE_30 = 6;
//
//    TextView tvColor, tvSize;
//
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v,
//                                    ContextMenu.ContextMenuInfo menuInfo) {
//        switch (v.getId()) {
//            case R.id.tvColor:
//                menu.add(0, MENU_COLOR_RED, 0, "Red");
//                menu.add(0, MENU_COLOR_GREEN, 0, "Green");
//                menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
//                break;
//            case R.id.tvSize:
//                menu.add(0, MENU_SIZE_22, 0, "22");
//                menu.add(0, MENU_SIZE_26, 0, "26");
//                menu.add(0, MENU_SIZE_30, 0, "30");
//                break;
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);

        // прописываем обработчик
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
//        Log.d(TAG, "First");
//        tvOut = (TextView) findViewById(R.id.tvOut);
//        btnOk = (Button) findViewById(R.id.btnOk);
//        btnCancel = (Button) findViewById(R.id.btnCancel);
//
////        tvColor = (TextView) findViewById(R.id.tvColor);
////        tvSize = (TextView) findViewById(R.id.tvSize);
//
//        Log.d(TAG, "Second");
//        View.OnClickListener oclBtnOk = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tvOut.setText("Нажата кнопка OK");
//            }
//        };
//
//        View.OnClickListener oclBtnCancel = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tvOut.setText("Нажата кнопка Cancel");
//                setContentView(R.layout.myscreen);
//            }
//        };

//        View.OnClickListener multyMethod = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switch (view.getId()) {
//                    case R.id.btnOk:
//                        tvOut.setText("Нажата кнопка OK");
//                        break;
//                    case R.id.btnCancel:
//                        tvOut.setText("Нажата кнопка Cancel");
//                        break;
//                }
//            }
//        };
//        btnOk.setOnClickListener(this);
//        btnCancel.setOnClickListener(this);

//        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
//        TextView textView = (TextView) findViewById(R.id.textView);
//         Button button = (Button) findViewById(R.id.button);
//
//        checkBox.setChecked(true);
//        textView.setText("Text is updated");
//        button.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        // Проверяем поля на пустоту
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        // читаем EditText и заполняем переменные числами
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        // определяем нажатую кнопку и выполняем соответствующую операцию
        // в oper пишем операцию, потом будем использовать в выводе
        switch (v.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }

        // формируем строку вывода
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }


//    @Override
//    public void onClick(View view) {
//        Log.d(TAG, "Inside OnClick");
//        switch (view.getId()) {
//            case R.id.btnOk:
//                Log.d(TAG, "Ok");
//                tvOut.setText("Нажата кнопка OK");
//                Toast.makeText(this, "Нажата кнопка OK", Toast.LENGTH_LONG).show();
//                break;
//            case R.id.btnCancel:
//                Log.d(TAG, "Close");
//                tvOut.setText("Нажата кнопка Cancel");
//                Toast.makeText(this, "Нажата кнопка Cancel", Toast.LENGTH_LONG).show();
//                break;
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        menu.add("menu1");
        menu.add("menu2");
        menu.add("menu3");
        menu.add("menu4");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }


}

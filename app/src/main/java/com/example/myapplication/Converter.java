package com.example.myapplication;

import android.widget.EditText;
import android.widget.Toast;

public class Converter {

    EditText editText1;
    EditText editText2;
    MainActivity mainActivity;

    public Converter(EditText editText1, EditText editText2,
                     MainActivity mainActivity) {
        this.editText1 = editText1;
        this.editText2 = editText2;
        this.mainActivity = mainActivity;
    }
    public void convertValues(String first_value, String second_value,  CharSequence converterCategory) {
        double value = 0;

        try {
            value = Double.parseDouble(editText1.getText().toString());
        } catch (Exception ex) {
            editText1.setText("");
            editText2.setText("");
            Toast.makeText(mainActivity, "Incorrect input value!", Toast.LENGTH_LONG).show();
        }

        if (!editText1.getText().toString().equals("")) {
            double result = 0;
            if (!first_value.equals(second_value)) {
                switch(converterCategory.toString()) {
                    case "Distance": {

                        if (first_value.equals("Meters") && second_value.equals("Kilometers")) {
                            result = value / 1000;
                        } else if (first_value.equals("Kilometers") && second_value.equals("Meters")) {
                            result = value * 1000;
                        } else if (first_value.equals("Meters") && second_value.equals("Miles")) {
                            result = value / 1609.34;
                        } else if (first_value.equals("Miles") && second_value.equals("Meters")) {
                            result = value * 1609.34;
                        } else if (first_value.equals("Kilometers") && second_value.equals("Miles")) {
                            result = value / 1.60934;
                        } else if (first_value.equals("Miles") && second_value.equals("Kilometers")) {
                            result = value * 1.60934;
                        }
                    }
                    break;

                    case "Weight": {
                        if (first_value.equals("Grams") && second_value.equals("Kilograms")) {
                            result = value / 1000;
                        } else if (first_value.equals("Kilograms") && second_value.equals("Grams")) {
                            result = value * 1000;
                        } else if (first_value.equals("Grams") && second_value.equals("Pounds")) {
                            result = value / 453.59237;
                        } else if (first_value.equals("Pounds") && second_value.equals("Grams")) {
                            result = value * 453.59237;
                        } else if (first_value.equals("Kilograms") && second_value.equals("Pounds")) {
                            result = value / 0.45359237;
                        } else if (first_value.equals("Pounds") && second_value.equals("Kilograms")) {
                            result = value * 0.45359237;
                        }
                    }
                    break;

                    case "Currency" : {
                        if (first_value.equals("BYN") && second_value.equals("RUB")) {
                            result = value * 28.49;
                        } else if (first_value.equals("RUB") && second_value.equals("BYN")) {
                            result = value / 28.49;
                        } else if (first_value.equals("BYN") && second_value.equals("USD")) {
                            result = value * 0.38;
                        } else if (first_value.equals("USD") && second_value.equals("BYN")) {
                            result = value / 0.38;
                        } else if (first_value.equals("BYN") && second_value.equals("EUR")) {
                            result = value * 0.32;
                        } else if (first_value.equals("EUR") && second_value.equals("BYN")) {
                            result = value / 0.32;
                        } else if (first_value.equals("RUB") && second_value.equals("EUR")) {
                            result = value / 90.0499048;
                        } else if (first_value.equals("EUR") && second_value.equals("RUB")) {
                            result = value * 90.0499048;
                        } else if (first_value.equals("RUB") && second_value.equals("USD")) {
                            result = value / 76.1035008;
                        } else if (first_value.equals("USD") && second_value.equals("RUB")) {
                            result = value * 76.1035008;
                        } else if (first_value.equals("USD") && second_value.equals("EUR")) {
                            result = value / 0.845773248;
                        } else if (first_value.equals("EUR") && second_value.equals("USD")) {
                            result = value * 0.845773248;
                        }
                    }
                    break;
                }
            }
            else {
                result = value;
            }
            editText2.setText(String.valueOf(result));
        }
    }
}

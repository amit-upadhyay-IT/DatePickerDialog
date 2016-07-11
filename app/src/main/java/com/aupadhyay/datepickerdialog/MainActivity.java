package com.aupadhyay.datepickerdialog;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    DatePickerDialog datePickerDialog;// this will be used to display the Date Picker Options
    DatePickerDialog.OnDateSetListener onDateSetListener;// this will be used as event listener after the user has choosen date from the date picker.

    int dd, mm, yy;

    public void initDatePickerDialog()
    {
        textView = (TextView) findViewById(R.id.textView);// we will use this to display the chosen date.
        button = (Button) findViewById(R.id.buttonDatePicker);// On Click of this button the used should see the Date Picker menu.

        Calendar calendar = Calendar.getInstance(Locale.getDefault());

        dd = calendar.get(Calendar.DAY_OF_MONTH);
        mm = calendar.get(Calendar.MONTH);
        yy = calendar.get(Calendar.YEAR);

        // now we have to set these attributes on the Date Picker dialog so that on opening the DatePicker we would be able to see these dates by default.
        // for this we get the reference of the object of DatePickeDialog class.
        // but while getting the reference we need to pass the object of OnDateSetListener as the second argument. So lets create that anonyomous class.

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                textView.setText(String.format("%s/%s/%s", String.valueOf(dd), String.valueOf(mm + 1), String.valueOf(yy)));
            }
        };

        // now we can get the reference of DatePickerDialog
        datePickerDialog = new DatePickerDialog(this, onDateSetListener, yy, mm, dd);

        // now if someone clicks on the Button then we need to show the DatePickerDialog.

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatePickerDialog();
    }
}

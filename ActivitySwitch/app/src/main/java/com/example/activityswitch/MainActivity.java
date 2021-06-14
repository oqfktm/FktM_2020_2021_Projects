package com.example.activityswitch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.activityswitch.MESSAGE";
    AlertDialog.Builder builder;
    EditText input;
    public int value = 0;
    public String send = "Default";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Projekt MF");
        final TextView valueTextView = (TextView) findViewById(R.id.valueTextView);
        final TextView sendTextView = (TextView) findViewById(R.id.sendTextView);

        valueTextView.setText("Value: " + value);
        sendTextView.setText("TextView: " + send);

        builder = new AlertDialog.Builder(this);
        input = new EditText(this);

        configureNextButton();
        configureToastButton();
        configureDialogButton(valueTextView);
        configureChangeButton(sendTextView);
        configureSendButton();
    }

    private void configureNextButton() {
        Button nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
    private void configureToastButton() {
        Button toastButton = (Button) findViewById(R.id.toastButton);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Toto je Toast", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void configureDialogButton(TextView valueTextView) {
        Button dialogButton = (Button) findViewById(R.id.dialogButton);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Chcete pridať 1 ku value?")
                        .setTitle("Potvrdenie")
                        .setCancelable(false)
                        .setPositiveButton("Áno", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                value++;
                                valueTextView.setText("Value: " + value);
                            }

                });
                builder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }

    private void configureChangeButton(TextView sendTextView) {
        Button changeButton = (Button) findViewById(R.id.changeButton);
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Čo by ste chceli mať v TextView?")
                        .setTitle("Zmena TextView")
                        .setCancelable(false);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        send = input.getText().toString();
                        sendTextView.setText("TextView: " + send);
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();


            }
        });
    }

    private void configureSendButton() {
        Button sendButton = (Button) findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SendActivity.class);
                intent.putExtra(EXTRA_MESSAGE, send);
                startActivity(intent);
            }
        });
    }

}
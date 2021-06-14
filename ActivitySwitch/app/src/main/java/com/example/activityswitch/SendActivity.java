package com.example.activityswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        setTitle("TextView Ukážka");

        final TextView messageView = (TextView) findViewById(R.id.messageView);

        Intent intent = getIntent();
        String receive = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        messageView.setText("TextView: " + receive);

        configureReturnButton();
    }

    private void configureReturnButton() {
        Button returnButton = (Button) findViewById(R.id.returnButton); returnButton.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {finish();}});}
}
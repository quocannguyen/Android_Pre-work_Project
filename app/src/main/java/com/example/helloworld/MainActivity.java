package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text);

        // User can tap a button to change the text color of the label.
//        findViewById(R.id.changeTextColorButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
        findViewById(R.id.changeTextColorButton).setOnClickListener(lambda -> {
            // change the text color of the label
//            textView.setTextColor(getResources().getColor(R.color.yellow));
            textView.setTextColor(getRandomColor());
        });

        // User can tap a button to change the color of the background view.
//        findViewById(R.id.changeBackgroundColorButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
        findViewById(R.id.changeBackgroundColorButton).setOnClickListener(lambda -> {
            // change the color of the background view.
            // #b0e0e6 - light blue
//            findViewById(R.id.parent).setBackgroundColor(getResources().getColor(R.color.light_blue));
            findViewById(R.id.parent).setBackgroundColor(getRandomColor());
        });

//        // User can tap a button to change the text string of the label - Android is Awesome!
//        findViewById(R.id.changeTextStringButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // change the text string of the label - Android is Awesome!
//                ((TextView) findViewById(R.id.text)).setText("Android is awesome!");
//            }
//        });

        // User can tap on the background view to reset all views to default settings.
//        findViewById(R.id.parent).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
        findViewById(R.id.parent).setOnClickListener(lambda -> {
            // 1. Reset the text to "Hello from Nathan!" id - @id/text
            textView.setText(getResources().getString(R.string.defaultTextString));

            // 2. Reset the text color to original color
            // Original text color - black, text id - @id/text
            textView.setTextColor(getResources().getColor(R.color.black));

            // 3. Reset the background color
            // Original background color - R.color.white
            findViewById(R.id.parent).setBackgroundColor(getResources().getColor(R.color.white));
        });

        // User can tap the “Change text string” button to update the label with the text from the text field.
//        findViewById(R.id.changeTextStringButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
        findViewById(R.id.changeTextStringButton).setOnClickListener(lambda -> {
            // update the label with the text from the text field.
            String userText = ((EditText) findViewById(R.id.editText)).getText().toString();

            // If the text field is empty, update label with default text string.
            if (userText.isEmpty()) userText = "Enter your own text!";

            textView.setText(userText);
        });
    }

    public int getRandomColor() {
        Random random = new Random();
        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
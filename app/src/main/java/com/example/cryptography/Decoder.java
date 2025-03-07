package com.example.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Decoder extends AppCompatActivity {
    EditText etdec;
    TextView dectv;
    ClipboardManager cplboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoder);

        etdec = findViewById(R.id.etVar1);
        dectv = findViewById(R.id.tvVar2);

        cplboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
    }
    public void dec(View view)
    {
        String temp = etdec.getText().toString();
        Log.e("dec", "text - "+temp);

        String rv = Decode.decode(temp);
        dectv.setText(rv);
        Log.e("dec", "text - "+rv);
    }

    public void cpl(View view)
    {
        String data = dectv.getText().toString().trim();
        if(!data.isEmpty())
        {
            ClipData temp = ClipData.newPlainText("text",data);
            Toast.makeText(this,"copied",Toast.LENGTH_SHORT).show();
        }
    }
}
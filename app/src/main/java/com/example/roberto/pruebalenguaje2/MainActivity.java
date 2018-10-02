package com.example.roberto.pruebalenguaje2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.roberto.pruebalenguaje2.Preferences;

public class MainActivity extends AppCompatActivity {
    private static MainActivity applicationInstance;
    Button buttonSpanish;
    Button buttonEnglish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        applicationInstance = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.getInstance().initAppLanguage(this);

        buttonSpanish = (Button) findViewById(R.id.buttonSpanish);
        buttonEnglish = (Button) findViewById(R.id.buttonEnglish);
        buttonSpanish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                cambiarASpain();
                Log.i("Main",Preferences.getSelectedLanguageId());
                Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                startActivity(i);

            }
        });
        buttonEnglish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                cambiarAEnglish();
                Log.i("Main",Preferences.getSelectedLanguageId());
                Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                startActivity(i);

            }
        });
    }
    public void initAppLanguage(Context context){
        LocaleUtils.initialize(context, Preferences.getSelectedLanguageId() );
    }

    public static synchronized MainActivity getInstance() {
        return applicationInstance;
    }

    public void cambiarASpain(){
        Preferences.setSelectedLanguageId("es");
    }

    public void cambiarAEnglish(){
        Preferences.setSelectedLanguageId("en");
    }
}

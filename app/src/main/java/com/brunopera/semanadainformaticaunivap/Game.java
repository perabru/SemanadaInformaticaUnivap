package com.brunopera.semanadainformaticaunivap;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    TextView lblPergunta ;
    TextView lblResp ;



    public void proximaPergunta(View view){
        try {
            SQLiteDatabase semanaInfoDB = this.openOrCreateDatabase("Perguntas", MODE_PRIVATE, null);

            Cursor cursor = semanaInfoDB.rawQuery("SELECT * FROM perguntas ORDER BY RANDOM() LIMIT 1", null);



            int piadaIndex = cursor.getColumnIndex("piada");
            int respIndex = cursor.getColumnIndex("resp");


            cursor.moveToFirst();

            while (cursor != null) {

                //Log.i("Results - piada ", cursor.getString(piadaIndex));
                //Log.i("Results - resp", cursor.getString(respIndex));

                lblPergunta.setText(cursor.getString(piadaIndex));
                lblResp.setText(cursor.getString(respIndex));

                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        lblPergunta = (TextView) findViewById(R.id.lblPergunta);
        lblResp = (TextView) findViewById(R.id.lblResp);

        try {
           SQLiteDatabase semanaInfoDB = this.openOrCreateDatabase("Perguntas", MODE_PRIVATE, null);
           // semanaInfoDB.execSQL("CREATE TABLE IF NOT EXISTS perguntas(piada VARCHAR, resp VARCHAR)");

            // semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'O que uma impressora falou para outra?','Essa folha é sua ou é impressão minha?')");

            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'int x=10; int y = 10; int z = x+y; printf(%d,z) Qual o nome do filme?','Código da 20')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Por que o Linux usa o pinguim como mascote?','Porque ele não congela')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Quantos programadores são necessários para trocar uma lâmpada?','Nenhum. É um problema de Hardware')");

            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Como o Latino cantaria se fosse técnico de informática?','Hoje é party é no meu IP, pode aparecer, tem um slot para você')");
            Cursor cursor = semanaInfoDB.rawQuery("SELECT * FROM perguntas ORDER BY RANDOM() LIMIT 1", null);



            int piadaIndex = cursor.getColumnIndex("piada");
            int respIndex = cursor.getColumnIndex("resp");


            cursor.moveToFirst();

            while (cursor != null) {

                //Log.i("Results - piada ", cursor.getString(piadaIndex));
                //Log.i("Results - resp", cursor.getString(respIndex));

                lblPergunta.setText(cursor.getString(piadaIndex));
                lblResp.setText(cursor.getString(respIndex));

                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
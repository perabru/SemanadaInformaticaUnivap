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
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Qual a diferença entre o Batman e o Bill Gates?','O Batman consegue derrotar o Pinguim')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Qual é a linguagem de programação usada no laptop da Xuxa?','Ruby, porque a Xuxa adora os do ends (duendes)')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Por que a Barbie estava esculpindo o Ben 10 de costas para o Ken?','Porque ela estava fazendo o Ben sem olhar para Ken')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'O que é um Terapetua?','São 1024 gigapeutas')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Como se chama a linguagem de programação no universo de Star Wars?','JabbaScript')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Por que o Bill Gates só come lanche no Bobs?','Porque ele tem medo Big MAC')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Qual a banda favorita dos técnicos de informática','Banda Larga')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Para qual santo você reza quando esquece a senha?','São Login')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'O que C++ falou para o C?','Você não tem Classe')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Por que o livro do técnico de TI pula da página 403 para a 405? ','Porque a 404 não foi encontrada. E se o nerd for um bom moço, ele não lê a 403, porque é proibida.')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Por que o sapo entrou no computador?','Para procurar a RAM')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'O que aconteceu com o pintinho binário que não tinha 1?','Foi compilar e explodiu!')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Por que ninguém pisca quando Steve Jobs tira foto','Porque ele não usa Flash')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Como um webdesigner fecha a casa?','</home>.')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'O que é um JPG?','Um GIF desanimado.')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'O que é um astrólogo num cavalo?','Um cavaleiro do zodíaco')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Como o Batman dorme?','De Bruce')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'O que uma impressora falou para a outra?','De Essa folha no chão é sua ou é impressão minha?')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'O que o programador foi fazer no programa do Ratinho?','Exame de DNS')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Numa cidade havia muitas motos Yamaha e só duas Honda. Qual o nome do filme?','POCA HONDAS')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'O que a Lady Gaga cantou depois de sair com o Batman?','Oh-oh-oh-oh-oooh, caught in a Bat-romance.')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Por que o Homem-Aranha não vai ao Xuxa Park?','Porque tem medo de encontrar duendes.')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Acaba a luz do cinema em Tron, o legado. O que o filme vira?','Troff, o deslegado.')");
            semanaInfoDB.execSQL("INSERT INTO perguntas (piada, resp) VALUES ( 'Como se chamará o próximo filme do Hulk?','Hulk 2 – Vale a pena verde novo.')");

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
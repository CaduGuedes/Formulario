package forms.caduguedes.formulariotopocad;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.Normalizer;

import forms.caduguedes.formulariotopocad.database.DataBase;
import forms.caduguedes.formulariotopocad.dominio.ManipulaBanco;
import forms.caduguedes.formulariotopocad.dominio.entidades.Formulario;

public class QuintaPagina extends AppCompatActivity {


    //Declarando os EditText
    private EditText edtTestadaPrincipal;
    private EditText edtTestada2;
    private EditText edtCodTestada2;
    private EditText edtSecTestada2;
    private EditText edtTestada3;
    private EditText edtCodTestada3;
    private EditText edtSecTestada3;
    private EditText edtTestada4;
    private EditText edtCodTestada4;
    private EditText edtSecTestada4;
    private EditText edtAreaTerreno;
    private EditText edtAreaConstUni;
    private EditText edtTotalUnidades;
    private EditText edtAreaTotalConst;


    //Declarando os Buttons
    private Button avancar5;
    private Button voltar5;

    private ListView lstForms;
    private ArrayAdapter<Formulario> adpFormularios;
    private ManipulaBanco manipulaBanco;
    private Formulario formulario;

    //Declarando o Banco de Dados
    private DataBase dataBase;
    private SQLiteDatabase forms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quinta_pagina);

        //Criando a Referência pro meu BD
        try{

            dataBase = new DataBase(this);
            forms = dataBase.getWritableDatabase();


            manipulaBanco = new ManipulaBanco(forms);


        }catch (SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Criar o Banco." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }

        //Recuperando as ref dos EditText
        edtTestadaPrincipal = (EditText) findViewById(R.id.edtTestadaPrincipal);
        edtTestada2 = (EditText) findViewById(R.id.edtTestada2);
        edtCodTestada2 = (EditText) findViewById(R.id.edtCodTestada2);
        edtSecTestada2 = (EditText) findViewById(R.id.edtSecTestada2);
        edtTestada3 = (EditText) findViewById(R.id.edtTestada3);
        edtCodTestada3 = (EditText) findViewById(R.id.edtCodTestada3);
        edtSecTestada3 = (EditText) findViewById(R.id.edtSecTestada3);
        edtTestada4 = (EditText) findViewById(R.id.edtTestada4);
        edtCodTestada4 = (EditText) findViewById(R.id.edtCodTestada4);
        edtSecTestada4 = (EditText) findViewById(R.id.edtSecTestada4);
        edtAreaTerreno = (EditText) findViewById(R.id.edtAreaTerreno);
        edtAreaConstUni = (EditText) findViewById(R.id.edtAreaConstUni);
        edtTotalUnidades = (EditText) findViewById(R.id.edtTotalUnidades);
        edtAreaTotalConst = (EditText) findViewById(R.id.edtAreaTotalConst);


        //Recuperando as ref dos Buttons
        avancar5 = (Button) findViewById(R.id.avancar5);
        voltar5 = (Button) findViewById(R.id.voltar5);

        avancar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuintaPagina.this, SextaPagina.class); // intent é a intenção de fazer algo, no caso troca de tela
                startActivity(intent);
            }
        });

        voltar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuintaPagina.this, QuartaPagina.class); // intent é a intenção de fazer algo, no caso troca de tela
                startActivity(intent);
            }
        });



    }
}

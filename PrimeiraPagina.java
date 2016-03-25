package forms.caduguedes.formulariotopocad;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.HashMap;

import forms.caduguedes.formulariotopocad.database.DataBase;
import forms.caduguedes.formulariotopocad.dominio.ManipulaBanco;
import forms.caduguedes.formulariotopocad.dominio.entidades.Formulario;

public class PrimeiraPagina extends AppCompatActivity {

    //Declarando os EditText
    private EditText edtPrefeitura;
    private EditText edtDistrito1;
    private EditText edtSetor1;
    private EditText edtQuadra1;
    private EditText edtLote1;
    private EditText edtUnidade1;
    private EditText edtDistrito2;
    private EditText edtSetor2;
    private EditText edtQuadra2;
    private EditText edtLote2;
    private EditText edtUnidade2;
    private EditText edtNomeLogadouro;
    private EditText edtBairro1;
    private EditText edtNumero1;
    private EditText edtComplemento1;
    private EditText edtLoteamento1;
    private EditText edtQuadraImovel;
    private EditText edtLoteImovel;

    //Declarando os Botões
    private Button avancar1;

    private ListView lstForms;
    private ArrayAdapter<Formulario> adpFormularios;
    private ManipulaBanco manipulaBanco;
    private Formulario formulario;

    //Declarando o Banco de Dados
    private DataBase dataBase;
    private SQLiteDatabase forms;

    int codigo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_pagina);

        codigo = this.getIntent().getIntExtra("codigoID", 0);

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


        //Declaração dos EditText
        edtPrefeitura = (EditText) findViewById(R.id.edtPrefeitura);
        edtDistrito1 = (EditText) findViewById(R.id.edtDistrito1);
        edtSetor1 = (EditText) findViewById(R.id.edtSetor1);
        edtQuadra1 = (EditText) findViewById(R.id.edtQuadra1);
        edtLote1 = (EditText) findViewById(R.id.edtLote1);
        edtUnidade1 = (EditText) findViewById(R.id.edtUnidade1);
        edtDistrito2 = (EditText) findViewById(R.id.edtDistrito2);
        edtSetor2 = (EditText) findViewById(R.id.edtSetor2);
        edtQuadra2 = (EditText) findViewById(R.id.edtQuadra2);
        edtLote2 = (EditText) findViewById(R.id.edtLote2);
        edtUnidade2 = (EditText) findViewById(R.id.edtUnidade2);
        edtNomeLogadouro = (EditText) findViewById(R.id.edtNomeLogadouro);
        edtBairro1 = (EditText) findViewById(R.id.edtBairro1);
        edtComplemento1 = (EditText) findViewById(R.id.edtComplemento1);
        edtNumero1 = (EditText) findViewById(R.id.edtNumero1);
        edtLoteamento1 = (EditText) findViewById(R.id.edtLoteamento1);
        edtQuadraImovel = (EditText) findViewById(R.id.edtQuadraImovel);
        edtLoteImovel = (EditText) findViewById(R.id.edtLoteImovel);



        //Recuperando Referências dos Buttons

        avancar1 = (Button) findViewById(R.id.avancar1);

        avancar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inserirPrimeiraPagina(codigo);

                Intent intent = new Intent(PrimeiraPagina.this, SegundaPagina.class);
                intent.putExtra("codigoID", codigo);

                AlertDialog.Builder dlg = new AlertDialog.Builder(PrimeiraPagina.this);
                dlg.setMessage("VALOR DA ID QUE SAI NA PRIMEIRA PAG: " + codigo );
                dlg.setNeutralButton("OK", null);
                dlg.show();

                startActivity(intent);
                finish();

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_inicial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    private void inserirPrimeiraPagina(int codigoID){


        try {
            ContentValues values = new ContentValues();
           // String sql = "_id='" + codigoID +"'";
           // String[] campos = {"PREFEITURA"};

           // Cursor c = forms.query("FORMULARIO", campos, sql,null, null, null, null,null);

       //     Cursor c = forms.rawQuery("SELECT * FROM FORMULARIO WHERE _id='" + codigoID +"'", null);

       //     if(c.moveToFirst()) {

       //         forms.execSQL("UPDATE FORMULARIO SET PREFEITURA='" + edtPrefeitura.getText() + "'  WHERE _id='" + codigoID +"'");

            Cursor c = forms.rawQuery("SELECT * FROM FORMULARIO", null);
            if(c.moveToFirst()){

                forms.execSQL("UPDATE FORMULARIO SET PREFEITURA='" + edtPrefeitura.getText() + "'  WHERE _id='" + codigoID +"'");
                forms.insertOrThrow("FORMULARIO", null, values);
            }c.close();

              /*
                formulario.setPREFEITURA(edtPrefeitura.getText().toString());
                formulario.setDISTRITO1(edtDistrito1.getText().toString());
                formulario.setSETOR1(edtSetor1.getText().toString());
                formulario.setQUADRA1(edtQuadra1.getText().toString());
                formulario.setLOTE1(edtLote1.getText().toString());
                formulario.setUNIDADE1(edtUnidade1.getText().toString());
                formulario.setDISTRITO2(edtDistrito2.getText().toString());
                formulario.setSETOR2(edtSetor2.getText().toString());
                formulario.setQUADRA2(edtQuadra2.getText().toString());
                formulario.setLOTE2(edtLote2.getText().toString());
                formulario.setUNIDADE2(edtUnidade2.getText().toString());
                formulario.setNOME_LOGADOURO(edtNomeLogadouro.getText().toString());
                formulario.setBAIRRO1(edtBairro1.getText().toString());
                formulario.setNUMERO1(edtNumero1.getText().toString());
                formulario.setCOMPLEMENTO1(edtComplemento1.getText().toString());
                formulario.setLOTEAMENTO1(edtLoteamento1.getText().toString());
                formulario.setQUADRA_IMOVEL(edtQuadraImovel.getText().toString());
                formulario.setLOTE_IMOVEL(edtLoteImovel.getText().toString());
                */

            // }c.close();

        }catch (Exception ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Inserir os Dados." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

             }
        forms.close();

        }




}

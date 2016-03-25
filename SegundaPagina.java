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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import forms.caduguedes.formulariotopocad.database.DataBase;
import forms.caduguedes.formulariotopocad.dominio.ManipulaBanco;
import forms.caduguedes.formulariotopocad.dominio.entidades.Formulario;

public class SegundaPagina extends AppCompatActivity {

    //Declarando os EditText
    private EditText edtNomeProprietario;
    private EditText edtCPFProprietario;
    private EditText edtNomeConjuge;
    private EditText edtNomeLogProprietario;
    private EditText edtTipoLogProprietario;
    private EditText edtNumLogProprietario;
    private EditText edtComplemtoProprietario;
    private EditText edtBairroProprietario;
    private EditText edtMunicipioProprietario;
    private EditText edtCepProprietario;
    private EditText edtEstadoProprietario;


    //Declarando os Buttons
    private Button avancar2;
    private Button voltar2;

    //Declarando os RadioButtons
    private RadioButton rbtSolteiro;
    private RadioButton rbtCasado;
    private RadioButton rbtSeparado;
    private RadioButton rbtDivorciado;
    private RadioButton rbtViuvo;

    //Declarando o RadioGroup
    private RadioGroup rgpEstadoCivil;


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
        setContentView(R.layout.activity_segunda_pagina);

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

        //Recuperando as referências dos EditText
        edtNomeProprietario = (EditText) findViewById(R.id.edtNomeProprietario);
        edtCPFProprietario = (EditText) findViewById(R.id.edtCPFProprietario);
        edtNomeConjuge = (EditText) findViewById(R.id.edtNomeConjuge);
        edtNomeLogProprietario = (EditText) findViewById(R.id.edtNomeLogProprietario);
        edtTipoLogProprietario = (EditText) findViewById(R.id.edtTipoLogProprietario);
        edtNumLogProprietario = (EditText) findViewById(R.id.edtNumLogProprietario);
        edtComplemtoProprietario = (EditText) findViewById(R.id.edtComplemtoProprietario);
        edtBairroProprietario = (EditText) findViewById(R.id.edtBairroProprietario);
        edtMunicipioProprietario = (EditText) findViewById(R.id.edtMunicipioProprietario);
        edtCepProprietario = (EditText) findViewById(R.id.edtCepProprietario);
        edtEstadoProprietario = (EditText) findViewById(R.id.edtEstadoProprietario);

        //Recuperando as ref dos RadioButtons
        rbtSolteiro = (RadioButton) findViewById(R.id.rbtSolteiro);
        rbtCasado = (RadioButton) findViewById(R.id.rbtCasado);
        rbtSeparado = (RadioButton) findViewById(R.id.rbtSeparado);
        rbtDivorciado = (RadioButton) findViewById(R.id.rbtDivorciado);
        rbtViuvo = (RadioButton) findViewById(R.id.rbtViuvo);

        //Recuperando as ref do RadioGroup
        rgpEstadoCivil = (RadioGroup) findViewById(R.id.rgpEstadoCivil);


        //Recuperando as referências dos Buttons
        avancar2 = (Button) findViewById(R.id.avancar2);
        voltar2 = (Button) findViewById(R.id.voltar2);



        avancar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                inserir(codigo);
                Intent intent = new Intent(SegundaPagina.this, TelaInicial.class);


                AlertDialog.Builder dlg = new AlertDialog.Builder(SegundaPagina.this);
                dlg.setMessage("VALOR DA ID QUE SAI NA PRIMEIRA PAG: " + codigo);
                dlg.setNeutralButton("OK", null);
                dlg.show();

                startActivity(intent);

                finish();


            }
        });

        voltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaPagina.this, PrimeiraPagina.class); // intent é a intenção de fazer algo, no caso troca de tela
                startActivity(intent);
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



    private void inserir(int codigoID){



            try {
                ContentValues values = new ContentValues();
              //  String sql = "_id='" + codigoID +"'";
              //  String[] campos = {"PREFEITURA"};

                //Cursor c = forms.query("FORMULARIO", campos, sql,null, null, null, null,null);
              //  Cursor c = forms.rawQuery("SELECT * FROM FORMULARIO WHERE _id='" + codigoID +"'", null);

              //  if(c.moveToFirst()) {

                Cursor c = forms.rawQuery("SELECT * FROM FORMULARIO", null);
                if(c.moveToFirst()){

                    forms.execSQL("UPDATE FORMULARIO SET NOME_PROPRIETARIO='" + edtNomeProprietario.getText() + "'  WHERE _id='" + codigoID +"'");
                    forms.insertOrThrow("FORMULARIO", null, values);
                }c.close();

              //      forms.execSQL("UPDATE FORMULARIO SET NOME_PROPRIETARIO='" + edtNomeProprietario.getText() + "'  WHERE _id='" + codigoID +"'");
               // formulario = new Formulario();
                    /*
                    formulario.setNOME_PROPRIETARIO(edtNomeProprietario.getText().toString());
                    formulario.setCPF_PROPRIETARIO(edtCPFProprietario.getText().toString());
                    formulario.setNOME_CONJUGE(edtNomeConjuge.getText().toString());
                    formulario.setNOME_LOG_PROPRIETARIO(edtNomeLogProprietario.getText().toString());
                    formulario.setTIPO_LOG_PROPRIETARIO(edtTipoLogProprietario.getText().toString());
                    formulario.setNUM_LOG_PROPRIETARIO(edtNumLogProprietario.getText().toString());
                    formulario.setCOMPLEMENTO_PROPRIETARIO(edtComplemtoProprietario.getText().toString());
                    formulario.setBAIRRO_PROPRIETARIO(edtBairroProprietario.getText().toString());
                    formulario.setMUNICIPIO_PROPRIETARIO(edtMunicipioProprietario.getText().toString());
                    formulario.setCEP_PROPRIETARIO(edtCepProprietario.getText().toString());
                    formulario.setESTADO_PROPRIETARIO(edtEstadoProprietario.getText().toString());

                    formulario.setESTADO_CIVIL(String.valueOf(rgpEstadoCivil.getCheckedRadioButtonId()));
                  */


                  //  manipulaBanco.inserir(formulario);
             //  }c.close();

            }catch (Exception ex){

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("Erro ao Inserir os Dados." + ex.getMessage());
                dlg.setNeutralButton("OK", null);
                dlg.show();

            }

        forms.close();
    }


}

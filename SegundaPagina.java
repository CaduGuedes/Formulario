package forms.caduguedes.formulariotopocad;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

    long codigo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pagina);

        codigo = this.getIntent().getLongExtra("codigoID", 0);

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

        inserirVolteiDaTerceira(codigo);

        avancar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inserirSegundaPagina(codigo);
                Intent intent = new Intent(SegundaPagina.this, TerceiraPagina.class); //ULTIMA PAGINA VOLTA PARA TELA INICIAL SEMPRE
                intent.putExtra("codigoID", codigo);
                startActivity(intent);
                finish();

            }
        });

        voltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaPagina.this, PrimeiraPagina.class);
                intent.putExtra("codigoID", codigo);
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

    private String selectEstadoCivil() {
        String value = "Nada Consta";
        int opcao = rgpEstadoCivil.getCheckedRadioButtonId();

        if (opcao == R.id.rbtSolteiro) return rbtSolteiro.getText().toString();
        else if (opcao == R.id.rbtCasado) return rbtCasado.getText().toString();
        else if (opcao == R.id.rbtSeparado) return rbtSeparado.getText().toString();
        else if (opcao == R.id.rbtDivorciado) return rbtDivorciado.getText().toString();
        else if (opcao == R.id.rbtViuvo) return rbtViuvo.getText().toString();

        return String.valueOf(value);
    }


    private void inserirSegundaPagina(long codigoID) {

        try {

            String sql = "_id='" + codigoID + "'";
            String[] campos = {"NOME_PROPRIETARIO", "CPF_PROPRIETARIO", "NOME_CONJUGE", "NOME_LOG_PROPRIETARIO",
                    "TIPO_LOG_PROPRIETARIO", "NUM_LOG_PROPRIETARIO", "COMPLEMENTO_PROPRIETARIO", "BAIRRO_PROPRIETARIO",
                    "MUNICIPIO_PROPRIETARIO", "CEP_PROPRIETARIO", "ESTADO_PROPRIETARIO"};

            Cursor c = forms.query("FORMULARIO", campos, sql, null, null, null, null, null);

            if (c.moveToFirst()) {
                forms.execSQL("UPDATE FORMULARIO SET NOME_PROPRIETARIO='" + edtNomeProprietario.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET CPF_PROPRIETARIO='" + edtCPFProprietario.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET NOME_CONJUGE='" + edtNomeConjuge.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET NOME_LOG_PROPRIETARIO='" + edtNomeLogProprietario.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET TIPO_LOG_PROPRIETARIO='" + edtTipoLogProprietario.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET NUM_LOG_PROPRIETARIO='" + edtNumLogProprietario.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET COMPLEMENTO_PROPRIETARIO='" + edtComplemtoProprietario.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET BAIRRO_PROPRIETARIO='" + edtBairroProprietario.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET MUNICIPIO_PROPRIETARIO='" + edtMunicipioProprietario.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET CEP_PROPRIETARIO='" + edtCepProprietario.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET ESTADO_PROPRIETARIO='" + edtEstadoProprietario.getText() + "'  WHERE _id='" + codigoID + "'");

                //RadioGroups RETORNOS
                forms.execSQL("UPDATE FORMULARIO SET ESTADO_CIVIL='" + selectEstadoCivil() + "'  WHERE _id='" + codigoID + "'");


            }
            c.close();

            }catch (Exception ex){

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage("Erro ao Inserir os Dados." + ex.getMessage());
                dlg.setNeutralButton("OK", null);
                dlg.show();

            }
    }


    private void inserirVolteiDaTerceira(long codigoID) {

        try {
            forms = dataBase.getReadableDatabase();
            Cursor c = forms.rawQuery("SELECT * FROM FORMULARIO WHERE _id='" + codigoID + "'", null);

            if (c.moveToFirst()) {

                edtNomeProprietario.setText(c.getString(19));
                edtCPFProprietario.setText(c.getString(20));
                edtNomeConjuge.setText(c.getString(22));
                edtNomeLogProprietario.setText(c.getString(23));
                edtTipoLogProprietario.setText(c.getString(24));
                edtNumLogProprietario.setText(c.getString(25));
                edtComplemtoProprietario.setText(c.getString(26));
                edtBairroProprietario.setText(c.getString(27));
                edtMunicipioProprietario.setText(c.getString(28));
                edtCepProprietario.setText(c.getString(29));
                edtEstadoProprietario.setText(c.getString(30));
                //if(c.getString(21).equals("Solteiro(a)")) rbtSolteiro.setSelected(true);

            }c.close();

        }catch (Exception ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Inserir os Dados." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }
    }


}

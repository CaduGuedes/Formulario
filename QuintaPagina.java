package forms.caduguedes.formulariotopocad;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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

    long codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quinta_pagina);

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

        inserirVolteiDaSexta(codigo);

        avancar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserirQuintaPagina(codigo);
                Intent intent = new Intent(QuintaPagina.this, SextaPagina.class);
                intent.putExtra("codigoID", codigo);

                startActivity(intent);
                finish();
            }
        });

        voltar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuintaPagina.this, QuartaPagina.class);
                intent.putExtra("codigoID", codigo);
                startActivity(intent);
                finish();
            }
        });
    }

    private void inserirQuintaPagina(long codigoID) {


        try {
            String sql = "_id='" + codigoID + "'";
            String[] campos = {"TESTADA_PRINCIPAL", "TESTADA2", "COD_TESTADA2", "SEC_TESTADA2",
                    "TESTADA3", "COD_TESTADA3", "SEC_TESTADA3", "TESTADA4",
                    "COD_TESTADA4", "SEC_TESTADA4", "AREA_TERRENO",
                    "AREA_CONST_UNI", "TOTAL_UNIDADES", "AREA_TOTAL_CONST"};

            Cursor c = forms.query("FORMULARIO", campos, sql, null, null, null, null, null);
            if (c.moveToFirst()) {

                forms.execSQL("UPDATE FORMULARIO SET TESTADA_PRINCIPAL='" + edtTestadaPrincipal.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET TESTADA2='" + edtTestada2.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET COD_TESTADA2='" + edtCodTestada2.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET SEC_TESTADA2='" + edtSecTestada2.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET TESTADA3='" + edtTestada3.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET COD_TESTADA3='" + edtCodTestada3.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET SEC_TESTADA3='" + edtSecTestada3.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET TESTADA4='" + edtTestada4.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET COD_TESTADA4='" + edtCodTestada4.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET SEC_TESTADA4='" + edtSecTestada4.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET AREA_TERRENO='" + edtAreaTerreno.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET AREA_CONST_UNI='" + edtAreaConstUni.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET TOTAL_UNIDADES='" + edtTotalUnidades.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET AREA_TOTAL_CONST='" + edtAreaTotalConst.getText() + "'  WHERE _id='" + codigoID + "'");

            }
            c.close();

        } catch (Exception ex) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Inserir os Dados." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }
        //forms.close();

    }

    private void inserirVolteiDaSexta(long codigoID) {

            forms = dataBase.getReadableDatabase();
            Cursor c = forms.rawQuery("SELECT * FROM FORMULARIO WHERE _id='" + codigoID + "'", null);

            if (c.moveToFirst()) {

                edtTestadaPrincipal.setText(c.getString(42));
                edtTestada2.setText(c.getString(43));
                edtCodTestada2.setText(c.getString(44));
                edtSecTestada2.setText(c.getString(45));
                edtTestada3.setText(c.getString(46));
                edtCodTestada3.setText(c.getString(47));
                edtSecTestada3.setText(c.getString(48));
                edtTestada4.setText(c.getString(49));
                edtCodTestada4.setText(c.getString(50));
                edtSecTestada4.setText(c.getString(51));
                edtAreaTerreno.setText(c.getString(52));
                edtAreaConstUni.setText(c.getString(53));
                edtTotalUnidades.setText(c.getString(54));
                edtAreaTotalConst.setText(c.getString(55));

            }c.close();
    }


}

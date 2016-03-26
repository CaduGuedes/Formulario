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
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import forms.caduguedes.formulariotopocad.database.DataBase;
import forms.caduguedes.formulariotopocad.dominio.ManipulaBanco;
import forms.caduguedes.formulariotopocad.dominio.entidades.Formulario;

public class QuartaPagina extends AppCompatActivity {

    //Declarando os RadioButtons
    private RadioButton rbt1frente;
    private RadioButton rbt2frentes;
    private RadioButton rbt3frentes;
    private RadioButton rbt4frentes;
    private RadioButton rbtCondHoriz;
    private RadioButton rbtEscravado;
    private RadioButton rbtGleba;
    private RadioButton rbtAglomerado;
    private RadioButton rbtPlano;
    private RadioButton rbtAclive;
    private RadioButton rbtDeclive;
    private RadioButton rbtIrregular;
    private RadioButton rbtInundavel;
    private RadioButton rbtFirme;
    private RadioButton rbtAlagado;

    //Declarando os RadioGroups
    private RadioGroup rgpSituacaoTer;
    private RadioGroup rgpTopografiaTer;
    private RadioGroup rgpPedologiaTer;


    //Declarando os Buttons
    private Button avancar4;
    private Button voltar4;

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
        setContentView(R.layout.activity_quarta_pagina);

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

        //Recuperando as ref dos RadioButtons
        rbt1frente = (RadioButton) findViewById(R.id.rbt1frente);
        rbt2frentes = (RadioButton) findViewById(R.id.rbt2frentes);
        rbt3frentes = (RadioButton) findViewById(R.id.rbt3frentes);
        rbt4frentes = (RadioButton) findViewById(R.id.rbt4frentes);
        rbtCondHoriz = (RadioButton) findViewById(R.id.rbtCondHoriz);
        rbtEscravado = (RadioButton) findViewById(R.id.rbtEscravado);
        rbtGleba = (RadioButton) findViewById(R.id.rbtGleba);
        rbtAglomerado = (RadioButton) findViewById(R.id.rbtAglomerado);
        rbtPlano = (RadioButton) findViewById(R.id.rbtPlano);
        rbtAclive = (RadioButton) findViewById(R.id.rbtAclive);
        rbtDeclive = (RadioButton) findViewById(R.id.rbtDeclive);
        rbtIrregular = (RadioButton) findViewById(R.id.rbtIrregular);
        rbtInundavel = (RadioButton) findViewById(R.id.rbtInundavel);
        rbtFirme = (RadioButton) findViewById(R.id.rbtFirme);
        rbtAlagado = (RadioButton) findViewById(R.id.rbtAlagado);

        //Recuperando as ref dos RadioGroups
        rgpSituacaoTer = (RadioGroup) findViewById(R.id.rgpSituacaoTer);
        rgpTopografiaTer = (RadioGroup) findViewById(R.id.rgpTopografiaTer);
        rgpPedologiaTer = (RadioGroup) findViewById(R.id.rgpPedologiaTer);


        //Recuperando as ref dos Buttons
        avancar4 = (Button) findViewById(R.id.avancar4);
        voltar4 = (Button) findViewById(R.id.voltar4);

        avancar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserirQuartaPagina(codigo);
                Intent intent = new Intent(QuartaPagina.this, QuintaPagina.class); //ULTIMA PAGINA VOLTA PARA TELA INICIAL SEMPRE
                intent.putExtra("codigoID", codigo);

                startActivity(intent);
                finish();
            }
        });

        voltar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuartaPagina.this, TerceiraPagina.class);
                intent.putExtra("codigoID", codigo);
                startActivity(intent);
                finish();
            }
        });
    }


    private String selectSituacao() {
        String value = "Nada Consta";
        int opcao = rgpSituacaoTer.getCheckedRadioButtonId();

        if (opcao == R.id.rbt1frente) return rbt1frente.getText().toString();
        else if (opcao == R.id.rbt2frentes) return rbt2frentes.getText().toString();
        else if (opcao == R.id.rbt3frentes) return rbt3frentes.getText().toString();
        else if (opcao == R.id.rbt4frentes) return rbt4frentes.getText().toString();
        else if (opcao == R.id.rbtCondHoriz) return rbtCondHoriz.getText().toString();
        else if (opcao == R.id.rbtEscravado) return rbtEscravado.getText().toString();
        else if (opcao == R.id.rbtGleba) return rbtGleba.getText().toString();
        else if (opcao == R.id.rbtAglomerado) return rbtAglomerado.getText().toString();
        return String.valueOf(value);
    }

    private String selectTopografia() {
        String value = "Nada Consta";
        int opcao = rgpTopografiaTer.getCheckedRadioButtonId();

        if (opcao == R.id.rbtPlano) return rbtPlano.getText().toString();
        else if (opcao == R.id.rbtAclive) return rbtAclive.getText().toString();
        else if (opcao == R.id.rbtDeclive) return rbtDeclive.getText().toString();
        else if (opcao == R.id.rbtIrregular) return rbtIrregular.getText().toString();
        return String.valueOf(value);
    }

    private String selectPedologia() {
        String value = "Nada Consta";
        int opcao = rgpPedologiaTer.getCheckedRadioButtonId();

        if (opcao == R.id.rbtInundavel) return rbtInundavel.getText().toString();
        else if (opcao == R.id.rbtFirme) return rbtFirme.getText().toString();
        else if (opcao == R.id.rbtAlagado) return rbtAlagado.getText().toString();
        return String.valueOf(value);
    }

    private void inserirQuartaPagina(long codigoID) {

        try {
            String sql = "_id='" + codigoID + "'";
            String[] campos = {"SITUACAO_TER", "TOPOGRAFIA_TER", "PEDOLOGIA_TER"};

            Cursor c = forms.query("FORMULARIO", campos, sql, null, null, null, null, null);

            if (c.moveToFirst()) {
                //RadioGroups RETORNOS
                forms.execSQL("UPDATE FORMULARIO SET SITUACAO_TER='" + selectSituacao() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET TOPOGRAFIA_TER='" + selectTopografia() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET PEDOLOGIA_TER='" + selectPedologia() + "'  WHERE _id='" + codigoID + "'");

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




}

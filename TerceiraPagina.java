package forms.caduguedes.formulariotopocad;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class TerceiraPagina extends AppCompatActivity {

    //Declarando os EditText
    private EditText edtAnoRefImovel;

    //Declarando os RadioButtons
    private RadioButton rbtNaoConstImovel;
    private RadioButton rbtRuinasImovel;
    private RadioButton rbtDemolicaoImovel;
    private RadioButton rbtConstParaImovel;
    private RadioButton rbtConstAndImovel;
    private RadioButton rbtConstruidoImovel;
    private RadioButton rbtNatTempImovel;
    private RadioButton rbtEmReformaImovel;
    private RadioButton rbtSemUsoImovel;
    private RadioButton rbtResidenImovel;
    private RadioButton rbtComercImovel;
    private RadioButton rbtServImovel;
    private RadioButton rbtServPublImovel;
    private RadioButton rbtIndusImovel;
    private RadioButton rbtReligImovel;
    private RadioButton rbtPatPublico;
    private RadioButton rbtPatParticular;
    private RadioButton rbtPatReligioso;
    private RadioButton rbtMuroNao;
    private RadioButton rbtMuroSim;
    private RadioButton rbtPasseioNao;
    private RadioButton rbtPasseiSim;
    private RadioButton rbtImuneNao;
    private RadioButton rbtImuneImune;
    private RadioButton rbtImuneSim;
    private RadioButton rbtIsentoNao;
    private RadioButton rbtIsentoSim;

    //Declarando os RadioGroups
    private RadioGroup rgpOcupacaoImovel;
    private RadioGroup rgpUtilizaImovel;
    private RadioGroup rgpPatrimonImovel;
    private RadioGroup rgpMuroCercaImovel;
    private RadioGroup rgpPasseioImovel;
    private RadioGroup rgpImuneIPTUImovel;
    private RadioGroup rgpIsentoIPTUImovel;

    //Declarando os Buttons
    private Button avancar3;
    private Button voltar3;

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
        setContentView(R.layout.activity_terceira_pagina);

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
        edtAnoRefImovel = (EditText) findViewById(R.id.edtAnoRefImovel);

        //Recuperando as referências dos RadioButtons
        rbtNaoConstImovel = (RadioButton) findViewById(R.id.rbtNaoConstImovel);
        rbtRuinasImovel = (RadioButton) findViewById(R.id.rbtRuinasImovel);
        rbtDemolicaoImovel = (RadioButton) findViewById(R.id.rbtDemolicaoImovel);
        rbtConstParaImovel = (RadioButton) findViewById(R.id.rbtConstParaImovel);
        rbtConstAndImovel = (RadioButton) findViewById(R.id.rbtConstAndImovel);
        rbtConstruidoImovel = (RadioButton) findViewById(R.id.rbtConstruidoImovel);
        rbtNatTempImovel = (RadioButton) findViewById(R.id.rbtNatTempImovel);
        rbtEmReformaImovel = (RadioButton) findViewById(R.id.rbtEmReformaImovel);
        rbtSemUsoImovel = (RadioButton) findViewById(R.id.rbtSemUsoImovel);
        rbtResidenImovel = (RadioButton) findViewById(R.id.rbtResidenImovel);
        rbtComercImovel = (RadioButton) findViewById(R.id.rbtComercImovel);
        rbtServImovel = (RadioButton) findViewById(R.id.rbtServImovel);
        rbtServPublImovel = (RadioButton) findViewById(R.id.rbtServPublImovel);
        rbtIndusImovel = (RadioButton) findViewById(R.id.rbtIndusImovel);
        rbtReligImovel = (RadioButton) findViewById(R.id.rbtReligImovel);
        rbtPatPublico = (RadioButton) findViewById(R.id.rbtPatPublico);
        rbtPatParticular = (RadioButton) findViewById(R.id.rbtPatParticular);
        rbtPatReligioso = (RadioButton) findViewById(R.id.rbtPatReligioso);
        rbtMuroNao = (RadioButton) findViewById(R.id.rbtMuroNao);
        rbtMuroSim = (RadioButton) findViewById(R.id.rbtMuroSim);
        rbtPasseioNao = (RadioButton) findViewById(R.id.rbtPasseioNao);
        rbtPasseiSim = (RadioButton) findViewById(R.id.rbtPasseiSim);
        rbtImuneNao = (RadioButton) findViewById(R.id.rbtImuneNao);
        rbtImuneImune = (RadioButton) findViewById(R.id.rbtImuneImune);
        rbtImuneSim = (RadioButton) findViewById(R.id.rbtImuneSim);
        rbtIsentoNao = (RadioButton) findViewById(R.id.rbtIsentoNao);
        rbtIsentoSim = (RadioButton) findViewById(R.id.rbtIsentoSim);

        //Recuperando as referências dos RadioGroups
        rgpOcupacaoImovel = (RadioGroup) findViewById(R.id.rgpOcupacaoImovel);
        rgpUtilizaImovel = (RadioGroup) findViewById(R.id.rgpUtilizaImovel);
        rgpPatrimonImovel = (RadioGroup) findViewById(R.id.rgpPatrimonImovel);
        rgpMuroCercaImovel = (RadioGroup) findViewById(R.id.rgpMuroCercaImovel);
        rgpPasseioImovel = (RadioGroup) findViewById(R.id.rgpPasseioImovel);
        rgpImuneIPTUImovel = (RadioGroup) findViewById(R.id.rgpImuneIPTUImovel);
        rgpOcupacaoImovel = (RadioGroup) findViewById(R.id.rgpOcupacaoImovel);



        //Recuperando as referências dos Buttons
        avancar3 = (Button) findViewById(R.id.avancar3);
        voltar3 = (Button) findViewById(R.id.voltar3);




        avancar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TerceiraPagina.this, QuartaPagina.class); // intent é a intenção de fazer algo, no caso troca de tela
                startActivity(intent);
            }
        });

        voltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TerceiraPagina.this, SegundaPagina.class); // intent é a intenção de fazer algo, no caso troca de tela
                startActivity(intent);
            }
        });




    }
}

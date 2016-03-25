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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import forms.caduguedes.formulariotopocad.database.DataBase;
import forms.caduguedes.formulariotopocad.dominio.ManipulaBanco;
import forms.caduguedes.formulariotopocad.dominio.entidades.Formulario;

public class SextaPagina extends AppCompatActivity {

    //Declarando os RadioButtons
    private RadioButton rbtCasaEdi;
    private RadioButton rbtBarracaoEdi;
    private RadioButton rbtAptdEdi;
    private RadioButton rbtSalaEdi;
    private RadioButton rbtLojaEdi;
    private RadioButton rbtGalpaoEdi;
    private RadioButton rbtTelheiroEdi;
    private RadioButton rbtAglomerado;
    private RadioButton rbtFabricaEdi;
    private RadioButton rbtAlinhadaEdi;
    private RadioButton rbtRecuadaEdi;
    private RadioButton rbtIsolada;
    private RadioButton rbtConjugada;
    private RadioButton rbtGeminada;
    private RadioButton rbtLocFrente;
    private RadioButton rbtLocFundos;
    private RadioButton rbtLocSupFrente;
    private RadioButton rbtLocSupFundos;
    private RadioButton rbtLocSobreloja;
    private RadioButton rbtLocSubsolo;
    private RadioButton rbtLocGaleria;
    private RadioButton rbtEstAlvenaria;
    private RadioButton rbtEstMadeira;
    private RadioButton rbtEstMetalica;
    private RadioButton rbtEstConcreto;
    private RadioButton rbtCobPalhaZinco;
    private RadioButton rbtCobAmiComum;
    private RadioButton rbtCobTelhaBarro;
    private RadioButton rbtCobLaje;
    private RadioButton rbtCobMetalica;
    private RadioButton rbtCobTelhaColonial;
    private RadioButton rbtCobAmiEspecial;
    private RadioButton rbtCobTelhaColEspecial;
    private RadioButton rbtParSem;
    private RadioButton rbtParAdobe;
    private RadioButton rbtParAlvenaria;
    private RadioButton rbtParMadeiraSimples;
    private RadioButton rbtParMadeiraLuxo;
    private RadioButton rbtParConcreto;
    private RadioButton rbtForSem;
    private RadioButton rbtForMadeira;
    private RadioButton rbtForGesso;
    private RadioButton rbtForLaje;
    private RadioButton rbtForEsteira;
    private RadioButton rbtEletSem;
    private RadioButton rbtEletAparente;
    private RadioButton rbtEletSemiImbut;
    private RadioButton rbtEletEmbu;
    private RadioButton rbtPisoTerra;
    private RadioButton rbtPisoCimento;
    private RadioButton rbtPisoCeramico;
    private RadioButton rbtPisoCarpete;
    private RadioButton rbtPisoPlastico;
    private RadioButton rbtPisoTaco;
    private RadioButton rbtPisoTabuas;
    private RadioButton rbtPisoMarmore;
    private RadioButton rbtPisoGranito;
    private RadioButton rbtPadraoLuxo;
    private RadioButton rbtPadraoNormal;
    private RadioButton rbtPadraoPopular;
    private RadioButton rbtPadraoBaixo;

    //Declarando RadioGroups
    private RadioGroup rgpTipoEdi;
    private RadioGroup rgpAlinhamentoEdi;
    private RadioGroup rgpPosicaoEdi;
    private RadioGroup rgpLocalizacaoEdi;
    private RadioGroup rgpEstrutEdi;
    private RadioGroup rgpCoberturaEdi;
    private RadioGroup rgpParedesEdi;
    private RadioGroup rgpForroEdi;
    private RadioGroup rgpEletricEdi;
    private RadioGroup rgpPisoEdi;
    private RadioGroup rgpPadraoEdi;

    //Declarando EditText
    private EditText edtCpfCnpj;

    //Declarando os Buttons
    private Button voltar6;
    //private Button concluir6;

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
        setContentView(R.layout.activity_sexta_pagina);

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
        rbtCasaEdi = (RadioButton) findViewById(R.id.rbtCasaEdi);
        rbtBarracaoEdi = (RadioButton) findViewById(R.id.rbtBarracaoEdi);
        rbtAptdEdi = (RadioButton) findViewById(R.id.rbtAptdEdi);
        rbtSalaEdi = (RadioButton) findViewById(R.id.rbtSalaEdi);
        rbtLojaEdi = (RadioButton) findViewById(R.id.rbtLojaEdi);
        rbtGalpaoEdi = (RadioButton) findViewById(R.id.rbtGalpaoEdi);
        rbtTelheiroEdi = (RadioButton) findViewById(R.id.rbtTelheiroEdi);
        rbtAglomerado = (RadioButton) findViewById(R.id.rbtAglomerado);
        rbtFabricaEdi = (RadioButton) findViewById(R.id.rbtFabricaEdi);
        rbtAlinhadaEdi = (RadioButton) findViewById(R.id.rbtAlinhadaEdi);
        rbtRecuadaEdi = (RadioButton) findViewById(R.id.rbtRecuadaEdi);
        rbtIsolada = (RadioButton) findViewById(R.id.rbtIsolada);
        rbtConjugada = (RadioButton) findViewById(R.id.rbtConjugada);
        rbtGeminada = (RadioButton) findViewById(R.id.rbtGeminada);
        rbtLocFrente = (RadioButton) findViewById(R.id.rbtLocFrente);
        rbtLocFundos = (RadioButton) findViewById(R.id.rbtLocFundos);
        rbtLocSupFrente = (RadioButton) findViewById(R.id.rbtLocSupFrente);
        rbtLocSupFundos = (RadioButton) findViewById(R.id.rbtLocSupFundos);
        rbtLocSobreloja = (RadioButton) findViewById(R.id.rbtLocSobreloja);
        rbtLocSubsolo = (RadioButton) findViewById(R.id.rbtLocSubsolo);
        rbtLocGaleria = (RadioButton) findViewById(R.id.rbtLocGaleria);
        rbtEstAlvenaria = (RadioButton) findViewById(R.id.rbtEstAlvenaria);
        rbtEstMadeira = (RadioButton) findViewById(R.id.rbtEstMadeira);
        rbtEstMetalica = (RadioButton) findViewById(R.id.rbtEstMetalica);
        rbtEstConcreto = (RadioButton) findViewById(R.id.rbtEstConcreto);
        rbtCobPalhaZinco = (RadioButton) findViewById(R.id.rbtCobPalhaZinco);
        rbtCobAmiComum = (RadioButton) findViewById(R.id.rbtCobAmiComum);
        rbtCobTelhaBarro = (RadioButton) findViewById(R.id.rbtCobTelhaBarro);
        rbtCobLaje = (RadioButton) findViewById(R.id.rbtCobLaje);
        rbtCobMetalica = (RadioButton) findViewById(R.id.rbtCobMetalica);
        rbtCobTelhaColonial = (RadioButton) findViewById(R.id.rbtCobTelhaColonial);
        rbtCobAmiEspecial = (RadioButton) findViewById(R.id.rbtCobAmiEspecial);
        rbtCobTelhaColEspecial = (RadioButton) findViewById(R.id.rbtCobTelhaColEspecial);
        rbtParSem = (RadioButton) findViewById(R.id.rbtParSem);
        rbtParAdobe = (RadioButton) findViewById(R.id.rbtParAdobe);
        rbtParAlvenaria = (RadioButton) findViewById(R.id.rbtParAlvenaria);
        rbtParMadeiraSimples = (RadioButton) findViewById(R.id.rbtParMadeiraSimples);
        rbtParMadeiraLuxo = (RadioButton) findViewById(R.id.rbtParMadeiraLuxo);
        rbtParConcreto = (RadioButton) findViewById(R.id.rbtParConcreto);
        rbtForSem = (RadioButton) findViewById(R.id.rbtForSem);
        rbtForMadeira = (RadioButton) findViewById(R.id.rbtForMadeira);
        rbtForGesso = (RadioButton) findViewById(R.id.rbtForGesso);
        rbtForLaje = (RadioButton) findViewById(R.id.rbtForLaje);
        rbtForEsteira = (RadioButton) findViewById(R.id.rbtForEsteira);
        rbtEletSem = (RadioButton) findViewById(R.id.rbtEletSem);
        rbtEletAparente = (RadioButton) findViewById(R.id.rbtEletAparente);
        rbtEletSemiImbut = (RadioButton) findViewById(R.id.rbtEletSemiImbut);
        rbtEletEmbu = (RadioButton) findViewById(R.id.rbtEletEmbu);
        rbtPisoTerra = (RadioButton) findViewById(R.id.rbtPisoTerra);
        rbtPisoCimento = (RadioButton) findViewById(R.id.rbtPisoCimento);
        rbtPisoCeramico = (RadioButton) findViewById(R.id.rbtPisoCeramico);
        rbtPisoCarpete = (RadioButton) findViewById(R.id.rbtPisoCarpete);
        rbtPisoPlastico = (RadioButton) findViewById(R.id.rbtPisoPlastico);
        rbtPisoTaco = (RadioButton) findViewById(R.id.rbtPisoTaco);
        rbtPisoTabuas = (RadioButton) findViewById(R.id.rbtPisoTabuas);
        rbtPisoMarmore = (RadioButton) findViewById(R.id.rbtPisoMarmore);
        rbtPisoGranito = (RadioButton) findViewById(R.id.rbtPisoGranito);
        rbtPadraoLuxo = (RadioButton) findViewById(R.id.rbtPadraoLuxo);
        rbtPadraoNormal = (RadioButton) findViewById(R.id.rbtPadraoNormal);
        rbtPadraoPopular = (RadioButton) findViewById(R.id.rbtPadraoPopular);
        rbtPadraoBaixo = (RadioButton) findViewById(R.id.rbtPadraoBaixo);

        //Recuperando os RadioGrupous
        rgpTipoEdi = (RadioGroup) findViewById(R.id.rgpTipoEdi);
        rgpAlinhamentoEdi = (RadioGroup) findViewById(R.id.rgpAlinhamentoEdi);
        rgpPosicaoEdi = (RadioGroup) findViewById(R.id.rgpPosicaoEdi);
        rgpLocalizacaoEdi = (RadioGroup) findViewById(R.id.rgpLocalizacaoEdi);
        rgpEstrutEdi = (RadioGroup) findViewById(R.id.rgpEstrutEdi);
        rgpCoberturaEdi = (RadioGroup) findViewById(R.id.rgpCoberturaEdi);
        rgpParedesEdi = (RadioGroup) findViewById(R.id.rgpParedesEdi);
        rgpForroEdi = (RadioGroup) findViewById(R.id.rgpForroEdi);
        rgpEletricEdi = (RadioGroup) findViewById(R.id.rgpEletricEdi);
        rgpPisoEdi = (RadioGroup) findViewById(R.id.rgpPisoEdi);
        rgpPadraoEdi = (RadioGroup) findViewById(R.id.rgpPadraoEdi);

        //Recuperando as ref dos EditText
        edtCpfCnpj = (EditText) findViewById(R.id.edtCpfCnpj);


        //Recuperandoa as refs dos Buttons
        voltar6 = (Button) findViewById(R.id.voltar6);
        //concluir6 = (Button) findViewById(R.id.concluir6);

        /*concluir6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SextaPagina.this, SextaPagina.class); // intent é a intenção de fazer algo, no caso troca de tela
                startActivity(intent);
            }
        });*/

        voltar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SextaPagina.this, QuintaPagina.class); // intent é a intenção de fazer algo, no caso troca de tela
                startActivity(intent);
            }
        });

    }
}

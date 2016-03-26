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
    private RadioButton rbtFabricaEdi;
    private RadioButton rbtEspecialEdi;
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
    private Button concluir6;

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
        setContentView(R.layout.activity_sexta_pagina);

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
        rbtCasaEdi = (RadioButton) findViewById(R.id.rbtCasaEdi);
        rbtBarracaoEdi = (RadioButton) findViewById(R.id.rbtBarracaoEdi);
        rbtAptdEdi = (RadioButton) findViewById(R.id.rbtAptdEdi);
        rbtSalaEdi = (RadioButton) findViewById(R.id.rbtSalaEdi);
        rbtLojaEdi = (RadioButton) findViewById(R.id.rbtLojaEdi);
        rbtGalpaoEdi = (RadioButton) findViewById(R.id.rbtGalpaoEdi);
        rbtTelheiroEdi = (RadioButton) findViewById(R.id.rbtTelheiroEdi);
        rbtFabricaEdi = (RadioButton) findViewById(R.id.rbtFabricaEdi);
        rbtEspecialEdi = (RadioButton) findViewById(R.id.rbtEspecialEdi);
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


        //Recuperando as refs dos Buttons
        voltar6 = (Button) findViewById(R.id.voltar6);
        concluir6 = (Button) findViewById(R.id.concluir6);

        inserirVoltei(codigo);

        concluir6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inserirSextaPagina(codigo);
                Intent intent = new Intent(SextaPagina.this, TelaInicial.class);//ULTIMA PAGINA VOLTA PARA TELA INICIAL SEMPRE
                startActivity(intent);
                finish();
            }
        });

        voltar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SextaPagina.this, QuintaPagina.class);
                intent.putExtra("codigoID", codigo);
                startActivity(intent);
                finish();
            }
        });

    }

    private String selectTipoEdificacao() {
        String value = "Nada Consta";
        int opcao = rgpTipoEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtCasaEdi) return rbtCasaEdi.getText().toString();
        else if (opcao == R.id.rbtBarracaoEdi) return rbtBarracaoEdi.getText().toString();
        else if (opcao == R.id.rbtAptdEdi) return rbtAptdEdi.getText().toString();
        else if (opcao == R.id.rbtSalaEdi) return rbtSalaEdi.getText().toString();
        else if (opcao == R.id.rbtLojaEdi) return rbtLojaEdi.getText().toString();
        else if (opcao == R.id.rbtGalpaoEdi) return rbtGalpaoEdi.getText().toString();
        else if (opcao == R.id.rbtTelheiroEdi) return rbtTelheiroEdi.getText().toString();
        else if (opcao == R.id.rbtFabricaEdi) return rbtFabricaEdi.getText().toString();
        else if (opcao == R.id.rbtEspecialEdi) return rbtEspecialEdi.getText().toString();
        return String.valueOf(value);
    }

    private String selectAlinhamento() {
        String value = "Nada Consta";
        int opcao = rgpAlinhamentoEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtAlinhadaEdi) return rbtAlinhadaEdi.getText().toString();
        else if (opcao == R.id.rbtRecuadaEdi) return rbtRecuadaEdi.getText().toString();
        return String.valueOf(value);
    }

    private String selectPosicao() {
        String value = "Nada Consta";
        int opcao = rgpPosicaoEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtIsolada) return rbtIsolada.getText().toString();
        else if (opcao == R.id.rbtConjugada) return rbtConjugada.getText().toString();
        else if (opcao == R.id.rbtGeminada) return rbtGeminada.getText().toString();
        return String.valueOf(value);
    }

    private String selectLocalizacao() {
        String value = "Nada Consta";
        int opcao = rgpLocalizacaoEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtLocFrente) return rbtLocFrente.getText().toString();
        else if (opcao == R.id.rbtLocFundos) return rbtLocFundos.getText().toString();
        else if (opcao == R.id.rbtLocSupFrente) return rbtLocSupFrente.getText().toString();
        else if (opcao == R.id.rbtLocSupFundos) return rbtLocSupFundos.getText().toString();
        else if (opcao == R.id.rbtLocSobreloja) return rbtLocSobreloja.getText().toString();
        else if (opcao == R.id.rbtLocSubsolo) return rbtLocSubsolo.getText().toString();
        else if (opcao == R.id.rbtLocGaleria) return rbtLocGaleria.getText().toString();
        return String.valueOf(value);
    }

    private String selectEstutura() {
        String value = "Nada Consta";
        int opcao = rgpEstrutEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtEstAlvenaria) return rbtEstAlvenaria.getText().toString();
        else if (opcao == R.id.rbtEstMadeira) return rbtEstMadeira.getText().toString();
        else if (opcao == R.id.rbtEstMetalica) return rbtEstMetalica.getText().toString();
        else if (opcao == R.id.rbtEstConcreto) return rbtEstConcreto.getText().toString();
        return String.valueOf(value);
    }

    private String selectCobertura() {
        String value = "Nada Consta";
        int opcao = rgpCoberturaEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtCobPalhaZinco) return rbtCobPalhaZinco.getText().toString();
        else if (opcao == R.id.rbtCobAmiComum) return rbtCobAmiComum.getText().toString();
        else if (opcao == R.id.rbtCobTelhaBarro) return rbtCobTelhaBarro.getText().toString();
        else if (opcao == R.id.rbtCobLaje) return rbtCobLaje.getText().toString();
        else if (opcao == R.id.rbtCobMetalica) return rbtCobMetalica.getText().toString();
        else if (opcao == R.id.rbtCobTelhaColonial) return rbtCobTelhaColonial.getText().toString();
        else if (opcao == R.id.rbtCobAmiEspecial) return rbtCobAmiEspecial.getText().toString();
        else if (opcao == R.id.rbtCobTelhaColEspecial)
            return rbtCobTelhaColEspecial.getText().toString();
        return String.valueOf(value);
    }

    private String selectParedes() {
        String value = "Nada Consta";
        int opcao = rgpParedesEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtParSem) return rbtParSem.getText().toString();
        else if (opcao == R.id.rbtParAdobe) return rbtParAdobe.getText().toString();
        else if (opcao == R.id.rbtParAlvenaria) return rbtParAlvenaria.getText().toString();
        else if (opcao == R.id.rbtParMadeiraSimples)
            return rbtParMadeiraSimples.getText().toString();
        else if (opcao == R.id.rbtParMadeiraLuxo) return rbtParMadeiraLuxo.getText().toString();
        else if (opcao == R.id.rbtParConcreto) return rbtParConcreto.getText().toString();
        return String.valueOf(value);
    }

    private String selectForro() {
        String value = "Nada Consta";
        int opcao = rgpForroEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtForSem) return rbtForSem.getText().toString();
        else if (opcao == R.id.rbtForMadeira) return rbtForMadeira.getText().toString();
        else if (opcao == R.id.rbtForGesso) return rbtForGesso.getText().toString();
        else if (opcao == R.id.rbtForLaje) return rbtForLaje.getText().toString();
        else if (opcao == R.id.rbtForEsteira) return rbtForEsteira.getText().toString();
        return String.valueOf(value);
    }

    private String selectInstEletric() {
        String value = "Nada Consta";
        int opcao = rgpEletricEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtEletSem) return rbtEletSem.getText().toString();
        else if (opcao == R.id.rbtEletAparente) return rbtEletAparente.getText().toString();
        else if (opcao == R.id.rbtEletEmbu) return rbtEletEmbu.getText().toString();
        else if (opcao == R.id.rbtEletSemiImbut) return rbtEletSemiImbut.getText().toString();
        return String.valueOf(value);
    }

    private String selectPiso() {
        String value = "Nada Consta";
        int opcao = rgpPisoEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtPisoTerra) return rbtPisoTerra.getText().toString();
        else if (opcao == R.id.rbtPisoCimento) return rbtPisoCimento.getText().toString();
        else if (opcao == R.id.rbtPisoCeramico) return rbtPisoCeramico.getText().toString();
        else if (opcao == R.id.rbtPisoCarpete) return rbtPisoCarpete.getText().toString();
        else if (opcao == R.id.rbtPisoPlastico) return rbtPisoPlastico.getText().toString();
        else if (opcao == R.id.rbtPisoTaco) return rbtPisoTaco.getText().toString();
        else if (opcao == R.id.rbtPisoTabuas) return rbtPisoTabuas.getText().toString();
        else if (opcao == R.id.rbtPisoMarmore) return rbtPisoMarmore.getText().toString();
        else if (opcao == R.id.rbtPisoGranito) return rbtPisoGranito.getText().toString();
        return String.valueOf(value);
    }

    private String selectPadrao() {
        String value = "Nada Consta";
        int opcao = rgpPadraoEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtPadraoLuxo) return rbtPadraoLuxo.getText().toString();
        else if (opcao == R.id.rbtPadraoNormal) return rbtPadraoNormal.getText().toString();
        else if (opcao == R.id.rbtPadraoPopular) return rbtPadraoPopular.getText().toString();
        else if (opcao == R.id.rbtPadraoBaixo) return rbtPadraoBaixo.getText().toString();
        return String.valueOf(value);
    }


    private void inserirSextaPagina(long codigoID) {

        try {

            String sql = "_id='" + codigoID + "'";
            String[] campos = {"TIPO_EDI", "ALINHAMENTO_EDI", "POSICAO_EDI", "LOCALIZACAO_EDI",
                    "ESTRUT_EDI", "COBERTURA_EDI", "PAREDES_EDI", "FORRO_EDI",
                    "ELETRIC_EDI", "PISO_EDI", "PADRAO_EDI", "CPF_CNPJ"};

            Cursor c = forms.query("FORMULARIO", campos, sql, null, null, null, null, null);

            if (c.moveToFirst()) {
                forms.execSQL("UPDATE FORMULARIO SET TIPO_EDI='" + selectTipoEdificacao() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET ALINHAMENTO_EDI='" + selectAlinhamento() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET POSICAO_EDI='" + selectPosicao() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET LOCALIZACAO_EDI='" + selectLocalizacao() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET ESTRUT_EDI='" + selectEstutura() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET COBERTURA_EDI='" + selectCobertura() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET PAREDES_EDI='" + selectParedes() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET FORRO_EDI='" + selectForro() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET ELETRIC_EDI='" + selectInstEletric() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET PISO_EDI='" + selectPiso() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET PADRAO_EDI='" + selectPadrao() + "'  WHERE _id='" + codigoID + "'");
                //EditText RETORNOS
                forms.execSQL("UPDATE FORMULARIO SET CPF_CNPJ='" + edtCpfCnpj.getText() + "'  WHERE _id='" + codigoID + "'");

            }
            c.close();

        } catch (Exception ex) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Inserir os Dados." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }

        forms.close();
    }

    private void inserirVoltei(long codigoID) {

        try {
            forms = dataBase.getReadableDatabase();
            Cursor c = forms.rawQuery("SELECT * FROM FORMULARIO WHERE _id='" + codigoID + "'", null);

            if (c.moveToFirst()) {

                edtCpfCnpj.setText(c.getString(67));

            }c.close();

        }catch (Exception ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Inserir os Dados." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }
    }



}

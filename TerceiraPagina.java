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
    private RadioButton rbtPasseioSim;
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

    long codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira_pagina);

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
        rbtPasseioSim = (RadioButton) findViewById(R.id.rbtPasseioSim);
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
        rgpIsentoIPTUImovel = (RadioGroup) findViewById(R.id.rgpIsentoIPTUImovel);

        //Recuperando as referências dos Buttons
        avancar3 = (Button) findViewById(R.id.avancar3);
        voltar3 = (Button) findViewById(R.id.voltar3);

        inserirVolteiDaQuarta(codigo);

        avancar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inserirTerceiraPagina(codigo);
                Intent intent = new Intent(TerceiraPagina.this, QuartaPagina.class);
                intent.putExtra("codigoID", codigo);

                startActivity(intent);
                finish();
            }
        });

        voltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TerceiraPagina.this, SegundaPagina.class);
                intent.putExtra("codigoID", codigo);
                startActivity(intent);
                finish();
            }
        });
    }


    private String selectOcupacaoImovel() {
        String value = "Nada Consta";
        int opcao = rgpOcupacaoImovel.getCheckedRadioButtonId();

        if (opcao == R.id.rbtNaoConstImovel) return rbtNaoConstImovel.getText().toString();
        else if (opcao == R.id.rbtRuinasImovel) return rbtRuinasImovel.getText().toString();
        else if (opcao == R.id.rbtDemolicaoImovel) return rbtDemolicaoImovel.getText().toString();
        else if (opcao == R.id.rbtConstParaImovel) return rbtConstParaImovel.getText().toString();
        else if (opcao == R.id.rbtConstAndImovel) return rbtConstAndImovel.getText().toString();
        else if (opcao == R.id.rbtConstruidoImovel) return rbtConstruidoImovel.getText().toString();
        else if (opcao == R.id.rbtNatTempImovel) return rbtNatTempImovel.getText().toString();
        else if (opcao == R.id.rbtEmReformaImovel) return rbtEmReformaImovel.getText().toString();
        return String.valueOf(value);
    }

    private String selectUtilizacaoImovel() {
        String value = "Nada Consta";
        int opcao = rgpUtilizaImovel.getCheckedRadioButtonId();

        if (opcao == R.id.rbtSemUsoImovel) return rbtSemUsoImovel.getText().toString();
        else if (opcao == R.id.rbtResidenImovel) return rbtResidenImovel.getText().toString();
        else if (opcao == R.id.rbtComercImovel) return rbtComercImovel.getText().toString();
        else if (opcao == R.id.rbtServImovel) return rbtServImovel.getText().toString();
        else if (opcao == R.id.rbtServPublImovel) return rbtServPublImovel.getText().toString();
        else if (opcao == R.id.rbtIndusImovel) return rbtIndusImovel.getText().toString();
        else if (opcao == R.id.rbtReligImovel) return rbtReligImovel.getText().toString();
        return String.valueOf(value);
    }

    private String selectPatrimonio() {
        String value = "Nada Consta";
        int opcao = rgpPatrimonImovel.getCheckedRadioButtonId();

        if (opcao == R.id.rbtPatPublico) return rbtPatPublico.getText().toString();
        else if (opcao == R.id.rbtPatParticular) return rbtPatParticular.getText().toString();
        else if (opcao == R.id.rbtPatReligioso) return rbtPatReligioso.getText().toString();
        return String.valueOf(value);
    }

    private String selectMuroCerca() {
        String value = "Nada Consta";
        int opcao = rgpMuroCercaImovel.getCheckedRadioButtonId();

        if (opcao == R.id.rbtMuroNao) return rbtMuroNao.getText().toString();
        else if (opcao == R.id.rbtMuroSim) return rbtMuroSim.getText().toString();
        return String.valueOf(value);
    }

    private String selectPasseio() {
        String value = "Nada Consta";
        int opcao = rgpPasseioImovel.getCheckedRadioButtonId();

        if (opcao == R.id.rbtPasseioNao) return rbtPasseioNao.getText().toString();
        else if (opcao == R.id.rbtPasseioSim) return rbtPasseioSim.getText().toString();
        return String.valueOf(value);
    }

    private String selectImuneIPTU() {
        String value = "Nada Consta";
        int opcao = rgpImuneIPTUImovel.getCheckedRadioButtonId();

        if (opcao == R.id.rbtImuneNao) return rbtImuneNao.getText().toString();
        else if (opcao == R.id.rbtImuneImune) return rbtImuneImune.getText().toString();
        else if (opcao == R.id.rbtImuneSim) return rbtImuneSim.getText().toString();
        return String.valueOf(value);
    }

    private String selectIsentoIPTU() {
        String value = "Nada Consta";
        int opcao = rgpIsentoIPTUImovel.getCheckedRadioButtonId();

        if (opcao == R.id.rbtIsentoNao) return rbtIsentoNao.getText().toString();
        else if (opcao == R.id.rbtIsentoSim) return rbtIsentoSim.getText().toString();
        return String.valueOf(value);
    }


    private void inserirTerceiraPagina(long codigoID) {

        try {
            String sql = "_id='" + codigoID + "'";
            String[] campos = {"OCUPACAO_IMOVEL", "UTILIZA_IMOVEL", "PATRIMON_IMOVEL", "MUROCERCA_IMOVEL",
                    "PASSEIO_IMOVEL", "ANO_REF_IMOVEL", "IMUNE_IPTU_IMOVEL", "ISENTO_IPTU_IMOVEL"};

            Cursor c = forms.query("FORMULARIO", campos, sql, null, null, null, null, null);

            if (c.moveToFirst()) {


                //RadioGroups RETORNOS
                forms.execSQL("UPDATE FORMULARIO SET OCUPACAO_IMOVEL='" + selectOcupacaoImovel() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET UTILIZA_IMOVEL='" + selectUtilizacaoImovel() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET PATRIMON_IMOVEL='" + selectPatrimonio() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET MUROCERCA_IMOVEL='" + selectMuroCerca() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET PASSEIO_IMOVEL='" + selectPasseio() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET ANO_REF_IMOVEL='" + edtAnoRefImovel.getText() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET IMUNE_IPTU_IMOVEL='" + selectImuneIPTU() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET ISENTO_IPTU_IMOVEL='" + selectIsentoIPTU() + "'  WHERE _id='" + codigoID + "'");

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

    private void inserirVolteiDaQuarta(long codigoID) {

        try {
            forms = dataBase.getReadableDatabase();
            Cursor c = forms.rawQuery("SELECT * FROM FORMULARIO WHERE _id='" + codigoID + "'", null);

            if (c.moveToFirst()) {

                edtAnoRefImovel.setText(c.getString(36));

            }c.close();

        }catch (Exception ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Inserir os Dados." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }
    }

}

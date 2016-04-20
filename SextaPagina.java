package forms.caduguedes.formulariotopocad;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

    private RadioButton rbtRevestSem;
    private RadioButton rbtRevestReboco;
    private RadioButton rbtRevestCaia;
    private RadioButton rbtRevestPintura;
    private RadioButton rbtRevestCeramico;
    private RadioButton rbtRevestPedra;
    private RadioButton rbtRevestMadeira;
    private RadioButton rbtRevestConcreto;

    private RadioButton rbtSanitSem;
    private RadioButton rbtSanitExterna;
    private RadioButton rbtSanitInternaSimples;
    private RadioButton rbtSanitInternaLuxo;
    private RadioButton rbtSanitMaisDe1Interna;

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

    private RadioGroup rgpRevestimento;
    private RadioGroup rgpSanitEdi;

    private RadioGroup rgpEletricEdi;
    private RadioGroup rgpPisoEdi;
    private RadioGroup rgpPadraoEdi;

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

    private File diretorio;
    private String nomeDiretorio;
    private String diretorioApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexta_pagina);


        codigo = this.getIntent().getLongExtra("codigoID", 0);


        nomeDiretorio = "Formularios_CGTI";


        diretorioApp = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                + "/" + nomeDiretorio + "/";

        diretorio = new File(diretorioApp);
        diretorio.mkdirs();

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

        rbtRevestSem = (RadioButton) findViewById(R.id.rbtRevestSem);
        rbtRevestReboco = (RadioButton) findViewById(R.id.rbtRevestReboco);
        rbtRevestCaia = (RadioButton) findViewById(R.id.rbtRevestCaia);
        rbtRevestPintura = (RadioButton) findViewById(R.id.rbtRevestPintura);
        rbtRevestCeramico = (RadioButton) findViewById(R.id.rbtRevestCeramico);
        rbtRevestPedra = (RadioButton) findViewById(R.id.rbtRevestPedra);
        rbtRevestMadeira = (RadioButton) findViewById(R.id.rbtRevestMadeira);
        rbtRevestConcreto = (RadioButton) findViewById(R.id.rbtRevestConcreto);
        rbtSanitSem = (RadioButton) findViewById(R.id.rbtSanitSem);
        rbtSanitExterna = (RadioButton) findViewById(R.id.rbtSanitExterna);
        rbtSanitInternaSimples = (RadioButton) findViewById(R.id.rbtSanitInternaSimples);
        rbtSanitInternaLuxo = (RadioButton) findViewById(R.id.rbtSanitInternaLuxo);
        rbtSanitMaisDe1Interna = (RadioButton) findViewById(R.id.rbtSanitMaisDe1Interna);

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

        rgpRevestimento = (RadioGroup) findViewById(R.id.rgpRevestimentoEdi);
        rgpSanitEdi = (RadioGroup) findViewById(R.id.rgpSanitEdi);

        rgpEletricEdi = (RadioGroup) findViewById(R.id.rgpEletricEdi);
        rgpPisoEdi = (RadioGroup) findViewById(R.id.rgpPisoEdi);
        rgpPadraoEdi = (RadioGroup) findViewById(R.id.rgpPadraoEdi);


        //Recuperando as refs dos Buttons
        voltar6 = (Button) findViewById(R.id.voltar6);
        concluir6 = (Button) findViewById(R.id.concluir6);

        inserirVoltei(codigo);

        concluir6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inserirSextaPagina(codigo);
                if (selectTipoEdificacao().toString().equals("null") || selectAlinhamento().toString().equals("null") ||
                        selectPosicao().toString().equals("null") || selectLocalizacao().toString().equals("null") ||
                        selectEstutura().toString().equals("null") || selectCobertura().toString().equals("null") ||
                        selectParedes().toString().equals("null") || selectForro().toString().equals("null") ||
                        selectRevestimento().toString().equals("null") || selectInstSanitaria().toString().equals("null") ||
                        selectInstEletric().toString().equals("null") || selectPiso().toString().equals("null") ||
                        selectPadrao().toString().equals("null")) {

                    Toast.makeText(SextaPagina.this, "Preencha os campos obrigatórios.(*)", Toast.LENGTH_SHORT).show();

                } else {
                    forms.close(); //Finalizando o Formulário
                    salvarArquivoTXT();
                    Intent intent = new Intent(SextaPagina.this, TelaInicial.class);//ULTIMA PAGINA VOLTA PARA TELA INICIAL SEMPRE
                    startActivity(intent);
                    finish();

                }
            }
        });

        voltar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inserirSextaPagina(codigo);
                Intent intent = new Intent(SextaPagina.this, QuintaPagina.class);
                intent.putExtra("codigoID", codigo);
                startActivity(intent);
                finish();
            }
        });

    }

    private void salvarArquivoTXT() {

        forms = dataBase.getReadableDatabase();

        Cursor c = forms.rawQuery("SELECT * FROM FORMULARIO WHERE PADRAO_EDI!='" + null + "'", null);
        if (c.getCount() == 0) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(SextaPagina.this);
            dlg.setMessage("ERRO AO ADICIONAR NO ARQUIVO .TXT");
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
        StringBuffer buffer = new StringBuffer();

        buffer.append(//Primeira Linha do Arquivo TXT com os campos das colunas.
                //"ID: " + "\t" + campo ID (não sera mais utilziado)
                "GEO CODIGO LOTE" + "\t " +
                        "GEO CODIGO ÁREA 1" + "\t " +
                        "GEO CODIGO ÁREA 2" + "\t " +
                        "GEO CODIGO ÁREA 3" + "\t " +
                        "PREFEITURA MUNICIPAL" + "\t" +
                        "DISTRITO" + "\t" +
                        "SETOR" + "\t" +
                        "QUADRA" + "\t" +
                        "LOTE" + "\t" +
                        "UNIDADE" + "\t" +
                        "DISTRITO ANT." + "\t" +
                        "SETOR ANT." + "\t" +
                        "QUADRA ANT." + "\t" +
                        "LOTE ANT." + "\t" +
                        "UNIDADE ANT." + "\t" +
                        "LOGADOURO" + "\t" +
                        "BAIRRO" + "\t" +
                        "NÚMERO" + "\t" +
                        "COMPLEMENTO" + "\t" +
                        "LOTEAMENTO " + "\t" +
                        "QUADRA" + "\t" +
                        "LOTE" + "\t" +
                        //Segunda Página
                        "NOME PROPRIET." + "\t" +
                        "CPF PROPRIET. " + "\t" +
                        "EST. CIVIL " + "\t" +
                        "CÔNJUGE" + "\t" +
                        "CPF CÔNJUGE" + "\t" +
                        "LOGADOURO" + "\t" +
                        "TIPO" + "\t" +
                        "NÚMERO" + "\t" +
                        "COMPLEMENTO" + "\t" +
                        "BAIRRO" + "\t" +
                        "MUNICÍPIO" + "\t" +
                        "CEP" + "\t" +
                        "UF" + "\t" +
                        //testes Terceira Página
                        "OCUPAÇÃO" + "\t" +
                        "UTILIZAÇÃO" + "\t" +
                        "PATRIMÔNIO" + "\t" +
                        "MURO" + "\t" +
                        "PASSEIO " + "\t" +
                        "ANO REF. " + "\t" +
                        "IPTU IMUNE/ISENTO" + "\t" +
                        "TSU ISENTO" + "\t" +
                        //Teste Quarta Página
                        "SITUAÇÃO" + "\t" +
                        "TOPOGRAFIA" + "\t" +
                        "PEDOLOGIA" + "\t" +
                        //Teste Quinta Página
                        "TESTADA PRINCIPAL" + "\t" +
                        "TESTADA2" + "\t" +
                        "CÓDIGO TESTADA2" + "\t" +
                        "SEÇÃO TESTADA2" + "\t" +
                        "TESTADA3" + "\t" +
                        "CÓDIGO TESTADA3" + "\t" +
                        "SEÇÃO TESTADA3" + "\t" +
                        "TESTADA4" + "\t" +
                        "CÓDIGO TESTADA4" + "\t" +
                        "SEÇÃO TESTADA4" + "\t" +
                        "ÁREA DO TERRENO" + "\t" +
                        "ÁREA CONST. DA UNIDADE" + "\t" +
                        "TOTAL DE UNIDADES" + "\t" +
                        "ÁREA TOTAL CONSTRUIDA" + "\t" +
                        //Sexta Pagina
                        "TIPO" + "\t" +
                        "ALINHAMENTO" + "\t" +
                        "POSIÇÃO" + "\t" +
                        "LOCALIZAÇÃO" + "\t" +
                        "ESTRUTURA" + "\t" +
                        "COBERTURA" + "\t" +
                        "PAREDES" + "\t" +
                        "FORRO" + "\t" +
                        "REVEST. EXTERNO" + "\t" +
                        "INST. SANITÁRIA" + "\t" +
                        "INST.ELÉTRICA" + "\t" +
                        "PISO" + "\t" +
                        "PADRÃO" + "\n");


        while (c.moveToNext()) {

            buffer.append(
                    //c.getString(0) + "\t" + campo ID (não sera mais utilziado)
                    c.getString(68) + "\t" +
                            c.getString(69) + "\t" +
                            c.getString(70) + "\t" +
                            c.getString(71) + "\t" +
                            //Primeira Página
                            c.getString(1) + "\t" +
                            c.getString(2) + "\t" +
                            c.getString(3) + "\t" +
                            c.getString(4) + "\t" +
                            c.getString(5) + "\t" +
                            c.getString(6) + "\t" +
                            c.getString(7) + "\t" +
                            c.getString(8) + "\t" +
                            c.getString(9) + "\t" +
                            c.getString(10) + "\t" +
                            c.getString(11) + "\t" +
                            c.getString(12) + "\t" +
                            c.getString(13) + "\t" +
                            c.getString(14) + "\t" +
                            c.getString(15) + "\t" +
                            c.getString(16) + "\t" +
                            c.getString(17) + "\t" +
                            c.getString(18) + "\t" +
                            //Segunda Página
                            c.getString(19) + "\t" +
                            c.getString(20) + "\t" +
                            c.getString(21) + "\t" +
                            c.getString(22) + "\t" +
                    /*CPF CONJUGE*/c.getString(67) + "\t" +
                            c.getString(23) + "\t" +
                            c.getString(24) + "\t" +
                            c.getString(25) + "\t" +
                            c.getString(26) + "\t" +
                            c.getString(27) + "\t" +
                            c.getString(28) + "\t" +
                            c.getString(29) + "\t" +
                            c.getString(30) + "\t" +
                            //testes Terceira Página
                            c.getString(31) + "\t" +
                            c.getString(32) + "\t" +
                            c.getString(33) + "\t" +
                            c.getString(34) + "\t" +
                            c.getString(35) + "\t" +
                            c.getString(36) + "\t" +
                            c.getString(37) + "\t" +
                            c.getString(38) + "\t" +
                            //Teste Quarta Página
                            c.getString(39) + "\t" +
                            c.getString(40) + "\t" +
                            c.getString(41) + "\t" +
                            //Teste Quinta Página
                            c.getString(42) + "\t" +
                            c.getString(43) + "\t" +
                            c.getString(44) + "\t" +
                            c.getString(45) + "\t" +
                            c.getString(46) + "\t" +
                            c.getString(47) + "\t" +
                            c.getString(48) + "\t" +
                            c.getString(49) + "\t" +
                            c.getString(50) + "\t" +
                            c.getString(51) + "\t" +
                            c.getString(52) + "\t" +
                            c.getString(53) + "\t" +
                            c.getString(54) + "\t" +
                            c.getString(55) + "\t" +
                            //Sexta Pagina
                            c.getString(56) + "\t" +
                            c.getString(57) + "\t" +
                            c.getString(58) + "\t" +
                            c.getString(59) + "\t" +
                            c.getString(60) + "\t" +
                            c.getString(61) + "\t" +
                            c.getString(62) + "\t" +
                            c.getString(63) + "\t" +
                            c.getString(72) + "\t" +
                            c.getString(73) + "\t" +
                            c.getString(64) + "\t" +
                            c.getString(65) + "\t" +
                            c.getString(66) + "\t" +
                            "\n");

        }

        File filename = new File(diretorioApp, "formularios.txt");

        String conteudoArquivo = buffer.toString();
        try {
            FileOutputStream arquivoGravar;
            arquivoGravar = new FileOutputStream(filename);
            arquivoGravar.write(conteudoArquivo.getBytes());
            Toast.makeText(this, "Formulario Gravado com Sucesso!", Toast.LENGTH_SHORT).show();
            arquivoGravar.close();
        } catch (FileNotFoundException erro) {
            mostrarMensagem("Arquivo nao encontrado.", "" + erro);
        } catch (IOException erro) {
            mostrarMensagem("Erro de Entrada e Saida", "" + erro);
        }
    }


    public void mostrarMensagem(String titulo, String texto) { // Para teste

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle(titulo);
        dlg.setMessage(texto);
        dlg.setPositiveButton("OK", null);
        dlg.show();

    }


    @Override
    public void onBackPressed() {
        inserirSextaPagina(codigo);
        Intent intent = new Intent(SextaPagina.this, QuintaPagina.class);
        intent.putExtra("codigoID", codigo);
        startActivity(intent);
        finish();

    }

    private String selectTipoEdificacao() {
        String value = "null";
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
        String value = "null";
        int opcao = rgpAlinhamentoEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtAlinhadaEdi) return rbtAlinhadaEdi.getText().toString();
        else if (opcao == R.id.rbtRecuadaEdi) return rbtRecuadaEdi.getText().toString();
        return String.valueOf(value);
    }

    private String selectPosicao() {
        String value = "null";
        int opcao = rgpPosicaoEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtIsolada) return rbtIsolada.getText().toString();
        else if (opcao == R.id.rbtConjugada) return rbtConjugada.getText().toString();
        else if (opcao == R.id.rbtGeminada) return rbtGeminada.getText().toString();
        return String.valueOf(value);
    }

    private String selectLocalizacao() {
        String value = "null";
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
        String value = "null";
        int opcao = rgpEstrutEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtEstAlvenaria) return rbtEstAlvenaria.getText().toString();
        else if (opcao == R.id.rbtEstMadeira) return rbtEstMadeira.getText().toString();
        else if (opcao == R.id.rbtEstMetalica) return rbtEstMetalica.getText().toString();
        else if (opcao == R.id.rbtEstConcreto) return rbtEstConcreto.getText().toString();
        return String.valueOf(value);
    }

    private String selectCobertura() {
        String value = "null";
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
        String value = "null";
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
        String value = "null";
        int opcao = rgpForroEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtForSem) return rbtForSem.getText().toString();
        else if (opcao == R.id.rbtForMadeira) return rbtForMadeira.getText().toString();
        else if (opcao == R.id.rbtForGesso) return rbtForGesso.getText().toString();
        else if (opcao == R.id.rbtForLaje) return rbtForLaje.getText().toString();
        else if (opcao == R.id.rbtForEsteira) return rbtForEsteira.getText().toString();
        return String.valueOf(value);
    }

    private String selectRevestimento() {
        String value = "null";
        int opcao = rgpRevestimento.getCheckedRadioButtonId();

        if (opcao == R.id.rbtRevestSem) return rbtRevestSem.getText().toString();
        else if (opcao == R.id.rbtRevestReboco) return rbtRevestReboco.getText().toString();
        else if (opcao == R.id.rbtRevestCaia) return rbtRevestCaia.getText().toString();
        else if (opcao == R.id.rbtRevestPintura) return rbtRevestPintura.getText().toString();
        else if (opcao == R.id.rbtRevestCeramico) return rbtRevestCeramico.getText().toString();
        else if (opcao == R.id.rbtRevestPedra) return rbtRevestPedra.getText().toString();
        else if (opcao == R.id.rbtRevestMadeira) return rbtRevestMadeira.getText().toString();
        else if (opcao == R.id.rbtRevestConcreto) return rbtRevestConcreto.getText().toString();
        return String.valueOf(value);
    }

    private String selectInstSanitaria() {
        String value = "null";
        int opcao = rgpSanitEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtSanitSem) return rbtSanitSem.getText().toString();
        else if (opcao == R.id.rbtSanitExterna) return rbtSanitExterna.getText().toString();
        else if (opcao == R.id.rbtSanitInternaSimples)
            return rbtSanitInternaSimples.getText().toString();
        else if (opcao == R.id.rbtSanitInternaLuxo) return rbtSanitInternaLuxo.getText().toString();
        else if (opcao == R.id.rbtSanitMaisDe1Interna)
            return rbtSanitMaisDe1Interna.getText().toString();
        return String.valueOf(value);
    }

    private String selectInstEletric() {
        String value = "null";
        int opcao = rgpEletricEdi.getCheckedRadioButtonId();

        if (opcao == R.id.rbtEletSem) return rbtEletSem.getText().toString();
        else if (opcao == R.id.rbtEletAparente) return rbtEletAparente.getText().toString();
        else if (opcao == R.id.rbtEletEmbu) return rbtEletEmbu.getText().toString();
        else if (opcao == R.id.rbtEletSemiImbut) return rbtEletSemiImbut.getText().toString();
        return String.valueOf(value);
    }

    private String selectPiso() {
        String value = "null";
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
        String value = "null";
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
                    "ESTRUT_EDI", "COBERTURA_EDI", "PAREDES_EDI", "FORRO_EDI", "REVEST_EDI",
                    "SANIT_EDI", "ELETRIC_EDI", "PISO_EDI", "PADRAO_EDI"};

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
                forms.execSQL("UPDATE FORMULARIO SET REVEST_EDI='" + selectRevestimento() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET SANIT_EDI='" + selectInstSanitaria() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET ELETRIC_EDI='" + selectInstEletric() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET PISO_EDI='" + selectPiso() + "'  WHERE _id='" + codigoID + "'");
                forms.execSQL("UPDATE FORMULARIO SET PADRAO_EDI='" + selectPadrao() + "'  WHERE _id='" + codigoID + "'");
            }
            c.close();

        } catch (Exception ex) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Inserir os Dados." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }
    }


    private void inserirVoltei(long codigoID) {

        try {
            forms = dataBase.getReadableDatabase();
            Cursor c = forms.rawQuery("SELECT * FROM FORMULARIO WHERE _id='" + codigoID + "'", null);

            if (c.moveToFirst()) {
                if (c.getString(56) != null) {//TIPO
                    if (c.getString(56).equals("Casa")) rgpTipoEdi.check(R.id.rbtCasaEdi);
                    else if (c.getString(56).equals("Barracão"))
                        rgpTipoEdi.check(R.id.rbtBarracaoEdi);
                    else if (c.getString(56).equals("Apartamento"))
                        rgpTipoEdi.check(R.id.rbtAptdEdi);
                    else if (c.getString(56).equals("Sala")) rgpTipoEdi.check(R.id.rbtSalaEdi);
                    else if (c.getString(56).equals("Loja")) rgpTipoEdi.check(R.id.rbtLojaEdi);
                    else if (c.getString(56).equals("Galpão")) rgpTipoEdi.check(R.id.rbtGalpaoEdi);
                    else if (c.getString(56).equals("Telheiro"))
                        rgpTipoEdi.check(R.id.rbtTelheiroEdi);
                    else if (c.getString(56).equals("Fábrica"))
                        rgpTipoEdi.check(R.id.rbtFabricaEdi);
                    else if (c.getString(56).equals("Especial"))
                        rgpTipoEdi.check(R.id.rbtEspecialEdi);
                }
                if (c.getString(57) != null) {//ALLINHAMENTO
                    if (c.getString(57).equals("Alinhada"))
                        rgpAlinhamentoEdi.check(R.id.rbtAlinhadaEdi);
                    else if (c.getString(57).equals("Recuada"))
                        rgpAlinhamentoEdi.check(R.id.rbtRecuadaEdi);
                }
                if (c.getString(58) != null) {//POSICAO
                    if (c.getString(58).equals("Isolada")) rgpPosicaoEdi.check(R.id.rbtIsolada);
                    else if (c.getString(58).equals("Conjugada"))
                        rgpPosicaoEdi.check(R.id.rbtConjugada);
                    else if (c.getString(58).equals("Geminada"))
                        rgpPosicaoEdi.check(R.id.rbtGeminada);
                }
                if (c.getString(59) != null) {//LOCALIZACAO
                    if (c.getString(59).equals("Frente"))
                        rgpLocalizacaoEdi.check(R.id.rbtLocFrente);
                    else if (c.getString(59).equals("Fundos"))
                        rgpLocalizacaoEdi.check(R.id.rbtLocFundos);
                    else if (c.getString(59).equals("Sup. Frente"))
                        rgpLocalizacaoEdi.check(R.id.rbtLocSupFrente);
                    else if (c.getString(59).equals("Sup. Fundos"))
                        rgpLocalizacaoEdi.check(R.id.rbtLocSupFundos);
                    else if (c.getString(59).equals("Sobreloja"))
                        rgpLocalizacaoEdi.check(R.id.rbtLocSobreloja);
                    else if (c.getString(59).equals("Subsolo"))
                        rgpLocalizacaoEdi.check(R.id.rbtLocSubsolo);
                    else if (c.getString(59).equals("Galeria"))
                        rgpLocalizacaoEdi.check(R.id.rbtLocGaleria);
                }
                if (c.getString(60) != null) {//ESTRUTURA
                    if (c.getString(60).equals("Alvenaria"))
                        rgpEstrutEdi.check(R.id.rbtEstAlvenaria);
                    else if (c.getString(60).equals("Madeira"))
                        rgpEstrutEdi.check(R.id.rbtEstMadeira);
                    else if (c.getString(60).equals("Metálica"))
                        rgpEstrutEdi.check(R.id.rbtEstMetalica);
                    else if (c.getString(60).equals("Concreto"))
                        rgpEstrutEdi.check(R.id.rbtEstConcreto);
                }
                if (c.getString(61) != null) {//COBERTURA
                    if (c.getString(61).equals("Palha/Zinco"))
                        rgpCoberturaEdi.check(R.id.rbtCobPalhaZinco);
                    else if (c.getString(61).equals("Amianto Comum"))
                        rgpCoberturaEdi.check(R.id.rbtCobAmiComum);
                    else if (c.getString(61).equals("Telha de Barro"))
                        rgpCoberturaEdi.check(R.id.rbtCobTelhaBarro);
                    else if (c.getString(61).equals("Laje")) rgpCoberturaEdi.check(R.id.rbtCobLaje);
                    else if (c.getString(61).equals("Metálica"))
                        rgpCoberturaEdi.check(R.id.rbtCobMetalica);
                    else if (c.getString(61).equals("Telha Colonial"))
                        rgpCoberturaEdi.check(R.id.rbtCobTelhaColonial);
                    else if (c.getString(61).equals("Amianto Especial"))
                        rgpCoberturaEdi.check(R.id.rbtCobAmiEspecial);
                    else if (c.getString(61).equals("Telha Colonial Especial"))
                        rgpCoberturaEdi.check(R.id.rbtCobTelhaColEspecial);
                }
                if (c.getString(62) != null) {//PAREDES
                    if (c.getString(62).equals("Sem")) rgpParedesEdi.check(R.id.rbtParSem);
                    else if (c.getString(62).equals("Adobe/Taipa"))
                        rgpParedesEdi.check(R.id.rbtParAdobe);
                    else if (c.getString(62).equals("Alvenaria"))
                        rgpParedesEdi.check(R.id.rbtParAlvenaria);
                    else if (c.getString(62).equals("Madeira Simples"))
                        rgpParedesEdi.check(R.id.rbtParMadeiraSimples);
                    else if (c.getString(62).equals("Madeira Luxo"))
                        rgpParedesEdi.check(R.id.rbtParMadeiraLuxo);
                    else if (c.getString(62).equals("Concreto"))
                        rgpParedesEdi.check(R.id.rbtParConcreto);
                }
                if (c.getString(63) != null) {//FORRO
                    if (c.getString(63).equals("Sem")) rgpForroEdi.check(R.id.rbtForSem);
                    else if (c.getString(63).equals("Madeira"))
                        rgpForroEdi.check(R.id.rbtForMadeira);
                    else if (c.getString(63).equals("Gesso")) rgpForroEdi.check(R.id.rbtForGesso);
                    else if (c.getString(63).equals("Laje")) rgpForroEdi.check(R.id.rbtForLaje);
                    else if (c.getString(63).equals("Esteira"))
                        rgpForroEdi.check(R.id.rbtForEsteira);
                }
                if (c.getString(64) != null) {//INST ELETRIC
                    if (c.getString(64).equals("Sem")) rgpEletricEdi.check(R.id.rbtEletSem);
                    else if (c.getString(64).equals("Aparente"))
                        rgpEletricEdi.check(R.id.rbtEletAparente);
                    else if (c.getString(64).equals("Semi-embutida"))
                        rgpEletricEdi.check(R.id.rbtEletSemiImbut);
                    else if (c.getString(64).equals("Embutida"))
                        rgpEletricEdi.check(R.id.rbtEletEmbu);
                }
                if (c.getString(72) != null) {//REVESTIMENTO EXTERNO
                    if (c.getString(72).equals("Sem")) rgpRevestimento.check(R.id.rbtRevestSem);
                    else if (c.getString(72).equals("Reboco"))
                        rgpRevestimento.check(R.id.rbtRevestReboco);
                    else if (c.getString(72).equals("Caiação"))
                        rgpRevestimento.check(R.id.rbtRevestCaia);
                    else if (c.getString(72).equals("Pintura"))
                        rgpRevestimento.check(R.id.rbtRevestPintura);
                    else if (c.getString(72).equals("Cerâmico"))
                        rgpRevestimento.check(R.id.rbtRevestCeramico);
                    else if (c.getString(72).equals("Pedra"))
                        rgpRevestimento.check(R.id.rbtRevestPedra);
                    else if (c.getString(72).equals("Madeira"))
                        rgpRevestimento.check(R.id.rbtRevestMadeira);
                    else if (c.getString(72).equals("Concreto"))
                        rgpRevestimento.check(R.id.rbtRevestConcreto);
                }

                if (c.getString(73) != null) {//INSTALAÇÃO SANITÁRIA
                    if (c.getString(73).equals("Sem")) rgpSanitEdi.check(R.id.rbtSanitSem);
                    else if (c.getString(73).equals("Externa"))
                        rgpSanitEdi.check(R.id.rbtSanitExterna);
                    else if (c.getString(73).equals("Interna Simples"))
                        rgpSanitEdi.check(R.id.rbtSanitInternaSimples);
                    else if (c.getString(73).equals("Interna Luxo"))
                        rgpSanitEdi.check(R.id.rbtSanitInternaLuxo);
                    else if (c.getString(73).equals("Mais de 1 Interna"))
                        rgpSanitEdi.check(R.id.rbtSanitMaisDe1Interna);
                }

                if (c.getString(65) != null) {//PISO
                    if (c.getString(65).equals("Terra")) rgpPisoEdi.check(R.id.rbtPisoTerra);
                    else if (c.getString(65).equals("Cimento"))
                        rgpPisoEdi.check(R.id.rbtPisoCimento);
                    else if (c.getString(65).equals("Cerâmico"))
                        rgpPisoEdi.check(R.id.rbtPisoCeramico);
                    else if (c.getString(65).equals("Carpete"))
                        rgpPisoEdi.check(R.id.rbtPisoCarpete);
                    else if (c.getString(65).equals("Plástico"))
                        rgpPisoEdi.check(R.id.rbtPisoPlastico);
                    else if (c.getString(65).equals("Taco")) rgpPisoEdi.check(R.id.rbtPisoTaco);
                    else if (c.getString(65).equals("Tábuas")) rgpPisoEdi.check(R.id.rbtPisoTabuas);
                    else if (c.getString(65).equals("Mármore"))
                        rgpPisoEdi.check(R.id.rbtPisoMarmore);
                    else if (c.getString(65).equals("Granito"))
                        rgpPisoEdi.check(R.id.rbtPisoGranito);
                }
                if (c.getString(66) != null) {//PADRAO
                    if (c.getString(66).equals("Luxo")) rgpPadraoEdi.check(R.id.rbtPadraoLuxo);
                    else if (c.getString(66).equals("Normal"))
                        rgpPadraoEdi.check(R.id.rbtPadraoNormal);
                    else if (c.getString(66).equals("Popular"))
                        rgpPadraoEdi.check(R.id.rbtPadraoPopular);
                    else if (c.getString(66).equals("Baixo"))
                        rgpPadraoEdi.check(R.id.rbtPadraoBaixo);
                }


            }
            c.close();

        } catch (Exception ex) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Inserir os Dados." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }
    }


}

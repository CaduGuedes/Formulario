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
import android.widget.ListView;

import forms.caduguedes.formulariotopocad.database.DataBase;
import forms.caduguedes.formulariotopocad.dominio.ManipulaBanco;
import forms.caduguedes.formulariotopocad.dominio.entidades.Formulario;


public class TelaInicial extends AppCompatActivity {



    private Button inserirForm;
    private Button buscarForm;
    private Button limparTXT;

    private ListView lstForms;
    private ArrayAdapter<String> adpFormularios;
    private ManipulaBanco manipulaBanco;
    private Formulario formulario;


    //Declarando o Banco de Dados
    private DataBase dataBase;
    private SQLiteDatabase forms;

    long codigo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

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

        inserirForm = (Button) findViewById(R.id.inserirForm);
        buscarForm = (Button) findViewById(R.id.buscarForm);
        limparTXT = (Button) findViewById(R.id.limparTXT);


        inserirForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inserirRegistroTelaInicial();
                Intent intent = new Intent(TelaInicial.this, PrimeiraPagina.class);
                intent.putExtra("codigoID", codigo);

                startActivity(intent);
                //finish();

            }
        });

        buscarForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(TelaInicial.this, FormsCriados.class);
                //startActivity(intent);
                mostrarNaTela();

            }
        });

        limparTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(TelaInicial.this, ManipulaForms.class);
                startActivity(it);
                //finish();

            }
        });

    }

    private void mostrarNaTela(){ // Para Teste

        forms = dataBase.getReadableDatabase();

        Cursor c = forms.rawQuery("SELECT * FROM FORMULARIO WHERE PADRAO_EDI!='" + null + "'", null);
        if(c.getCount()==0){
            AlertDialog.Builder dlg = new AlertDialog.Builder(TelaInicial.this);
            dlg.setMessage("Nada encontrado.");
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){

            buffer.append(//"ID USADA: " + c.getString(0) +
                    //Primeira Página
                    "\nGeoCodigo Lote: " + c.getString(68) +
                            "\nGeoCodigo Área 1: " + c.getString(69) +
                            "\nGeoCodigo Área 2: " + c.getString(70) +
                            "\nGeoCodigo Área 3: " + c.getString(71) +
                    "\nPrefeitura Municpal de " + c.getString(1) +
                    "\n------------\nINSCRIÇÃO CADASTRAL\n------------\nDistrito: " + c.getString(2) +
                    " Setor: " + c.getString(3) +
                    " Quadra: " + c.getString(4) +
                    " Lote: " + c.getString(5) +
                    " Unidade: " + c.getString(6) +
                    " \nINSCRIÇÃO ATERIOR\n------------\nDistrito: " + c.getString(7) +
                    " Setor: " + c.getString(8) +
                    " Quadra: " + c.getString(9) +
                    " Lote: " + c.getString(10) +
                    " Unidade: " + c.getString(11) +
                    "\n------------\nLOCALIZAÇÃO \n------------\nLogadouro: " + c.getString(12) +
                    " Bairro: " + c.getString(13) +
                    " Número: " + c.getString(14) +
                    " Complemento: " + c.getString(15) +
                    " Loteamento: " + c.getString(16) +
                    " Quadra: " + c.getString(17) +
                    " Lote: " + c.getString(18) +
                    //Segunda Página
                    "\n------------\nSOBRE O PROPRIETÁRIO\n------------\nNome: " + c.getString(19) +
                    "\nCPF: " + c.getString(20) +
                    "\nEst. Civil: " + c.getString(21) +
                    "\nCônjuge: " + c.getString(22) +
                            "\nCPF do Cônjuge: " + c.getString(67) +
                    "\nLogadouro: " + c.getString(23) +
                    "\nTipo: " + c.getString(24) +
                    " Número: " + c.getString(25) +
                    "\nComplemento: " + c.getString(26) +
                    " Bairro: " + c.getString(27) +
                    "\nMunicípio: " + c.getString(28) +
                    "\nCEP: " + c.getString(29) +
                            " - UF: " + c.getString(30) +
                    //testes Terceira Página
                    "\n------------\nSOBRE O IMÓVEL\n------------\nOCUPAÇÃO: " + c.getString(31) +
                    "\nUTILIZAÇÃO: " + c.getString(32) +
                    "\nPATRIMONIO: " + c.getString(33) +
                    "\nMURO: " + c.getString(34) +
                    "\nPASSEIO: " + c.getString(35) +
                    "\nANO: " + c.getString(36) +
                            "\nIPTU Imune/Isento: " + c.getString(37) +
                            "\nTSU Isento: " + c.getString(38) +
                    //Teste Quarta Página
                    "\n------------\nSOBRE O TERRENO\n------------\nSituaçao: " + c.getString(39) +
                    "\nTopografia: " + c.getString(40) +
                    "\nPedologia: " + c.getString(41) +
                    //Teste Quinta Página
                    "\n------------\nMEDIDAS DO IMÓVEL\n------------\nTestada Principal: " + c.getString(42) +
                    "\nTestada2: " + c.getString(43) +
                    "\nCódigo Testada2: " + c.getString(44) +
                    "\nSeção Testada2: " + c.getString(45) +
                    "\nTestada3: " + c.getString(46) +
                    "\nCódigo Testada3: " + c.getString(47) +
                    "\nSeção Testada3: " + c.getString(48) +
                    "\nTestada4: " + c.getString(49) +
                    "\nCódigo Testada4: " + c.getString(50) +
                    "\nSeção Testada4: " + c.getString(51) +
                    "\nÁrea do Terreno: " + c.getString(52) +
                    "\nÁrea Const. da Unidade: " + c.getString(53) +
                    "\nTotal de Unidades: " + c.getString(54) +
                    "\nÁrea Total Construída: " + c.getString(55) +
                    //Sexta Pagina
                    "\n------------\nSOBRE EDIFICAÇÃO\n------------\nTipo: " + c.getString(56) +
                    "\nAlinhamento: " + c.getString(57) +
                    "\nPosição: " + c.getString(58) +
                    "\nLocalização: " + c.getString(59) +
                    "\nEstrutura: " + c.getString(60) +
                    "\nCobertura: " + c.getString(61) +
                    "\nParedes: " + c.getString(62) +
                    "\nForro: " + c.getString(63) +
                            "\nRevest. Externo: " + c.getString(72) +
                            "\nInst.Sanitária: " + c.getString(73) +
                    "\nInst.Elétrica: " + c.getString(64) +
                    "\nPiso: " + c.getString(65) +
                    "\nPadrão: " + c.getString(66) +

                            " \n \n************************************ ");

        }
        AlertDialog.Builder dlg1 = new AlertDialog.Builder(TelaInicial.this);
        dlg1.setMessage("FORMULÁRIOS:\n" + buffer.toString());
        dlg1.setNeutralButton("OK", null);
        dlg1.show();
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

    private void inserirRegistroTelaInicial(){

        try {
            formulario = new Formulario();

            manipulaBanco.inserir(formulario);

            //TRECHO EXTRAIDO DE: http://stackoverflow.com/questions/7575166/android-sqlite-get-last-insert-row-id
            String query = "SELECT ROWID from FORMULARIO order by ROWID DESC limit 1";
            Cursor c = forms.rawQuery(query, null);
            if (c != null && c.moveToFirst()) {
                codigo = c.getLong(0); //The 0 is the column index, we only have 1 column, so the index is 0
            }


        }catch (Exception ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Inserir os Dados." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }
        forms.close();

    }
}


package forms.caduguedes.formulariotopocad;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import forms.caduguedes.formulariotopocad.database.DataBase;
import forms.caduguedes.formulariotopocad.dominio.ManipulaBanco;
import forms.caduguedes.formulariotopocad.dominio.entidades.Formulario;


public class TelaInicial extends AppCompatActivity {



    private Button inserirForm;
    private Button buscarForm;

    private ListView lstForms;
    private ArrayAdapter<String> adpFormularios;
    private ManipulaBanco manipulaBanco;
    private Formulario formulario;


    //Declarando o Banco de Dados
    private DataBase dataBase;
    private SQLiteDatabase forms;

    int codigo;


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

        inserirForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inserirRegistroTelaInicial();
                Intent intent = new Intent(TelaInicial.this, PrimeiraPagina.class);
                intent.putExtra("codigoID", codigo);

                AlertDialog.Builder dlg = new AlertDialog.Builder(TelaInicial.this);
                dlg.setMessage("VALOR DA ID QUE INICIA: " + codigo );
                dlg.setNeutralButton("OK", null);
                dlg.show();

                startActivity(intent);
                finish();

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


    }

    private void mostrarNaTela(){ // Para Teste

        forms = dataBase.getReadableDatabase();

        Cursor c = forms.rawQuery("SELECT * FROM FORMULARIO", null);
        if(c.getCount()==0){
            AlertDialog.Builder dlg = new AlertDialog.Builder(TelaInicial.this);
            dlg.setMessage("ERRO. Nada encontrado.");
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
        StringBuffer buffer = new StringBuffer();
        while(c.moveToNext()){

            buffer.append("CIDADE: " + c.getString(1) + " NOME: " + c.getString(19) + " ID USADA: " + c.getString(0) + " \n ");

        }
        AlertDialog.Builder dlg1 = new AlertDialog.Builder(TelaInicial.this);
        dlg1.setMessage("Detalhes do Contato:\n" + buffer.toString());
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

            formulario.setPREFEITURA("");
            formulario.setDISTRITO1("");
            formulario.setSETOR1("");
            formulario.setQUADRA1("");
            formulario.setLOTE1("");
            formulario.setUNIDADE1("");
            formulario.setDISTRITO2("");
            formulario.setSETOR2("");
            formulario.setQUADRA2("");
            formulario.setLOTE2("");
            formulario.setUNIDADE2("");
            formulario.setNOME_LOGADOURO("");
            formulario.setBAIRRO1("");
            formulario.setNUMERO1("");
            formulario.setCOMPLEMENTO1("");
            formulario.setLOTEAMENTO1("");
            formulario.setQUADRA_IMOVEL("");
            formulario.setLOTE_IMOVEL("");
            //Segunda Página
            formulario.setNOME_PROPRIETARIO("");

            manipulaBanco.inserir(formulario);



        }catch (Exception ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Inserir os Dados." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }
        forms.close();

        codigo = (int) formulario.get_ID();

    }


}

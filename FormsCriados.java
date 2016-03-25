package forms.caduguedes.formulariotopocad;

import android.app.AlertDialog;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

import forms.caduguedes.formulariotopocad.database.DataBase;
import forms.caduguedes.formulariotopocad.dominio.ManipulaBanco;
import forms.caduguedes.formulariotopocad.dominio.entidades.Formulario;

public class FormsCriados extends AppCompatActivity {

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
        setContentView(R.layout.activity_forms_criados);

        lstForms = (ListView) findViewById(R.id.lstForms);

        //Criando a Referência pro meu BD
        try{

            dataBase = new DataBase(this);
            forms = dataBase.getWritableDatabase();


            manipulaBanco = new ManipulaBanco(forms);

           // adpFormularios = manipulaBanco.buscaForms(this);

           // lstForms.setAdapter(adpFormularios); //vinculando o obj listview ao adpForm


        }catch (SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Criar o Banco." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }







    }
}

package forms.caduguedes.formulariotopocad;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import forms.caduguedes.formulariotopocad.database.DataBase;


public class ManipulaForms extends AppCompatActivity {
    //Declarando o Banco de Dados
    private DataBase dataBase;
    private SQLiteDatabase forms;

    private EditText edtSenha;

    private Button btnCancelExc;
    private Button btnExcDef;

    private CheckBox cboxMostraSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manipula_forms);
        //Criando a Referência pro meu BD
        try {

            dataBase = new DataBase(this);
            forms = dataBase.getWritableDatabase();


        } catch (SQLException ex) {

            android.app.AlertDialog.Builder dlg = new android.app.AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Criar o Banco." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }

        edtSenha = (EditText) findViewById(R.id.edtSenha);

        //Recuperando Referências dos Buttons
        btnCancelExc = (Button) findViewById(R.id.btnCancelExc);
        btnExcDef = (Button) findViewById(R.id.btnExcDef);

        //Recuperando ChecBox
        cboxMostraSenha = (CheckBox) findViewById(R.id.cboxMostraSenha);

        //Codigo pra mostrar senha digitada
        cboxMostraSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked)
                    edtSenha.setTransformationMethod(new PasswordTransformationMethod());
                else
                    edtSenha.setTransformationMethod(null);

            }
        });

        btnExcDef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtSenha.getText().toString().equals("topo@cad1234")) {
                    deletaFormulario();
                    Toast.makeText(ManipulaForms.this, "Formulários Excluídos", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ManipulaForms.this, "Senha incorreta", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnCancelExc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


    }

    private void deletaFormulario() {

        try {
            forms = dataBase.getWritableDatabase();
            forms.delete("FORMULARIO", null, null);
            forms.close();
        } catch (SQLException ex) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Inserir os Dados." + ex.getMessage());
            dlg.setNeutralButton("OK", null);
            dlg.show();

        }
    }

}

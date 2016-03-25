package forms.caduguedes.formulariotopocad.database;

/**
 * Created by caduguedes on 21/03/16.
 */

import android.content.Context;
import android.database.sqlite.*;


public class DataBase extends SQLiteOpenHelper{


    public DataBase(Context context){

        super(context, "FORMULARIO", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(ScripSQL.getCreateFormulario());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

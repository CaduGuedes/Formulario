package forms.caduguedes.formulariotopocad.dominio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import forms.caduguedes.formulariotopocad.dominio.entidades.Formulario;

/**
 * Created by caduguedes on 21/03/16.
 */
public class ManipulaBanco {

    private SQLiteDatabase forms;

    public ManipulaBanco(SQLiteDatabase forms){

        this.forms = forms;

    }

    public int inserir(Formulario formulario){
        ContentValues values = new ContentValues();
        //Primeira Página 18 itens
        values.put("PREFEITURA", formulario.getPREFEITURA());
        values.put("DISTRITO1", formulario.getDISTRITO1());
        values.put("SETOR1", formulario.getSETOR1());
        values.put("QUADRA1", formulario.getQUADRA1());
        values.put("LOTE1", formulario.getLOTE1());
        values.put("UNIDADE1", formulario.getUNIDADE1());
        values.put("DISTRITO2", formulario.getDISTRITO2());
        values.put("SETOR2", formulario.getSETOR2());
        values.put("QUADRA2", formulario.getQUADRA2());
        values.put("LOTE2", formulario.getLOTE2());
        values.put("UNIDADE2", formulario.getUNIDADE2());
        values.put("NOME_LOGADOURO", formulario.getNOME_LOGADOURO());
        values.put("BAIRRO1", formulario.getBAIRRO1());
        values.put("NUMERO1", formulario.getNUMERO1());
        values.put("COMPLEMENTO1", formulario.getCOMPLEMENTO1());
        values.put("LOTEAMENTO1", formulario.getLOTEAMENTO1());
        values.put("QUADRA_IMOVEL", formulario.getQUADRA_IMOVEL());
        values.put("LOTE_IMOVEL", formulario.getLOTE_IMOVEL());
        //Segunda Página 12 itens
        values.put("NOME_PROPRIETARIO", formulario.getNOME_PROPRIETARIO());
        values.put("CPF_PROPRIETARIO", formulario.getCPF_PROPRIETARIO());
        values.put("ESTADO_CIVIL", formulario.getESTADO_CIVIL());
        values.put("NOME_CONJUGE", formulario.getNOME_CONJUGE());
        values.put("NOME_LOG_PROPRIETARIO", formulario.getNOME_LOG_PROPRIETARIO());
        values.put("TIPO_LOG_PROPRIETARIO", formulario.getTIPO_LOG_PROPRIETARIO());
        values.put("NUM_LOG_PROPRIETARIO", formulario.getNUM_LOG_PROPRIETARIO());
        values.put("COMPLEMENTO_PROPRIETARIO", formulario.getCOMPLEMENTO_PROPRIETARIO());
        values.put("BAIRRO_PROPRIETARIO", formulario.getBAIRRO_PROPRIETARIO());
        values.put("MUNICIPIO_PROPRIETARIO", formulario.getMUNICIPIO_PROPRIETARIO());
        values.put("CEP_PROPRIETARIO", formulario.getCEP_PROPRIETARIO());
        values.put("ESTADO_PROPRIETARIO", formulario.getESTADO_PROPRIETARIO());
        //Terceira Página 8itens
        values.put("OCUPACAO_IMOVEL", formulario.getOCUPACAO_IMOVEL());
        values.put("UTILIZA_IMOVEL", formulario.getUTILIZA_IMOVEL());
        values.put("PATRIMON_IMOVEL", formulario.getPATRIMON_IMOVEL());
        values.put("MUROCERCA_IMOVEL", formulario.getMUROCERCA_IMOVEL());
        values.put("PASSEIO_IMOVEL", formulario.getPASSEIO_IMOVEL());
        values.put("ANO_REF_IMOVEL", formulario.getANO_REF_IMOVEL());
        values.put("IMUNE_IPTU_IMOVEL", formulario.getIMUNE_IPTU_IMOVEL());
        values.put("ISENTO_TSU_IMOVEL", formulario.getISENTO_TSU_IMOVEL());
        //Quarta Página 3 itens
        values.put("SITUACAO_TER", formulario.getSITUACAO_TER());
        values.put("TOPOGRAFIA_TER", formulario.getTOPOGRAFIA_TER());
        values.put("PEDOLOGIA_TER", formulario.getPEDOLOGIA_TER());
        //Quinta Página
        values.put("TESTADA_PRINCIPAL", formulario.getTESTADA_PRINCIPAL());
        values.put("TESTADA2", formulario.getTESTADA2());
        values.put("COD_TESTADA2", formulario.getCOD_TESTADA2());
        values.put("SEC_TESTADA2", formulario.getSEC_TESTADA2());
        values.put("TESTADA3", formulario.getTESTADA3());
        values.put("COD_TESTADA3", formulario.getCOD_TESTADA3());
        values.put("SEC_TESTADA3", formulario.getSEC_TESTADA3());
        values.put("TESTADA4", formulario.getTESTADA4());
        values.put("COD_TESTADA4", formulario.getCOD_TESTADA4());
        values.put("SEC_TESTADA4", formulario.getSEC_TESTADA4());
        values.put("AREA_TERRENO", formulario.getAREA_TERRENO());
        values.put("AREA_CONST_UNI", formulario.getAREA_CONST_UNI());
        values.put("TOTAL_UNIDADES", formulario.getTOTAL_UNIDADES());
        values.put("AREA_TOTAL_CONST", formulario.getAREA_TOTAL_CONST());
        //Sexta Página 12 itens
        values.put("TIPO_EDI", formulario.getTIPO_EDI());
        values.put("ALINHAMENTO_EDI", formulario.getALINHAMENTO_EDI());
        values.put("POSICAO_EDI", formulario.getPOSICAO_EDI());
        values.put("LOCALIZACAO_EDI", formulario.getLOCALIZACAO_EDI());
        values.put("ESTRUT_EDI", formulario.getESTRUT_EDI());
        values.put("COBERTURA_EDI", formulario.getCOBERTURA_EDI());
        values.put("PAREDES_EDI", formulario.getPAREDES_EDI());
        values.put("FORRO_EDI", formulario.getFORRO_EDI());
        values.put("REVEST_EDI", formulario.getREVEST_EDI());
        values.put("SANIT_EDI", formulario.getSANIT_EDI());
        values.put("ELETRIC_EDI", formulario.getELETRIC_EDI());
        values.put("PISO_EDI", formulario.getPISO_EDI());
        values.put("PADRAO_EDI", formulario.getPADRAO_EDI());
        values.put("CPF_CONJUGE", formulario.getCPF_CONJUGE());
        values.put("GEO_CODIGO", formulario.getGEO_CODIGO());
        values.put("GEO_CODIGO1", formulario.getGEO_CODIGO1());
        values.put("GEO_CODIGO2", formulario.getGEO_CODIGO2());
        values.put("GEO_CODIGO3", formulario.getGEO_CODIGO3());



        forms.insertOrThrow("FORMULARIO", null, values);
        return verificaId();

    }

    private int verificaId() {
        Cursor c = forms.query("FORMULARIO", null, null, null, null, null, null);

        return c.getCount();
    }




    /*   public ArrayAdapter<Formulario> buscaForms(Context context) {

        ArrayAdapter<Formulario> adpFormularios = new ArrayAdapter<Formulario>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = forms.query("FORMULARIO", null, null, null, null, null, null);//Responsável por armazenar os registros

        if(cursor!= null){

            cursor.moveToFirst();


            do{
                Formulario formulario = new Formulario();

                //Primeira Página
                formulario.setPREFEITURA(cursor.getString(1));
                formulario.setDISTRITO1(cursor.getString(2));
                formulario.setSETOR1(cursor.getString(3));
                formulario.setQUADRA1(cursor.getString(4));
                formulario.setLOTE1(cursor.getString(5));
                formulario.setUNIDADE2(cursor.getString(6));
                formulario.setDISTRITO2(cursor.getString(7));
                formulario.setSETOR2(cursor.getString(8));
                formulario.setQUADRA1(cursor.getString(9));
                formulario.setLOTE2(cursor.getString(10));
                formulario.setUNIDADE2(cursor.getString(11));
                formulario.setNOME_LOGADOURO(cursor.getString(12));
                formulario.setBAIRRO1(cursor.getString(13));
                formulario.setNUMERO1(cursor.getString(14));
                formulario.setCOMPLEMENTO1(cursor.getString(15));
                formulario.setLOTEAMENTO1(cursor.getString(16));
                formulario.setQUADRA_IMOVEL(cursor.getString(17));
                formulario.setLOTE_IMOVEL(cursor.getString(18));
                //Segunda Página

                formulario.setNOME_PROPRIETARIO(cursor.getString(19));
                formulario.setCPF_PROPRIETARIO(cursor.getString(20));
                formulario.setESTADO_CIVIL(String.valueOf(cursor.getString(21)));
                formulario.setNOME_CONJUGE(cursor.getString(22));
                formulario.setNOME_LOG_PROPRIETARIO(cursor.getString(23));
                formulario.setTIPO_LOG_PROPRIETARIO(cursor.getString(24));
                formulario.setNUM_LOG_PROPRIETARIO(cursor.getString(25));
                formulario.setCOMPLEMENTO_PROPRIETARIO(cursor.getString(26));
                formulario.setBAIRRO_PROPRIETARIO(cursor.getString(27));
                formulario.setMUNICIPIO_PROPRIETARIO(cursor.getString(28));
                formulario.setCEP_PROPRIETARIO(cursor.getString(29));
                formulario.setESTADO_PROPRIETARIO(cursor.getString(30));
                //Terceira Página

                adpFormularios.add(formulario);

            }while (cursor.moveToNext());

        }

        return adpFormularios;
    }*/




}

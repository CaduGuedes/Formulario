package forms.caduguedes.formulariotopocad.database;

/**
 * Created by caduguedes on 22/03/16.
 */

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

public class CriarBanco extends SQLiteOpenHelper{
    public CriarBanco(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }/*

    protected static final String NOME_BANCO = "banco";
    protected static final String TABELA = "cadastro";
    protected static final String TABELA2 = "quiz";
    protected static final int VERSAO = 1;
    protected static final String _ID = "_id";
    protected static final String PREFEITURA = "edtPrefeitura";
    protected static final String DISTRITO1 = "edtDistrito1";
    protected static final String SETOR1 = "distrito1";
    protected static final String QUADRA1 = "distrito1";
    protected static final String LOTE1 = "distrito1";
    protected static final String UNIDADE1 = "distrito1";
    protected static final String DISTRITO2 = "distrito1";
    protected static final String SETOR2 = "distrito1";
    protected static final String QUADRA2 = "distrito1";
    protected static final String LOTE2 = "distrito1";
    protected static final String UNIDADE2 = "distrito1";
    protected static final String NOME_LOGADOURO = "distrito1";
    protected static final String BAIRRO1 = "distrito1";
    protected static final String NUMERO1 = "distrito1";
    protected static final String COMPLEMENTO1 = "distrito1";
    protected static final String LOTEAMENTO1 = "distrito1";
    protected static final String QUADRA_IMOVEL = "distrito1";
    protected static final String LOTE_IMOVEL = "distrito1";
    protected static final String NOME_PROPRIETARIO = "distrito1";
    protected static final String CPF_PROPRIETARIO = "distrito1";
    protected static final String ESTADO_CIVIL = "distrito1";
    protected static final String NOME_CONJUGE = "distrito1";
    protected static final String NOME_LOG_PROPRIETARIO = "distrito1";
    protected static final String TIPO_LOG_PROPRIETARIO = "distrito1";
    protected static final String NUM_LOG_PROPRIETARIO = "distrito1";
    protected static final String COMPLEMENTO_PROPRIETARIO = "distrito1";
    protected static final String BAIRRO_PROPRIETARIO = "distrito1";
    protected static final String CEP_PROPRIETARIO = "distrito1";
    protected static final String ESTADO_PROPRIETARIO = "distrito1";
    protected static final String OCUPACAO_IMOVEL = "distrito1";
    protected static final String PATRIMON_IMOVEL = "distrito1";
    protected static final String MUROCERCA_IMOVEL = "distrito1";
    protected static final String PASSEIO_IMOVEL = "distrito1";
    protected static final String ANO_REF_IMOVEL = "distrito1";
    protected static final String IMUNE_IPTU_IMOVEL = "distrito1";
    protected static final String ISENTO_IPTU_IMOVEL = "distrito1";
    protected static final String SITUACAO_TER = "distrito1";
    protected static final String TOPOGRAFIA_TER = "distrito1";
    protected static final String PEDOLOGIA_TER = "distrito1";
    protected static final String TESTADA_PRINCIPAL = "distrito1";
    protected static final String TESTADA2 = "distrito1";
    protected static final String COD_TESTADA2 = "distrito1";
    protected static final String SEC_TESTADA2 = "distrito1";
    protected static final String TESTADA3 = "distrito1";
    protected static final String COD_TESTADA3 = "distrito1";
    protected static final String SEC_TESTADA3 = "distrito1";
    protected static final String TESTADA4 = "distrito1";
    protected static final String COD_TESTADA4 = "distrito1";
    protected static final String SEC_TESTADA4 = "distrito1";
    protected static final String AREA_TERRENO = "distrito1";
    protected static final String AREA_CONST_UNI = "distrito1";
    protected static final String TOTAL_UNIDADES = "distrito1";
    protected static final String AREA_TOTAL_CONST = "distrito1";
    protected static final String TIPO_EDI = "distrito1";
    protected static final String ALINHAMENTO_EDI = "distrito1";
    protected static final String POSICAO_EDI = "distrito1";
    protected static final String LOCALIZACAO_EDI = "distrito1";
    protected static final String ESTRUT_EDI = "distrito1";
    protected static final String COBERTURA_EDI = "distrito1";
    protected static final String PAREDES_EDI = "distrito1";
    protected static final String FORRO_EDI = "distrito1";
    protected static final String ELETRIC_EDI = "distrito1";
    protected static final String PISO_EDI = "distrito1";
    protected static final String PADRAO_EDI = "distrito1";
    protected static final String CPF_CNPJ = "distrito1";

    private static final  String getCreateFormulario(){

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS FORMULARIO ( ");
        sqlBuilder.append("        _id            INTEGER        NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("PREFEITURA    TEXT, ");//1
        sqlBuilder.append("DISTRITO1    TEXT, ");//2
        sqlBuilder.append("SETOR1        TEXT, ");//3
        sqlBuilder.append("QUADRA1    TEXT, ");//4
        sqlBuilder.append("LOTE1    TEXT, ");//5
        sqlBuilder.append("UNIDADE1    TEXT, ");//6
        sqlBuilder.append("DISTRITO2    TEXT, ");//7
        sqlBuilder.append("SETOR2    TEXT, ");//8
        sqlBuilder.append("QUADRA2    TEXT, ");//9
        sqlBuilder.append("LOTE2    TEXT, ");//10
        sqlBuilder.append("UNIDADE2    TEXT,");//11
        sqlBuilder.append("NOME_LOGADOURO    TEXT, ");//12
        sqlBuilder.append("BAIRRO1    TEXT, ");//13
        sqlBuilder.append("NUMERO1    TEXT, ");//14
        sqlBuilder.append("COMPLEMENTO1    TEXT, ");//15
        sqlBuilder.append("LOTEAMENTO1    TEXT, ");//16
        sqlBuilder.append("QUADRA_IMOVEL    TEXT, ");//17
        sqlBuilder.append("LOTE_IMOVEL    TEXT, ");//18
        sqlBuilder.append("NOME_PROPRIETARIO    TEXT, ");//19
        sqlBuilder.append("CPF_PROPRIETARIO    TEXT, ");//20
        sqlBuilder.append("ESTADO_CIVIL    TEXT, ");//21
        sqlBuilder.append("NOME_CONJUGE    TEXT, ");//22
        sqlBuilder.append("NOME_LOG_PROPRIETARIO    TEXT, ");//23
        sqlBuilder.append("TIPO_LOG_PROPRIETARIO    TEXT, ");//24
        sqlBuilder.append("NUM_LOG_PROPRIETARIO    TEXT, ");//25
        sqlBuilder.append("COMPLEMENTO_PROPRIETARIO    TEXT, ");//26
        sqlBuilder.append("BAIRRO_PROPRIETARIO    TEXT, ");//27
        sqlBuilder.append("CEP_PROPRIETARIO    TEXT, ");//28
        sqlBuilder.append("ESTADO_PROPRIETARIO    TEXT, ");//29
        sqlBuilder.append("OCUPACAO_IMOVEL    TEXT, ");//30
        sqlBuilder.append("PATRIMON_IMOVEL    TEXT, ");//31
        sqlBuilder.append("MUROCERCA_IMOVEL    TEXT, ");//32
        sqlBuilder.append("PASSEIO_IMOVEL    TEXT, ");//33
        sqlBuilder.append("ANO_REF_IMOVEL    TEXT, ");//34
        sqlBuilder.append("IMUNE_IPTU_IMOVEL    TEXT, ");//35
        sqlBuilder.append("ISENTO_IPTU_IMOVEL    TEXT, ");//36
        sqlBuilder.append("SITUACAO_TER    TEXT, ");//37
        sqlBuilder.append("TOPOGRAFIA_TER    TEXT, ");//38
        sqlBuilder.append("PEDOLOGIA_TER    TEXT, ");//39
        sqlBuilder.append("TESTADA_PRINCIPAL    TEXT, ");//40
        sqlBuilder.append("TESTADA2    TEXT, ");//41
        sqlBuilder.append("COD_TESTADA2    TEXT, ");//42
        sqlBuilder.append("SEC_TESTADA2    TEXT, ");//43
        sqlBuilder.append("TESTADA3    TEXT, ");//44
        sqlBuilder.append("COD_TESTADA3    TEXT, ");//45
        sqlBuilder.append("SEC_TESTADA3    TEXT, ");//46
        sqlBuilder.append("TESTADA4    TEXT, ");//47
        sqlBuilder.append("COD_TESTADA4    TEXT, ");//48
        sqlBuilder.append("SEC_TESTADA4    TEXT, ");//49
        sqlBuilder.append("AREA_TERRENO    TEXT, ");//50
        sqlBuilder.append("AREA_CONST_UNI    TEXT, ");//51
        sqlBuilder.append("TOTAL_UNIDADES    TEXT, ");//52
        sqlBuilder.append("AREA_TOTAL_CONST    TEXT, ");//53
        sqlBuilder.append("TIPO_EDI    TEXT, ");//54
        sqlBuilder.append("ALINHAMENTO_EDI    TEXT, ");//55
        sqlBuilder.append("POSICAO_EDI    TEXT, ");//56
        sqlBuilder.append("LOCALIZACAO_EDI    TEXT, ");//57
        sqlBuilder.append("ESTRUT_EDI    TEXT, ");//58
        sqlBuilder.append("COBERTURA_EDI    TEXT, ");//59
        sqlBuilder.append("PAREDES_EDI    TEXT, ");//60
        sqlBuilder.append("FORRO_EDI    TEXT, ");//61
        sqlBuilder.append("ELETRIC_EDI    TEXT, ");//62
        sqlBuilder.append("PISO_EDI    TEXT, ");//63
        sqlBuilder.append("PADRAO_EDI    TEXT, ");//64
        sqlBuilder.append("CPF_CNPJ    TEXT ");//65
        sqlBuilder.append(");");

        return sqlBuilder.toString();
    }


    public CriarBanco(Context context){                                                      //Comentar
        super(context, NOME_BANCO,null,VERSAO);
    }


    */
}
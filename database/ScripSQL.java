package forms.caduguedes.formulariotopocad.database;

/**
 * Created by caduguedes on 21/03/16.
 */
public class ScripSQL {

    public static String getCreateFormulario(){


        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS FORMULARIO ( ");
        sqlBuilder.append("        _id            INTEGER        NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        //Primeira Pagina
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
        //Segunda Página
        sqlBuilder.append("NOME_PROPRIETARIO    TEXT, ");//19
        sqlBuilder.append("CPF_PROPRIETARIO    TEXT, ");//20
        sqlBuilder.append("ESTADO_CIVIL    TEXT, ");//21
        sqlBuilder.append("NOME_CONJUGE    TEXT, ");//22
        sqlBuilder.append("NOME_LOG_PROPRIETARIO    TEXT, ");//23
        sqlBuilder.append("TIPO_LOG_PROPRIETARIO    TEXT, ");//24
        sqlBuilder.append("NUM_LOG_PROPRIETARIO    TEXT, ");//25
        sqlBuilder.append("COMPLEMENTO_PROPRIETARIO    TEXT, ");//26
        sqlBuilder.append("BAIRRO_PROPRIETARIO    TEXT, ");//27
        sqlBuilder.append("MUNICIPIO_PROPRIETARIO    TEXT, ");//29
        sqlBuilder.append("CEP_PROPRIETARIO    TEXT, ");//29
        sqlBuilder.append("ESTADO_PROPRIETARIO    TEXT, ");//30
        //Terceira Pagina
        sqlBuilder.append("OCUPACAO_IMOVEL    TEXT, ");//31editar
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
}

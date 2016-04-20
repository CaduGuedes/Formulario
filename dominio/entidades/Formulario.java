package forms.caduguedes.formulariotopocad.dominio.entidades;

/**
 * Created by caduguedes on 21/03/16.
 */
public class Formulario { //MAPEAMENTO OBJETO RELACIONAL

    private long _ID;

    private String PREFEITURA;
    private String DISTRITO1;
    private String SETOR1;
    private String QUADRA1;
    private String LOTE1;
    private String UNIDADE1;
    private String DISTRITO2;
    private String SETOR2;
    private String QUADRA2;
    private String LOTE2;
    private String UNIDADE2;
    private String NOME_LOGADOURO;
    private String BAIRRO1;
    private String NUMERO1;
    private String COMPLEMENTO1;
    private String LOTEAMENTO1;
    private String QUADRA_IMOVEL;
    private String LOTE_IMOVEL;
    //Segunda Pagina
    private String NOME_PROPRIETARIO;
    private String CPF_PROPRIETARIO;
    private String ESTADO_CIVIL;
    private String NOME_CONJUGE;
    private String NOME_LOG_PROPRIETARIO;
    private String TIPO_LOG_PROPRIETARIO;
    private String NUM_LOG_PROPRIETARIO;
    private String COMPLEMENTO_PROPRIETARIO;
    private String BAIRRO_PROPRIETARIO;
    private String MUNICIPIO_PROPRIETARIO;
    private String CEP_PROPRIETARIO;
    private String ESTADO_PROPRIETARIO;
    //Terceira Pagina
    private String OCUPACAO_IMOVEL;
    private String UTILIZA_IMOVEL;
    private String PATRIMON_IMOVEL;
    private String MUROCERCA_IMOVEL;
    private String PASSEIO_IMOVEL;
    private String ANO_REF_IMOVEL;
    private String IMUNE_IPTU_IMOVEL;
    private String ISENTO_TSU_IMOVEL;
    //Quarta Pagina
    private String SITUACAO_TER;
    private String TOPOGRAFIA_TER;
    private String PEDOLOGIA_TER;
    //Quinta Pagina
    private String TESTADA_PRINCIPAL;
    private String TESTADA2;
    private String COD_TESTADA2;
    private String SEC_TESTADA2;
    private String TESTADA3;
    private String COD_TESTADA3;
    private String SEC_TESTADA3;
    private String TESTADA4;
    private String COD_TESTADA4;
    private String SEC_TESTADA4;
    private String AREA_TERRENO;
    private String AREA_CONST_UNI;
    private String TOTAL_UNIDADES;
    private String AREA_TOTAL_CONST;
    //Sexta Pagina
    private String TIPO_EDI;
    private String ALINHAMENTO_EDI;
    private String POSICAO_EDI;
    private String LOCALIZACAO_EDI;
    private String ESTRUT_EDI;
    private String COBERTURA_EDI;
    private String PAREDES_EDI;
    private String FORRO_EDI;
    private String REVEST_EDI;
    private String SANIT_EDI;
    private String ELETRIC_EDI;
    private String PISO_EDI;
    private String PADRAO_EDI;
    private String CPF_CONJUGE;
    private String GEO_CODIGO;
    private String GEO_CODIGO1;
    private String GEO_CODIGO2;
    private String GEO_CODIGO3;


    /*public Formulario{ //Construtor
    }*/

    public long get_ID() {
        return _ID;
    }

    public void set_ID(long _ID) {
        this._ID = _ID;
    }

    public String getPREFEITURA() {
        return PREFEITURA;
    }

    public void setPREFEITURA(String PREFEITURA) {
        this.PREFEITURA = PREFEITURA;
    }

    public String getSETOR1() {
        return SETOR1;
    }

    public void setSETOR1(String SETOR1) {
        this.SETOR1 = SETOR1;
    }

    public String getQUADRA1() {
        return QUADRA1;
    }

    public void setQUADRA1(String QUADRA1) {
        this.QUADRA1 = QUADRA1;
    }

    public String getLOTE1() {
        return LOTE1;
    }

    public void setLOTE1(String LOTE1) {
        this.LOTE1 = LOTE1;
    }

    public String getUNIDADE1() {
        return UNIDADE1;
    }

    public void setUNIDADE1(String UNIDADE1) {
        this.UNIDADE1 = UNIDADE1;
    }

    public String getDISTRITO2() {
        return DISTRITO2;
    }

    public void setDISTRITO2(String DISTRITO2) {
        this.DISTRITO2 = DISTRITO2;
    }

    public String getSETOR2() {
        return SETOR2;
    }

    public void setSETOR2(String SETOR2) {
        this.SETOR2 = SETOR2;
    }

    public String getQUADRA2() {
        return QUADRA2;
    }

    public void setQUADRA2(String QUADRA2) {
        this.QUADRA2 = QUADRA2;
    }

    public String getLOTE2() {
        return LOTE2;
    }

    public void setLOTE2(String LOTE2) {
        this.LOTE2 = LOTE2;
    }

    public String getUNIDADE2() {
        return UNIDADE2;
    }

    public void setUNIDADE2(String UNIDADE2) {
        this.UNIDADE2 = UNIDADE2;
    }

    public String getNOME_LOGADOURO() {
        return NOME_LOGADOURO;
    }

    public void setNOME_LOGADOURO(String NOME_LOGADOURO) {
        this.NOME_LOGADOURO = NOME_LOGADOURO;
    }

    public String getBAIRRO1() {
        return BAIRRO1;
    }

    public void setBAIRRO1(String BAIRRO1) {
        this.BAIRRO1 = BAIRRO1;
    }

    public String getNUMERO1() {
        return NUMERO1;
    }

    public void setNUMERO1(String NUMERO1) {
        this.NUMERO1 = NUMERO1;
    }

    public String getCOMPLEMENTO1() {
        return COMPLEMENTO1;
    }

    public void setCOMPLEMENTO1(String COMPLEMENTO1) {
        this.COMPLEMENTO1 = COMPLEMENTO1;
    }

    public String getLOTEAMENTO1() {
        return LOTEAMENTO1;
    }

    public void setLOTEAMENTO1(String LOTEAMENTO1) {
        this.LOTEAMENTO1 = LOTEAMENTO1;
    }

    public String getQUADRA_IMOVEL() {
        return QUADRA_IMOVEL;
    }

    public void setQUADRA_IMOVEL(String QUADRA_IMOVEL) {
        this.QUADRA_IMOVEL = QUADRA_IMOVEL;
    }

    public String getLOTE_IMOVEL() {
        return LOTE_IMOVEL;
    }

    public void setLOTE_IMOVEL(String LOTE_IMOVEL) {
        this.LOTE_IMOVEL = LOTE_IMOVEL;
    }

    public String getNOME_PROPRIETARIO() {
        return NOME_PROPRIETARIO;
    }

    public void setNOME_PROPRIETARIO(String NOME_PROPRIETARIO) {
        this.NOME_PROPRIETARIO = NOME_PROPRIETARIO;
    }

    public String getNOME_LOG_PROPRIETARIO() {
        return NOME_LOG_PROPRIETARIO;
    }

    public void setNOME_LOG_PROPRIETARIO(String NOME_LOG_PROPRIETARIO) {
        this.NOME_LOG_PROPRIETARIO = NOME_LOG_PROPRIETARIO;
    }

    public String getTIPO_LOG_PROPRIETARIO() {
        return TIPO_LOG_PROPRIETARIO;
    }

    public void setTIPO_LOG_PROPRIETARIO(String TIPO_LOG_PROPRIETARIO) {
        this.TIPO_LOG_PROPRIETARIO = TIPO_LOG_PROPRIETARIO;
    }

    public String getNUM_LOG_PROPRIETARIO() {
        return NUM_LOG_PROPRIETARIO;
    }

    public void setNUM_LOG_PROPRIETARIO(String NUM_LOG_PROPRIETARIO) {
        this.NUM_LOG_PROPRIETARIO = NUM_LOG_PROPRIETARIO;
    }

    public String getCOMPLEMENTO_PROPRIETARIO() {
        return COMPLEMENTO_PROPRIETARIO;
    }

    public void setCOMPLEMENTO_PROPRIETARIO(String COMPLEMENTO_PROPRIETARIO) {
        this.COMPLEMENTO_PROPRIETARIO = COMPLEMENTO_PROPRIETARIO;
    }

    public String getBAIRRO_PROPRIETARIO() {
        return BAIRRO_PROPRIETARIO;
    }

    public void setBAIRRO_PROPRIETARIO(String BAIRRO_PROPRIETARIO) {
        this.BAIRRO_PROPRIETARIO = BAIRRO_PROPRIETARIO;
    }

    public String getCEP_PROPRIETARIO() {
        return CEP_PROPRIETARIO;
    }

    public void setCEP_PROPRIETARIO(String CEP_PROPRIETARIO) {
        this.CEP_PROPRIETARIO = CEP_PROPRIETARIO;
    }

    public String getESTADO_PROPRIETARIO() {
        return ESTADO_PROPRIETARIO;
    }

    public void setESTADO_PROPRIETARIO(String ESTADO_PROPRIETARIO) {
        this.ESTADO_PROPRIETARIO = ESTADO_PROPRIETARIO;
    }

    public String getOCUPACAO_IMOVEL() {
        return OCUPACAO_IMOVEL;
    }

    public void setOCUPACAO_IMOVEL(String OCUPACAO_IMOVEL) {
        this.OCUPACAO_IMOVEL = OCUPACAO_IMOVEL;
    }

    public String getPATRIMON_IMOVEL() {
        return PATRIMON_IMOVEL;
    }

    public void setPATRIMON_IMOVEL(String PATRIMON_IMOVEL) {
        this.PATRIMON_IMOVEL = PATRIMON_IMOVEL;
    }

    public String getMUROCERCA_IMOVEL() {
        return MUROCERCA_IMOVEL;
    }

    public void setMUROCERCA_IMOVEL(String MUROCERCA_IMOVEL) {
        this.MUROCERCA_IMOVEL = MUROCERCA_IMOVEL;
    }

    public String getPASSEIO_IMOVEL() {
        return PASSEIO_IMOVEL;
    }

    public void setPASSEIO_IMOVEL(String PASSEIO_IMOVEL) {
        this.PASSEIO_IMOVEL = PASSEIO_IMOVEL;
    }

    public String getANO_REF_IMOVEL() {
        return ANO_REF_IMOVEL;
    }

    public void setANO_REF_IMOVEL(String ANO_REF_IMOVEL) {
        this.ANO_REF_IMOVEL = ANO_REF_IMOVEL;
    }

    public String getIMUNE_IPTU_IMOVEL() {
        return IMUNE_IPTU_IMOVEL;
    }

    public void setIMUNE_IPTU_IMOVEL(String IMUNE_IPTU_IMOVEL) {
        this.IMUNE_IPTU_IMOVEL = IMUNE_IPTU_IMOVEL;
    }

    public String getISENTO_TSU_IMOVEL() {
        return ISENTO_TSU_IMOVEL;
    }

    public void setISENTO_TSU_IMOVEL(String ISENTO_TSU_IMOVEL) {
        this.ISENTO_TSU_IMOVEL = ISENTO_TSU_IMOVEL;
    }

    public String getSITUACAO_TER() {
        return SITUACAO_TER;
    }

    public void setSITUACAO_TER(String SITUACAO_TER) {
        this.SITUACAO_TER = SITUACAO_TER;
    }

    public String getTOPOGRAFIA_TER() {
        return TOPOGRAFIA_TER;
    }

    public void setTOPOGRAFIA_TER(String TOPOGRAFIA_TER) {
        this.TOPOGRAFIA_TER = TOPOGRAFIA_TER;
    }

    public String getPEDOLOGIA_TER() {
        return PEDOLOGIA_TER;
    }

    public void setPEDOLOGIA_TER(String PEDOLOGIA_TER) {
        this.PEDOLOGIA_TER = PEDOLOGIA_TER;
    }

    public String getTESTADA_PRINCIPAL() {
        return TESTADA_PRINCIPAL;
    }

    public void setTESTADA_PRINCIPAL(String TESTADA_PRINCIPAL) {
        this.TESTADA_PRINCIPAL = TESTADA_PRINCIPAL;
    }

    public String getTESTADA2() {
        return TESTADA2;
    }

    public void setTESTADA2(String TESTADA2) {
        this.TESTADA2 = TESTADA2;
    }

    public String getCOD_TESTADA2() {
        return COD_TESTADA2;
    }

    public void setCOD_TESTADA2(String COD_TESTADA2) {
        this.COD_TESTADA2 = COD_TESTADA2;
    }

    public String getSEC_TESTADA2() {
        return SEC_TESTADA2;
    }

    public void setSEC_TESTADA2(String SEC_TESTADA2) {
        this.SEC_TESTADA2 = SEC_TESTADA2;
    }

    public String getTESTADA3() {
        return TESTADA3;
    }

    public void setTESTADA3(String TESTADA3) {
        this.TESTADA3 = TESTADA3;
    }

    public String getCOD_TESTADA3() {
        return COD_TESTADA3;
    }

    public void setCOD_TESTADA3(String COD_TESTADA3) {
        this.COD_TESTADA3 = COD_TESTADA3;
    }

    public String getSEC_TESTADA3() {
        return SEC_TESTADA3;
    }

    public void setSEC_TESTADA3(String SEC_TESTADA3) {
        this.SEC_TESTADA3 = SEC_TESTADA3;
    }

    public String getTESTADA4() {
        return TESTADA4;
    }

    public void setTESTADA4(String TESTADA4) {
        this.TESTADA4 = TESTADA4;
    }

    public String getCOD_TESTADA4() {
        return COD_TESTADA4;
    }

    public void setCOD_TESTADA4(String COD_TESTADA4) {
        this.COD_TESTADA4 = COD_TESTADA4;
    }

    public String getSEC_TESTADA4() {
        return SEC_TESTADA4;
    }

    public void setSEC_TESTADA4(String SEC_TESTADA4) {
        this.SEC_TESTADA4 = SEC_TESTADA4;
    }

    public String getAREA_TERRENO() {
        return AREA_TERRENO;
    }

    public void setAREA_TERRENO(String AREA_TERRENO) {
        this.AREA_TERRENO = AREA_TERRENO;
    }

    public String getAREA_CONST_UNI() {
        return AREA_CONST_UNI;
    }

    public void setAREA_CONST_UNI(String AREA_CONST_UNI) {
        this.AREA_CONST_UNI = AREA_CONST_UNI;
    }

    public String getTOTAL_UNIDADES() {
        return TOTAL_UNIDADES;
    }

    public void setTOTAL_UNIDADES(String TOTAL_UNIDADES) {
        this.TOTAL_UNIDADES = TOTAL_UNIDADES;
    }

    public String getAREA_TOTAL_CONST() {
        return AREA_TOTAL_CONST;
    }

    public void setAREA_TOTAL_CONST(String AREA_TOTAL_CONST) {
        this.AREA_TOTAL_CONST = AREA_TOTAL_CONST;
    }

    public String getTIPO_EDI() {
        return TIPO_EDI;
    }

    public void setTIPO_EDI(String TIPO_EDI) {
        this.TIPO_EDI = TIPO_EDI;
    }

    public String getALINHAMENTO_EDI() {
        return ALINHAMENTO_EDI;
    }

    public void setALINHAMENTO_EDI(String ALINHAMENTO_EDI) {
        this.ALINHAMENTO_EDI = ALINHAMENTO_EDI;
    }

    public String getPOSICAO_EDI() {
        return POSICAO_EDI;
    }

    public void setPOSICAO_EDI(String POSICAO_EDI) {
        this.POSICAO_EDI = POSICAO_EDI;
    }

    public String getLOCALIZACAO_EDI() {
        return LOCALIZACAO_EDI;
    }

    public void setLOCALIZACAO_EDI(String LOCALIZACAO_EDI) {
        this.LOCALIZACAO_EDI = LOCALIZACAO_EDI;
    }

    public String getESTRUT_EDI() {
        return ESTRUT_EDI;
    }

    public void setESTRUT_EDI(String ESTRUT_EDI) {
        this.ESTRUT_EDI = ESTRUT_EDI;
    }

    public String getCOBERTURA_EDI() {
        return COBERTURA_EDI;
    }

    public void setCOBERTURA_EDI(String COBERTURA_EDI) {
        this.COBERTURA_EDI = COBERTURA_EDI;
    }

    public String getPAREDES_EDI() {
        return PAREDES_EDI;
    }

    public void setPAREDES_EDI(String PAREDES_EDI) {
        this.PAREDES_EDI = PAREDES_EDI;
    }

    public String getFORRO_EDI() {
        return FORRO_EDI;
    }

    public void setFORRO_EDI(String FORRO_EDI) {
        this.FORRO_EDI = FORRO_EDI;
    }

    public String getELETRIC_EDI() {
        return ELETRIC_EDI;
    }

    public void setELETRIC_EDI(String ELETRIC_EDI) {
        this.ELETRIC_EDI = ELETRIC_EDI;
    }

    public String getPISO_EDI() {
        return PISO_EDI;
    }

    public void setPISO_EDI(String PISO_EDI) {
        this.PISO_EDI = PISO_EDI;
    }

    public String getPADRAO_EDI() {
        return PADRAO_EDI;
    }

    public void setPADRAO_EDI(String PADRAO_EDI) {
        this.PADRAO_EDI = PADRAO_EDI;
    }

    public String getCPF_CONJUGE() {
        return CPF_CONJUGE;
    }

    public void setCPF_CONJUGE(String CPF_CONJUGE) {
        this.CPF_CONJUGE = CPF_CONJUGE;
    }

    public String getDISTRITO1() {
        return DISTRITO1;
    }

    public void setDISTRITO1(String DISTRITO1) {
        this.DISTRITO1 = DISTRITO1;
    }

    public String getCPF_PROPRIETARIO() {
        return CPF_PROPRIETARIO;
    }

    public void setCPF_PROPRIETARIO(String CPF_PROPRIETARIO) {
        this.CPF_PROPRIETARIO = CPF_PROPRIETARIO;
    }

    public String getESTADO_CIVIL() {
        return ESTADO_CIVIL;
    }

    public void setESTADO_CIVIL(String ESTADO_CIVIL) {
        this.ESTADO_CIVIL = ESTADO_CIVIL;
    }

    public String getNOME_CONJUGE() {
        return NOME_CONJUGE;
    }

    public void setNOME_CONJUGE(String NOME_CONJUGE) {
        this.NOME_CONJUGE = NOME_CONJUGE;
    }

    public String getMUNICIPIO_PROPRIETARIO() {
        return MUNICIPIO_PROPRIETARIO;
    }

    public void setMUNICIPIO_PROPRIETARIO(String MUNICIPIO_PROPRIETARIO) {
        this.MUNICIPIO_PROPRIETARIO = MUNICIPIO_PROPRIETARIO;
    }

    public String getUTILIZA_IMOVEL() {
        return UTILIZA_IMOVEL;
    }

    public void setUTILIZA_IMOVEL(String UTILIZA_IMOVEL) {
        this.UTILIZA_IMOVEL = UTILIZA_IMOVEL;
    }

    @Override
    public String toString(){
        return "CIDADE: " + PREFEITURA;
    }

    public String getGEO_CODIGO() {
        return GEO_CODIGO;
    }

    public void setGEO_CODIGO(String GEO_CODIGO) {
        this.GEO_CODIGO = GEO_CODIGO;
    }

    public String getGEO_CODIGO1() {
        return GEO_CODIGO1;
    }

    public void setGEO_CODIGO1(String GEO_CODIGO1) {
        this.GEO_CODIGO1 = GEO_CODIGO1;
    }

    public String getGEO_CODIGO2() {
        return GEO_CODIGO2;
    }

    public void setGEO_CODIGO2(String GEO_CODIGO2) {
        this.GEO_CODIGO2 = GEO_CODIGO2;
    }

    public String getGEO_CODIGO3() {
        return GEO_CODIGO3;
    }

    public void setGEO_CODIGO3(String GEO_CODIGO3) {
        this.GEO_CODIGO3 = GEO_CODIGO3;
    }

    public String getREVEST_EDI() {
        return REVEST_EDI;
    }

    public void setREVEST_EDI(String REVEST_EDI) {
        this.REVEST_EDI = REVEST_EDI;
    }

    public String getSANIT_EDI() {
        return SANIT_EDI;
    }

    public void setSANIT_EDI(String SANIT_EDI) {
        this.SANIT_EDI = SANIT_EDI;
    }
}

package models;

/**
 * Created by Yi on 7/11/2016.
 */
public class Doctor {
    private String CODE;
    private String LAST_NAME;
    private String FIRST_NAME;
    private String USERNAME;
    private String PASSWORD;
    private String SP;
    private String PHONE;
    private String ADDRESS;


    public Doctor(){

    }


    public String getCODE(){
        return CODE;
    }

    public String getLAST_NAME(){
        return LAST_NAME;
    }

    public String getFIRST_NAME(){
        return FIRST_NAME;
    }


    public String getUSERNAME(){
        return USERNAME;
    }

    public String getPASSWORD(){
        return PASSWORD;
    }

    public String getSP(){
        return SP;
    }

    public String getPHONE(){
        return PHONE;
    }

    public String getADDRESS(){
        return  ADDRESS;
    }

    public void setCODE(String s){
        CODE=s;
    }

    public void setLAST_NAME(String s){
        LAST_NAME=s;
    }

    public void setFIRST_NAME(String s){
        FIRST_NAME=s;
    }


    public void setUSERNAME(String s){
        USERNAME=s;
    }

    public void setPASSWORD(String s){
        PASSWORD=s;
    }

    public void setSP(String s){
        SP=s;
    }
    public void setPHONE (String s){
        PHONE = s;
    }

    public void setADDRESS(String s){
        ADDRESS = s;
    }
}

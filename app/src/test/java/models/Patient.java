package models;

/**
 * Created by Yi on 7/11/2016.
 */
public class Patient {
    private String PHN;
    private String LAST_NAME;
    private String FIRST_NAME;
    private String DOB; //format in YYYY-MM-DD)
    private String USERNAME;
    private String PASSWORD;
    private String FAMDOC;
    private String PHONE;
    private String ADDRESS;


    public Patient(){

    }


    public String getPHN(){
        return PHN;
    }

    public String getLAST_NAME(){
        return LAST_NAME;
    }

    public String getFIRST_NAME(){
        return FIRST_NAME;
    }

    public String getDOB(){
        return DOB;
    }

    public String getUSERNAME(){
        return USERNAME;
    }

    public String getPASSWORD(){
        return PASSWORD;
    }

    public String getFAMDOC(){
        return FAMDOC;
    }

    public String getPHONE(){
        return PHONE;
    }

    public String getADDRESS(){
        return  ADDRESS;
    }

    public void setPHN(String s){
        PHN=s;
    }

    public void setLAST_NAME(String s){
        LAST_NAME=s;
    }

    public void setFIRST_NAME(String s){
        FIRST_NAME=s;
    }

    public void setDOB(String s){
        DOB=s;
    }

    public void setUSERNAME(String s){
        USERNAME=s;
    }

    public void setPASSWORD(String s){
        PASSWORD=s;
    }

    public void setFAMDOC(String s){
        FAMDOC=s;
    }

    public void setPHONE (String s){
        PHONE = s;
    }

    public void setADDRESS(String s){
        ADDRESS = s;
    }
}

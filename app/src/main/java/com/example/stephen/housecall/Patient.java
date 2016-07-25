package com.example.stephen.housecall;

import com.cloudant.sync.datastore.DocumentRevision;

import java.util.HashMap;
import java.util.Map;

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

    private DocumentRevision rev;

    private Patient(){}

    public Patient(String phn, String lname, String fname, String dob, String user, String pw, String doc, String phone, String addr){
        this.setPHN(phn);
        this.setLAST_NAME(lname);
        this.setFIRST_NAME(fname);
        this.setDOB(dob);
        this.setUSERNAME(user);
        this.setPASSWORD(pw);
        this.setFAMDOC(doc);
        this.setPHONE(phone);
        this.setADDRESS(addr);
    }

    public DocumentRevision getDocumentRevision(){
        return rev;
    }



    public static Patient fromRevision(DocumentRevision rev) {
        Patient p = new Patient();
        p.rev = rev;
        // this could also be done by a fancy object mapper
        Map<String, Object> map = rev.asMap();
        if(map.containsKey("phn")) {
            p.setPHN((String) map.get("phn"));
            p.setLAST_NAME((String) map.get("lname"));
            p.setFIRST_NAME((String) map.get("fname"));
            p.setDOB((String) map.get("dob"));
            p.setUSERNAME((String) map.get("user"));
            p.setFAMDOC((String) map.get("doc"));
            p.setPHONE((String) map.get("phone"));
            p.setADDRESS((String) map.get("address"));
            return p;
        }
        return null;
    }

    public Map<String, Object> asMap() {
        // this could also be done by a fancy object mapper
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("phn",PHN);
        map.put("lname", LAST_NAME);
        map.put("fname", FIRST_NAME);
        map.put("dob", DOB);
        map.put("user", USERNAME);
        map.put("doc", FAMDOC);
        map.put("phone", PHONE);
        map.put("address", ADDRESS);
        return map;
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

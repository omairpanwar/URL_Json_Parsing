package com.example.umairpanwar.url_json_parsing;

public class Json_Dm {
    private int userid;
    private int id;
    private String tittle;
    private String body;

    public Json_Dm(int userid, int id, String tittle, String body) {
        this.userid = userid;
        this.id = id;
        this.tittle = tittle;
        this.body = body;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

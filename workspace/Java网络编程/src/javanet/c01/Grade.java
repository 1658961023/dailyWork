package javanet.c01;

public class Grade {
    private byte Grade;
    private String sno;
    private String name;

    public Grade() {

    }

    public byte getGrade() {
        return Grade;
    }

    public void setGrade(byte Grade) {
        this.Grade = Grade;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String printInfo(){
        return "Ñ§ºÅ £º"+this.sno+"    ÐÕÃû£º "+this.name+"       ³É¼¨£º"+this.Grade;
    }

}

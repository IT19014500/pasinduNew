/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it19014500;

/**
 *
 * @author it19014500
 */
class User {
    private int id,tot;
    private String monD,tueD,wednesD,thurD,friD,satD,sunD,hour,min,wee,mont;
    
    public User(int id,String monD,String tueD,String wednesD,String thurD,String friD,String satD,String sunD,String hour,String min,int tot,String wee,String mont){
    
        this.id = id;
        this.monD = monD;
        this.tueD = tueD;
        this.wednesD = wednesD;
        this.thurD = thurD;
        this.friD = friD;
        this.satD = satD;
        this.sunD = sunD;
        this.hour = hour;
        this.min = min;
        this.tot = tot;
        this.wee = wee;
        this.mont = mont;
        
    }
    
    public int getid(){
        return id;
    }
    public String getmonD(){
        return monD;
    }
    public String gettueD(){
        return tueD;
    }
    public String getwednesD(){
        return wednesD;
    }
    public String getthurD(){
        return thurD;
    }
    public String getfriD(){
        return friD;
    }
    public String getsatD(){
        return satD;
    }
    public String getsunD(){
        return sunD;
    }
    public String gethour(){
        return hour;
    }
    public String getmin(){
        return min;
    }
    public int gettot(){
        return tot;
    }
    public String getwee(){
        return wee;
    }
    public String getmont(){
        return mont;
    }
}

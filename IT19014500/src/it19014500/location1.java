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
class location1 {
    private int lId,tid,session2;
    private String room,day,session,sTime,samt,eTime,eamt;
    
    public location1(int lId,String room,String day,String session,String sTime,String samt,String eTime,String eamt,int tid,int session2){
        this.lId=lId;
        this.room=room;
        this.day=day;
        this.session=session;
        this.sTime=sTime;
        this.samt=samt;
        this.eTime=eTime;
        this.eamt=eamt;
        this.tid = tid;
        this.session2=session2;
    }
    
    public int getlId(){
        return lId;
    }
    
    public String getroom(){
        return room;
    }
    
    public String getday(){
        return day;
    }
    
    public String getsession(){
        return session;
    }
    
    public String getsTime(){
        return sTime;
    }
    
    public String getSamt(){
        return samt;
    }
    
    public String geteTime(){
        return eTime;
    }
    
    public String getEamt(){
        return eamt;
    }
    
    public int getTid(){
        return tid;
    }
    
    public int getSession2(){
        return session2;
    }
}

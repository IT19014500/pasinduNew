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
class nOverlapping {
    private int noId,rid,tid,session2;
    private String room,day,session,sTime,sam,eTime,eam;
    
    public nOverlapping(int noId,int rid,String room,String day,String session,String sTime,String sam,String eTime,String eam,int tid,int session2){
        this.noId=noId;
        this.rid=rid;
        this.room=room;
        this.day=day;
        this.session=session;
        this.sTime=sTime;
        this.sam=sam;
        this.eTime=eTime;
        this.eam=eam;
        this.tid=tid;
        this.session2=session2;
    }
    
    public int getnoId(){
        return noId;
    }
    public int getrid(){
        return rid;
    }
    public String getroom1(){
        return room;
    }
    public String getday1(){
        return day;
    }
    public String getsession1(){
        return session;
    }
    public String getsTime1(){
        return sTime;
    }
    public String getSam(){
        return sam;
    }
    public String geteTime1(){
        return eTime;
    }
    public String getEam(){
        return eam;
    }
    public int getTid(){
        return tid;
    }
    public int getsession2(){
        return session2;
    }
}

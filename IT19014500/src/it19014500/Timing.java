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
class Timing {
    
    private int ntId,tid,session2;
    private String time,mainGroup,subGroup,lecturer,subCode,day,sessionId;
    
    public Timing(int ntId,String time,String mainGroup,String subGroup,String subCode,String sessionId,String lecturer,int tid,String day,int session2){
        
        this.ntId=ntId;
        this.time=time;
        this.mainGroup=mainGroup;
        this.subGroup=subGroup;
        this.subCode=subCode;
        this.sessionId=sessionId;
        this.lecturer=lecturer;
        this.tid=tid;
        this.day=day;
        this.session2=session2;
        
    }
    
    public int getntId(){
        return ntId;
    }
    
    
    
    public String gettime(){
        return time;
    }
    
    public String getmainGroup(){
        return mainGroup;
    }
    
    public String getsubGroup(){
        return subGroup;
    }
    
    public String getsubCode(){
        return subCode;
    }
    
    public String getsessionId(){
        return sessionId;
    }
    
    public String getlecturer(){
        return lecturer;
    }
    public int getTid(){
        return tid;
    }
    
    public String getDay(){
        return day;
    }
    
    public int getSession2(){
        return session2;
    }
    
}

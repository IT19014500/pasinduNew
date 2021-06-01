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
class Sess {
    private int mid,session;
    private String room,lecture1,lecture2,tag,group_id, subject_name, subject_code;
    
    
    public Sess(int mid,int session,String room,String lecture1,String lecture2,String tag,String group_id,String subject_name,String subject_code){
        this.mid=mid;
        this.session=session;
        this.room=room;
        this.lecture1=lecture1;
        this.lecture2=lecture2;
        this.tag=tag;
        this.group_id=group_id;
        this.subject_name=subject_name;
        this.subject_code=subject_code;
        
    }
    
    public int getMids(){
        return mid;
    }
    public int getSession(){
        return session;
    }
    public String getRoom(){
        return room;
    }
    public String getlect(){
        return lecture1;
    }
    public String getlect2(){
        return lecture2;
    }
    public String getTag(){
        return tag;
    }
    public String getGid(){
        return group_id;
    }
    public String getSubName(){
        return subject_name;
    }
    public String getSubCode(){
        return subject_code;
    }

}

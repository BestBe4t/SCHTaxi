package com.example.schtaxi;

public class dbobject{
    private int _IDX;											//테이블 관리를 위한 고유값
    private String Name;										//이름
    private String PH;											//전화번호
    private String Dest;										//목적지
    private String Start;										//출발지
    private String Enter_Time;									//예상 탑승시간(Date로 형변환해서 사용하기)
    private String Invi_Time;									//모집 마감시간(Date로 형변환해서 사용하기)
    private int Now_P;										    //현재 인원
    private int Entire_P;									    //모집 인원
    private String State;										//모집 상태
    private String Create_Time;									//생성 시간
    private String Cheat;										//채팅 내용
    private int is_party;										//참여 파티(0:없음, 나머지:idx)
    private int C_cnt;											//패널티
    private int D_cnt;											//현재 일자 - 마지막 접속 일자

    public int get_IDX(){
        return this._IDX;
    }
    public String getName(){
        return this.Name;
    }
    public String getPH(){
        return this.PH;
    }
    public String getDest(){
        return this.Dest;
    }
    public String getStart(){
        return this.Start;
    }
    public String getEnter_Time(){
        return this.Enter_Time;
    }
    public String getInvi_Time(){
        return this.Invi_Time;
    }
    public int getNow_P(){
        return this.Now_P;
    }
    public int getEntire_P(){
        return this.Entire_P;
    }
    public String getState(){
        return this.State;
    }
    public String getCreate_Time(){
        return this.Create_Time;
    }
    public String getCheat(){
        return this.Cheat;
    }
    public int getis_party(){
        return this.is_party;
    }
    public int getC_cnt(){
        return this.C_cnt;
    }
    public int getD_cnt(){
        return this.D_cnt;
    }

    public void set_IDX(int _IDX){
        this._IDX = _IDX;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setPH(String PH){
        this.PH = PH;
    }
    public void setDest(String Dest){
        this.Dest = Dest;
    }
    public void setStart(String Start){
        this.Start = Start;
    }
    public void setEnter_Time(String Enter_Time){
        this.Enter_Time = Enter_Time;
    }
    public void setInvi_Time(String Invi_Time){
        this.Invi_Time = Invi_Time;
    }
    public void setNow_P(int Now_P){
        this.Now_P = Now_P;
    }
    public void setEntire_P(int Entire_P){
        this.Entire_P = Entire_P;
    }
    public void setState(String State){
        this.State = State;
    }
    public void setCreate_Time(String Create_Time){
        this.Create_Time = Create_Time;
    }
    public void setCheat(String Cheat){
        this.Cheat = Cheat;
    }
    public void setis_party(int is_party){
        this.is_party = is_party;
    }
    public void setC_cnt(int C_cnt){
        this.C_cnt = C_cnt;
    }
    public void setD_cnt(int D_cnt){
        this.D_cnt = D_cnt;
    }

    public dbobject(){								//기본 초기화
        this._IDX=0;
        this.Name=null;
        this.PH=null;
        this.Dest=null;
        this.Start=null;
        this.Enter_Time=null;
        this.Invi_Time=null;
        this.Now_P=0;
        this.Entire_P=0;
        this.State=null;
        this.Create_Time=null;
        this.Cheat=null;
        this.is_party=0;
        this.C_cnt=0;
        this.D_cnt=0;
    }

    public dbobject(int _IDX, String Name, String PH, String Dest, String Start, String Enter_Time, String Invi_Time, int Entire_P){		//게시글 생성
        this._IDX = _IDX;
        this.Name = Name;
        this.PH = PH;
        this.Dest = Dest;
        this.Start = Start;
        this.Enter_Time = Enter_Time;
        this.Invi_Time = Invi_Time;
        this.Entire_P = Entire_P;
    }

    public dbobject(String Name, String PH){		//user생성
        this.Name = Name;
        this.PH = PH;
    }
}

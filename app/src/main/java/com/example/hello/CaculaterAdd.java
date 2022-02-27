package com.example.hello;

public class CaculaterAdd {

    private  int a;
    private  int b;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public CaculaterAdd() {
    }

    public   CaculaterAdd(int a, int b){
        this.a=a;
        this.b=b;
    }
    public int add(){
        return  a+b;
    }

}

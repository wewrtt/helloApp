package com.example.hello.model;

import java.io.Serializable;

public class Address implements Serializable {
    private  double DienTich,DanSo;
    private  int img;

    public Address(double dienTich, double danSo, int img) {
        DienTich = dienTich;
        DanSo = danSo;
        this.img = img;
    }

    public double getDienTich() {
        return DienTich;
    }

    public void setDienTich(double dienTich) {
        DienTich = dienTich;
    }

    public double getDanSo() {
        return DanSo;
    }

    public void setDanSo(double danSo) {
        DanSo = danSo;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

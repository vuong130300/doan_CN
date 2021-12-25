package com.mssv.hovaten_mssv.ck_hovaten_mssv.model;

public class Monan {
    private int ma;
    private String tenMonan;
    private String loaiMonan;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenMonan() {
        return tenMonan;
    }

    public void setTenMonan(String tenMonan) {
        this.tenMonan = tenMonan;
    }

    public String getLoaiMonan() {
        return loaiMonan;
    }

    public void setLoaiMonan(String loaiMonan) {
        this.loaiMonan = loaiMonan;
    }

    public Monan() {
    }

    public Monan(int ma, String tenMonan, String loaiMonan) {
        this.ma = ma;
        this.tenMonan = tenMonan;
        this.loaiMonan = loaiMonan;
    }
}

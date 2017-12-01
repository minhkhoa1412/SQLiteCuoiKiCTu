package com.nguyenchungtu.onthicuoiki.model;

import java.util.Date;

public class HocSinh {
    private int mahs;
    private String tenhs;
    private Date ngaysinh;
    private boolean gioitinh;

    public HocSinh(int mahs, String tenhs, Date ngaysinh, boolean gioitinh) {
        this.mahs = mahs;
        this.tenhs = tenhs;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
    }

    public HocSinh() {
    }

    public int getMahs() {
        return mahs;
    }

    public HocSinh setMahs(int mahs) {
        this.mahs = mahs;
        return this;
    }

    public String getTenhs() {
        return tenhs;
    }

    public HocSinh setTenhs(String tenhs) {
        this.tenhs = tenhs;
        return this;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public HocSinh setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
        return this;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public HocSinh setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
        return this;
    }

    @Override
    public String toString() {
        return "HocSinh{" +
                "mahs=" + mahs +
                ", tenhs='" + tenhs + '\'' +
                ", ngaysinh=" + ngaysinh +
                ", gioitinh=" + gioitinh +
                '}';
    }
}

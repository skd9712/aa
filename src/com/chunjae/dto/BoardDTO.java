package com.chunjae.dto;

public class BoardDTO {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bimg;
    private int readno;

    public BoardDTO() {
    }

    public BoardDTO(int bno, String btitle, String bcontent, String bimg, int readno) {
        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bimg = bimg;
        this.readno = readno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public String getBimg() {
        return bimg;
    }

    public void setBimg(String bimg) {
        this.bimg = bimg;
    }

    public int getReadno() {
        return readno;
    }

    public void setReadno(int readno) {
        this.readno = readno;
    }
}

package com.chunjae.dao;

import com.chunjae.dto.BoardDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
    public static BoardDAO dao = new BoardDAO();
    public BoardDAO(){}
    public static BoardDAO getDAO(){
        return dao;
    }

    public List<BoardDTO> getList(Connection conn) {
        StringBuilder sql = new StringBuilder();
        sql.append("   select    bno     ");
        sql.append("       ,btitle       ");
        sql.append("        ,readno      ");
        sql.append("  from  imgboard     ");
        ResultSet rs = null;
        ArrayList<BoardDTO> arr = new ArrayList<>();

        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
            rs= pstmt.executeQuery();
            while (rs.next()){
                BoardDTO dto = new BoardDTO();
                dto.setBno(rs.getInt("bno"));
                dto.setBtitle(rs.getString("btitle"));
                dto.setReadno(rs.getInt("readno"));
                arr.add(dto);
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                }catch (Exception e){}
            }
        }
        return arr;
    }

    public void insertData(Connection conn, BoardDTO dto) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("insert into imgboard(   ");
        sql.append("          btitle        ");
        sql.append("        ,bcontent       ");
        sql.append("            ,bimg       ");
        sql.append("        ,readno)        ");
        sql.append("  values(?,?,?,0)       ");

        try(PreparedStatement pstmt= conn.prepareStatement(sql.toString());) {
            pstmt.setString(1,dto.getBtitle());
            pstmt.setString(2,dto.getBcontent());
            pstmt.setString(3,dto.getBimg());
            pstmt.executeUpdate();
        }
    }

    public void addCount(Connection conn, int bno) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append(" update  imgboard   ");
        sql.append("     set       ");
        sql.append("  readno = ifnull(readno,0)+1  ");
        sql.append("  where    bno   =  ?  ");
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
            pstmt.setInt(1,bno);
            pstmt.executeUpdate();
        }
    }

    public BoardDTO detailData(Connection conn, int bno) throws SQLException{
        StringBuilder sql = new StringBuilder();
        sql.append("  select    bno      ");
        sql.append("         ,btitle     ");
        sql.append("          ,bcontent  ");
        sql.append("         ,bimg       ");
        sql.append("         ,readno     ");
        sql.append("   from    imgboard  ");
        sql.append("   where   bno =  ?  ");
        ResultSet rs = null;
        BoardDTO dto = new BoardDTO();
        try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setInt(1,bno);
            rs = pstmt.executeQuery();
            while (rs.next()){
                dto.setBno(rs.getInt("bno"));
                dto.setBtitle(rs.getString("btitle"));
                dto.setBcontent(rs.getString("bcontent"));
                dto.setBimg(rs.getString("bimg"));
                dto.setReadno(rs.getInt("readno"));
            }
        }finally {
            if(rs!=null)try {
                rs.close();
            }catch (Exception e){}
        }
        return dto;
    }
}

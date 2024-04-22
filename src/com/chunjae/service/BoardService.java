package com.chunjae.service;

import com.chunjae.comm.DBConnection;
import com.chunjae.dao.BoardDAO;
import com.chunjae.dto.BoardDTO;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardService {
    private static BoardService service= new BoardService();
    public static BoardService getService(){
        return service;
    }
    private BoardService(){}

    public List<BoardDTO> list(){
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        List<BoardDTO> arr = new ArrayList<>();
        try {
            conn=db.getConnection();
            conn.setAutoCommit(false);
            BoardDAO dao = BoardDAO.getDAO();
            arr = dao.getList(conn);
            conn.commit();
        }catch (SQLException| NamingException e){
            try {
                conn.rollback();
            }catch (SQLException e2){}
        }finally {
            if(conn!=null){
                try {conn.close();}catch (Exception e){}
            }
        }
        return arr;
    }


    public void insertData(BoardDTO dto) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        try {
            conn=db.getConnection();
            conn.setAutoCommit(false);
            BoardDAO dao = BoardDAO.getDAO();
            dao.insertData(conn,dto);
            conn.commit();
        }catch (Exception e){
            System.out.println(e);
            try {
                conn.rollback();
            }catch (Exception e2){}
        }finally {
            if(conn!=null)try {
                conn.close();
            }catch (Exception e){}
        }
    }

    public BoardDTO detailData(int bno) {
        DBConnection db = DBConnection.getInstance();
        Connection conn = null;
        BoardDAO dao = BoardDAO.getDAO();
        BoardDTO dto = new BoardDTO();
        try {
            conn = db.getConnection();
            conn.setAutoCommit(false);
            dao.addCount(conn,bno);
            dto = dao.detailData(conn, bno);
            conn.commit();
        } catch (SQLException | NamingException e) {
            System.out.println(e);
            try {
                conn.rollback();
            } catch (Exception e2) {}
        }finally {
            db.disconn(conn);
        }
        return dto;
    }
}

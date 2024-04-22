package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

import com.chunjae.dto.BoardDTO;
import com.chunjae.service.BoardService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int filesize = 1024*1024*100;
        String uploadpath =request.getServletContext().getRealPath("upload");
        MultipartRequest multi = new MultipartRequest(request,uploadpath,filesize,"utf-8",new DefaultFileRenamePolicy());

        String title = multi.getParameter("title");
        String content = multi.getContentType("content");
        /*String filename = multi.getFilesystemName("imgfile");
        filename = filename.replace("[","").replace("]","");*/
        Enumeration files = multi.getFileNames();
        String filelist = "";
        while (files.hasMoreElements()){
            String file = (String) files.nextElement();
            String filename = multi.getFilesystemName(file);
            if(filename!=null){
                filelist+=filename+";";
            }
        }
        BoardService service = BoardService.getService();
        BoardDTO dto = new BoardDTO();
        dto.setBtitle(title);
        dto.setBcontent(content);
        dto.setBimg(filelist);
//        dto.setBimg(filename);
        service.insertData(dto);

        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("list.do");
        return forward;
    }
}

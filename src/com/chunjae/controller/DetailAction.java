package com.chunjae.controller;

import com.chunjae.comm.Action;
import com.chunjae.comm.Forward;
import com.chunjae.dto.BoardDTO;
import com.chunjae.service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bno = 1;
        try {
            bno= Integer.parseInt(request.getParameter("bno"));
        }catch (NumberFormatException e){
            bno=1;
        }
        BoardService service = BoardService.getService();
        BoardDTO dto = service.detailData(bno);
        request.setAttribute("dto",dto);
        Forward forward = new Forward();
        forward.setForward(true);
        forward.setUrl("/WEB-INF/board/detail.jsp");
        return forward;
    }
}

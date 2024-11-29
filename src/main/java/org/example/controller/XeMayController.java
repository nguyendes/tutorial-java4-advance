package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entity.LoaiXe;
import org.example.entity.User;
import org.example.entity.XeMay;
import org.example.repo.impl.LoaiXeRepoImpl;
import org.example.repo.impl.XeMayRepoImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet({"/hien-thi","/xoa","/them"})
public class XeMayController extends HttpServlet {
    List<XeMay> xeMays = new ArrayList<>();
    XeMayRepoImpl xeMayRepo = new XeMayRepoImpl();
    List<LoaiXe> loaiXe = new ArrayList<>();
    LoaiXeRepoImpl loaiXeRepo = new LoaiXeRepoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.equals("/hien-thi")) {
            xeMays = xeMayRepo.findAll();
            loaiXe = loaiXeRepo.findAll();
            req.setAttribute("loaiXe", loaiXe);
            req.setAttribute("xeMays", xeMays);
            req.getRequestDispatcher("xemay.jsp").forward(req, resp);
        }
        if(uri.equals("/xoa")) {
            User user = (User) req.getSession().getAttribute("user");

            if(user.getUsername().equals("nguyentu")) {
                int id = Integer.parseInt(req.getParameter("id"));
                XeMay xeMay = xeMayRepo.findById(id);
                xeMayRepo.delete(xeMay);
                resp.sendRedirect("/hien-thi");
            }
            else if(user == null) {
                resp.sendRedirect("/hien-thi");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.equals("/them")) {
            XeMay xeMay = new XeMay();
            xeMay.setTenXe(req.getParameter("tenXe"));
            xeMay.setGiaBan(Double.parseDouble(req.getParameter("giaBan")));
            int lxm = Integer.parseInt(req.getParameter("lxm"));
            System.out.println(lxm);
            LoaiXe loaiXe= loaiXeRepo.findbyId(lxm);
            xeMay.setLoaiXe(loaiXe);
            xeMayRepo.save(xeMay);
            resp.sendRedirect("/hien-thi");
        }
    }
}

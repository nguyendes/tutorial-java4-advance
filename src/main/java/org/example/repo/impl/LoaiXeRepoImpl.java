package org.example.repo.impl;

import org.example.entity.LoaiXe;
import org.example.repo.LoaiXeRepo;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class LoaiXeRepoImpl implements LoaiXeRepo {

    @Override
    public LoaiXe findbyId(int id) {
        LoaiXe loaiXe= null;
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            loaiXe= (LoaiXe)session.get(LoaiXe.class, id);
        }catch(HibernateException e){
            e.printStackTrace();
        }return loaiXe;
    }

    @Override
    public List<LoaiXe> findAll() {
        List<LoaiXe> loaiXeList= new ArrayList<LoaiXe>();
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            Query query= session.createQuery("from LoaiXe");
            loaiXeList= (List<LoaiXe>)query.list();
        }catch(HibernateException e){
            e.printStackTrace();
        }return loaiXeList;
    }

}

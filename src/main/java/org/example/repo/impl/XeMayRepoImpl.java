package org.example.repo.impl;

import org.example.entity.XeMay;
import org.example.repo.XeMayRepo;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class XeMayRepoImpl implements XeMayRepo {
    @Override
    public List<XeMay> findAll() {
        List<XeMay> list = new ArrayList<XeMay>();
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            Query<XeMay> query = session.createQuery("from XeMay");
            list=query.list();
        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public XeMay findById(int id) {
        XeMay xeMay = null;
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            xeMay = session.get(XeMay.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }return xeMay;
    }

    @Override
    public XeMay save(XeMay xeMay) {
        Transaction tx = null;
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.save(xeMay);
            tx.commit();
        }catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }e.printStackTrace();
        }
        return xeMay;
    }

    @Override
    public void delete(XeMay xeMay) {
        Transaction tx = null;
        try(Session session= HibernateUtil.getSessionFactory().openSession()){
            tx = session.beginTransaction();
            session.delete(xeMay);
            tx.commit();
        }catch (Exception  e){
            if(tx!=null){
                tx.rollback();
            }e.printStackTrace();
        }
    }

}

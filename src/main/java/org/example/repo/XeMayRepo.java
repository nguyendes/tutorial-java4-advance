package org.example.repo;

import org.example.entity.XeMay;
import java.util.List;

public interface XeMayRepo {
    List<XeMay> findAll();
    XeMay findById(int id);
    XeMay save(XeMay xeMay);
    void delete(XeMay xeMay);
}

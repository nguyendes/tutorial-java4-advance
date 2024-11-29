package org.example.repo;

import org.example.entity.LoaiXe;

import java.util.List;

public interface LoaiXeRepo {
    LoaiXe findbyId(int id);
    List<LoaiXe> findAll();
}

package org.example.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "LoaiXe")
@NoArgsConstructor
public class LoaiXe {
    @Id
    @Column(name = "IDLoaiXe")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TenLoaiXe")
    private String tenLoaiXe;
}

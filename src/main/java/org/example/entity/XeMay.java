package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "XeMay")
@NoArgsConstructor
@AllArgsConstructor
public class XeMay {
    @Id
    @Column(name = "IDXe")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "TenXe")
    private String tenXe;

    @Column(name = "GiaBan")
    private double giaBan;

    @ManyToOne
    @JoinColumn(name= "IDLoaiXe")
    private LoaiXe loaiXe;
}

package com.perpustakaan.Perpustakaan.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Petugas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Petugas", nullable = false)
    private Integer id;

    @Column(name = "Nama_Petugas", nullable = false, length = 100)
    private String namaPetugas;

    @Column(name = "Jabatan_Petugas", nullable = false, length = 100)
    private String jabatanPetugas;

    @Column(name = "Phone_Petugas", length = 13)
    private String phonePetugas;

    @Column(name = "Alamat_Petugas", length = 100)
    private String alamatPetugas;

    public Petugas(String namaPetugas, String jabatanPetugas, String phonePetugas, String alamatPetugas) {
        this.namaPetugas = namaPetugas;
        this.jabatanPetugas = jabatanPetugas;
        this.phonePetugas = phonePetugas;
        this.alamatPetugas = alamatPetugas;
    }

    public Petugas(Integer id) {
        this.id = id;
    }
}
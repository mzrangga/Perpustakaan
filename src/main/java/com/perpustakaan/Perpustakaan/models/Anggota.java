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
public class Anggota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Anggota", nullable = false)
    private Integer id;

    @Column(name = "Kode_Anggota", nullable = false, length = 10)
    private String kodeAnggota;

    @Column(name = "Nama_Anggota", nullable = false, length = 100)
    private String namaAnggota;

    @Column(name = "Jk_Anggota", nullable = false, length = 1)
    private String jkAnggota;

    @Column(name = "Jurusan_Anggota", nullable = false, length = 2)
    private String jurusanAnggota;

    @Column(name = "Phone_Anggota", length = 13)
    private String phoneAnggota;

    @Column(name = "Alamat", length = 100)
    private String alamat;

    public Anggota(String kodeAnggota, String namaAnggota, String jkAnggota, String jurusanAnggota, String phoneAnggota, String alamat) {
        this.kodeAnggota = kodeAnggota;
        this.namaAnggota = namaAnggota;
        this.jkAnggota = jkAnggota;
        this.jurusanAnggota = jurusanAnggota;
        this.phoneAnggota = phoneAnggota;
        this.alamat = alamat;
    }

    public Anggota(Integer id) {
        this.id = id;
    }
}
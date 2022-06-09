package com.perpustakaan.Perpustakaan.models;

import com.perpustakaan.Perpustakaan.dtos.buku.BukuDto;
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
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Buku", nullable = false)
    private Integer id;

    @Column(name = "Kode_Buku", nullable = false, length = 10)
    private String kodeBuku;

    @Column(name = "Judul_Buku", nullable = false, length = 100)
    private String judulBuku;

    @Column(name = "Penulis_Buku", nullable = false, length = 50)
    private String penulisBuku;

    @Column(name = "Penerbit_Buku", length = 50)
    private String penerbitBuku;

    @Column(name = "Tahun_Penerbit", length = 4)
    private String tahunPenerbit;

    public Buku(String kodeBuku, String judulBuku, String penulisBuku, String penerbitBuku, String tahunPenerbit) {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.penulisBuku = penulisBuku;
        this.penerbitBuku = penerbitBuku;
        this.tahunPenerbit = tahunPenerbit;
    }

    public Buku(Integer id) {
        this.id = id;
    }

    public static BukuDto setData(Buku idBuku) {
        return new BukuDto(
                idBuku.getId(),
                idBuku.getKodeBuku(),
                idBuku.getJudulBuku(),
                idBuku.getPenulisBuku(),
                idBuku.getPenerbitBuku(),
                idBuku.getTahunPenerbit()
        );
    }
}
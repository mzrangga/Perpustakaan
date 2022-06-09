package com.perpustakaan.Perpustakaan.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Peminjaman", nullable = false)
    private Integer id;

    @Column(name = "tanggal_Pinjam", nullable = false)
    private LocalDate tanggalPinjam;

    @Column(name = "tanggal_Kembali", nullable = false)
    private LocalDate tanggalKembali;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_Buku", nullable = false)
    private Buku idBuku;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_Anggota", nullable = false)
    private Anggota idAnggota;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_Petugas", nullable = false)
    private Petugas idPetugas;

    public String getTanggalPinjam() {
        return String.format("%d-%d-%d", tanggalPinjam.getDayOfMonth(),
                tanggalPinjam.getMonthValue(), tanggalPinjam.getYear());
    }

    public String getTanggalKembali() {
        return String.format("%d-%d-%d", tanggalKembali.getDayOfMonth(),
                tanggalKembali.getMonthValue(), tanggalKembali.getYear());
    }

    public Peminjaman(LocalDate tanggalPinjam, LocalDate tanggalKembali, Buku idBuku, Anggota idAnggota, Petugas idPetugas) {
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.idBuku = idBuku;
        this.idAnggota = idAnggota;
        this.idPetugas = idPetugas;
    }


    public Peminjaman(Integer id) {
        this.id = id;
    }
}
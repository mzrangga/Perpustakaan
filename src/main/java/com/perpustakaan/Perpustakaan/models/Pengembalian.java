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
public class Pengembalian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Pengembalian", nullable = false)
    private Integer id;

    @Column(name = "tanggal_Pengembalian", nullable = false)
    private LocalDate tanggalPengembalian;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_Buku", nullable = false)
    private Buku idBuku;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_Anggota", nullable = false)
    private Anggota idAnggota;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Id_Petugas", nullable = false)
    private Petugas idPetugas;

}
package com.perpustakaan.Perpustakaan.dtos.peminjaman;

import com.perpustakaan.Perpustakaan.models.Anggota;
import com.perpustakaan.Perpustakaan.models.Buku;
import com.perpustakaan.Perpustakaan.models.Peminjaman;
import com.perpustakaan.Perpustakaan.models.Petugas;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PeminjamanInsertDto {
    private final LocalDate tanggalPinjam;
    private final LocalDate tanggalKembali;
    private final Buku idBuku;
    private final Anggota idAnggota;
    private final Petugas idPetugas;

    public Peminjaman convert() {
        return new Peminjaman(
                tanggalPinjam,
                tanggalKembali,
                idBuku,
                idAnggota,
                idPetugas);
    }


}

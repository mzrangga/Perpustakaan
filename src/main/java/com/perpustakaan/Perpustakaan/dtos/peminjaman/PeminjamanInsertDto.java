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
    private final Integer idBuku;
    private final Integer idAnggota;
    private final Integer idPetugas;

    public Peminjaman convert(Buku buku, Anggota anggota, Petugas petugas) {
        return new Peminjaman(
                tanggalPinjam,
                tanggalKembali,
                buku,
                anggota,
                petugas);
    }

}

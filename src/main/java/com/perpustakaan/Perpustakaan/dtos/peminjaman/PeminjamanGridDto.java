package com.perpustakaan.Perpustakaan.dtos.peminjaman;

import com.perpustakaan.Perpustakaan.models.Anggota;
import com.perpustakaan.Perpustakaan.models.Buku;
import com.perpustakaan.Perpustakaan.models.Peminjaman;
import com.perpustakaan.Perpustakaan.models.Petugas;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class PeminjamanGridDto implements Serializable {
    private final Integer id;
    private final LocalDate tanggalPinjam;
    private final LocalDate tanggalKembali;
    private final Buku idBuku;
    private final Anggota idAnggota;
    private final Petugas idPetugas;

    public static List<PeminjamanGridDto> toList(List<Peminjaman> all) {

    }
}

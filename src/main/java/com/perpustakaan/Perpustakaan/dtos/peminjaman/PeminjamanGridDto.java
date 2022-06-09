package com.perpustakaan.Perpustakaan.dtos.peminjaman;

import com.perpustakaan.Perpustakaan.dtos.anggota.AnggotaDto;
import com.perpustakaan.Perpustakaan.dtos.buku.BukuDto;
import com.perpustakaan.Perpustakaan.dtos.petugas.PetugasDto;
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
    private final String tanggalPinjam;
    private final String tanggalKembali;
    private final BukuDto idBuku;
    private final AnggotaDto idAnggota;
    private final PetugasDto idPetugas;

    public static List<PeminjamanGridDto> toList(List<Peminjaman> all) {
        return all.stream().map(PeminjamanGridDto::set).
                toList();
    }

    public static PeminjamanGridDto set(Peminjaman peminjaman) {
        return new PeminjamanGridDto(
                peminjaman.getId(),
                peminjaman.getTanggalPinjam(),
                peminjaman.getTanggalKembali(),
                Buku.setData(peminjaman.getIdBuku()),
                Anggota.setData(peminjaman.getIdAnggota()),
                Petugas.setData(peminjaman.getIdPetugas())
        );
    }

    private static BukuDto setBuku(Buku buku) {
        return new BukuDto(
                buku.getId(),
                buku.getKodeBuku() == null ? "aduh" : buku.getKodeBuku().toString(),
                buku.getJudulBuku(),
                buku.getPenulisBuku(),
                buku.getPenerbitBuku(),
                buku.getTahunPenerbit()
        );
    }

}

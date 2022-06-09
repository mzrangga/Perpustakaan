package com.perpustakaan.Perpustakaan.dtos.peminjaman;

import com.perpustakaan.Perpustakaan.exceptions.CustomException;
import com.perpustakaan.Perpustakaan.models.Anggota;
import com.perpustakaan.Perpustakaan.models.Peminjaman;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Data
public class PeminjamanDto implements Serializable {
    private final Integer id;
    private final String tanggalPinjam;
    private final String tanggalKembali;
    private final Integer idBuku;
//    private final String judulBuku;
//    private final String penulisBuku;
    private final Integer idAnggota;
    private final Integer idPetugas;

    public static PeminjamanDto setData(Peminjaman peminjaman) {
        return new PeminjamanDto(
                peminjaman.getId(),
                peminjaman.getTanggalPinjam(),
                peminjaman.getTanggalKembali(),
                peminjaman.getIdBuku().getId(),
//                peminjaman.getIdBuku().getJudul(),
//                peminjaman.getIdBuku().getPenulis(),
                peminjaman.getIdAnggota().getId(),
                peminjaman.getIdPetugas().getId()
        );
    }

    public static List<PeminjamanDto> toList(List<Peminjaman> peminjaman) {
        if (peminjaman.size() == 0) {
            throw new CustomException(
                    HttpStatus.NOT_FOUND, "Tidak Ada Data Yang Sesuai.");
        }

        Stream<PeminjamanDto> result =
                peminjaman.stream().map(PeminjamanDto::setData);
        return result.toList();
    }


    public Peminjaman convert() {
        return new Peminjaman(
                LocalDate.parse(tanggalPinjam),
                LocalDate.parse(tanggalKembali),
                new com.perpustakaan.Perpustakaan.models.Buku(idBuku),
                new com.perpustakaan.Perpustakaan.models.Anggota(idAnggota),
                new com.perpustakaan.Perpustakaan.models.Petugas(idPetugas)
        );
    }
}

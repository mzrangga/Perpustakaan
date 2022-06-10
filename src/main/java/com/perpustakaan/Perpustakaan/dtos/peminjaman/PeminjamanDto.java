package com.perpustakaan.Perpustakaan.dtos.peminjaman;

import com.perpustakaan.Perpustakaan.exceptions.CustomException;
import com.perpustakaan.Perpustakaan.models.Peminjaman;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Data
public class PeminjamanDto implements Serializable {
    private final Integer id;
    private final String tanggalPinjam;
    private final String tanggalKembali;
    private final Integer idBuku;
    private final Integer idAnggota;
    private final Integer idPetugas;

    public static PeminjamanDto setData(Peminjaman peminjaman) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new PeminjamanDto(
                peminjaman.getId(),
                peminjaman.getTanggalPinjam(),
                peminjaman.getTanggalKembali(),
                peminjaman.getIdBuku().getId(),
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

    public static List<PeminjamanDto> makeList(List<Peminjaman> peminjamans) {
        List<PeminjamanDto> result = new ArrayList<>();
        for (Peminjaman peminjaman : peminjamans) {
            result.add(setData(peminjaman));
        }
        return result;
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

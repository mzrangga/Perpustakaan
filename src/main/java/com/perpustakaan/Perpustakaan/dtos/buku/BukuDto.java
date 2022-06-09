package com.perpustakaan.Perpustakaan.dtos.buku;

import com.perpustakaan.Perpustakaan.exceptions.CustomException;
import com.perpustakaan.Perpustakaan.exceptions.EntityNotFound;
import com.perpustakaan.Perpustakaan.models.Buku;
import lombok.Data;
import org.springframework.http.HttpStatus;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.perpustakaan.Perpustakaan.dtos.anggota.AnggotaDto.setData;

@Data
public class BukuDto implements Serializable {
    private final Integer id;
    private final String kodeBuku;
    private final String judulBuku;
    private final String penulisBuku;
    private final String penerbitBuku;
    private final String tahunPenerbit;

    public static List<BukuDto> toList(List<Buku> bukus) {
        List<BukuDto> result = new ArrayList<>();
        if (bukus.size() == 0) {
            throw new EntityNotFound("Tidak Ada Data Yang Sesuai.");
        }
        Stream<BukuDto> stream = bukus.stream().map(BukuDto::setData);
        return result.stream().toList();
    }

    public static BukuDto setData(Buku buku) {
        return new BukuDto(
                buku.getId(),
                buku.getKodeBuku(),
                buku.getJudulBuku(),
                buku.getPenulisBuku(),
                buku.getPenerbitBuku(),
                buku.getTahunPenerbit()
        );
    }

    public Buku convert() {
        return new Buku(
                kodeBuku,
                judulBuku,
                penulisBuku,
                penerbitBuku,
                tahunPenerbit
        );
    }

    public static List<BukuDto> makeList(List<Buku> bukus) {
        List<BukuDto> result = new ArrayList<>();
        for (Buku buku : bukus) {
            result.add(setData(buku));
        }
        return result;
    }
}

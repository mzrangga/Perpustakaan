package com.perpustakaan.Perpustakaan.dtos.buku;

import com.perpustakaan.Perpustakaan.models.Buku;
import lombok.Data;

import java.io.Serializable;

@Data
public class BukuInsertDto implements Serializable {
    private final Integer id;
    private final String kodeBuku;
    private final String judulBuku;
    private final String penulisBuku;
    private final String penerbitBuku;
    private final String tahunPenerbit;

    public Buku convert() {
        return new Buku(
                kodeBuku,
                judulBuku,
                penulisBuku,
                penerbitBuku,
                tahunPenerbit
        );
    }
}

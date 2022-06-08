package com.perpustakaan.Perpustakaan.dtos.buku;

import lombok.Data;

@Data
public class BukuUpdateDto {
    private final Integer id;
    private final String judulBuku;
    private final String penerbitBuku;
}

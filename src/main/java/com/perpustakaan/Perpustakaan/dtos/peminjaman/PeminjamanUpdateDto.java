package com.perpustakaan.Perpustakaan.dtos.peminjaman;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PeminjamanUpdateDto implements Serializable {
    private final Integer id;
    private final LocalDate tanggalKembali;
}

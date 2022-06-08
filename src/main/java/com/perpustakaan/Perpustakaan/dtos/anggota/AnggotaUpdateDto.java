package com.perpustakaan.Perpustakaan.dtos.anggota;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnggotaUpdateDto implements Serializable {
    private final Integer id;
    private final String namaAnggota;
}

package com.perpustakaan.Perpustakaan.dtos.anggota;

import com.perpustakaan.Perpustakaan.models.Anggota;
import lombok.Data;

import java.io.Serializable;

@Data
public class AnggotaInsertDto implements Serializable {
    private final String kodeAnggota;
    private final String namaAnggota;
    private final String jkAnggota;
    private final String jurusanAnggota;
    private final String phoneAnggota;
    private final String alamat;

}

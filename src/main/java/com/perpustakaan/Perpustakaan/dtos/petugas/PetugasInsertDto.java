package com.perpustakaan.Perpustakaan.dtos.petugas;

import lombok.Data;

import java.io.Serializable;

@Data
public class PetugasInsertDto implements Serializable {
    private final String namaPetugas;
    private final String jabatanPetugas;
    private final String phonePetugas;
    private final String alamatPetugas;
}

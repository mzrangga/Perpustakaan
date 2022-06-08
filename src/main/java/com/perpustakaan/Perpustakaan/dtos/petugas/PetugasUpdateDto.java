package com.perpustakaan.Perpustakaan.dtos.petugas;

import lombok.Data;


@Data
public class PetugasUpdateDto{
    private final Integer id;
    private final String namaPetugas;
    private final String jabatanPetugas;
}

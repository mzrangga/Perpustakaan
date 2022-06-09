package com.perpustakaan.Perpustakaan.dtos.peminjaman;

import com.perpustakaan.Perpustakaan.models.Anggota;
import com.perpustakaan.Perpustakaan.models.Buku;
import com.perpustakaan.Perpustakaan.models.Petugas;
import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class PeminjamanUpdateDto implements Serializable {
    private final Integer id;
    private final LocalDate tanggalKembali;

//    public PeminjamanUpdateDto convert(){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("");
//        return new PeminjamanUpdateDto(id,tanggalKembali);
//    }
}

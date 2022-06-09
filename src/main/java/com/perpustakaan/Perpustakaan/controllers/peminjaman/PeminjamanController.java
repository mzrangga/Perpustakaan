package com.perpustakaan.Perpustakaan.controllers.peminjaman;

import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanDto;
import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanGridDto;
import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanInsertDto;
import com.perpustakaan.Perpustakaan.exceptions.RestResponse;
import com.perpustakaan.Perpustakaan.models.Buku;
import com.perpustakaan.Perpustakaan.models.Peminjaman;
import com.perpustakaan.Perpustakaan.repositories.AnggotaRepository;
import com.perpustakaan.Perpustakaan.repositories.PeminjamanRepository;
import com.perpustakaan.Perpustakaan.services.anggota.AnggotaService;
import com.perpustakaan.Perpustakaan.services.peminjaman.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {
    @Autowired
    private PeminjamanService peminjamanService;
    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @GetMapping
    public ResponseEntity<RestResponse<List<PeminjamanGridDto>>> findAllAnggota(){
        return new ResponseEntity<>(
                new RestResponse<>(peminjamanService.findAllPeminjaman(),
                        peminjamanService.findAllPeminjaman().size() + " Data Peminjaman Ditemukan",
                        "200"),
                HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<RestResponse<PeminjamanDto>> insertNewAnggota
            (@RequestBody PeminjamanInsertDto newPeminjaman){
        return new ResponseEntity(
                new RestResponse<>(peminjamanService.insertNewPeminjaman(newPeminjaman),
                        "Berhasil Menambahkan Peminjaman.",
                        "201"),
                HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RestResponse<PeminjamanDto>> updatePeminjaman
            (@RequestBody PeminjamanDto peminjamanDto){
        return new ResponseEntity(
                new RestResponse<>(peminjamanService.updatePeminjaman(peminjamanDto),
                        "Berhasil Mengubah Peminjaman.",
                        "201"),
                HttpStatus.CREATED);
    }



}

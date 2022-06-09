package com.perpustakaan.Perpustakaan.controllers.peminjaman;

import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanDto;
import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanGridDto;
import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanInsertDto;
import com.perpustakaan.Perpustakaan.dtos.peminjaman.PeminjamanUpdateDto;
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
    public ResponseEntity<RestResponse<PeminjamanGridDto>> insertNewAnggota
            (@RequestBody PeminjamanInsertDto newPeminjaman){
        return new ResponseEntity(
                new RestResponse<>(peminjamanService.insertNewPeminjaman(newPeminjaman),
                        peminjamanService.findAllPeminjaman().size() + " Data Peminjaman Ditemukan",
                        "201"),
                HttpStatus.CREATED);
    }

    @PutMapping("/update/{idPeminjaman}")
    public ResponseEntity<RestResponse<PeminjamanDto>> updatePeminjaman
            (@PathVariable Integer idPeminjaman,
             @RequestBody PeminjamanUpdateDto updatePeminjaman){
        return new ResponseEntity(
                new RestResponse<>(peminjamanService.updatePeminjaman
                        (updatePeminjaman, idPeminjaman),
                        "Berhasil Mengubah Data Peminjaman.",
                        "201"),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{idPeminjaman}")
    public ResponseEntity<RestResponse<PeminjamanDto>> deletePeminjaman
            (@PathVariable Integer idPeminjaman){
        return new ResponseEntity<>(
                new RestResponse<>(
                        peminjamanService.deletePeminjaman(idPeminjaman),
                        "Data Peminjaman Berhasil Dihapus",
                        "200"),
                HttpStatus.OK);
    }

    @GetMapping("/findById")
    public List<PeminjamanDto> getidPeminjaman(@RequestParam Integer id){
        return peminjamanService.findPeminjamanById(id);
    }
}

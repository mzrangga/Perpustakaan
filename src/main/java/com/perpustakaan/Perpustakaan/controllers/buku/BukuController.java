package com.perpustakaan.Perpustakaan.controllers.buku;

import com.perpustakaan.Perpustakaan.dtos.buku.BukuDto;
import com.perpustakaan.Perpustakaan.dtos.buku.BukuUpdateDto;
import com.perpustakaan.Perpustakaan.exceptions.RestResponse;
import com.perpustakaan.Perpustakaan.models.Buku;
import com.perpustakaan.Perpustakaan.repositories.BukuRepository;
import com.perpustakaan.Perpustakaan.services.buku.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buku")
public class BukuController {
    @Autowired
    private BukuRepository bukuRepository;
    @Autowired
    private BukuService bukuService;

    @Autowired
    public BukuController(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    @GetMapping("/findById")
    public List<BukuDto> getIdBuku(@RequestParam Integer id) {
        return bukuService.findAllAnggotaById(id);
    }

    @RequestMapping
    public ResponseEntity<RestResponse<List<Buku>>> findAllBuku() {
        return new ResponseEntity<>(
                new RestResponse<>(bukuRepository.findAll(),
                        bukuRepository.findAll().size() + " Buku Ditemukan",
                        "200"),
                HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<RestResponse<Buku>> insertNewBuku(@RequestBody Buku buku) {
        return new ResponseEntity<>(
                new RestResponse<>(bukuRepository.save(buku),
                        "Berhasil Menambahkan Buku.",
                        "201"),
                HttpStatus.CREATED);
    }


    @PutMapping("/update/{idBuku}")
    public ResponseEntity<RestResponse<BukuDto>>
    updateBuku(@PathVariable Integer idBuku,
               @RequestBody BukuUpdateDto updateBuku) {
        return new ResponseEntity<>(
                new RestResponse<>(bukuService.updateBuku(updateBuku, idBuku),
                        "Data Buku Diperbaharui",
                        "200"),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idBuku}")
    public ResponseEntity<RestResponse<BukuDto>> deleteBuku(@PathVariable Integer idBuku) {
        return new ResponseEntity<>(
                new RestResponse<>(bukuService.deleteBuku(idBuku),
                        "Data Buku Berhasil Dihapus",
                        "200"),
                HttpStatus.OK);
    }
}

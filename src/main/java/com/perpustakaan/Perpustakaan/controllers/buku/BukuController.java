package com.perpustakaan.Perpustakaan.controllers.buku;

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

    @PutMapping("/update/{id}")
    public Boolean updateBuku(@RequestBody BukuUpdateDto updateBuku,
                              @PathVariable Integer id) {
        bukuService.updateBuku(updateBuku, id);
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteBukuById(@PathVariable Integer id) {
        return bukuService.DeleteBukuById(id);
    }
}

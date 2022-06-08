package com.perpustakaan.Perpustakaan.services.buku;

import com.perpustakaan.Perpustakaan.dtos.buku.BukuDto;
import com.perpustakaan.Perpustakaan.dtos.buku.BukuUpdateDto;
import com.perpustakaan.Perpustakaan.models.Buku;
import com.perpustakaan.Perpustakaan.repositories.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BukuService {
    @Autowired
    private BukuRepository bukuRepository;

    @Autowired
    public BukuService(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    public List<BukuDto> findAllBuku() {
        return BukuDto.toList(bukuRepository.findAll());
    }

    public BukuDto insertBuku(BukuDto newBuku) {
        Buku buku = newBuku.convert();
        bukuRepository.save(buku);
        return BukuDto.setData(buku);
    }

    public Boolean updateBuku(BukuUpdateDto updateBuku,
                              Integer idBuku) {
        Buku buku = bukuRepository.findById(idBuku)
                .orElseThrow(
                        () -> new RuntimeException("Buku tidak ditemukan"));

        buku.setJudulBuku(updateBuku.getJudulBuku());
        buku.setPenerbitBuku(updateBuku.getPenerbitBuku());
        bukuRepository.save(buku);
        return true;
    }

    public boolean DeleteBukuById(Integer id){
        bukuRepository.deleteById(id);
        return true;
    }
}

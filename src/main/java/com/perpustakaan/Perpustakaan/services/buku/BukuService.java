package com.perpustakaan.Perpustakaan.services.buku;

import com.perpustakaan.Perpustakaan.dtos.buku.BukuDto;
import com.perpustakaan.Perpustakaan.dtos.buku.BukuUpdateDto;
import com.perpustakaan.Perpustakaan.exceptions.CustomException;
import com.perpustakaan.Perpustakaan.models.Buku;
import com.perpustakaan.Perpustakaan.repositories.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BukuService {
    @Autowired
    private BukuRepository bukuRepository;

    @Autowired
    public BukuService(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    public List<BukuDto> findAllBuku() {
        return bukuRepository.findAll()
                .stream().map(BukuDto::setData)
                .collect(Collectors.toList());
    }

    public BukuDto insertBuku(BukuDto newBuku) {
        Buku buku = newBuku.convert();
        bukuRepository.save(buku);
        return BukuDto.setData(buku);
    }

    public BukuDto updateBuku(BukuUpdateDto updateBuku, Integer idBuku
                              ) {
        Buku buku = bukuRepository.findById(idBuku)
                .orElseThrow(() -> new RuntimeException("Buku tidak ditemukan"));

        buku.setJudulBuku(updateBuku.getJudulBuku()
                == null ? buku.getJudulBuku() : updateBuku.getJudulBuku());

        buku.setPenerbitBuku(updateBuku.getPenerbitBuku()
                == null ? buku.getPenerbitBuku() : updateBuku.getPenerbitBuku());

        bukuRepository.save(buku);
        return BukuDto.setData(buku);
    }

    public BukuDto deleteBuku(Integer idBuku) {
        Buku buku = bukuRepository.findById(idBuku)
                .orElseThrow(() -> new
                        CustomException(HttpStatus.NOT_FOUND, "Buku tidak ditemukan"));

        bukuRepository.delete(buku);
        return BukuDto.setData(buku);
    }

    public List<BukuDto> findAllAnggotaById(Integer idBuku) {
        return BukuDto.makeList(bukuRepository.getIdBuku(idBuku));
    }
}

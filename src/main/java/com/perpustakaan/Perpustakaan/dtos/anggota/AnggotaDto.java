package com.perpustakaan.Perpustakaan.dtos.anggota;

import com.perpustakaan.Perpustakaan.exceptions.CustomException;
import com.perpustakaan.Perpustakaan.models.Anggota;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Data
public class AnggotaDto implements Serializable {
    private final Integer id;
    private final String kodeAnggota;
    private final String namaAnggota;
    private final String jkAnggota;
    private final String jurusanAnggota;
    private final String phoneAnggota;
    private final String alamat;


    public static List<AnggotaDto> toList(List<Anggota> anggotas) {
        if (anggotas.size() == 0) {
            throw new CustomException(HttpStatus.NOT_FOUND, "Tidak Ada Data Yang Sesuai.");
        }

        Stream<AnggotaDto> result =
                anggotas.stream().map(AnggotaDto::setData);
        return result.toList();
    }

    public static AnggotaDto setData(Anggota anggota) {
        return new AnggotaDto(
                anggota.getId(),
                anggota.getKodeAnggota(),
                anggota.getNamaAnggota(),
                anggota.getJkAnggota(),
                anggota.getJurusanAnggota(),
                anggota.getPhoneAnggota(),
                anggota.getAlamat()
        );
    }

    public static List<AnggotaDto> makeList(List<Anggota> anggotas) {
        List<AnggotaDto> result =new ArrayList<>();
        for (Anggota anggota : anggotas) {
            result.add(setData(anggota));
        }
        return result;
    }

    public Anggota convert() {
        return new Anggota(
                kodeAnggota,
                namaAnggota,
                jkAnggota,
                jurusanAnggota,
                phoneAnggota,
                alamat
        );
    }
}

package com.example.technical_assessment.service;

import com.example.technical_assessment.model.Karyawan;
import com.example.technical_assessment.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // untuk mengelola data Karyawan
public class KaryawanService {
    // untuk mengakses data Karyawan
    @Autowired
    private KaryawanRepository karyawanRepository;

    // Ambil semua karyawan dengan sorting berdasarkan nama
    public List<Karyawan> getAllKaryawanSortedByName() {
        return karyawanRepository.findAll(Sort.by(Sort.Direction.ASC, "namaKaryawan"));
    }

    public Optional<Karyawan> getKaryawanById(Integer id) {
        return karyawanRepository.findById(id); // untuk mengambil data Karyawan berdasarkan id
    }

    public Karyawan createKaryawan(Karyawan karyawan) {
        return karyawanRepository.save(karyawan); // untuk menyimpan data Karyawan
    }

    public Karyawan updateKaryawan(Integer id, Karyawan newKaryawan) { // untuk mengupdate data Karyawan
        return karyawanRepository.findById(id).map(karyawan -> {
            karyawan.setNamaKaryawan(newKaryawan.getNamaKaryawan());
            karyawan.setJabatanKaryawan(newKaryawan.getJabatanKaryawan());
            karyawan.setUserId(newKaryawan.getUserId());
            return karyawanRepository.save(karyawan);
        }).orElseThrow(() -> new RuntimeException("Karyawan Tidak Ditemukan"));
    }

    public void deleteKaryawan(Integer id) { // untuk menghapus data Karyawan
        karyawanRepository.deleteById(id);
    }
}
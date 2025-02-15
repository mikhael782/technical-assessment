package com.example.technical_assessment.controller;

import com.example.technical_assessment.model.Karyawan;
import com.example.technical_assessment.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController // Indikasi controller
@RequestMapping("/api/karyawan")
public class KaryawanController {
    // Autowired untuk menginisialisasi service
    @Autowired
    private KaryawanService karyawanService;

    // Ambil semua karyawan yang sudah diurutkan berdasarkan nama
    @GetMapping("/sorted")
    public List<Karyawan> getAllKaryawanSorted() {
        return karyawanService.getAllKaryawanSortedByName();
    }

    // Method untuk mendapatkan data karyawan berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Karyawan> getKaryawanById(@PathVariable Integer id){ // Mendapatkan data karyawan berdasarkan id
        Optional<Karyawan> karyawan = karyawanService.getKaryawanById(id);
        return karyawan.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Method untuk menambahkan data karyawan
    @PostMapping
    public Karyawan createKaryawan(@RequestBody Karyawan karyawan){ // Menambahkan data karyawan
        return karyawanService.createKaryawan(karyawan);
    }

    // Method untuk mengupdate data karyawan
    @PutMapping("/{id}")
    public ResponseEntity<Karyawan> updateKaryawan(@PathVariable Integer id, @RequestBody Karyawan karyawan){ // Mengupdate data karyawan
        try {
            return ResponseEntity.ok(karyawanService.updateKaryawan(id, karyawan));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Method untuk menghapus data karyawan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKaryawan(@PathVariable Integer id){ // Menghapus data karyawan
        karyawanService.deleteKaryawan(id);
        return ResponseEntity.noContent().build();
    }
}
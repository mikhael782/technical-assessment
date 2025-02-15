package com.example.technical_assessment.controller;

import com.example.technical_assessment.model.Karyawan;
import com.example.technical_assessment.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/karyawan")
public class KaryawanViewController {
    @Autowired
    private KaryawanService karyawanService; // service layer

    // GET: Tampilkan daftar karyawan
    @GetMapping
    public String getKaryawan(Model model){ // model untuk menyimpan data
        model.addAttribute("karyawans", karyawanService.getAllKaryawanSortedByName());
        model.addAttribute("karyawan", new Karyawan()); // Untuk form create
        return "karyawan";
    }

    // POST: Tambah karyawan
    @PostMapping
    public String createKaryawan(@ModelAttribute Karyawan karyawan){ // @ModelAttribute untuk mengambil data dari form
        karyawanService.createKaryawan(karyawan);
        return "redirect:/karyawan";
    }

    // GET: Form Edit Karyawan
    @GetMapping("/edit/{id}")
    public String editKaryawan(@PathVariable Integer id, Model model){ // @PathVariable untuk mengambil id dari url
        model.addAttribute("karyawan", karyawanService.getKaryawanById(id).orElse(null));
        return "edit-karyawan"; // Buat file edit-karyawan.html
    }

    // POST: Simpan Update
    @PostMapping("/update/{id}")
    public String updateKaryawan(@PathVariable Integer id, @ModelAttribute Karyawan karyawan){ // @PathVariable untuk mengambil id dari url
        karyawanService.updateKaryawan(id, karyawan);
        return "redirect:/karyawan";
    }

    // GET: Hapus karyawan
    @GetMapping("/delete/{id}")
    public String deleteKaryawan(@PathVariable Integer id){ // 
        karyawanService.deleteKaryawan(id);
        return "redirect:/karyawan";
    }
}
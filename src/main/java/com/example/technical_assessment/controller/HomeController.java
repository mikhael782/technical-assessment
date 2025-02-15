package com.example.technical_assessment.controller;

import com.example.technical_assessment.model.Karyawan;
import com.example.technical_assessment.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private KaryawanService karyawanService;

    @GetMapping("/")
    public String home(Model model){ // model untuk menampilkan data
        List<Karyawan> karyawanList = karyawanService.getAllKaryawanSortedByName();
        model.addAttribute("karyawans", karyawanList); // menambahkan data ke model
        model.addAttribute("karyawan", new Karyawan()); // Tambahkan ini untuk form tambah data
        return "karyawan";
    }
}
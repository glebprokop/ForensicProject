//package com.forensic.controller.crime.view;
//
//import com.forensic.entity.crime.Crime;
//import com.forensic.repository.crime.CrimeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/crime")
//public class CrimeViewController {
//
//    @Autowired
//    CrimeRepository repository;
//
//
//    @GetMapping("")
//    public ModelAndView showAll(){
//        List<Crime> objects = repository.findAll();
//
//        ModelAndView modelAndView = new ModelAndView().addObject("crimes", objects);
//        modelAndView.setViewName("crime");
//
//        return modelAndView;
//
//    }
//
//
//}

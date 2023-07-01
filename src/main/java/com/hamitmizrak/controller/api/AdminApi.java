package com.hamitmizrak.controller.api;

import com.hamitmizrak.business.dto.AdminDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin/api/v1")
@Log4j2
public class AdminApi {

    // http://localhost:2222/admin/api/v1/object1
    @GetMapping("object1")
    public AdminDto getRest1(){
        AdminDto adminDto=AdminDto.builder()
                .adminId(0L)
                .adminName("name")
                .adminSurname("surname")
                .build();
        return adminDto;
    }

    // http://localhost:2222/admin/api/v1/object2/1
    @GetMapping("object2/{id}")
    public AdminDto getRest2(@PathVariable Long id){
        AdminDto adminDto=AdminDto.builder()
                .adminId(id)
                .adminName("name")
                .adminSurname("surname")
                .build();
        return adminDto;
    }

    // http://localhost:2222/admin/api/v1/object3
    // http://localhost:2222/admin/api/v1/object3/1
    @GetMapping(value = {"object3","object3/{id}"})
    public AdminDto getRest3(@PathVariable(name="id",required = false) Long id){
        AdminDto adminDto = null;
        if(id==null){
            System.out.println("404");
        }else{
             adminDto=AdminDto.builder()
                    .adminId(id)
                    .adminName("name")
                    .adminSurname("surname")
                    .build();
        }
        return adminDto;
    }

    // http://localhost:2222/admin/api/v1/object4
    @GetMapping("object4")
    public List<AdminDto>  getRest4(){
        List<AdminDto> adminDtoList=new ArrayList<>();
        for (int i = 1; i <=10 ; i++) {
            AdminDto adminDto=AdminDto.builder()
                    .adminId(Long.valueOf(i))
                    .adminName("name"+i)
                    .adminSurname("surname"+i)
                    .build();
            adminDtoList.add(adminDto);
        }
        return adminDtoList;
    }


    // http://localhost:2222/admin/api/v1/object5?id=1
    @GetMapping("object5")
    public AdminDto getRest5(@RequestParam Long id){
        AdminDto adminDto=AdminDto.builder()
                .adminId(id)
                .adminName("name")
                .adminSurname("surname")
                .build();
        return adminDto;
    }


    // http://localhost:2222/admin/api/v1/object6
    // http://localhost:2222/admin/api/v1/object6?id=1
    @GetMapping("object6")
    public AdminDto getRest6(@RequestParam(name = "id",required = false,defaultValue = "44") Long id){
        AdminDto adminDto=AdminDto.builder()
                .adminId(id)
                .adminName("name")
                .adminSurname("surname")
                .build();
        return adminDto;
    }


    // http://localhost:2222/admin/api/v1/object7?id=1&name=deneme
    @GetMapping("object7")
    public AdminDto getRest7(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "name") String name
    ){
        AdminDto adminDto=AdminDto.builder()
                .adminId(id)
                .adminName(name)
                .adminSurname("surname")
                .build();
        return adminDto;
    }

    // http://localhost:2222/admin/api/v1/object8
    @GetMapping("object8")
    public ResponseEntity<AdminDto> getRest8(){
        AdminDto adminDto=AdminDto.builder()
                .adminId(0L)
                .adminName("name")
                .adminSurname("surname")
                .build();
        //return ResponseEntity.status(200).body(adminDto);
        //return ResponseEntity.status(HttpStatus.OK).body(adminDto);
       return ResponseEntity.ok(adminDto);
    }


    // http://localhost:2222/admin/api/v1/object9
    // http://localhost:2222/admin/api/v1/object9/0
    // http://localhost:2222/admin/api/v1/object9/1
    @GetMapping("object9/{id}")
    public ResponseEntity<AdminDto> getRest9(@PathVariable Long id){
        AdminDto adminDto=AdminDto.builder()
                .adminId(id)
                .adminName("name")
                .adminSurname("surname")
                .build();
        if(id==null){
            log.error("404 hatası");
            return ResponseEntity.notFound().build();
        }else if(id==0){
            log.error("400 hatası");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(adminDto);
    }
}

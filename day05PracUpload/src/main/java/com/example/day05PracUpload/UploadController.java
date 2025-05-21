package com.example.day05PracUpload;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;

@Controller
public class UploadController {

    @GetMapping("/uploadForm")
    public String uploadForm(){
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam(name="title") String title,
                         @RequestParam(name="file") MultipartFile file,
                         Model model){

        System.out.println(title);
        System.out.println(file.getOriginalFilename());
        String fileOriginName = file.getOriginalFilename();

        // 2. 겹치지 않는 이름으로 저장하기
        String uuid = UUID.randomUUID().toString();
        // 원본파일의 확장자 추출해서 확장이름 만들기

        // cuteImg.jpg, aaaaaa.png 에서 확장자만 뽑아오기
        int index = fileOriginName.lastIndexOf(".");
        String ext = fileOriginName.substring(index+1);

        //파일을 고유한 이름으로 저장하기
        String saveName = uuid+"."+ext;
        System.out.println(saveName);

        // 3. 업로드하기
        String path = "c:\\test\\";
        try {
            file.transferTo(new File(path+saveName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("fileName",saveName);
        return "uploadok";
    }

    //이미지 보여주기
    // :.* -> 확장자를 무시하지 않고 다 불러오는 문법
//    @ResponseBody
//    @GetMapping("/images/{fileName}")
//    public Resource image(@PathVariable(name="fileName") String fileName) throws MalformedURLException {
//        System.out.println(fileName);
//        return new UrlResource("file:c:\\test\\"+fileName);
//    }

    // 힌번 감싸서 보낸다 ResponseEntity로
    @GetMapping("/images/{fileName}")
    public ResponseEntity<Resource> images(@PathVariable(name="fileName") String fileName) throws MalformedURLException {
        System.out.println(fileName);

        Resource res = new UrlResource("file:c:\\test\\"+fileName);

        return ResponseEntity.ok().body(res);
    }
}

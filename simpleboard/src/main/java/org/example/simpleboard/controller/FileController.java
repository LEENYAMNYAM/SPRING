package org.example.simpleboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.simpleboard.dto.FileBoardDTO;
import org.example.simpleboard.model.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class FileController {

    private final BoardService boardService;

    //
    @GetMapping("uploadFile")
    public void uploadFile() {
    }

    @PostMapping("fileUpload")
    public String fileUpload(@RequestParam("uploads") MultipartFile[] uploads, Model model) {
//        파일 업로드 해주는 라이브러리(commons-fileupload2-jakarta) 추가(pom.xml)
//        web.xml 에서도 multipart-config 설정해줘야함
        String uploadFolder = "D:\\JMT\\Spring\\work\\uploads";
        ArrayList<String> arr = new ArrayList<>();
        for (MultipartFile multipartFile: uploads) {
            //파일 이름 중복 피하기 위해 이름 수정
            UUID uuid = UUID.randomUUID();
            String uploadFileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();
            File saveFile = new File(uploadFolder, uploadFileName);
            /* 저장위치, 파일명*/
            try {
                multipartFile.transferTo(saveFile);
                arr.add(multipartFile.getOriginalFilename());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        model.addAttribute("fileArr", arr);
        return "fileResult";
    }

    //파일 추가폼
    @GetMapping("fileInsert")
    public String fileInsert(Model model) {
        return "fileBoardInsert";
    }

    //파일 추가
    @PostMapping("fileInsert")
    public String fileInsert(FileBoardDTO fileBoardDTO, HttpServletRequest request) {

        /* 업로드 경로(/루뜨)를 가져옴*/
        String uploadPath = request.getSession().getServletContext().getRealPath("/");
        uploadPath += "/resources/images/";

        MultipartFile multipartFile = fileBoardDTO.getUpload();

        //파일 이름 중복 피하기 위해 이름 수정
        UUID uuid = UUID.randomUUID();
        String fileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();

//        File saveDir = new File(uploadPath);
//        if (!saveDir.exists()) {
//            saveDir.mkdirs(); // 디렉토리 없으면 생성
//        }

        File saveFile = new File(uploadPath, fileName);
        try {
            multipartFile.transferTo(saveFile);
            fileBoardDTO.setFileimage(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boardService.fileInsert(fileBoardDTO);
        return "fileBoardInsert";
    }
}

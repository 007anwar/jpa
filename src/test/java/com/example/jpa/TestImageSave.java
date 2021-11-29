package com.example.jpa;

import com.example.jpa.entity.Image;
import com.example.jpa.repo.ImageRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Optional;

@SpringBootTest
public class TestImageSave {

    private final ImageRepo imageRepo;

    @Autowired
    public TestImageSave(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    @Test
    public void saveImage()
    {
        Image image = new Image();
        image.setName("TraceId to graylogs.png");
        image.setId(5);
        File file=new File("C:\\Users\\anwar.mulla\\Pictures\\TraceId to graylogs.png");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte fileContent[]=new byte[(byte)file.length()];
           // FileInputStream fileInputStream1 = new FileInputStream(file);
             fileInputStream.read(fileContent);

                image.setData(fileContent);
                imageRepo.save(image);
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }


    }

    @Test
    public void getImage()
    {
        Optional<Image> byId = imageRepo.findById(1);
        byId.ifPresent(image -> {
            File file = new File("C:\\Users\\anwar.mulla\\Pictures\\" + "downloaded.png");
            try {
                FileOutputStream fos=new FileOutputStream(file);
                fos.write(image.getData());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
                 });
    }



}

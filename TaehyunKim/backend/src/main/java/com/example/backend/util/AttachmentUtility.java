package com.example.backend.util;

import com.example.backend.entity.Attachment;
import com.example.backend.entity.Post;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class AttachmentUtility {

    public Post createAttachment(List<MultipartFile> fileList, Post post) throws IOException {

        String path = "D:\\KHWeb19\\PersonalProject\\TaehyunKim\\frontend\\src\\assets\\img\\";

        if (ObjectUtils.isEmpty(fileList)) {
            return post;
        } else {
            for (MultipartFile multipartFile : fileList) {
                String uuid = UUID.randomUUID().toString();
                String newName = uuid + multipartFile.getOriginalFilename();
                String newPath = path+newName;

                Attachment attachment = new Attachment(null, newName, multipartFile.getOriginalFilename(), post);
                post.addAttachment(attachment);

                File file = new File(newPath);
                multipartFile.transferTo(file);
            }
            return post;
        }
    }

}

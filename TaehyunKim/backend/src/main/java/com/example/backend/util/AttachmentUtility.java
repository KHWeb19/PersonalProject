package com.example.backend.util;

import com.example.backend.entity.Attachment;
import com.example.backend.entity.Post;
import com.example.backend.service.AmazonS3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
@Slf4j
@RequiredArgsConstructor
public class AttachmentUtility {

    private final AmazonS3Service amazonS3Service;

    public Post createAttachment(List<MultipartFile> fileList, Post post, String strUUID) throws IOException {

        if (ObjectUtils.isEmpty(fileList)) {
            return post;
        } else

            for (MultipartFile multipartFile : fileList) {

                String randomUUID = UUID.randomUUID().toString();
                String newName = randomUUID + '_' + multipartFile.getOriginalFilename();

                String url = amazonS3Service.uploadFile(multipartFile, randomUUID);

                log.info("Returned URL: {}", url);

                post.setContent(post.getContent().replaceFirst(strUUID, "<img src=\"" + url +
                        "\" style =\"max-width:80%; display: block" +"\">"));
                System.out.println(post.getContent());

                Attachment attachment = new Attachment(null, newName, url, post);
                post.getAttachments().add(attachment);

            }
            return post;
        }

    public Post deleteAttachment (Post post){
        Collection<Attachment> attachments = post.getAttachments();
        List<Attachment> filesToRemove = new ArrayList<>();
        try {
            attachments.forEach((file) -> {
                if (!post.getContent().contains(file.getFilename())){
                    log.info(amazonS3Service.deleteFile(file.getFilename()));
                    filesToRemove.add(file);
                }
            });
            // ConcurrentModificationException
            filesToRemove.forEach((file) -> {
                post.getAttachments().remove(file);
            });
        }
        catch(Exception e){
            log.error("Error while deleting file in Bucket " + e);
        }

        return post;
    }

    public void deleteAllAttachments (Post post) {
        Collection<Attachment> attachments = post.getAttachments();

        attachments.forEach((file) -> {
            amazonS3Service.deleteFile(file.getFilename());
        });
    }
}

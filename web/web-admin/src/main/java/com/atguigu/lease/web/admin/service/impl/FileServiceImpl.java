package com.atguigu.lease.web.admin.service.impl;

import com.atguigu.lease.web.admin.service.FileService;
import io.minio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucket-name}")
    private String bucketName;

    @Value("${minio.endpoint}")
    private String endpoint;

    @Override
    public String upload(MultipartFile file) {
        try {
            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!bucketExists) {
                // Create bucket
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
            // Set access policy
            String policies = """
                    {
                                              "Statement" : [ {
                                                "Action" : "s3:GetObject",
                                                "Effect" : "Allow",
                                                "Principal" : "*",
                                                "Resource" : "arn:aws:s3:::%s/*"
                                              } ],
                                              "Version" : "2012-10-17"
                                            }
                    """.formatted(bucketName); // %s == placeholder
            minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucketName)
                    .config(policies)
                    .build());

            // Set file name
            String filename = new SimpleDateFormat("yyyyMMdd")
                    .format(new Date())
                    + "/" // Content before '/' is first level path, Sorted by date
                    + UUID.randomUUID() // Get unique id
                    + "-"
                    + file.getOriginalFilename();
            // Upload file
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(filename)
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .build());
            // Return url
            String url = endpoint + "/" + bucketName + "/" + filename;
            return url;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.taotao.service;

import com.taotao.common.pojo.PictureUploadResult;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

    PictureUploadResult uploadPicture(MultipartFile uploadFile);

}

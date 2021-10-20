package com.nero.uploadfile.mapper;

import com.nero.uploadfile.domain.UploadInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author NeRo Claudius
 * @version 1.0.0
 * @date 20/10/2021 下午3:48
 * @company https://nero-cx.ltd
 */
@Mapper
public interface LogMapper {

    int insertInfo(UploadInfo info);

    UploadInfo getUploadInfo(String uuid);

}

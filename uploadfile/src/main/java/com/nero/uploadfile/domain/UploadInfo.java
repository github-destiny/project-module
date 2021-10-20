package com.nero.uploadfile.domain;

/**
 * @author NeRo Claudius
 * @version 1.0.0
 * @date 20/10/2021 下午4:00
 * @company https://nero-cx.ltd
 */
public class UploadInfo {

    /**
     * 自增id
     */
    private int id;

    /**
     * uuid：文件标识(8位)
     */
    private String uuid;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 上传名称
     */
    private String originName;

    /**
     * 上传时间 yyyyMMdd
     */
    private String time;

    /**
     * 保存路径
     */
    private String path;

    /**
     * 文件类型
     */
    private String type;

    public UploadInfo() {
    }

    public UploadInfo(String uuid, Long size, String originName, String time, String path, String type) {
        this.uuid = uuid;
        this.size = size;
        this.originName = originName;
        this.time = time;
        this.path = path;
        this.type = type;
    }

    public UploadInfo(int id, String uuid, Long size, String originName, String time, String path, String type) {
        this.id = id;
        this.uuid = uuid;
        this.size = size;
        this.originName = originName;
        this.time = time;
        this.path = path;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UploadInfo{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", size=" + size +
                ", originName='" + originName + '\'' +
                ", time='" + time + '\'' +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

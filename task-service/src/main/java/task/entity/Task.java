package task.entity;

import lombok.Data;

@Data
public class Task {
    private long id;
    private String publisher;
    private String processor;
    private String content;
    private String attachmentUrl;
    private String createDate;
    private String updateDate;
    private String status;
}

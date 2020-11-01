package io.dashaun.jdconf2020.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Data
@RedisHash("PageView")
public class PageView implements Serializable {

    public PageView(){
        this.setCreated(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    @Id
    private String id;
    private String remoteAddr;
    private String localAddr;
    private String created;
}
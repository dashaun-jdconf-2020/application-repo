package io.dashaun.jdconf2020.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash("PageView")
public class PageView implements Serializable {
    @Id
    private String id;
    private String remoteAddr;
    private String localAddr;
    private Date created;
}
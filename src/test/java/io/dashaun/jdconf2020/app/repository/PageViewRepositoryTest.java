package io.dashaun.jdconf2020.app.repository;

import io.dashaun.jdconf2020.app.domain.PageView;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class PageViewRepositoryTest extends BaseRedisTest {

    @Autowired
    PageViewRepository pageViewRepository;

    @Test
    public void testSimplePutAndGet() {
        PageView pageView = new PageView();
        pageView.setRemoteAddr("127.0.0.1");
        pageView.setLocalAddr("127.0.0.2");
        pageView = pageViewRepository.save(pageView);

        Optional<PageView> retrieved = pageViewRepository.findById(pageView.getId());
        assertTrue(retrieved.isPresent());
    }
}

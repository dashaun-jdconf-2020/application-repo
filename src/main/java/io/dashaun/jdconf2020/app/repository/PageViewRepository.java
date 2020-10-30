package io.dashaun.jdconf2020.app.repository;

import io.dashaun.jdconf2020.app.domain.PageView;
import org.springframework.data.repository.CrudRepository;

public interface PageViewRepository extends CrudRepository<PageView, String> {
}
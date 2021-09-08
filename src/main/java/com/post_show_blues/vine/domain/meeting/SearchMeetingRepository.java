package com.post_show_blues.vine.domain.meeting;

import com.post_show_blues.vine.domain.category.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchMeetingRepository {

    Page<Object[]> searchPage(List<Long> categoryIdList, String keyword, Pageable pageable);

}

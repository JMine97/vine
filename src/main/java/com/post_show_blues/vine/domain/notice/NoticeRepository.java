package com.post_show_blues.vine.domain.notice;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query("select n from Notice n where n.memberId = :memberId")
    Page<Notice> getListPage(Pageable pageable, @Param("memberId") Long memberId);

    @Query("select count(n.id) from Notice n where n.memberId = :memberId and n.state = false")
    int getUnreadCount(Long memberId);


    //테스트 코드에 사용
    @Query("select n from Notice n where n.memberId = :memberId")
    List<Notice> getNoticeList(Long memberId);
}

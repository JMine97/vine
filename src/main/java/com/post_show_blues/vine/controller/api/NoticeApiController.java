package com.post_show_blues.vine.controller.api;

import com.post_show_blues.vine.config.auth.PrincipalDetails;
import com.post_show_blues.vine.domain.notice.Notice;
import com.post_show_blues.vine.dto.CMRespDto;
import com.post_show_blues.vine.dto.notice.NoticeDTO;
import com.post_show_blues.vine.dto.page.PageRequestDTO;
import com.post_show_blues.vine.dto.page.PageResultDTO;
import com.post_show_blues.vine.service.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequiredArgsConstructor
@RequestMapping("/members/{member-id}/notices")
@Controller
public class NoticeApiController {


    private final NoticeService noticeService;

    @GetMapping //알림목록
    public CMRespDto<?> noticeList(@PathVariable("member-id") Long memberId,
                                   @RequestBody PageRequestDTO requestDTO){

        PageResultDTO<NoticeDTO, Notice> noticeDTOList = noticeService.getNoticeList(requestDTO, memberId);

        return new CMRespDto<>(1, "알림목록 불러오기 성공", noticeDTOList);

    }

    @DeleteMapping("/{notice-id}") //알림삭제
    public CMRespDto<?> deleteNotice(@PathVariable("notice-id") Long noticeId){

        noticeService.remove(noticeId);

        return new CMRespDto<>(1, "알람 삭제 상공", null);
    }
}
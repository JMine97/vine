package com.post_show_blues.vine.dto.auth;

import com.post_show_blues.vine.domain.member.Member;
import com.post_show_blues.vine.domain.memberimg.MemberImg;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class  SignupDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String nickname;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String university;

    private MultipartFile file;

    public Member toMemberEntity() {
        return Member.builder()
                .name(name)
                .nickname(nickname)
                .password(password)
                .email(email)
                .phone(phone)
                .university(university)
                .build();
    }

    public MemberImg toMemberImgEntity(String memberImgUrl, Member member){
        return MemberImg.builder()
                .member(member)
                .fileName(memberImgUrl)
                .build();
    }
}

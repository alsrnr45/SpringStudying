package com.kh.spring.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 롬복(lombok)
 * - 필드에 대한 getter/setter, toString, 생성자 등등 어노테이션 기술만으로 자동으로 만들어주는 라이브러리
 * => 필드 수정할 때마다 내가 일일이 getter/setter, 생성자 수정할 필요가 없어짐
 * 
 * 1. Maven을 통해 lombok라이브러리 dependency로 추가
 * 2. 해당 jar파일이 위치해있는 폴더 찾아가서 .jar 파일 실행해서 설치했음
 *    내가 적용시키고자 하는 IDE 선택해서 설치
 * 3. IDE 재부팅 
 * 4. 어노테이션 기술하면서 이용하면 됨
 * @ToString : 모든 필드 하나의 문자열로 합쳐서 반환시켜주는 toString 메소드 자동생성
 * @Setter/@Getter : 모든 필드에 대한 getter/setter 메소드 자동생성
 * @NoArgsConstructor : 인자 없는 생성자(기본생성자) 자동 생성
 * @AllArgsConstructor : 모든 인자를 가진 생성자(매개변수 생성자) 자동 생성
 * @EqualsAndHashCode : equals()와 hashCode() 메소드 자동생성
 * 등등...
 * 
 * @Data : 위의 모든 것을 싹다 만들어주지만 유지/보수가 힘들기때문에 지양(매개변수 생성자만 제외)
 * 
 *
 */

// 어노테이션 쓸 때 지켜야할 점
// 필드명이 pName 이런식으로 되어있으면 setpName getpName => jsp ${ 객체.pName }
// 하지만 롬복에서는 PName 이런식으로 만들어져버려서 일치하지않음 
// 그러므로 소문자 하나로 시작하는것 하지마세용.
// 즉, 필드명 지을 때 적어도 소문자 두 개 이상으로 시작하는 이름으로 지을 것
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Member {
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String gender;
	private String age;
	private String phone;
	private String address;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	
	
}

package com.kh.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kh.spring.board.model.service.BoardService;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.model.vo.PageInfo;
import com.kh.spring.common.template.Pagination;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	/*
	 * model방식
	@RequestMapping("list.bo")
	public String selectBoardList(@RequestParam(value="currentPage", defaultValue="1") int currentPage, Model model) {
		// RequestParam 이라는 어노테이션으로 매개변수에 currentPage(페이징바 누르면 넘기는 값)라는 키 값의 값을 받는데, 
		// 기본적으로 메뉴바만 클릭하면 기본값이 null로 담기기때문에 기본값(defaultValue 로 1을 주자!)
		int listCount = bService.selectListCount();
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 10, 5);
		
		ArrayList<Board> list = bService.selectList(pi);
		
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);
		
		return "board/boardListView";
	}
	*/
	
	// mv방식
	@RequestMapping("list.bo")
	public ModelAndView selectBoardList(@RequestParam(value="currentPage", defaultValue="1") int currentPage, ModelAndView mv) {
		// RequestParam 이라는 어노테이션으로 매개변수에 currentPage(페이징바 누르면 넘기는 값)라는 키 값의 값을 받는데, 
		// 기본적으로 메뉴바만 클릭하면 기본값이 null로 담기기때문에 기본값(defaultValue 로 1을 주자!)
		int listCount = bService.selectListCount();
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, 10, 5);
		
		ArrayList<Board> list = bService.selectList(pi);
		
		/*
		mv.addObject("pi", pi);
		mv.addObject("list", list);
		mv.setViewName("board/boardListView");
		
		return mv;
		*/
		// 한줄로 줄이기
		mv.addObject("pi", pi)
		  .addObject("list", list)
		  .setViewName("board/boardListView");

		return mv;
	}
	
	@RequestMapping("enrollForm.bo")
	public String enrollForm() {
		return "board/boardEnrollForm";
	}
	
	@RequestMapping("insert.bo")
	public String insertBoard(Board b, MultipartFile upfile, HttpSession session, ModelAndView mv) {
		/*
		 * 만약 다중첨부파일 업로드 기능일 경우?
		 * <input type="file"> 요소들 다 동일한 키값으로 부여
		 * Controller쪽에서 매개변수로 MultipartFile[](배열) 키 값 로 받으면 됨
		 * 
		 * 
		 */
		
		// 곧바로 받아지지 않음 => 파일업로드 관련 라이브러리 추가 + 파일업로드 관련 클래스 '빈' 등록
		
		// 전달된 파일이 있을 경우 => 파일 수정 작업 후 서버에 업로드
		
		if(!upfile.getOriginalFilename().equals("")) { 
			/*
			// upfile에 뭐라도 담겨있을 경우
			// 파일 원본명, 수정, 경로 바꾸기 => b안에 추가로 담기
			// 파일 업로드 될 물리적 경로 지정
			String savePath = session.getServletContext().getRealPath("resources/uploadFiles/");
			
			String originName = upfile.getOriginalFilename(); // 파일의 원본명("aaa.jpg")
			
			// 수정명 이름 만들기
			String currentTime = new SimpleDateFormat("yyyyMMddHHmmsss").format(new Date());
			int ranNum = (int)(Math.random() * 90000 + 10000);
			String ext = originName.substring(originName.lastIndexOf("."));
			
			String changeName = currentTime + ranNum + ext;
			
			try {
				upfile.transferTo(new File(savePath + changeName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
		}
		*/
		
		String changeName = saveFile(upfile, session);
		
		b.setOriginName(upfile.getOriginalFilename());
		// 첨부파일 원본명 board객체에 담기
		b.setChangeName("resources/uploadFiles/" + changeName); 
		// changeName이란 필드에 경로까지 아예 담아버리겠음(resources/uploadFiles/수정된이름)
		// 첨부파일 수정명 board객체에 담기

		
		}
		
		int result = bService.insertBoard(b);
		
		if(result>0) {
			session.setAttribute("alertMsg", "성공적으로 게시글을 작성했습니다.");
			mv.addObject("b", b);
			return "redirect:list.bo";
		} else {
			mv.addObject("errorPage", "게시글 작성 실패");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("detail.bo")
	public String selectBoard(int bno, Model model) {
		int result = bService.increaseCount(bno);
		
		if(result>0) {
			Board b = bService.selectBoard(bno);
			model.addAttribute("b", b);
			return "board/boardDetailView";
		} else {
			model.addAttribute("errorMsg", "게시글 조회 실패!");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("delete.bo")
	public String deleteBoard(int bno, String filePath, HttpSession session, Model model) {
			// filePath : 첨부파일 존재하면 "경로" <-> 존재x: ""
		
		int result = bService.deleteBoard(bno);
		
		if(result>0) {
			// 성공시 첨부파일 있을경우, 서버에 업로드된 파일 찾아서 삭제
			if(!filePath.equals("")) {
				new File(session.getServletContext().getRealPath(filePath)).delete(); // 해당 파일경로를 찾아서 문자열로 반환해주는 메소드
			}
			//
			session.setAttribute("alertMsg", "성공적으로 삭제되었습니다.");
			return "redirect:list.bo";
		} else {
			model.addAttribute("errorMsg", "게시글 삭제 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("updateForm.bo")
	public String updateForm(int bno, Model model) {
		//Board b = bService.selectBoard(bno);
		//model.addAttribute("b", b);
		model.addAttribute("b", bService.selectBoard(bno));
		
		return "board/boardUpdateForm";
	}
	
	@RequestMapping("update.bo")
	public String updateBoard(Board b, MultipartFile reupfile, HttpSession session, Model model) {
		
		// 첨부파일이 존재할 경우
		if(!reupfile.getOriginalFilename().equals("")) {
			
			// 새로 넘어온 파일이 있는데, 기존에 파일이 있었을 경우 
			// => 서버에 업로드 되어있는 기존의 파일 찾아서 지우고 새로운 것 올려놓기
			if(b.getChangeName() != null) {
				new File(session.getServletContext().getRealPath(b.getChangeName())).delete();
			}
			
			// 그리고 새로 넘어온 첨부파일 서버에 업로드 시킴
			String changeName = saveFile(reupfile, session);
			b.setOriginName(reupfile.getOriginalFilename()); // reupfile의 originName을 담기
			b.setChangeName("resources/uploadFiles/" + changeName); // reupfile의 changeName을 담기
		}
		
		/*
		 * case1. 새로 첨부된 파일 x, 기존 첨부파일 x
		 * => originName : null
		 *    changeName : null
		 *    
		 * case2. 새로 첨부된 파일 x, 기존 첨부파일 o
		 * => originName : 기존 첨부파일 원본명
		 *    changeName : 기존첨부파일 수정명
		 *    
		 * case3. 새로 첨부된 파일 o, 기존 첨부파일 x
		 * => originName : 새로운 첨부파일 원본명
		 *    changeName : 새로운 첨부파일 수정명
		 *    
		 * case4. 새로 첨부된 파일 o, 기존 첨부파일 o
		 * => originName : 새로운 첨부파일 원본명
		 *    changeName : 새로운 첨부파일 수정명
		 */
		
		int result = bService.updateBoard(b);
		
		if(result>0){ //성공 => 이미 detail.bo?bno=글번호 url재요청 => 상세보기페이지
			session.setAttribute("alertMsg", "성공적으로 수정되었습니다");
			return "redirect:detail.bo?bno=" + b.getBoardNo();
		} else { // 실패 => 에러문구 담아서 => 에러페이지 포워딩
			model.addAttribute("errorMsg", "게시글 수정실패");
			return "common/errorPage";
		}	
	}
	
	// 전달받은 첨부파일 수정명 작업해서 서버에 업로드 시킨 후 수정된 파일명(서버에 업로드된 파일명)을 반환하는 메소드
	public String saveFile(MultipartFile upfile, HttpSession session) {
		
		// upfile에 뭐라도 담겨있을 경우
		// 파일 원본명, 수정, 경로 바꾸기 => b안에 추가로 담기
		// 파일 업로드 될 물리적 경로 지정
		String savePath = session.getServletContext().getRealPath("resources/uploadFiles/");
		
		String originName = upfile.getOriginalFilename(); // 파일의 원본명("aaa.jpg")
		
		// 수정명 이름 만들기
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmsss").format(new Date());
		int ranNum = (int)(Math.random() * 90000 + 10000);
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime + ranNum + ext;
		
		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return changeName;
	}
	
	@ResponseBody
	@RequestMapping(value="rlist.bo", produces="application/json; charset=utf-8")
	public String ajaxSelectReplyList(int bno) {
		//ArrayList<Reply> list = bService.selectReplyList(bno);
		//return new Gson().toJson(list); 
		// 줄이기
		return new Gson().toJson(bService.selectReplyList(bno)); 
	}
	
	@ResponseBody
	@RequestMapping("rinsert.bo")
	public String ajaxInsertReply(Reply r) {
		int result = bService.insertReply(r);
		
		if(result>0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
}

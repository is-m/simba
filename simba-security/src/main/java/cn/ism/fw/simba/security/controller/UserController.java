package cn.ism.fw.simba.security.controller;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ism.fw.simba.base.PageVO;
import cn.ism.fw.simba.base.PagedResult;
import cn.ism.fw.simba.security.UserVO;
import cn.ism.fw.simba.security.service.IUserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Inject
	private IUserService userService;

	@GetMapping
	public ResponseEntity<?> find(UserVO userVO){
		if(!userVO.isSetId()){
			return ResponseEntity.badRequest().body("no set id");
		}
		UserVO user = userService.findObj(userVO.getId());
		return ResponseEntity.ok(user);
		
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody UserVO userVO){
		int n = userService.createObj(userVO); 
		return ResponseEntity.ok(n);
	}
	
	@GetMapping("/page/{pageSize}/{curPage}")
	public ResponseEntity<?> find(PageVO page,UserVO vo){ 
		PagedResult<UserVO> pageData = userService.findPagedList(new PageVO(), new UserVO());
		return ResponseEntity.ok(pageData);
		
	}
}

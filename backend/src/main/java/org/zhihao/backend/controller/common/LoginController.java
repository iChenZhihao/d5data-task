package org.zhihao.backend.controller.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zhihao.backend.entity.LoginRespVO;
import org.zhihao.backend.utils.JwtUtil;

/**
 * @Author ChenZhihao
 * @Date 2024/9/26 09:27
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @GetMapping("userLogin")
    public LoginRespVO userLogin(@RequestParam("username") String username,
                                 @RequestParam("password") String password) {
        if ("test".equals(username) && "123456".equals(password)) {
            LoginRespVO loginRespVO = new LoginRespVO();
            String jwt = JwtUtil.createJWT("1");
            String refreshJWT = JwtUtil.createRefreshJWT("1");
            loginRespVO.setToken(jwt);
            loginRespVO.setRefreshToken(refreshJWT);
            return loginRespVO;
        } else {
            throw new RuntimeException("登录失败");
        }
    }


}

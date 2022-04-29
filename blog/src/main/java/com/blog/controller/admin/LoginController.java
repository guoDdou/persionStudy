package com.blog.controller.admin;

import com.blog.pojo.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String loginPage(){
        return "admin/login";
    }

    //登录界面需要进行验证并给出适当的弹窗
    /* 1、输入用户名和密码但是信息不对提示：用户名或密码错误
    *  2、用户名和密码都不输入提示：用户名和密码为空，请重新输入
    *  3、输入用户名但不输入密码提示：密码不能为空
    *  4、输入密码不输入用户名提示：用户名不能为空
    * */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes){
        if("".equals(username) && "".equals(password)){
            attributes.addFlashAttribute("msg", "用户名和密码为空，请重新输入！");
            return "redirect:/admin";
        }
        else  if("".equals(username) && !"".equals(password)){
            attributes.addFlashAttribute("msg", "用户名不能为空！");
            return "redirect:/admin";
        }
        else  if(!"".equals(username) && "".equals(password)){
            attributes.addFlashAttribute("msg", "密码不能为空！");
            return "redirect:/admin";
        }
        else {
        User user = userService.checkUser(username, password);
        if(user != null){
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("msg", "用户名或密码错误");
            return "redirect:/admin";
        }
    }
        }
//退出当前登录
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}

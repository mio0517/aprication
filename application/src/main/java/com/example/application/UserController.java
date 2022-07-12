package com.example.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
  @Autowired
  private UserRepository userRepository; 
  @RequestMapping("/user/list")
  public String List(Model m) {
   
    //List<UserEntity> list = userRepository.findAll();

    m.addAttribute("userList", userRepository.findAllOrderByidDesc());

    return "/user/list";
  }

  @RequestMapping("/user/{id}") 
  public String show(Model m,
  @PathVariable int id) {

    UserEntity user = userRepository.findById(id).get();
    m.addAttribute("userData", user);

    return "user/show";

  }

  @RequestMapping("/user/new")
  public String usernewString(Model m) {
    m.addAttribute("userData", new UserEntity());

    return "/user/new";
  }

  @PostMapping("/user/create")
  public String usercreate(Model m,
    @RequestParam("name") String name,
    @RequestParam("address") String address,
    @RequestParam("email") String email
  ) {
    m.addAttribute("name", name);
    m.addAttribute("address", address);
    m.addAttribute("email", email);

  UserEntity user = new UserEntity();
  user.setName(name);
  user.setAddress(address);
  user.setEmail(email);

  userRepository.save(user);

  return "redirect:/user/list";  //redirect切り替える　指定したurlに
}

  @RequestMapping("/user/{id}/delete")
  public String delete(Model m,
    @PathVariable Integer id
    ) {
      userRepository.deleteById(id);

      return "redirect:/user/list";
    }

  @RequestMapping("/user/{id}/edit")
  public String edit(Model m,
  @PathVariable Integer id
  ) {
    UserEntity u = userRepository.findById(id).get();
    m.addAttribute("userData", u);

    return "user/edit";

  }

  @RequestMapping("/user/{id}/update")
  public String updaate(Model m,
  @PathVariable Integer id,
  @ModelAttribute UserEntity user
  ) {
  
  m.addAttribute("userData", user);
  

  userRepository.save(user);

  return "redirect:/user/list";


  }
}

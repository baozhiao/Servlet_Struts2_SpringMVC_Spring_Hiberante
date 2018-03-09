package com.byxy.student.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.byxy.student.entity.Student;
import com.byxy.student.service.StudentService;
import com.byxy.student.util.Pager;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("springmvc/std")
public class StudentController {

	@Resource
	StudentService studentService;

	/*
	 * 由于springmvc不支持person.pid=xxxx person.name=xxx等传值操作，需要加入以下设置 @InitBinder
	 * & @ModelAttribute，而Struts2则完美支持。Springmvc支持pid=xxx&name=xxx传值，以对象接收，
	 * 而Struts2需要使用驱动模型（ModelDriven）才能支持
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("person.");
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(String curPage, String pageCount, Model model) {
		Pager<Student> pager = studentService.getPage(curPage, pageCount);
		model.addAttribute("pager", pager);
		return "person/list";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		return "person/add";
	}

	@RequestMapping(value = "File", method = RequestMethod.GET)
	public String File() {
		return "person/upFile";
	}

	@RequestMapping(value = "down", method = RequestMethod.GET)
	public String down() {
		return "person/downFile";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student person) {
		studentService.addPerson(person);
		System.out.println("*********************************************************************************************************");
		return "redirect:list";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(String pid, Model model) {
		Student student = studentService.getById(pid);
		model.addAttribute("person", student);
		return "person/update";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@ModelAttribute Student person) {
		studentService.updatePerson(person);
		return "redirect:list";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(String pid) {
		studentService.deleteById(pid);
		return "redirect:list";
	}

	/*////上传文件会自动绑定到MultipartFile中
	@RequestMapping(value = "upFile", method = RequestMethod.POST)
	public String upFile(@RequestParam(value = "file",required = false)MultipartFile file, HttpServletRequest request,Model model) throws IOException {
		System.out.println("----------------------------------------------------------------------");



		//判断文件是否为空
		//如果不等于空
		if(!file.isEmpty())
		{
			//设置存储文件的路径   获取 服务器中当前WebRoot的物理路径
			String path = request.getSession().getServletContext().getRealPath("file");
			System.out.println(path);


			//获取文件名字
			String fileName = new Date().getTime()+file.getOriginalFilename();

			//创建file   参数是 路径和名字
			File Newfile = new File(path,fileName);
			System.out.println(Newfile.getPath());

			//判断目录是否存在  不存在则创建目录
			if(!Newfile.getParentFile().exists()){
				Newfile.getParentFile().mkdir();
			}

			//将文件上传到目录
			file.transferTo(Newfile);
			return "person/upFile";

		}else{
			model.addAttribute("error",1);
			return "person/upFile";
		}

	}*/
}

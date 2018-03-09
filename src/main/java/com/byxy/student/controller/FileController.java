package com.byxy.student.controller;

import com.byxy.student.entity.Student;
import com.byxy.student.service.FileService;
import com.byxy.student.service.LoginService;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("springmvc/file")
public class FileController {

	@Resource
	private FileService fileService;

	@RequestMapping(value = "upFile", method = RequestMethod.POST)
	public String upFile(@RequestParam(value = "file",required = false)MultipartFile file,
						 HttpServletRequest request, Model model) throws IOException {
		System.out.println("----------------------------------------------------------------------");

		//判断文件是否为空
		//如果不等于空
		if (!file.isEmpty()) {
			//设置存储文件的路径   获取 服务器中当前WebRoot的物理路径
			String path = request.getSession().getServletContext().getRealPath("file");
			System.out.println(path);


			//获取文件名字
			String fileName = new Date().getTime() + file.getOriginalFilename();

			//创建file   参数是 路径和名字
			File Newfile = new File(path, fileName);
			System.out.println(Newfile.getPath());

			//判断目录是否存在  不存在则创建目录
			if (!Newfile.getParentFile().exists()) {
				Newfile.getParentFile().mkdir();
			}

			//将文件上传到目录
			file.transferTo(Newfile);

			com.byxy.student.entity.File  fileEntity = new com.byxy.student.entity.File();

			fileEntity.setFile_Name(fileName);
			fileEntity.setFile_path(path);

			fileService.addFile(fileEntity);

			return "person/upFile";

		} else {
			model.addAttribute("error", 1);
			return "person/upFile";
		}
	}

	@RequestMapping(value = "FileList", method = RequestMethod.GET)
	public String FileList(Model model){

		List<com.byxy.student.entity.File> list = fileService.findFileList();

		model.addAttribute("list",list);

		return "person/downFile";
	}

	//下载文件
	@RequestMapping(value = "downLoadFile")
	public ResponseEntity<byte[]> download(int id) throws IOException {

		System.out.println(id);

		com.byxy.student.entity.File entityFile = fileService.findFileById(id);
		System.out.println(entityFile);

		File file = new File(entityFile.getFile_path()+"/"+entityFile.getFile_Name());

		HttpHeaders headers = new HttpHeaders();

		String fileName = new String(entityFile.getFile_Name().getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题

		headers.setContentDispositionFormData("attachment", fileName);

		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.CREATED);
	}

}

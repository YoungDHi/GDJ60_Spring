package com.iu.s1.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	//file을 HDD에 저장
	public String fileSave(MultipartFile multipartFile, String realPath) throws Exception {
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		String name = UUID.randomUUID().toString();
		
		name = name+"_"+multipartFile.getOriginalFilename();
		System.out.println(name);
		
		file = new File(file, name);
		
		multipartFile.transferTo(file);
		
		 return name;
	}
	
	//file을 HDD에서 삭제
	public boolean fileDelete(String path, String fileName) throws Exception{
		File file = new File(path, fileName);
		
		return file.delete();
		
	}
	

}

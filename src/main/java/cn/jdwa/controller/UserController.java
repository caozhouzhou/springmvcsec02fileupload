package cn.jdwa.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Created by czz on 2019/9/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testFileUpload01")
    public String testFileUpload01(HttpServletRequest request) throws Exception{
        System.out.println("testFileUpload01 ... ... ...");
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        System.out.println("path:"+path);
        File file = new File(path);
        if (!file.exists()) file.mkdirs();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item:items){
            if (!item.isFormField()){
                String fileName = item.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" +fileName;
                System.out.println("fileName:"+fileName);
                item.write(new File(path,fileName));
                item.delete();
            }
        }
        return "success";
    }


    /**
     * springMVC文件上传
     * @param upload 需要跟表单中的name属性值保持一致
     */
    @RequestMapping("/testFileUpload02")
    public String testFileUpload02(HttpServletRequest request, MultipartFile upload) throws Exception{
        System.out.println("spring mvc testFileUpload02  ... ... ...");
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        System.out.println("path:"+path);
        File file = new File(path);
        if (!file.exists()) file.mkdirs();
        String fileName = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" +fileName;
        System.out.println("fileName:"+fileName);
        upload.transferTo(new File(path,fileName));
        return "success";
    }
}

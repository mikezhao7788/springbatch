package com.manulife.guli.controller;

import com.manulife.guli.config.Resource;
import com.manulife.guli.entity.TUser;
import com.manulife.guli.entity.User;
import com.manulife.guli.pojo.ResultBean;
import com.manulife.guli.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.validation.Valid;
import java.io.IOException;

@Slf4j
@RequestMapping("/file")
@RestController
public class HelloWorld {

    @Autowired
    private IUserService userService;

    @Value("${resource.imageServer}")
    private String iamgeServer;
    @Autowired
    Resource resource;
    private static final Logger logger =  LogManager.getLogger(HelloWorld.class);
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        if(file==null)
        {
            return "上传文件不能为空!!";
        }
        return "文件存放路径为" ;
    }

    @RequestMapping(value  =  "/admin/uploadFile",  method  =  RequestMethod.POST)
    @ResponseBody
    public  Object  uploadResource(MultipartHttpServletRequest request)  throws  Exception  {
        //相当于获取form表单隐藏域的参数
        String  resourceId  =  request.getParameter("resource_id");
        //获取form表单要上传的文件
        MultipartFile  file  =  request.getFile("file");
        //获取文件的文件名字(后面要用到)
        String  filename  =  file.getOriginalFilename();
        //这个url是要上传到另一个服务器上接口
        String  url  =  String.format("http://localhost:8082//batch/v1/file/getUpload");
        //创建HttpClients实体类
        CloseableHttpClient aDefault  =  HttpClients.createDefault();
        Object  object  =  null;
        try  {
            HttpPost httpPost  =  new  HttpPost(url);
            MultipartEntityBuilder  builder  =  MultipartEntityBuilder.create();
             //使用这个，另一个服务就可以接收到这个file文件了
            builder.addBinaryBody("file",file.getBytes(), ContentType.create("multipart/form-data"),filename);
            StringBody stringBody  =  new  StringBody(resourceId,ContentType.MULTIPART_FORM_DATA);
            builder.addPart("resource_id",stringBody);
            HttpEntity entity  =  builder.build();
            httpPost.setEntity( entity);

            ResponseHandler<Object> rh  =  new  ResponseHandler<Object>()  {
                @Override
                public Object handleResponse(org.apache.http.HttpResponse httpResponse) throws ClientProtocolException, IOException {
                    HttpEntity  entity  =  httpResponse.getEntity();
                    String  result  =  EntityUtils.toString( entity,  "UTF-8");
                    return  result;
                }
            };
         //获取到执行结果集
        object=  aDefault.execute(httpPost,rh);
        }  catch  (Exception  e)  {
            logger.error("出错啦:{}",e);
        }  finally  {
            aDefault.close();
        }
        return  object;
    }

    /***
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public TUser getById(@PathVariable("id") Integer id)
    {
        System.out.println("id"+id);
     //   return new User(id,"java2018",new Date());
        return  userService.getById(id);
    }

/*    @PostMapping("add")
    public ResultBean add(@Valid User user, BindingResult bindingResult ) throws JsonProcessingException {
        if(bindingResult.hasErrors())
        {
            Map<String,String> result=new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String field = fieldError.getField();
                String message = fieldError.getDefaultMessage();
                log.error("{}:{}",field,message);
                result.put(field,message);
            }
            ObjectMapper objectMapper=new  ObjectMapper();
            String value = objectMapper.writeValueAsString(result);
            return  new ResultBean("faild",value);
        }
        System.out.println(user.getEntityDate());
        return new ResultBean("ok","ok11221"+resource.getImageServer());
    }*/

    @PostMapping("add")
    public ResultBean add(@Valid User user ) {

        System.out.println(user.getEntityDate());
        return new ResultBean("ok","ok11221"+resource.getImageServer());
    }
}

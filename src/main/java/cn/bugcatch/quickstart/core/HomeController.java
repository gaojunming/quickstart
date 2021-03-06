package cn.bugcatch.quickstart.core;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.bugcatch.quickstart.user.entity.MyEntity;
import cn.bugcatch.quickstart.user.pojo.XmlTestPojo;

@Controller//Rest
public class HomeController {
	@Autowired
	private MyEntity me;
	@Value("${name}")
	private String name;
	@RequestMapping("/xmlTest")
	@ResponseBody
	XmlTestPojo xmlTest() {
		System.err.println(name);
        return new XmlTestPojo();
    }
	@RequestMapping("/")
    String index() {
		System.err.println("index");
		me.query();
		return "index";
    }
	@RequestMapping("/test")
    String test() {
        return "test";
    }
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view() {
		return "test2";
	}
	@RequestMapping(value="/verify",method=RequestMethod.GET)
    String verify(@RequestParam Map<String,Object> params) {
		System.out.println();
		System.err.println(params);
		System.out.println();
		String signature= params.get("signature").toString();//微信加密签名
		String timestamp= params.get("timestamp").toString();//时间戳
		String nonce= params.get("nonce").toString();//随机数
		String echostr= params.get("echostr").toString();//随机字符串
		StringBuilder res= new StringBuilder();
    	String[] arr = new String[] { "gaojunming", timestamp, nonce};  
    	Arrays.sort(arr);//字典顺序排序
    	for (int i = 0; i < arr.length; i++) {
            res.append(arr[i]);
        }
    	String r= res.toString();
    	String sign = DigestUtils.sha1Hex(r);//对排序结果进行sha1加密
    	if(null!= sign && sign.equals(signature)) {
    		return echostr;//校验成功原样返回随机字符串
    	}else {
    		return "failed";
    	}
    }
}

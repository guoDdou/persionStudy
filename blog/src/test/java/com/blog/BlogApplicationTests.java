package com.blog;

import com.blog.dao.BlogDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.expression.Ids;
import org.thymeleaf.expression.Strings;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

@SpringBootTest
class BlogApplicationTests {

	@Test
	void contextLoads() {
		List list = new ArrayList();
		list.add("123456");
		list.add("5556456");
		Map map
				 = new HashMap();
		map.put("ids",list);
		List<String> ids = (List<String>) map.get("ids");
		for (String id: ids )
		System.out.println(id);

	}

}

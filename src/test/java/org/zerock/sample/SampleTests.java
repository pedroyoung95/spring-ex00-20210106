package org.zerock.sample;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	
	@Setter(onMethod_ = {@Autowired})
	//어노테이션은 여러 개 붙일 수 있으므로, 배열형태로 작성가능
	private Restaurant restaurant;
	
	@Autowired
	private ApplicationContext context;
	//web.xml에 있는 ContextLoaderListener가 root-context.xml을 잘 매칭해주기 때문에
	//실제 작업에서는 ApplicationContext와 ContextConfiguration어노테이션 사용할 필요X
	//의존성 주입을 어떻게 할지 설명서 역할을 하는 root-context만 잘 작성하면 됨
	
	public void testExist() {
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("-----------------------------");
		log.info(restaurant.getChef());
	}
	
	@Test
	public void testExist2() {
		Chef c1 = (Chef) context.getBean("chef");
		Restaurant r1 = (Restaurant) context.getBean("restaurant");
		
		//assert~ : log가 갖고있는 메소드들
		assertNotNull(r1.getChef());
		assertEquals(c1, r1.getChef());
		
		log.info("------");
		assertNotNull(context);
		assertNotNull(context.getBean("chef"));
		assertNotNull(context.getBean("restaurant"));
		
	}
}

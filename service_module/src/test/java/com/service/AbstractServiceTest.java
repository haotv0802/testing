package com.service;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:service-context-test.xml" })
public abstract class AbstractServiceTest {
	protected final Logger LOGGER = Logger.getLogger(this.getClass().getName());

	@Before
	public abstract void startUp();

	@After
	public abstract void tearDown();

}
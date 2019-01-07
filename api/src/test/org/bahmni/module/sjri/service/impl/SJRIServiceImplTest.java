package org.bahmni.module.sjri.service.impl;

import org.bahmni.module.sjri.service.SJRIService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;


@RunWith(MockitoJUnitRunner.class)
public class SJRIServiceImplTest {


  private SJRIService sjriService;

  @Before
  public void setUp() {
    sjriService = new SJRIServiceImpl();
  }


  @Test
  @Ignore
  public void shouldTestSomething() throws ParseException {

  }



}

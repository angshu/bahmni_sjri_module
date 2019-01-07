package org.bahmni.module.sjri.web.controller;


import org.bahmni.module.sjri.service.SJRIService;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/rest/" + RestConstants.VERSION_1 + "/sjri")
public class SJRIController extends BaseRestController {

  private SJRIService SJRIService;

  @Autowired
  public SJRIController(SJRIService SJRIService) {
      this.SJRIService = SJRIService;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/info", produces = "application/json")
  @ResponseBody
  public Map getDetails() throws ParseException {
      Map<String, Object> infoMap = new HashMap<>();
      infoMap.put("moduleName", "SJRI Custom Module");
      infoMap.put("author", "Angshu");
      return infoMap;
  }

}

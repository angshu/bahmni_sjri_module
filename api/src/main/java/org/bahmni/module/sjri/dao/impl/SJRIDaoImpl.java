package org.bahmni.module.sjri.dao.impl;

import org.bahmni.module.sjri.dao.SJRIDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SJRIDaoImpl implements SJRIDao {

  private SessionFactory sessionFactory;

  @Autowired
  public SJRIDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }



}

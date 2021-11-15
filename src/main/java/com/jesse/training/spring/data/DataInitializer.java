package com.jesse.training.spring.data;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
  private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

  @Autowired
  private ApplicationContext appContext;

  @PostConstruct
  public void onInit() throws Exception {
    logger.info("onInit()");
    DataDB.initDataDB(appContext);
    DataDB.getInstance().getData(GroupData.class).initialize(appContext);
    DataDB.getInstance().getData(AccountData.class).initialize(appContext);
  }
}

package com.excilys.formation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IngredientControllerException extends Exception{

  private static final long serialVersionUID = 5703395369156147268L;
  private static final Logger logger = LoggerFactory.getLogger(IngredientControllerException.class);

  public IngredientControllerException() {
    logger.warn(this.getMessage());
  }
  
  public IngredientControllerException(String arg0) {
    super(arg0);
  }

  public IngredientControllerException(Throwable arg0) {
    super(arg0);
  }

  public IngredientControllerException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public IngredientControllerException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
    super(arg0, arg1, arg2, arg3);
  }
}

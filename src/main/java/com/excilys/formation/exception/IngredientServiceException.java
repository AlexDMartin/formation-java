package com.excilys.formation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IngredientServiceException extends Exception {

  private static final long serialVersionUID = -4359795178170769698L;
  private static final Logger logger = LoggerFactory.getLogger(IngredientServiceException.class);

  public IngredientServiceException() {
    logger.warn(this.getMessage());
  }
  
  public IngredientServiceException(String arg0) {
    super(arg0);
  }

  public IngredientServiceException(Throwable arg0) {
    super(arg0);
  }

  public IngredientServiceException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public IngredientServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
    super(arg0, arg1, arg2, arg3);
  }

}

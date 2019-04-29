package com.excilys.formation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipeServiceException extends Exception {

  private static final long serialVersionUID = -6304545299346908132L;
  private static final Logger logger = LoggerFactory.getLogger(RecipeServiceException.class);

  public RecipeServiceException() {
    logger.warn(this.getMessage());
  }

  public RecipeServiceException(String arg0) {
    super(arg0);
  }

  public RecipeServiceException(Throwable arg0) {
    super(arg0);
  }

  public RecipeServiceException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public RecipeServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
    super(arg0, arg1, arg2, arg3);
  }
}

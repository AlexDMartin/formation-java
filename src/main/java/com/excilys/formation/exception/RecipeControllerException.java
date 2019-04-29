package com.excilys.formation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipeControllerException extends Exception {

  private static final long serialVersionUID = -5054859247908671878L;
  private static final Logger logger = LoggerFactory.getLogger(RecipeControllerException.class);

  public RecipeControllerException() {
    logger.warn(this.getMessage());
  }

  public RecipeControllerException(String arg0) {
    super(arg0);
  }

  public RecipeControllerException(Throwable arg0) {
    super(arg0);
  }

  public RecipeControllerException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public RecipeControllerException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
    super(arg0, arg1, arg2, arg3);
  }
}

package com.excilys.formation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipeDaoException extends Exception {

  private static final long serialVersionUID = 6722918679718410641L;
  private static final Logger logger = LoggerFactory.getLogger(RecipeDaoException.class);
  
  public RecipeDaoException() {
    logger.warn(this.getMessage());
  }

  public RecipeDaoException(String arg0) {
    super(arg0);
  }

  public RecipeDaoException(Throwable arg0) {
    super(arg0);
  }

  public RecipeDaoException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public RecipeDaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
    super(arg0, arg1, arg2, arg3);
  }

}

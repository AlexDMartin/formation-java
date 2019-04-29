package com.excilys.formation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IngredientDaoException extends Exception {

  private static final long serialVersionUID = 4232720918471003280L;
  private static final Logger logger = LoggerFactory.getLogger(IngredientDaoException.class);

  public IngredientDaoException() {
    logger.warn(this.getMessage());
  }
  
  public IngredientDaoException(String arg0) {
    super(arg0);
  }

  public IngredientDaoException(Throwable arg0) {
    super(arg0);
  }

  public IngredientDaoException(String arg0, Throwable arg1) {
    super(arg0, arg1);
  }

  public IngredientDaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
    super(arg0, arg1, arg2, arg3);
  }

}

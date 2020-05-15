package main.java.namespace;

import main.java.data.D_List;
import main.java.data.D_String;
import main.java.data.Obj;
import main.java.expr.E_Identifier;
import main.java.util.UFOException;

public class Params {

  // Static variables ===============================================

  public static final String WILDCARD_NAME = "...";
  public static final E_Identifier WILDCARD_ID = E_Identifier.create(WILDCARD_NAME);

  // Static methods =================================================

  public static int check(String funcName, D_List[] paramRules, D_List args) {
    return check(D_String.create(funcName), paramRules, args);
  }

  public static int check(Obj function, D_List[] paramRules, D_List args) {
    for(int n=0; n<paramRules.length; n++) {
      D_List rule = paramRules[n];
      if(checkRule(rule, args))
        return n;
    }
    throw UFOException.argumentMismatch(function, paramRules, args);
  }

  private static boolean checkRule(D_List params, D_List args) {
    while(true) {
      if(params.isEmpty())
        return args.isEmpty();
      Obj param = params.first();
      Obj arg = args.first();
      if(param == WILDCARD_ID)
        return true;
      D_List res = param.match(arg, D_List.EMPTY);
      if(res == null)
        return false;
      params = (D_List)params.rest();
      args = (D_List)args.rest();
    }
  }

}

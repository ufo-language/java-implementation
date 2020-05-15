package main.java.parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import main.java.util.UFOException;

public class ParseErrorListener extends BaseErrorListener {

  // Static methods =================================================

  public static ParseErrorListener INSTANCE = new ParseErrorListener();

  @Override
  public void syntaxError(Recognizer<?, ?> recognizer,
                          Object offendingSymbol,
                          int line, int col,
                          String msg, RecognitionException e) {
    msg = _rewriteMessage(msg);
    String source = recognizer.getInputStream().getSourceName();
    if(source == "<unknown>")
      source = "keyboard";
    throw UFOException.parseError(msg, source, line, col);
  }

  private static String _rewriteMessage(String msg) {
    if(msg.startsWith("mismatched input")) {
      String[] tokens = msg.split(" ");
      String token = tokens[2];
      if(token.equals("'<EOF>'"))
        msg = "expression is incomplete";
      else if(tokens[4].indexOf("<EOF>") > -1)
        msg = "extra tokens on line";
    }
    else if(msg.startsWith("token recognition error at: '\""))
      msg = "unterminated string";
    return msg;
  }

}
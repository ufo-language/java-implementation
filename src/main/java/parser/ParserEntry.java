package main.java.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_String;
import main.java.util.UFOException;

public class ParserEntry {
  
  // Static methods =================================================

  public static D_List parse(String inputString) {
    CharStream in = CharStreams.fromString(inputString);

    UFOLexer lexer = new UFOLexer(in);
    lexer.removeErrorListeners();
    lexer.addErrorListener(ParseErrorListener.INSTANCE);
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    UFOParser parser = new UFOParser(tokens);
    parser.removeErrorListeners();
    parser.addErrorListener(ParseErrorListener.INSTANCE);

    try {
      UFOParser.ProgContext tree = parser.prog();

      ParserListener extractor = new ParserListener();
      ParseTreeWalker.DEFAULT.walk(extractor, tree);
      D_List res = (D_List)extractor.pop();
      return res;
    }
    catch(UFOException exn) {
      if(exn.getName().equals("ParseError")) {
        int lineNum = ((D_Integer)exn.getField("LineNum")).asInt();
        int colNum = ((D_Integer)exn.getField("ColumnNum")).asInt();
        String[] lines = inputString.split("\n");
        String line = lines[lineNum - 1];
        exn.field_disp("Line", D_String.create(line));
        exn.field_disp("Here", D_String.create(".".repeat(colNum - 1) + "^"));
      }
      throw exn;
    }
  }

}

package main.java.util;

import main.java.data.D_Symbol;
import main.java.i18n.Strings;

public class CommonSymbols {

  private static D_Symbol sym(String s) {
    return D_Symbol.create(Strings.get(s));
  }

  // general
  //public static final D_Symbol INVISIBLE   = D_Symbol.create("TheInvisibleSymbol");

  // threading
  //public static final D_Symbol FINISHED    = D_Symbol.create("Finished");
  //public static final D_Symbol IDLE        = D_Symbol.create("Idle");
  //public static final D_Symbol INTERRUPTED = D_Symbol.create("Interrupted");
  //public static final D_Symbol OK          = D_Symbol.create("OK");
  //public static final D_Symbol PAUSED      = D_Symbol.create("Paused");
  //public static final D_Symbol RUNNING     = D_Symbol.create("Running");
  //public static final D_Symbol SLEEPING    = D_Symbol.create("Sleeping");
  //public static final D_Symbol STOPPED     = D_Symbol.create("Stopped");
  //public static final D_Symbol WAITING     = D_Symbol.create("Waiting");

  // networking
  //public static final D_Symbol IPADDRESS   = D_Symbol.create("IPAddress");
  //public static final D_Symbol PORT        = D_Symbol.create("Port");
  //public static final D_Symbol MESSAGE     = D_Symbol.create("Message");

  // HTTP server
  //   request symbols
  //public static final D_Symbol PORT              = D_Symbol.create("Port");
  //public static final D_Symbol DOC_ROOT          = D_Symbol.create("DocRoot");
  //public static final D_Symbol DEFAULT_PAGE_NAME = D_Symbol.create("DefaultPageName");
  //public static final D_Symbol REF_STRING        = D_Symbol.create("Ref");
  //public static final D_Symbol FULL_PATH_STRING  = D_Symbol.create("FullPath");
  //public static final D_Symbol URL_STRING        = D_Symbol.create("URL");
  //public static final D_Symbol QUERY_STRING      = D_Symbol.create("Query");
  //public static final D_Symbol QUERY_TABLE       = D_Symbol.create("QueryTable");
  //public static final D_Symbol REQ_TABLE         = D_Symbol.create("ReqTable");
  //   response symbols
  //public static final D_Symbol BODY              = D_Symbol.create("Body");
  //public static final D_Symbol HEAD              = D_Symbol.create("Head");
  //public static final D_Symbol STATUS_CODE       = D_Symbol.create("StatusCode");
  //public static final D_Symbol MIME_TYPE         = D_Symbol.create("MimeType");
  //public static final D_Symbol LAST_MODIFIED     = D_Symbol.create("LastModified");
  //public static final D_Symbol CONTENT           = D_Symbol.create("Content");

  //   method symbols
  //public static final D_Symbol HTTP_GET          = D_Symbol.create("GET");

  // mesh networking
  //public static final D_Symbol HELLO       = D_Symbol.create("Hello");
  //public static final D_Symbol HIBACK      = D_Symbol.create("HiBack");
  //public static final D_Symbol GIVEMETCP   = D_Symbol.create("GiveMeTCP");
  //public static final D_Symbol SPAWN       = D_Symbol.create("Spawn");
  //public static final D_Symbol GOODBYE     = D_Symbol.create("Goodbye");

  // CharacterStream
  public static final D_Symbol COL  = sym("Col");
  public static final D_Symbol LINE = sym("Line");
  public static final D_Symbol NAME = sym("Name");
  public static final D_Symbol POS  = sym("Pos");

  // lexer
  public static final D_Symbol EOI     = sym("EOI");
  public static final D_Symbol SPECIAL = sym("Special");
  public static final D_Symbol STRING  = sym("String");

  // parser
  public static final D_Symbol IGNORE_THIS_SYMBOL = D_Symbol.create("IgnoreThisSymbol");
  //public static final D_Symbol TOKENS      = D_Symbol.create("Tokens");

}

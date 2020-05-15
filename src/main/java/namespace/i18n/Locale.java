package main.java.namespace.i18n;

import main.java.data.D_HashTable;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_String;
import main.java.data.D_Symbol;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Locale extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "locale";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params()
  };

  private static final D_Symbol _COUNTRY = D_Symbol.create("Country");
  private static final D_Symbol _COUNTRYNAME = D_Symbol.create("CountryName");
  private static final D_Symbol _LANGUAGE = D_Symbol.create("Language");
  private static final D_Symbol _LANGUAGENAME = D_Symbol.create("LanguageName");
  private static final D_Symbol _LOCALENAME = D_Symbol.create("LocaleName");
  private static final D_Symbol _CODE = D_Symbol.create("Code");

  // Constructors ===================================================

  public Locale() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    java.util.Locale locale = java.util.Locale.getDefault();
    String country = locale.getCountry();
    String countryName = locale.getDisplayCountry();
    String language = locale.getLanguage();
    String languageName = locale.getDisplayLanguage();
    String name = locale.getDisplayName();

    D_HashTable localeHash = D_HashTable.create()
        .add(_COUNTRY, D_String.create(country))
        .add(_COUNTRYNAME, D_String.create(countryName))
        .add(_LANGUAGE, D_String.create(language))
        .add(_LANGUAGENAME, D_String.create(languageName))
        .add(_LOCALENAME, D_String.create(name))
        .add(_CODE, D_String.create(locale.toString()))
        ;

    etor.pushObj(localeHash);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

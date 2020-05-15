package main.java.namespace.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import main.java.data.D_HashTable;
import main.java.data.D_Integer;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_String;
import main.java.data.D_Symbol;
import main.java.evaluator.Evaluator;
import main.java.i18n.Strings;
import main.java.namespace.Params;

public class Now extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "now";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params()
  };

  private static final D_Symbol _YEAR = D_Symbol.create("Year");
  private static final D_Symbol _MONTH = D_Symbol.create("Month");
  private static final D_Symbol _DAY = D_Symbol.create("Day");

  private static final D_Symbol _MONTHNAME = D_Symbol.create("MonthName");
  private static final D_Symbol _DAYNAME = D_Symbol.create("DayName");

  private static final D_Symbol _HOUR24 = D_Symbol.create("Hour24");
  private static final D_Symbol _HOUR12 = D_Symbol.create("Hour12");
  private static final D_Symbol _AMPM = D_Symbol.create("AMPM");
  private static final D_Symbol _AM = D_Symbol.create("AM");
  private static final D_Symbol _PM = D_Symbol.create("PM");
  private static final D_Symbol _MINUTE = D_Symbol.create("Minute");
  private static final D_Symbol _SECOND = D_Symbol.create("Second");

  private static final D_Symbol _ZONE = D_Symbol.create("Zone");

  // Constructors ===================================================

  public Now() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    ZonedDateTime time = ZonedDateTime.now(ZoneId.of(Strings.get("_TZ_")));

    int year = time.getYear();
    int month = time.getMonthValue();
    int day = time.getDayOfMonth();
    
    String monthName = D_String.titleize(time.getMonth().toString());
    String dayName = D_String.titleize(time.getDayOfWeek().toString());

    int hour24 = time.getHour();
    int hour12 = hour24 % 12;
    if(hour12 == 0) hour12 = 12;
    boolean am = hour24 < 12;
    int minute = time.getMinute();
    int second = time.getSecond();
    
    String zone = time.getZone().toString();

    D_HashTable timeHash = D_HashTable.create()
        .add(_YEAR, D_Integer.create(year))
        .add(_MONTH, D_Integer.create(month))
        .add(_DAY, D_Integer.create(day))
        .add(_MONTHNAME, D_String.create(monthName))
        .add(_DAYNAME, D_String.create(dayName))
        .add(_HOUR24, D_Integer.create(hour24))
        .add(_HOUR12, D_Integer.create(hour12))
        .add(_AMPM, am ? _AM : _PM)
        .add(_MINUTE, D_Integer.create(minute))
        .add(_SECOND, D_Integer.create(second))
        .add(_ZONE, D_String.create(zone))
        ;

    etor.pushObj(timeHash);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}

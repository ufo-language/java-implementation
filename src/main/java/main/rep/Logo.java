package main.java.main.rep;

import main.java.show.Show;

public class Logo {

  public static void logo() {
    Show.showln("▌▐ ▛▘▛▜ ", About.appName(), " version ", About.appVersion());
    Show.showln("▙▟ ▛ ▙▟ ", About.appUrl());
    Show.showln("type :? for help");
    Show.showln("type :cav for caveats");
    Show.nl();
  }

}

package main.java;

import main.java.evaluator.RunQueue;
import main.java.io.StdIn;
import main.java.main.cli.CLI;
import main.java.main.rep.REPLoop;

public class UFO {

  public static void main(String[] args)	{
    CLI.handleArgs(args);

    RunQueue runQueue = new RunQueue();
    REPLoop repThread = new REPLoop(runQueue);
    runQueue.start();
    repThread.start();

    repThread.join();
    runQueue.terminate();
    StdIn.STDIN.terminate();
  }

}

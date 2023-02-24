package util;

public class UniqueGenerator {
  private long count;

  private UniqueGenerator() {
    count = System.currentTimeMillis();
  }

  public synchronized long getUniqueNumber() {
    return count++;
  }

  private static UniqueGenerator inst;

  public static UniqueGenerator instance() {
    if (inst == null)
      inst = new UniqueGenerator();
    return inst;
  }
}
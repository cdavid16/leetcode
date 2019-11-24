public class HammingDistance {

  public int hammingDistance(int x, int y) {
    int bitsDiff = 0;
    if (x != y) {
      String result = this.getBitString(x ^ y);
      for (int i = 0; i < result.length(); i++) {
        if (result.charAt(i) == '1') {
          bitsDiff++;
        }
      }
    }

    return bitsDiff;
  }

  private String getBitString(int n) {
    String result = "";
    while (n > 1) {
      result += n % 2;
      n = n / 2;
    }
    result += n;
    return result;
  }

}

public class ReverseString {
  public void reverseString(char[] s) {
    if (s.length <= 1)
      return;

    char c;
    for (int i = 0; i < s.length / 2; i++) {
      c = s[s.length - i - 1];
      s[s.length - i - 1] = s[i];
      s[i] = c;
    }
  }

}

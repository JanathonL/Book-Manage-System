package activity;

public class Fill {
	/**
	 * ×Ö·û´®²¹Æë
	 * @param source Ô´×Ö·û´®
	 * @param fillLength ²¹Æë³¤¶È
	 * @param fillChar ²¹ÆëµÄ×Ö·û
	 * @param isLeftFill trueÎª×ó²¹Æë£¬falseÎªÓÒ²¹Æë
	 * @return
	 */
	public static String stringFill(String source, int fillLength, char fillChar, boolean isLeftFill) {
	    if (source == null || source.length() >= fillLength) return source;
	     
	    StringBuilder result = new StringBuilder(fillLength);
	    int len = fillLength - source.length();
	    if (isLeftFill) {
	        for (; len > 0; len--) {
	            result.append(fillChar);
	        }
	        result.append(source);
	    } else {
	        result.append(source);
	        for (; len > 0; len--) {
	            result.append(fillChar);
	        }
	    }
	    return result.toString();
	}
	 
	public static String stringFill2(String source, int fillLength, char fillChar, boolean isLeftFill) {
	    if (source == null || source.length() >= fillLength) return source;
	     
	    char[] c = new char[fillLength];
	    char[] s = source.toCharArray();
	    int len = s.length;
	    if(isLeftFill){
	        int fl = fillLength - len;
	        for(int i = 0; i<fl; i++){
	            c[i] = fillChar;
	        }
	        System.arraycopy(s, 0, c, fl, len);
	    }else{
	        System.arraycopy(s, 0, c, 0, len);
	        for(int i = len; i<fillLength; i++){
	            c[i] = fillChar;
	        }
	    }
	    return String.valueOf(c);
	}
}

import java.util.*;

public class Resolve{

	// general idea: scan the whole text, 'pos' records how far we've travelled. 
	//find the first occurence of the variable pattern, resolve variabble. update pos and repeat the steps for substring(pos)
	public static String resolve(String text, HashMap<String,String> dict){
		StringBuilder builder = new StringBuilder();
		if (text != null && text.length() > 0) {
			char[] src = text.toCharArray();
			int pos = 0;
			String openToken="<%", closeToken="%>";
			int start = text.indexOf(openToken, pos);
			// start record the first occurence of opentoken in the substring(pos)
			while (start > -1) {
					int end = text.indexOf(closeToken, start);
					// end record the first occurence of endtoken in the substring(start)
					if (end == -1) {
						// finish search
						builder.append(src, pos, src.length - pos);
						pos = src.length;
					} else {
						// first append substring[pos, start)
						builder.append(src, pos, start - pos);
						// get value for variable
						pos = start + openToken.length();
						String content = new String(src, pos, end - pos);
						// append value
						builder.append(dict.get(content));
						// update pos
						pos = end + closeToken.length();
					}
				start = text.indexOf(openToken, pos);
			}
			if (pos < src.length) {
				builder.append(src, pos, src.length - pos);
			}
		}
		return builder.toString();

	}  
	public static void main(String[] args){
		HashMap<String,String> dict = new HashMap<String,String> ();
		dict.put("name1", "Avis");
		dict.put("name2", "William");
		dict.put("name3", "Gayle");
		String res= resolve("This is <%name1%>, that is <%name2%>, I am <%name3%>", dict);
		System.out.println(res);
	}
}
import java.util.HashMap;
import java.util.Map;

/**
 * Converts normal text into all sets from the
 * Mathematical Alphanumerical Symbols Unicode Block
 * https://en.wikipedia.org/wiki/Mathematical_Alphanumeric_Symbols
 * @author Profi06
 * @version 1
 */
public class Converter {

	public static final HashMap<String, String> BOLD_SERIF = new HashMap<String, String>(90);
	public static final HashMap<String, String> ITALIC_SERIF = new HashMap<String, String>(90);
	public static final HashMap<String, String> BOLD_ITALIC_SERIF = new HashMap<String, String>(90);

	public static final HashMap<String, String> SANS_SERIF = new HashMap<String, String>(90);
	public static final HashMap<String, String> BOLD_SANS_SERIF = new HashMap<String, String>(90);
	public static final HashMap<String, String> ITALIC_SANS_SERIF = new HashMap<String, String>(90);
	public static final HashMap<String, String> BOLD_ITALIC_SANS_SERIF = new HashMap<String, String>(90);

	public static final HashMap<String, String> SCRIPT = new HashMap<String, String>(90);
	public static final HashMap<String, String> BOLD_SCRIPT = new HashMap<String, String>(90);
	public static final HashMap<String, String> FRAKTUR = new HashMap<String, String>(90);
	public static final HashMap<String, String> BOLD_FRAKTUR = new HashMap<String, String>(90);
	public static final HashMap<String, String> MONOSPACE = new HashMap<String, String>(90);
	public static final HashMap<String, String> DOUBLESTRUCK = new HashMap<String, String>(90);

	// Fill HashMaps
	static {
		for(int i = 0x00; i <= 0x19; i++) {
			// Uppercase
			String normal = Character.toString(i + 0x0041);
			BOLD_SERIF.put(normal, Character.toString(i + 0x1D400));
			ITALIC_SERIF.put(normal, Character.toString(i + 0x1D434));
			BOLD_ITALIC_SERIF.put(normal, Character.toString(i + 0x1D468));

			SANS_SERIF.put(normal, Character.toString(i + 0x1D5A0));
			BOLD_SANS_SERIF.put(normal, Character.toString(i + 0x1D5D4));
			ITALIC_SANS_SERIF.put(normal, Character.toString(i + 0x1D608));
			BOLD_ITALIC_SANS_SERIF.put(normal, Character.toString(i + 0x1D63C));

			SCRIPT.put(normal, Character.toString(i + 0x1D49C));
			BOLD_SCRIPT.put(normal, Character.toString(i + 0x1D4D0));
			FRAKTUR.put(normal, Character.toString(i + 0x1D504));
			BOLD_FRAKTUR.put(normal, Character.toString(i + 0x1D56C));
			MONOSPACE.put(normal, Character.toString(i + 0x1D670));
			DOUBLESTRUCK.put(normal, Character.toString(i + 0x1D538));

			// Lowercase
			normal = Character.toString(i + 0x0061);
			BOLD_SERIF.put(normal, Character.toString(i + 0x1D41A));
			ITALIC_SERIF.put(normal, Character.toString(i + 0x1D44E));
			BOLD_ITALIC_SERIF.put(normal, Character.toString(i + 0x1D482));

			SANS_SERIF.put(normal, Character.toString(i + 0x1D5BA));
			BOLD_SANS_SERIF.put(normal, Character.toString(i + 0x1D5EE));
			ITALIC_SANS_SERIF.put(normal, Character.toString(i + 0x1D622));
			BOLD_ITALIC_SANS_SERIF.put(normal, Character.toString(i + 0x1D656));

			SCRIPT.put(normal, Character.toString(i + 0x1D4B6));
			BOLD_SCRIPT.put(normal, Character.toString(i + 0x1D4EA));
			FRAKTUR.put(normal, Character.toString(i + 0x1D51E));
			BOLD_FRAKTUR.put(normal, Character.toString(i + 0x1D586));
			MONOSPACE.put(normal, Character.toString(i + 0x1D68A));
			DOUBLESTRUCK.put(normal, Character.toString(i + 0x1D552));
		}
		// Exceptions
		ITALIC_SERIF.put("h", "???");

		SCRIPT.put("B", "???");
		SCRIPT.put("E", "???");
		SCRIPT.put("F", "???");
		SCRIPT.put("H", "???");
		SCRIPT.put("I", "???");
		SCRIPT.put("L", "???");
		SCRIPT.put("M", "???");
		SCRIPT.put("R", "???");
		SCRIPT.put("e", "???");
		SCRIPT.put("g", "???");
		SCRIPT.put("o", "???");

		FRAKTUR.put("C", "???");
		FRAKTUR.put("H", "???");
		FRAKTUR.put("I", "???");
		FRAKTUR.put("R", "???");
		FRAKTUR.put("Z", "???");

		DOUBLESTRUCK.put("C", "???");
		DOUBLESTRUCK.put("H", "???");
		DOUBLESTRUCK.put("N", "???");
		DOUBLESTRUCK.put("P", "???");
		DOUBLESTRUCK.put("Q", "???");
		DOUBLESTRUCK.put("R", "???");
		DOUBLESTRUCK.put("Z", "???");

		//Numbers
		for(int i = 0; i <= 9; i++) {
			String normal = Character.toString(i + 0x0030);
			BOLD_SERIF.put(normal, Character.toString(i + 0x1D7CE));

			SANS_SERIF.put(normal, Character.toString(i + 0x1D7E2));
			BOLD_SANS_SERIF.put(normal, Character.toString(i + 0x1D7EC));

			MONOSPACE.put(normal, Character.toString(i + 0x1D7F6));
			DOUBLESTRUCK.put(normal, Character.toString(i + 0x1D7D8));
		}
	}

	/**
	 * Main method
	 * @param args Commandline arguments. args[0] gets converted.
	 */
	public static void main(String[] args) {
		String str = args[0];

		System.out.println(str);
		System.out.println(convert(str, BOLD_SERIF));
		System.out.println(convert(str, ITALIC_SERIF));
		System.out.println(convert(str, BOLD_ITALIC_SERIF));

		System.out.println(convert(str, SANS_SERIF));
		System.out.println(convert(str, BOLD_SANS_SERIF));
		System.out.println(convert(str, ITALIC_SANS_SERIF));
		System.out.println(convert(str, BOLD_ITALIC_SANS_SERIF));

		System.out.println(convert(str, SCRIPT));
		System.out.println(convert(str, BOLD_SCRIPT));
		System.out.println(convert(str, FRAKTUR));
		System.out.println(convert(str, BOLD_FRAKTUR));
		System.out.println(convert(str, MONOSPACE));
		System.out.println(convert(str, DOUBLESTRUCK));

		System.out.println("");
	}

	/**
	 * Convert all keys in the String to their mapped value
	 * @param str String to be modified
	 * @param conv The conversion HashMap
	 */
	public static String convert(String str, HashMap<String, String> conv) {
		String returnValue = str;
		for (Map.Entry<String, String> entry : conv.entrySet()) {
			returnValue = returnValue.replaceAll(entry.getKey(), entry.getValue());
		}
		return returnValue;
	}
}

import java.text.DecimalFormat;
import java.util.Hashtable;

/*
 * Converts from the chosen Currency to various other currencies
 * Ex: Dollar to yen
 */
public class CurrencyConverter {

	private static Hashtable<String, String> converted_currencies;

	private static DecimalFormat formatter;

	private enum Currency {
		DOLLAR, POUND, EURO, YEN, RUPEE
	}

	private static double amount;

	// Initialized hashtables, formatter and a given amount
	public CurrencyConverter(double amount) {
		this.amount = amount;
		this.converted_currencies = new Hashtable<String, String>();
		formatter = new DecimalFormat("##.##");
	}

	// Takes a base currency name to convert the currency from
	// Ex: Yen to DOLLAR, YEN to POUND
	public static void currencyConversion(String baseCurrencyName) {
		switch (Currency.valueOf(baseCurrencyName)) {
		case DOLLAR:
			dollarConversion();
			break;
		case POUND:
			poundConversion();
			break;
		case EURO:
			euroConversion();
			break;
		case YEN:
			yenConversion();
			break;
		case RUPEE:
			rupeeConversion();
			break;
		}
	}

	/*
	 * Converting base currency to other currencies Then adding them into Hashtable
	 * with string,string as values
	 */

	private static void rupeeConversion() {
		double dollar = amount / 76;
		double pound = amount / 99.66;
		double euro = amount / 83.97;
		double yen = amount / 0.62;

		getConverted_currencies().put("Dollar", formatter.format(dollar));
		getConverted_currencies().put("Pound", formatter.format(pound));
		getConverted_currencies().put("Euro", formatter.format(euro));
		getConverted_currencies().put("Yen", formatter.format(yen));

	}

	private static void poundConversion() {
		double dollar = amount * 1.31;
		double rupee = amount * 99.63;
		double euro = amount * 1.19;
		double yen = amount * 160.63;

		getConverted_currencies().put("Dollar", formatter.format(dollar));
		getConverted_currencies().put("Rupee", formatter.format(rupee));
		getConverted_currencies().put("Euro", formatter.format(euro));
		getConverted_currencies().put("Yen", formatter.format(yen));
	}

	private static void euroConversion() {
		double dollar = amount * 1.10;
		double rupee = amount * 83.96;
		double pound = amount * 0.84;
		double yen = amount * 135.38;

		getConverted_currencies().put("Dollar", formatter.format(dollar));
		getConverted_currencies().put("Rupee", formatter.format(rupee));
		getConverted_currencies().put("Pound", formatter.format(pound));
		getConverted_currencies().put("Yen", formatter.format(yen));
	}

	private static void yenConversion() {
		double dollar = amount * 0.0082;
		double rupee = amount * 0.62;
		double pound = amount * 0.0062;
		double euro = amount * 0.0074;

		getConverted_currencies().put("Dollar", formatter.format(dollar));
		getConverted_currencies().put("Rupee", formatter.format(rupee));
		getConverted_currencies().put("Pound", formatter.format(pound));
		getConverted_currencies().put("Euro", formatter.format(euro));
	}

	private static void dollarConversion() {
		double yen = amount * 122.57;
		double rupee = amount * 75.98;
		double pound = amount * 0.76;
		double euro = amount * 0.91;

		getConverted_currencies().put("Yen", formatter.format(yen));
		getConverted_currencies().put("Rupee", formatter.format(rupee));
		getConverted_currencies().put("Pound", formatter.format(pound));
		getConverted_currencies().put("Euro", formatter.format(euro));
	}

	public static Hashtable<String, String> getConverted_currencies() {
		return converted_currencies;
	}

}

import java.text.DecimalFormat;
import java.util.Hashtable;

/*
 * Converts from the chosen Currency to various other currencies
 * Ex: Dollar to yen
 */
public class CurrencyConverter {

	private Hashtable<String, String> converted_currencies;

	private DecimalFormat formatter;

	private enum Currency {
		DOLLAR, POUND, EURO, YEN, RUPEE
	}

	private double amount;

	// Initialized hashtables, formatter and a given amount
	public CurrencyConverter(int amount) {
		this.amount = amount;
		this.converted_currencies = new Hashtable<String, String>();
		formatter = new DecimalFormat("##.##");
	}

	// Takes a base currency name to convert the currency from
	// Ex: Yen to DOLLAR, YEN to POUND
	private void currencyConversion(String baseCurrencyName) {
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

	private void rupeeConversion() {
		double dollar = amount / 76;
		double pound = amount / 99.66;
		double euro = amount / 83.97;
		double yen = amount / 0.62;

		this.converted_currencies.put("Dollar", formatter.format(dollar));
		this.converted_currencies.put("Pound", formatter.format(pound));
		this.converted_currencies.put("Euro", formatter.format(euro));
		this.converted_currencies.put("Yen", formatter.format(yen));

	}

	private void poundConversion() {
		double dollar = amount * 1.31;
		double rupee = amount * 99.63;
		double euro = amount * 1.19;
		double yen = amount * 160.63;

		this.converted_currencies.put("Dollar", formatter.format(dollar));
		this.converted_currencies.put("Rupee", formatter.format(rupee));
		this.converted_currencies.put("Euro", formatter.format(euro));
		this.converted_currencies.put("Yen", formatter.format(yen));
	}

	private void euroConversion() {
		double dollar = amount * 1.10;
		double rupee = amount * 83.96;
		double pound = amount * 0.84;
		double yen = amount * 135.38;

		this.converted_currencies.put("Dollar", formatter.format(dollar));
		this.converted_currencies.put("Rupee", formatter.format(rupee));
		this.converted_currencies.put("Pound", formatter.format(pound));
		this.converted_currencies.put("Yen", formatter.format(yen));
	}

	private void yenConversion() {
		double dollar = amount * 0.0082;
		double rupee = amount * 0.62;
		double pound = amount * 0.0062;
		double euro = amount * 0.0074;

		this.converted_currencies.put("Dollar", formatter.format(dollar));
		this.converted_currencies.put("Rupee", formatter.format(rupee));
		this.converted_currencies.put("Pound", formatter.format(pound));
		this.converted_currencies.put("Euro", formatter.format(euro));
	}

	private void dollarConversion() {
		double yen = amount * 122.57;
		double rupee = amount * 75.98;
		double pound = amount * 0.76;
		double euro = amount * 0.91;

		this.converted_currencies.put("Yen", formatter.format(yen));
		this.converted_currencies.put("Rupee", formatter.format(rupee));
		this.converted_currencies.put("Pound", formatter.format(pound));
		this.converted_currencies.put("Euro", formatter.format(euro));
	}

}

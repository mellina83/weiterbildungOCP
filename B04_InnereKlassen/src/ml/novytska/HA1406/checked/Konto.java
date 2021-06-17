package ml.novytska.HA1406.checked;



public class Konto {

	private double saldo;

	public Konto() {
		this(5.0);
	}

	public Konto(double saldo) {
		super();
		this.setSaldo(saldo);
	}

	public double getSaldo() {
		return this.saldo;
	}

	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * Vor dem Abheben einer Summe soll geprüft werden ob das Konto ausreichend
	 * gedeckt ist, wenn nicht soll eine "NegativeSaldoException" mit dem
	 * Aktuellen Saldo und dem abzuhebenden Betrag als Nachricht geworfen werden.
	 * 
	 * Es geht hier um eine "Checked" Exception
 	 */
	public void geldAbheben(double saldo) throws  NegativeSaldoExeption{
		if (this.saldo >= saldo) {
			this.saldo = this.saldo - saldo;
		} else {
			throw new NegativeSaldoExeption("Aktuellen Saldo ist nicht ausreichend " + this.saldo);
		}
	}

	public void geldEinzahlen(double saldo) {
		this.setSaldo(this.getSaldo() + saldo);
	}

	@Override
	public String toString() {
		return "Saldo verfuegbar = " + this.getSaldo();
	}
}

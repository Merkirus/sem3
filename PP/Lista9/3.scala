class Pojazd(val producent: String, val model: String, val rok: Int = -1, var rejestracja: String = "") {
  def this(producent: String, model: String, rejestracja: String) {
    this(producent, model, -1, rejestracja)
  }
}

object Test extends App {
  new Pojazd("Fiat", "126p", 2016, "ESI123")
  new Pojazd("Fiat", "126p", 2016)
  new Pojazd("Fiat", "126p", "ESI123")
  new Pojazd("Fiat", "126p")
}

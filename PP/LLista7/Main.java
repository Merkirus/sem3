import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Pracownik p = new Pracownik("Mielniczuk", "Rafal", "2115", 150.0);
    Pracownik s = new Specjalista("Kowalski", "Jan", "1234", 100.0);
    Zadanie z1 = new Zadanie("Liczenie", "Normalny");
    z1.uruchom(p);
    z1.zakoncz();
    Zadanie z2 = new Zadanie("Dodawanie", "Pilny");
    z2.uruchom(s);
    try {
      z2.setStatus("Inny");
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    Firma f = new Firma();
    f.dodajPracownika(p);
    f.dodajPracownika(s);
    f.dodajZadanie(z1);
    f.dodajZadanie(z2);
    f.podwyzkaDlaWszystkich(20);
    f.premiaDlaSpecjalisty(100, "1234");
    f.filtrujListeZadan("Liczenie");
    f.filtrujListeZadan();
    f.znajdzPracownika("2115");
    System.out.println(f.toString());
  }
}

class Pracownik {
  protected String nazwisko;
  protected String imie;
  protected String pesel;
  protected double placa;

  public Pracownik() {
    this.nazwisko = "";
    this.imie = "";
    this.pesel = "";
    this.placa = 0.0;
  }

  public Pracownik(String nazwisko, String imie, String pesel, double placa) {
    this.nazwisko = nazwisko;
    this.imie = imie;
    this.pesel = pesel;
    this.placa = placa;
  }

  public void dajPodwyzke(double procent) {
    this.placa = this.placa + (procent*this.placa/100);
  }

  public String getImie() {
    return imie;
  }

  public void setImie(String imie) {
    this.imie = imie;
  }

  public String getPesel() {
    return pesel;
  }

  public void setPesel(String pesel) {
    this.pesel = pesel;
  }

  public double getPlaca() {
    return placa;
  }

  public void setPlaca(double placa) {
    this.placa = placa;
  }

  public String getNazwisko() {
    return nazwisko;
  }

  public void setNazwisko(String nazwisko) {
    this.nazwisko = nazwisko;
  }
  
  @Override
  public String toString() {
    return "Pracownik: " + nazwisko + " " + imie + ".\nPesel: " + pesel + ".\nPłaca: " + placa + ".\n";
  }
}

class Specjalista extends Pracownik {
  private double premia;

  public Specjalista() {
    super();
    this.premia = 0.0;
  }

  public Specjalista(String nazwisko, String imie, String pesel, double placa) {
    super(nazwisko, imie, pesel, placa);
  }

  public Specjalista(String nazwisko, String imie, String pesel, double placa, double premia) {
    super(nazwisko, imie, pesel, placa);
    this.premia = premia;
  }

  public double getPremia() {
    return premia;
  }

  public void setPremia(double premia) {
    this.premia = premia;
    this.placa = premia + this.placa;
  }

  @Override
  public String toString() {
    return "Specjalista: " + nazwisko + " " + imie + ".\nPesel: " + pesel + ".\nPłaca: " + placa + ".\nPremia: " + premia + ".\n";
  }
} 

class Zadanie {
  private String nazwa;
  private String tryb;
  private String status;
  private Pracownik pracownik;

  public Zadanie() {
    this.nazwa = "";
    this.tryb = "";
    this.status = "WPrzygotowaniu";
  }

  public Zadanie(String nazwa, String tryb) {
    this.nazwa = nazwa;
    this.tryb = tryb;
    this.status = "WPrzygotowaniu";
  }

  public void uruchom(Pracownik pracownik) {
    if (this.status.equals("Zakonczone"))
      return;

    this.pracownik = pracownik;
    this.status = "WToku";
  }

  public boolean zakoncz() {
    if (this.status.equals("WToku")) {
      this.status = "Zakonczone";
      return true;
    }
    return false;
  }

  public String getNazwa() {
    return nazwa;
  }

  public void setNazwa(String nazwa) {
    this.nazwa = nazwa;
  }

  public String getTryb() {
    return tryb;
  }

  public void setTryb(String tryb) {
    this.tryb = tryb;
  }

  public Pracownik getPracownik() {
    return pracownik;
  }

  // setPracownik ~ uruchom

  public String getStatus() {
    return status;
  }

  // metoda moglaby nie istniec, tworze ze wzgledu na polecenie
  public void setStatus(String status) throws Exception {
    throw new Exception("Próba zmiany statusu");
  }

  @Override
  public String toString() {
    return "Zadanie: " + nazwa + ".\nTryb: " + tryb + ".\nStatus: " + status + ".\nPracownik: " + pracownik.getPesel() + ".\n";
  }
}

class Firma {
  List<Pracownik> listaPracownikow;
  List<Zadanie> listaZadan;
  
  public Firma() {
    this.listaPracownikow = new ArrayList<>();
    this.listaZadan = new ArrayList<>();
  }

  public void dodajPracownika(Pracownik pracownik) {
    boolean juzJest = false;

    for (Pracownik p : listaPracownikow) {
      if (p.getPesel().equals(pracownik.getPesel())) {
        juzJest = true;
        break;
      }
    }

    if (juzJest)
      return;

    listaPracownikow.add(pracownik);
  }

  public void dodajZadanie(Zadanie zadanie) {
    boolean juzJest = false;

    for (Zadanie z : listaZadan) {
      if (z.getNazwa().equals(zadanie.getNazwa())) {
        juzJest = true;
        break;
      }
    }

    if (juzJest)
      return;

    listaZadan.add(zadanie);
  }

  public void znajdzPracownika(String pesel) {
    for (int i = 0; i < listaPracownikow.size(); i++)
      if (listaPracownikow.get(i).getPesel().equals(pesel)) {
        System.out.println(listaPracownikow.get(i).toString());
        break;
      }
  }

  public void podwyzkaDlaWszystkich(double procent) {
    for (int i = 0; i < listaPracownikow.size(); i++) {
      listaPracownikow.get(i).dajPodwyzke(procent);
    }
  }

  public void premiaDlaSpecjalisty(double premia, String pesel) {
    for (int i = 0; i < listaPracownikow.size(); i++) {
      if (listaPracownikow.get(i).getPesel().equals(pesel) && listaPracownikow.get(i) instanceof Specjalista) {
        ((Specjalista)listaPracownikow.get(i)).setPremia(premia);
      }
    } 
  }

  public void filtrujListeZadan() {
    filtrujListeZadan(null, null, null);
  }

  public void filtrujListeZadan(String nazwa) {
    filtrujListeZadan(nazwa, null, null);
  }

  public void filtrujListeZadan(String nazwa, String status) {
    filtrujListeZadan(nazwa, status, null);
  }

  public void filtrujListeZadan(String nazwa, String status, String pesel) {
    List<Zadanie> result = new ArrayList<>();
    for (int i = 0; i < listaZadan.size(); i++)
      result.add(listaZadan.get(i));

    if (nazwa != null)
      result.removeIf(x -> !x.getNazwa().equals(nazwa));

    if (status != null)
      result.removeIf(x -> !x.getStatus().equals(status));

    if (pesel != null)
      result.removeIf(x -> !x.getPracownik().getPesel().equals(pesel));

    Comparator<Zadanie> comparator = (z1, z2) -> z1.getTryb().compareTo(z2.getTryb());

    result.sort(comparator.reversed());

    for (Zadanie z : result)
      System.out.println(z.toString());
  }

  @Override
  public String toString() {
    String result = "";
    for (Pracownik p : listaPracownikow) {
      result += p.toString();
      result += "\n";
    }
    for (Zadanie z : listaZadan) {
      result += z.toString();
      result += "\n";
    }
    return result;
  }
}

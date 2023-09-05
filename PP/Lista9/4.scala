object UzycieWyjatkow {
  def main(args: Array[String]) = {
    try {
      metoda1()
    } catch {
      case e: Exception =>
        System.err.println(e.getMessage + "\n")
        e.printStackTrace()
    }
  }
  def metoda1() = {
    metoda2()
  }
  def metoda2() = {
    metoda3()
  }

  def metoda3() = {
    throw new Exception("Wyjatek zgloszony w metoda3")
  }
}

// Wyjatek zgloszony w metoda3
//
// java.lang.Exception: Wyjatek zgloszony w metoda3
//         at UzycieWyjatkow$.metoda3(4.scala:19)
//         at UzycieWyjatkow$.metoda2(4.scala:15)
//         at UzycieWyjatkow$.metoda1(4.scala:12)
//         at UzycieWyjatkow$.main(4.scala:4)
//         at UzycieWyjatkow.main(4.scala)
//         at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:104)
//         at java.base/java.lang.reflect.Method.invoke(Method.java:578)
//         at dotty.tools.scripting.ScriptingDriver.compileAndRun(ScriptingDriver.scala:33)
//         at dotty.tools.scripting.Main$.process(Main.scala:45)
//         at dotty.tools.MainGenericRunner$.run$1(MainGenericRunner.scala:250)
//         at dotty.tools.MainGenericRunner$.process(MainGenericRunner.scala:270)
//         at dotty.tools.MainGenericRunner$.main(MainGenericRunner.scala:281)
//         at dotty.tools.MainGenericRunner.main(MainGenericRunner.scala)
//

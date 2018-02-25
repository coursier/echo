Run like
```
$ sbt proguard:proguard
…
$ java -cp target/scala-2.12/proguard/echo_2.12-1.0.2-SNAPSHOT.jar coursier.echo.Echo aa
Exception in thread "main" java.lang.VerifyError: Bad invokespecial instruction: interface method reference is in an indirect superinterface.
Exception Details:
  Location:
    scala/collection/SeqLike.toString()Ljava/lang/String; @3: invokespecial
  Reason:
    Error exists in the bytecode
  Bytecode:
    0x0000000: 2a59 4cb7 0036 b0

	at coursier.echo.Echo$.main(Echo.scala:7)
	at coursier.echo.Echo.main(Echo.scala)
$ java -noverify -cp target/scala-2.12/proguard/echo_2.12-1.0.2-SNAPSHOT.jar coursier.echo.Echo aa
Exception in thread "main" java.lang.IncompatibleClassChangeError: Interface method reference: scala.util.control.NoStackTrace.fillInStackTrace()Ljava/lang/Throwable;, is in an indirect superinterface of scala.util.control.BreakControl
	at scala.util.control.BreakControl.fillInStackTrace(Breaks.scala:1023)
	at java.lang.Throwable.<init>(Throwable.java:250)
	at scala.util.control.BreakControl.<init>(Breaks.scala:94)
	at scala.util.control.Breaks.<init>(Breaks.scala:29)
	at scala.collection.Traversable$.<init>(Traversable.scala:95)
	at scala.collection.Traversable$.<clinit>(Traversable.scala)
	at scala.package$.<init>(package.scala:40)
	at scala.package$.<clinit>(package.scala)
	at scala.Predef$.<init>(Predef.scala:139)
	at scala.Predef$.<clinit>(Predef.scala)
	at coursier.echo.Echo$.main(Echo.scala:7)
	at coursier.echo.Echo.main(Echo.scala)
```

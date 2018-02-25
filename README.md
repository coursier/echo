Run like
```
$ sbt proguard:proguard
…
$ java -cp target/scala-2.12/proguard/echo_2.12-1.0.2-SNAPSHOT.jar coursier.echo.Echo aa
Exception in thread "main" java.lang.VerifyError: Bad invokespecial instruction: interface method reference is in an indirect superinterface.
Exception Details:
  Location:
    a/a/aN.toString()Ljava/lang/String; @3: invokespecial
  Reason:
    Error exists in the bytecode
  Bytecode:
    0x0000000: 2a59 4cb7 0032 b0

	at coursier.echo.a.a(Unknown Source)
	at coursier.echo.Echo.main(Unknown Source)
$ java -noverify -cp target/scala-2.12/proguard/echo_2.12-1.0.2-SNAPSHOT.jar coursier.echo.Echo aa
Exception in thread "main" java.lang.IncompatibleClassChangeError: Interface method reference: a.h.a.g.fillInStackTrace()Ljava/lang/Throwable;, is in an indirect superinterface of a.h.a.a
	at a.h.a.a.fillInStackTrace(Unknown Source)
	at java.lang.Throwable.<init>(Throwable.java:250)
	at a.h.a.a.<init>(Unknown Source)
	at a.h.a.b.<init>(Unknown Source)
	at a.a.bB.<init>(Unknown Source)
	at a.a.bB.<clinit>(Unknown Source)
	at a.am.<init>(Unknown Source)
	at a.am.<clinit>(Unknown Source)
	at a.v.<init>(Unknown Source)
	at a.v.<clinit>(Unknown Source)
	at coursier.echo.a.a(Unknown Source)
	at coursier.echo.Echo.main(Unknown Source)
```

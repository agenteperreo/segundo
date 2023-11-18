package mono.android.app;

public class ApplicationRegistration {

	public static void registerApplications ()
	{
				// Application and Instrumentation ACWs must be registered first.
		mono.android.Runtime.register ("_09_Ejercicio1.MainApplication, 09_Ejercicio1, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", crc641b6b0487a8a8c188.MainApplication.class, crc641b6b0487a8a8c188.MainApplication.__md_methods);
		mono.android.Runtime.register ("Microsoft.Maui.MauiApplication, Microsoft.Maui, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", crc6488302ad6e9e4df1a.MauiApplication.class, crc6488302ad6e9e4df1a.MauiApplication.__md_methods);
		
	}
}

namespace LasPlacas.Views;

public partial class Login : ContentPage
{
	public Login()
	{
		InitializeComponent();
	}

	/// <summary>
	/// Metodo para navegar a la pantalla de trabajos
	/// </summary>
	/// <param name="sender"></param>
	/// <param name="e"></param>
	private async void inicioSesion(object sender, EventArgs e)
	{
		await Navigation.PushAsync(new Menu());
	}
}
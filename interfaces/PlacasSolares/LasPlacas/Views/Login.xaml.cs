namespace LasPlacas.Views;

public partial class Login : ContentPage
{
	public Login()
	{
		InitializeComponent();
	}

	private async void inicioSesion(object sender, EventArgs e)
	{
		await Navigation.PushAsync(new Menu());
	}
}
namespace LasPlacas.Views;

public partial class Ubicación : ContentPage
{
	public Ubicación()
	{
		InitializeComponent();
	}

    /// <summary>
    /// Metodo para navegar a la vista de los detalles del trabajo
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    private async void irDetalles(object sender, EventArgs e)
    {
        await Navigation.PushAsync(new Detalles());
    }
}
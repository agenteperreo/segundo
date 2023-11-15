namespace LasPlacas.Views;

public partial class Completados : ContentPage
{
	public Completados()
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

    /// <summary>
    /// Metodo para navegar a la vista de la ubicación del trabajo
    /// </summary>
    /// <param name="sender"></param>
    /// <param name="e"></param>
    private async void irUbicacion(object sender, EventArgs e)
    {
        await Navigation.PushAsync(new Ubicación());
    }
}
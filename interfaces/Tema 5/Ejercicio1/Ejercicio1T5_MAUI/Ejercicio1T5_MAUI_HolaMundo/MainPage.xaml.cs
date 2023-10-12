using Biblioteca_comun;

namespace Ejercicio1T5_MAUI_HolaMundo
{
    public partial class MainPage : ContentPage
    {

        clsPersona persona = new clsPersona();
        int count = 0;

        public MainPage()
        {
            InitializeComponent();
        }

        private async void VentanaSaludo(object sender, EventArgs e)
        {
            string apellidos = await DisplayPromptAsync("Introduzca sus apellidos", "Dime tus apellidos");

            persona.Apellidos = apellidos;
            persona.Nombre = txtNombre.Text;

            await DisplayAlert("Bienvenido", "Hola " + persona.Nombre+" "+persona.Apellidos, "OK");
        }
    }
}
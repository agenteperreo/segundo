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

        private void OnCounterClicked(object sender, EventArgs e)
        {
            count++;

            if (count == 1)
                CounterBtn.Text = $"Clicked {count} time";
            else
                CounterBtn.Text = $"Clicked {count} times";

            SemanticScreenReader.Announce(CounterBtn.Text);
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
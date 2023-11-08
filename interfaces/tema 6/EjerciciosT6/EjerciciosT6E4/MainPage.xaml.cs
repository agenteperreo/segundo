namespace EjerciciosT6E4
{
    public partial class MainPage : ContentPage
    {
        int count = 0;

        public MainPage()
        {
            InitializeComponent();

            entrada.MinimumDate = DateTime.Now;
            salida.MinimumDate = entrada.MinimumDate.AddDays(1);
        }

        private void entrada_DateSelected(object sender, DateChangedEventArgs e)
        {
            salida.MinimumDate = entrada.Date.AddDays(1);
        }
    }
}
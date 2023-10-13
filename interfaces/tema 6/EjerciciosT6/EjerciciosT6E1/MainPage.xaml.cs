namespace EjerciciosT6E1
{
    public partial class MainPage : ContentPage
    {
        Boolean btnYaCreado = false;

        public MainPage()
        {
            InitializeComponent();
        }

        /// <summary>
        /// Funcion que crea un boton nuevo en lenguaje C# tras el clickado de otro boton
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
       private void onClickBtn2(object sender, EventArgs e)
        {

            // Controlamos si el boton ya habia sido creado
            if (!btnYaCreado) {

                // Creamos un nuevo boton y las propiedades
                Button boton = new Button
                {
                    Text = "Boton 3",
                    HorizontalOptions = LayoutOptions.Center,
                    VerticalOptions = LayoutOptions.Center,
                    BackgroundColor = Colors.LightBlue,
                    HeightRequest = 70,
                    WidthRequest = 200,
                    FontFamily = "Verdana",
                    FontAttributes = FontAttributes.Bold,
                    FontSize = 16,
                    BorderColor = Colors.Yellow,
                    Margin = 30

                };

                // Le añadimos la funcion onClickBtn3
                boton.Clicked += onClickBtn3;

                // Creamos el boton en el StackLayout
                vslLayout.Children.Add(boton);

                // Cambiamos a que el boton ya a sido creado
                btnYaCreado = true;
             }         
        }

        /// <summary>
        /// Metodo que borra uno de los botones del layout y cambia el texto del segundo al clickar un tercero
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void onClickBtn3(object sender, EventArgs e)
        {
            // Borramos el boton 1 del layout
            vslLayout.Remove(btn1);

            // cambiamos el texto del boton 2
            btn2.Text = "Crear controles en tiempo de ejecución mola";
        }
    }
}
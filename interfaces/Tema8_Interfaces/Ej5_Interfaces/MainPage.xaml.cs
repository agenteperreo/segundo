using Ej5_Interfaces.Models;
using LibreriaEntidades;
using System.Collections.ObjectModel;

namespace Ej5_Interfaces
{
    public partial class MainPage : ContentPage
    {
        int count = 0;

        public MainPage()
        {
            InitializeComponent();

            ObservableCollection<clsPersona> listadoPersonas = new ObservableCollection<clsPersona>(clsListadoPersonasDAL.listadoPersonas());

            personasListView.ItemsSource = listadoPersonas;

            BindingContext = this;
        }

    }
}
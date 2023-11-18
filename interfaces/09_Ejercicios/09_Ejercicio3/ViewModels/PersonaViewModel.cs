using System.ComponentModel;
using System.Runtime.CompilerServices;
using Biblioteca;

namespace _09_Ejercicio3.ViewModels
{
    internal class PersonaViewModel : INotifyPropertyChanged 
    {
        #region Atributos
        private string nombre;

        //Me creo un objeto persona
        clsPersona persona = new clsPersona();
        #endregion

        #region constructores
        public PersonaViewModel()
        {
            this.nombre = persona.Nombre;

        }
        #endregion

        #region propiedades
        public string Nombre
        {
            get { return nombre; }
            set

            {

                nombre = value;

                // Call OnPropertyChanged whenever the property is updated
                NotifyPropertyChanged();

            }
        }

        #endregion

        #region metodos

        public event PropertyChangedEventHandler PropertyChanged;

        private void NotifyPropertyChanged([CallerMemberName] String propertyName = "")

        {

            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));

        }
        #endregion
    }
}

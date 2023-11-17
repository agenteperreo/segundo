using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace _09_Ejercicio2.Models
{
    internal class clsPersona : INotifyPropertyChanged
    {
        #region Atributos
        private String nombre;
        #endregion

        #region Contructores
        public clsPersona()
        {
            nombre = "Isaac García";
        }

        public clsPersona(String nombre)
        {
            this.nombre = nombre;
        }
        #endregion

        #region Propiedades
        public String Nombre
        {
            get { return nombre; }

            set 
            { 
                nombre = value;

                NotifyPropertyChanged();

            }
        }
        #endregion

        #region Metodos
        public event PropertyChangedEventHandler PropertyChanged;

        private void NotifyPropertyChanged([CallerMemberName]String propertyName = "")
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
        #endregion
    }
}

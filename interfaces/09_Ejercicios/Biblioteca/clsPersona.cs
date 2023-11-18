using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace Biblioteca
{
    public class clsPersona
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

            }
        }
        #endregion
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class clsModelos
    {
        #region Propiedades
        public int IdModelo { get; set; }
        public int IdMarca { get; set; }
        public string Nombre { get; set; }
        public int Precio { get; set; }
        #endregion

        #region Constructores
        public clsModelos() { }

        public clsModelos(int idModelo, int idMarca, string nombre, int precio)
        {
            IdModelo = idModelo;
            IdMarca = idMarca;
            Nombre = nombre;
            Precio = precio;
        }
        #endregion
    }
}

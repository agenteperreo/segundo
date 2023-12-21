using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class clsModelos
    {
        #region Atributos
        private int id;
        private string nombre;
        private int precio;
        private int idMarcas;
        #endregion

        #region Constructores
        public clsModelos()
        {

        }

        public clsModelos(int id, string nombre, int precio, int idMarcas)
        {
            this.id = id;
            this.nombre = nombre;
            this.precio = precio;
            this.idMarcas = idMarcas;
        }
        #endregion

        #region Propiedades
        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }

        public int Precio
        {
            get { return precio; }
            set { precio = value; }
        }

        public int IDMarcas
        {
            get { return idMarcas; }
            set { idMarcas = value; }
        }
        #endregion
    }
}

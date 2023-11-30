using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entidades
{
    public class clsDepartamento
    {
        #region Propiedades
        public int IdDepartamento { get; set; }
        public string Nombre { get; set; }
        #endregion

        #region Constructores
        public clsDepartamento() { }

        public clsDepartamento(int idDepartamento, string nombre)
        {
            IdDepartamento = idDepartamento;
            Nombre = nombre;
        }

        #endregion
    }
}

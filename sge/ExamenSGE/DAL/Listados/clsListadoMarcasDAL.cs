using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL.Listados
{
    public class clsListadoMarcasDAL
    {
        /// <summary>
        /// Función que devuelve un listado con todas las marcas
        /// </summary>
        /// <returns>Listado de marcas</returns>
        public static List<clsMarcas> listadoCompletoMarcasDAL()
        {
            List<clsMarcas> listadoMarcas = new List<clsMarcas>();
            listadoMarcas.Add(new clsMarcas(1, "Ford"));
            listadoMarcas.Add(new clsMarcas(2, "Renault"));
            listadoMarcas.Add(new clsMarcas(3, "Citroen"));

            return listadoMarcas;
        }
    }
}

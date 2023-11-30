using Entidades;
using DAL.Listados;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BL.Listados
{
    public class clsListadoMarcasBl
    {
        /// <summary>
        /// Función que devuelve el listado de marcas de la capa dal preparado para la introduccion de una norma de la empresa
        /// </summary>
        /// <returns>Listado de marcas</returns>
        public static List<clsMarcas> listadoCompletoMarcasBL()
        {
            return clsListadoMarcasDAL.listadoCompletoMarcasDAL();
        }
    }
}

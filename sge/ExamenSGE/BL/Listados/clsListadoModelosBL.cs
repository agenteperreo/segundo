using DAL.Listados;
using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BL.Listados
{
    public class clsListadoModelosBL
    {
        /// <summary>
        /// Funcion que devuelve un listado de modelos de la capa DAL listo para insertarle una norma de la empresa
        /// </summary>
        /// <returns>Listado de modelos</returns>
        public static List<clsModelos> listadoCompletoModelosBL()
        {
            return clsListadoModelosDAL.listadoCompletoModelosDAL();
        }
    }
}

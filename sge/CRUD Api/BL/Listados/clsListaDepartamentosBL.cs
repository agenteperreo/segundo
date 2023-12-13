using DAL;
using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BL.Listados
{
    public class clsListaDepartamentosBL
    {
        /// <summary>
        /// Funcion para obtener una lista de personas obtenido de la DAL y aplicando la regla de negocios
        /// </summary>
        /// <returns>Lista de personas de la vase de datos</returns>
        public static List<clsDepartamento> listadoCompletoDepartamentosBL()
        {
            return clsListadoDepartamentos.getDepartamentosDAL().Result;
        }
    }
}

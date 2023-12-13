using DAL;
using Entidades;

namespace BL.Listados
{
    public class clsListaPersonasBL
    {
        /// <summary>
        /// Funcion para obtener una lista de personas obtenido de la DAL y aplicando la regla de negocios
        /// </summary>
        /// <returns>Lista de personas de la vase de datos</returns>
        public static List<clsPersona> listadoCompletoPersonasBL()
        {
            return clsListadoPersonas.getPersonasDAL().Result;
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DAL.Listados;
using Entidades;

namespace DAL.Handler
{
    public class personaPorId
    {
        /// <summary>
        /// Método que devuelve una persona específica de la lista identificada por el Id.
        /// Precondición: id debe ser mayor que 0
        /// Postcondiciones: el objeto devuelto puede ser null o una persona rellena si se encuentra.
        /// </summary>
        /// <param name="Id">int</param>
        /// <returns>devuelve uns clsMision</returns>
        public static clsPersona obtenerPersonaId(int Id)
        {
            List<clsPersona> listaPersonas = clsListadoPersonas.getPersonasDAL().Result;
            return listaPersonas.Find(x => x.Id == Id);
        }
    }
}


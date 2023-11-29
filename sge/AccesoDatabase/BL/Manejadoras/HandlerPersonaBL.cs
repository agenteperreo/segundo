using DAL;
using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BL.Manejadoras
{
    public class HandlerPersonaBL
    {
        /// <summary>
        /// 
        /// Postcondicion: Mi salida es: 0 cuando ha habido un error, >0 se ha borrado bien y <0 es miercoles
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public static int deletePersonaBL(int id)
        {

            int numFilasAfectadas = 0;

            DateTime fechaActual = DateTime.Now;

            if(fechaActual.DayOfWeek == DayOfWeek.Tuesday)
            {
                numFilasAfectadas = -1;
            } 
            else
            {
                numFilasAfectadas = clsDeletePersona.deletePersonaDAL(id);
            }
           
            
            return numFilasAfectadas;
        }

        public static clsPersona getPersonaId(int id)
        {
            return personaPorId.obtenerPersonaId(id);
        }
    }
}

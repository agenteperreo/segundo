using DAL;
using DAL.Conexion;
using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
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
        public static Task deletePersonaBL(int id)
        {
            return clsDeletePersona.deletePersonaDAL(id);
        }
        

        public static clsPersona getPersonaId(int id)
        {
            return personaPorId.obtenerPersonaId(id);
        }

        public static Task editPersonaBL(clsPersona persona, int id)
        {
            return clsEditPersona.editPersonaDAL(id, persona);
        }
    }
}

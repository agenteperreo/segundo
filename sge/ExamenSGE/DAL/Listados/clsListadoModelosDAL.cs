using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL.Listados
{
    public class clsListadoModelosDAL
    {
        /// <summary>
        /// Funcion que devuelve un listado de modelos
        /// </summary>
        /// <returns>Listado de modelos</returns>
        public static List<clsModelos> listadoCompletoModelosDAL()
        {
            List<clsModelos> listadoModelos = new List<clsModelos>();
            listadoModelos.Add(new clsModelos(1, 1, "Focus", 25000));
            listadoModelos.Add(new clsModelos(2, 1, "Kuga", 35000));
            listadoModelos.Add(new clsModelos(3, 1, "Puma", 37000));
            listadoModelos.Add(new clsModelos(4, 2, "Akana", 28000));
            listadoModelos.Add(new clsModelos(5, 2, "Megane", 20000));
            listadoModelos.Add(new clsModelos(6, 3, "C3", 14000));
            listadoModelos.Add(new clsModelos(7, 3, "C4", 20000));
            listadoModelos.Add(new clsModelos(8, 3, "C5", 27000));

            return listadoModelos;

        }
    }
}

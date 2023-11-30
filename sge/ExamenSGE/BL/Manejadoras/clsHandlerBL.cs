using DAL.Manejadoras;
using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BL.Manejadoras
{
    public class clsHandlerBL
    {
        /// <summary>
        /// Funcion que devuelve el listado de modelos filtrado mediante la id de la marca en la capa DAL lista para insertarle una norma de empresa
        /// </summary>
        /// <param name="id"></param>
        /// <returns>Listado filtrado de modelos</returns>
        public static List<clsModelos> listadoCompletosModelosPorIdBL(int id)
        {
            return clsHandlerDAL.listadoCompletoModelosPorIdDAL(id);
        }

        /// <summary>
        /// Funcion que devuelve un numero en funcion si se ha podido cambiar el precio del modelo
        /// </summary>
        /// <param name="modelo"></param>
        /// <param name="nuevoPrecio"></param>
        /// <returns>Un numero</returns>
        public static int editarPrecioModeloBL(clsModelos modelo, int nuevoPrecio)
        {

            int resultado = 0;

            if (nuevoPrecio < modelo.Precio)
            {
                resultado = -1;
            }
            else
            {
                resultado = clsHandlerDAL.editarPrecioModeloDAL(modelo);
            }

            return resultado;
        }

        /// <summary>
        /// Función que devuelve el objeto modelo de la funcion de la capa DAL
        /// </summary>
        /// <param name="id"></param>
        /// <returns>Objeto modelo</returns>
        public static clsModelos getModeloByIdBL(int id)
        {
            return clsHandlerDAL.getModeloByIdDAL(id);
        }

        public static clsMarcas getMarcaByIdBL(int id)
        {
            return clsHandlerDAL.getMarcaByIdDAL(id);
        }
    }
}

using DAL.Listados;
using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL.Manejadoras
{
    public class clsHandlerDAL
    {
        /// <summary>
        /// Funcion que filtra el listado de los modelos mediante el id pasado por parametros que es el id de la marca y devuelve una lista con los modelos con ese id de marca
        /// </summary>
        /// <param name="id"></param>
        /// <returns>Listado de modelos filtrado</returns>
        public static List<clsModelos> listadoCompletoModelosPorIdDAL(int id)
        {
            List<clsModelos> listadoFiltrado = clsListadoModelosDAL.listadoCompletoModelosDAL().Where(x => x.IdMarca == id).ToList();

            return listadoFiltrado;
        }

        /// <summary>
        /// Función que devuelve un modelo segun el id de parametros
        /// </summary>
        /// <param name="id"></param>
        /// <returns>Modelo con id del parametro</returns>
        public static clsModelos getModeloByIdDAL(int id)
        {
            List<clsModelos> listadoModelos = clsListadoModelosDAL.listadoCompletoModelosDAL();
            return listadoModelos.Find(x => x.IdModelo == id);
        }

        public static int editarPrecioModeloDAL(clsModelos modelo)
        {
            return 1;
        }

        /// <summary>
        /// Funcion que busca una marca en funcion de la id
        /// </summary>
        /// <param name="id"></param>
        /// <returns>Objeto marca</returns>
        public static clsMarcas getMarcaByIdDAL(int id)
        {
            List<clsMarcas> listadoMarcas = clsListadoMarcasDAL.listadoCompletoMarcasDAL();
            return listadoMarcas.Find(x => x.IdMarca == id);
        }
    }
}

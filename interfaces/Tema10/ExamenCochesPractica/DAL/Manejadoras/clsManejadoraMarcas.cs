using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using DAL.Listados;
using Entidades;

namespace DAL.Manejadoras
{
    public class clsManejadoraMarcas
    {
        /// <summary>
        /// Busca en listado de modelos el modelo con el id pasado por parametros
        /// </summary>
        /// <param name="id"></param>
        /// <returns>Modelo con el id de parametros</returns>
        public static clsModelos obtenerModeloPorIdDAL(clsModelos modelo)
        {
            return clsListadoModelos.listadoModelosFiltradoIdMarcasDAL(modelo.IDMarcas).Find(x => x.Id == modelo.Id);
        }
    }
}

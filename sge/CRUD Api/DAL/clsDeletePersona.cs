using DAL.Conexion;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace DAL
{
    public class clsDeletePersona
    {
        /// <summary>
        /// Funcion para eliminar una persona de la api
        /// </summary>
        /// <param name="id"></param>
        /// <returns>Cuantas lineas ha afectado</returns>
        public static async Task<HttpStatusCode> deletePersonaDAL(int idPersona)
        {
            HttpClient mihttpClient = new HttpClient();
            HttpResponseMessage miRespuesta = new HttpResponseMessage();

            try
            {
                string miCadenaUrl = clsUriBase.getUriBaseDAL();
                Uri miUri = new Uri($"{miCadenaUrl}Personas/{idPersona}");

                // Usaremos el método DeleteAsync para realizar la operación de eliminación
                miRespuesta = await mihttpClient.DeleteAsync(miUri);
            }
            catch (Exception ex)
            {
                // Manejar cualquier excepción y relanzarla si es necesario
                throw ex;
            }

            return miRespuesta.StatusCode;
        }
    }
}

using DAL.Conexion;
using Entidades;
using Microsoft.Data.SqlClient;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace DAL
{
    public class clsEditPersona
    {
        /// <summary>
        /// Metodo para editar una persona en la base de datos
        /// </summary>
        /// <param name="oPersona"></param>
        public static async Task<HttpStatusCode> editPersonaDAL(int idPersona, clsPersona personaActualizada)
        {
            HttpClient mihttpClient = new HttpClient();
            HttpResponseMessage miRespuesta = new HttpResponseMessage();

            try
            {
                string miCadenaUrl = clsUriBase.getUriBaseDAL();
                Uri miUri = new Uri($"{miCadenaUrl}Personas/{idPersona}");

                // Usaremos el método PutAsync para realizar la operación de actualización
                string datos = JsonConvert.SerializeObject(personaActualizada);
                HttpContent contenido = new StringContent(datos, Encoding.UTF8, "application/json");

                miRespuesta = await mihttpClient.PutAsync(miUri, contenido);
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

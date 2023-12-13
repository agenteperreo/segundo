using DAL.Conexion;
using Entidades;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace DAL
{
    public static class clsCreatePersona
    {
        public static async Task<HttpStatusCode> createPersona(clsPersona persona)

        {

            HttpClient mihttpClient = new HttpClient();

            string datos;

            HttpContent contenido;

            string miCadenaUrl = clsUriBase.getUriBaseDAL();

            Uri miUri = new Uri($"{miCadenaUrl}Personas");

            //Usaremos el Status de la respuesta para comprobar si ha borrado

            HttpResponseMessage miRespuesta = new HttpResponseMessage();

            try

            {

                datos = JsonConvert.SerializeObject(persona);

                contenido = new StringContent(datos, System.Text.Encoding.UTF8, "application/json");

                miRespuesta = await mihttpClient.PostAsync(miUri, contenido);

            }

            catch (Exception ex)

            {

                throw ex;

            }

            return miRespuesta.StatusCode;

        }
    }
}

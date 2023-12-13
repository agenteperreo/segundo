using Microsoft.Data.SqlClient;
using Entidades;
using DAL.Conexion;
using Newtonsoft.Json;

namespace DAL
{
    public class clsListadoPersonas
    {
        /// <summary>
        /// Funcion para obtener una lista de personas de la base de datos
        /// </summary>
        /// <returns>Lista de personas de la vase de datos</returns>
        public static async Task<List<clsPersona>> getPersonasDAL()

        {

            //Pido la cadena de la Uri al método estático

            string miCadenaUrl = clsUriBase.getUriBaseDAL();

            Uri miUri = new Uri($"{miCadenaUrl}Personas");

            List<clsPersona> listadoPersonas = new List<clsPersona>();

            HttpClient mihttpClient;

            HttpResponseMessage miCodigoRespuesta;

            string textoJsonRespuesta;

            //Instanciamos el cliente Http

            mihttpClient = new HttpClient();

            try

            {

                miCodigoRespuesta = await mihttpClient.GetAsync(miUri);

                if (miCodigoRespuesta.IsSuccessStatusCode)

                {

                    textoJsonRespuesta = await mihttpClient.GetStringAsync(miUri);

                    mihttpClient.Dispose();

                    //JsonConvert necesita using Newtonsoft.Json;

                    //Es el paquete Nuget de Newtonsoft

                    listadoPersonas =
                    JsonConvert.DeserializeObject<List<clsPersona>>(textoJsonRespuesta);

                }

            }

            catch (Exception ex)

            {

                throw ex;

            }

            return listadoPersonas;

        }
    }
}
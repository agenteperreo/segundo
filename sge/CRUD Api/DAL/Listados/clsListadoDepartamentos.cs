using DAL.Conexion;
using Entidades;
using Microsoft.Data.SqlClient;
using Newtonsoft.Json;

namespace DAL.Listados
{
    public class clsListadoDepartamentos
    {
        public static async Task<List<clsDepartamento>> getDepartamentosDAL()

        {

            //Pido la cadena de la Uri al método estático

            string miCadenaUrl = clsUriBase.getUriBaseDAL();

            Uri miUri = new Uri($"{miCadenaUrl}Departamentos");

            List<clsDepartamento> listadoDepartamentos = new List<clsDepartamento>();

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

                    listadoDepartamentos =
                    JsonConvert.DeserializeObject<List<clsDepartamento>>(textoJsonRespuesta);

                }

            }

            catch (Exception ex)

            {

                throw ex;

            }

            return listadoDepartamentos;

        }
    }
}

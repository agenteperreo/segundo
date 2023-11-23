using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL
{
    public class clsDeletePersona
    {
        public static int deletePersonaDAL(int id)

        {

            int numeroFilasAfectadas = 0;

            SqlConnection miConexion = new SqlConnection();

            SqlCommand miComando = new SqlCommand();

            miConexion.ConnectionString = "server=baseisaacazure.database.windows.net;database=IsaacAzure;uid=prueba;pwd=fernandoG321;trustServerCertificate=true";

            miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = id;

            try
            {

                miConexion.Open();

                miComando.CommandText = "DELETE FROM personas WHERE ID=@id";

                miComando.Connection = miConexion;

                numeroFilasAfectadas = miComando.ExecuteNonQuery();

            }

            catch (Exception ex)

            {

                throw ex;

            }

            return numeroFilasAfectadas;

        }
    }
}

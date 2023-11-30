using Entidades;
using Microsoft.Data.SqlClient;

namespace DAL
{
    public class clsListadoDepartamentos
    {
        public static List<clsDepartamento> listadoCompletoDepartamentos()
        {
            SqlConnection miConexion = new SqlConnection();

            List<clsDepartamento> listadoDepartamentos = new List<clsDepartamento>();

            SqlCommand miComando = new SqlCommand();

            SqlDataReader miLector;

            clsDepartamento oDepartamento;

            miConexion.ConnectionString = "server=baseisaacazure.database.windows.net;database=IsaacAzure;uid=prueba;pwd=fernandoG321;trustServerCertificate=true";

            try
            {

                miConexion.Open();

                //Creamos el comando (Creamos el comando, le pasamos la sentencia y la conexion, y lo ejecutamos)

                miComando.CommandText = "SELECT * FROM departamentos";

                miComando.Connection = miConexion;

                miLector = miComando.ExecuteReader();

                //Si hay lineas en el lector

                if (miLector.HasRows)

                {

                    while (miLector.Read())

                    {

                        oDepartamento = new clsDepartamento();

                        oDepartamento.IdDepartamento = (int)miLector["ID"];

                        oDepartamento.Nombre = (string)miLector["Nombre"];

                        listadoDepartamentos.Add(oDepartamento);

                    }

                }

                miLector.Close();

                miConexion.Close();

            }

            catch (SqlException exSql)
            {

            }

            return listadoDepartamentos;
        }
    }
}

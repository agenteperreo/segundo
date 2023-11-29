using Entidades;
using Microsoft.Data.SqlClient;

namespace DAL
{
    public class clsCreatePersona
    {
        /// <summary>
        /// Funcion para añadir una persona a la base de datos
        /// </summary>
        /// <param name="oPersona"></param>
        /// <returns></returns>
        public static int createPersona(clsPersona oPersona)
        {
            int resultado = 0;

            SqlConnection miConexion = new SqlConnection();

            SqlCommand miComando = new SqlCommand();

            miConexion.ConnectionString = "server=baseisaacazure.database.windows.net;database=IsaacAzure;uid=prueba;pwd=fernandoG321;trustServerCertificate=true";

            try
            {
                miConexion.Open();

                miComando.CommandText = "INSERT INTO personas (Nombre, Apellidos, Telefono, Direccion, Foto, FechaNacimiento, IDDepartamento) VALUES (@nombre, @apellidos, @telefono, @direccion, @foto, @fechaNac, @idDep)";
                miComando.Parameters.Add("@nombre", System.Data.SqlDbType.VarChar).Value = oPersona.Nombre;
                miComando.Parameters.Add("@apellidos", System.Data.SqlDbType.VarChar).Value = oPersona.Apellidos;
                miComando.Parameters.Add("@telefono", System.Data.SqlDbType.VarChar).Value = oPersona.Telefono;
                miComando.Parameters.Add("@direccion", System.Data.SqlDbType.VarChar).Value = oPersona.Direccion;
                miComando.Parameters.Add("@foto", System.Data.SqlDbType.VarChar).Value = oPersona.Foto;
                miComando.Parameters.Add("@fechaNac", System.Data.SqlDbType.Date).Value = oPersona.FechaNac;
                miComando.Parameters.Add("@idDep", System.Data.SqlDbType.Int).Value = oPersona.IDDepartamento;

                miComando.Connection = miConexion;

                resultado= miComando.ExecuteNonQuery();

            }
            catch (Exception ex) 
            {
            
            }

            return resultado;
        }
    }
}

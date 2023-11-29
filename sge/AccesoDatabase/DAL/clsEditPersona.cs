using Entidades;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
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
        public static void editPersona(clsPersona oPersona)
        {
            int resultado = 0;

            SqlConnection miConexion = new SqlConnection();

            SqlCommand miComando = new SqlCommand();

            miConexion.ConnectionString = "server=baseisaacazure.database.windows.net;database=IsaacAzure;uid=prueba;pwd=fernandoG321;trustServerCertificate=true";

            try
            {
                miConexion.Open();

                miComando.CommandText = "UPDATE personas SET Nombre=@nombre, Apellidos=@apellidos, Telefono=@telefono, Direccion=@direccion, Foto=@foto, FechaNacimiento=@fechaNacimiento, IDDepartamento=@idDepartamento WHERE ID=@id";
                miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = oPersona.Id;
                miComando.Parameters.Add("@nombre", System.Data.SqlDbType.VarChar).Value = oPersona.Nombre;
                miComando.Parameters.Add("@apellidos", System.Data.SqlDbType.VarChar).Value = oPersona.Apellidos;
                miComando.Parameters.Add("@telefono", System.Data.SqlDbType.VarChar).Value = oPersona.Telefono;
                miComando.Parameters.Add("@direccion", System.Data.SqlDbType.VarChar).Value = oPersona.Direccion;
                miComando.Parameters.Add("@foto", System.Data.SqlDbType.VarChar).Value = oPersona.Foto;
                miComando.Parameters.Add("@fechaNacimiento", System.Data.SqlDbType.Date).Value = oPersona.FechaNac;
                miComando.Parameters.Add("@idDepartamento", System.Data.SqlDbType.Int).Value = oPersona.IDDepartamento;

                miComando.Connection = miConexion;

                resultado = miComando.ExecuteNonQuery();

            }
            catch (Exception ex)
            {

            }

        }
    }
}

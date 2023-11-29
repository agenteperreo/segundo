using Ejercicio12y3.Models.Entidades;

namespace Ejercicio12y3.Models.DAL
{
    public class clsListadoDepartamento
    {
        public static List<clsDepartamento> listadoCompletoDepartamento()
        {
            List<clsDepartamento> listadoDepartamentos = new List<clsDepartamento>();
            listadoDepartamentos.Add(new clsDepartamento(1, "Finanzas"));
            listadoDepartamentos.Add(new clsDepartamento(2, "Marketing"));
            listadoDepartamentos.Add(new clsDepartamento(3, "Testeo"));

            return listadoDepartamentos;
        }
    }
}

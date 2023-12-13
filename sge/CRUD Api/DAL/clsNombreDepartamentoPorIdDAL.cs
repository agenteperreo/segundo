using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL
{
    public class clsNombreDepartamentoPorIdDAL
    {
        public static string nombreDepPorIdDAL(int id)
        {
            clsDepartamento oDep = clsListadoDepartamentos.getDepartamentosDAL().Result.Find(x => x.IdDepartamento == id);
            return oDep.Nombre;
        }
    }
}

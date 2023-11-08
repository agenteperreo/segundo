using Tema7SGE.Models.Entidades;

namespace Tema7SGE.Models.DAL
{
    public class listaDepartamento
    {
        public static List<clsDepartamento> listadoCompletoDepartamento()
        {
            List<clsDepartamento> listaDepartamentos = new List<clsDepartamento>()
            {
                new clsDepartamento(1, "Finanzas"),
                new clsDepartamento(2, "Marketing"),
                new clsDepartamento(3, "Cadena de suministros"),
                new clsDepartamento(4, "Produccion"),
                new clsDepartamento(5, "Marketing Online")
            };

            return listaDepartamentos;
        }
    }
}

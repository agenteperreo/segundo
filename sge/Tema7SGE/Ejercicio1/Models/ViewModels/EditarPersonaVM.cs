using Ejercicio12y3.Models.DAL;
using Ejercicio12y3.Models.Entidades;

namespace Ejercicio12y3.Models.ViewModels
{
    public class EditarPersonaVM : clsPersona
    {
        public List<clsDepartamento> listadoDepartamentosVM {  get; }

        public EditarPersonaVM()
        {
            listadoDepartamentosVM = clsListadoDepartamento.listadoCompletoDepartamento();
        }
    }
}

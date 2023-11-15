using Tema7SGE.Models.DAL;
using Tema7SGE.Models.Entidades;

namespace Tema7SGE.Models.ViewModels
{
    public class EditarPersonaVM:clsPersona
    {

        #region Atributos
        private List<clsDepartamento> departamentos;
        #endregion

        #region Constructores
        public EditarPersonaVM() 
        { 
            this.departamentos = listaDepartamento.listadoCompletoDepartamento();
            this.nombre = "Pedro";
            this.apellidos = "Cornejo";
            this.telefono = "987654321";
            this.idDept = 1;
        }
        #endregion

        #region Propiedades
        public List<clsDepartamento> Departamentos
        {
            get { return departamentos; }
        }
        #endregion
    }
}
